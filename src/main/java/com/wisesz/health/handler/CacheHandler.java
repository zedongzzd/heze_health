package com.wisesz.health.handler;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.jfinal.log.Log;
import com.jfinal.plugin.ehcache.CacheKit;

public class CacheHandler {
	private Log log = Log.getLog(getClass());
	private ConcurrentHashMap<String, ReentrantLock> lockMap = new ConcurrentHashMap<String, ReentrantLock>();

	private ReentrantLock getLock(String key) {
		ReentrantLock lock = lockMap.get(key);
		if (lock != null)
			return lock;

		lock = new ReentrantLock();
		ReentrantLock previousLock = lockMap.putIfAbsent(key, lock);
		return previousLock == null ? lock : previousLock;
	}

	public static <T extends Serializable> T cache(String cacheName, String cacheKey) {
		return me().getCache(cacheName, cacheKey);
	}

	public static <T> void cache(String cacheName, String cacheKey, T t) {
		me().addCache(cacheName, cacheKey, t);
	}

	public <T extends Serializable> T getCache(String cacheName, String cacheKey) {
		T cacheData = CacheKit.get(cacheName, cacheKey);
		return cacheData;
	}

	public <T> void addCache(String cacheName, String cacheKey, T t) {
		Lock lock = getLock(cacheName);
		lock.lock();
		try {
			CacheKit.put(cacheName, cacheKey, t);
		} catch (Exception e) {
			log.error("将数据存入缓存出错！", e);
		} finally {
			lock.unlock();
		}
	}

	private static CacheHandler handler;

	private static CacheHandler me() {
		if (handler == null) {
			synchronized (CacheHandler.class) {
				if (handler == null) {
					handler = new CacheHandler();
				}
			}
		}
		return handler;
	}

}
