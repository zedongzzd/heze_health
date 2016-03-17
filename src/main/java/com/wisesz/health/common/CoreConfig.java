package com.wisesz.health.common;

import java.util.Iterator;
import java.util.Properties;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PathKit;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

import me.zzd.webapp.core.plugin.AutoRouteBindPlugin;
import me.zzd.webapp.core.plugin.AutoTableBindPlugin;
import me.zzd.webapp.core.plugin.DruidPlugin;
import me.zzd.webapp.core.plugin.QuartzPlugin;

public class CoreConfig extends JFinalConfig {
	private Properties systemConfig = loadPropertyFile("system.properties", "utf8");

	// 配置常量值
	@Override
	public void configConstant(Constants me) {
		// 开发者模式
		me.setDevMode(Boolean.valueOf(systemConfig.getProperty("developMode", "false")));
		// 编码
		me.setEncoding(systemConfig.getProperty("encoding", "utf8"));
		// 默认错误页面
		String errorViewMappingStr = systemConfig.getProperty("errorViewMapping", null);
		if (errorViewMappingStr != null) {
			JSONObject errorViewMapping = JSONObject.parseObject(errorViewMappingStr);
			Iterator<String> keys = errorViewMapping.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				me.setErrorView(Integer.valueOf(key), errorViewMapping.getString(key));
			}
		}
		// base path for all views
		me.setBaseViewPath(systemConfig.getProperty("baseViewPath", "//"));
		// view type
		me.setViewType(ViewType.valueOf(systemConfig.getProperty("viewType", "FREE_MARKER")));

		me.setLogFactory(new Log4jLogFactory());

	}

	@Override
	public void configRoute(Routes me) {
		me.add(new AutoRouteBindPlugin(systemConfig.getProperty("scanPackage")));
	}

	@Override
	public void configPlugin(Plugins me) {
		// 数据库配置
		DruidPlugin dp = new DruidPlugin(loadPropertyFile("db.properties", "utf8"));
		me.add(dp);
		AutoTableBindPlugin atbp = new AutoTableBindPlugin(dp, systemConfig.getProperty("modelScanPackage"));
		me.add(atbp);
		// ehcache
		me.add(new EhCachePlugin(PathKit.getRootClassPath() + "/ehcache.xml"));
		// 定时器
		QuartzPlugin quartzPlugin = new QuartzPlugin();
		me.add(quartzPlugin);
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}

	@Override
	public void configHandler(Handlers me) {
	}

}
