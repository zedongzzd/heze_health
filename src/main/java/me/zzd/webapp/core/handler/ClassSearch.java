package me.zzd.webapp.core.handler;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.jfinal.log.Log;

@SuppressWarnings({ "rawtypes", "unchecked" })
public final class ClassSearch {
	private Log log = Log.getLog(getClass());
	private Class target;
	private String scanBasePackage;
//	private String libDir;
	private List<String> libJars = new ArrayList<String>();

	private ClassSearch() {
		super();
	}

	public ClassSearch addLibJar(List<String> jars) {
		libJars.addAll(jars);
		return this;
	}

	public ClassSearch addLibJar(String... jars) {
		for (String jar : jars) {
			libJars.add(jar);
		}
		return this;
	}

	// 设置基础扫描的包地址
	public ClassSearch ofScanPackege(String scanPackege) {
		this.scanBasePackage = scanPackege;
		return this;
	}

	// 设置libjar包路径地址
	public ClassSearch ofLibDir(String libDir) {
//		this.libDir = libDir;
		return this;
	}

	public static ClassSearch ofTarget(Class target) {
		ClassSearch search = new ClassSearch();
		search.target = target;
		return search;
	}

	public static String getPathFromPackageName(String pack) {
		String packageName = pack.replace(" ", "");
		packageName = packageName.replace('.', File.separatorChar);
		URL url = Thread.currentThread().getContextClassLoader().getResource(packageName);
		if ("file".equals(url.getProtocol())) {
			try {
				return URLDecoder.decode(url.getFile(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 获取类类型集合中是目标类类型的儿子或接口实现
	 * 
	 * @param target
	 *            目标类类型
	 * @param sets
	 *            类类型集合
	 * @return
	 */
	public static List<Class> extraction(Class target, Set<Class> sets) {
		if (sets != null && target != null) {
			Iterator<Class> iterator = sets.iterator();
			List<Class> result = new ArrayList<Class>();
			while (iterator.hasNext()) {
				Class cls = iterator.next();
				if ((target.isAssignableFrom(cls) && cls != target)) {
					result.add(cls);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * 从指定package中获取所有的Class
	 * 
	 * @param pack
	 *            包名
	 * @return
	 */
	public static Set<Class> getClasses(String pack) {
		return getClasses(pack, true);
	}

	/**
	 * 从指定package中获取所有的Class
	 * 
	 * @param pack
	 *            包名
	 * @param isRecursive
	 *            是否递归查询包下的文件
	 * @return
	 */
	public static Set<Class> getClasses(String pack, boolean isRecursive) {
		Set<Class> classes = new LinkedHashSet<Class>();
		String packageName = pack.trim();
		String packageDirName = packageName.replace('.', File.separatorChar);
		Enumeration<URL> dirs;
		ClassFileFilter fileFilter = new ClassFileFilter(isRecursive);
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findAndAddClassesInPackageByFile(packageName, filePath, fileFilter, classes);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classes;
	}

	private static class ClassFileFilter implements FileFilter {
		private boolean isRecursive = true;

		public ClassFileFilter(boolean isRecursive) {
			super();
			this.isRecursive = isRecursive;
		}

		public boolean accept(File file) {
			return (isRecursive && file.isDirectory()) || (file.getName().endsWith(".class"));
		}

	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 *            包名
	 * @param packagePath
	 *            包的真实路径
	 * @param recursive
	 *            是否迭代
	 * @param classes
	 *            结果容器
	 */
	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, ClassFileFilter filter,
			Set<Class> classes) {
		File dir = new File(packagePath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		File[] dirfiles = dir.listFiles(filter);
		for (File file : dirfiles) {
			// 如果没有设置递归查询 则是文件夹的话filter返回false，不会进这个if
			if (file.isDirectory()) {
				String newPackageName = packageName != null && packageName.length() > 0
						? packageName + "." + file.getName() : file.getName();
				findAndAddClassesInPackageByFile(newPackageName, file.getAbsolutePath(), filter, classes);
			} else {
				// 去文件后缀
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 搜索所有符合条件的类类型(jar包搜索的尚未做)
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Class> search() throws Exception {
		if (target == null) {
			throw new Exception("未设置目标类类型");
		}
		if (scanBasePackage == null || scanBasePackage.length() == 0) {
			log.warn("未设置扫描路径");
			scanBasePackage = "";
		}
		return extraction(target, getClasses(scanBasePackage));
	}

}
