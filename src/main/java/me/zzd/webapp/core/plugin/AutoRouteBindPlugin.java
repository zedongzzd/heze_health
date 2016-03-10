package me.zzd.webapp.core.plugin;

import java.util.List;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;

import me.zzd.webapp.core.annotation.BindController;
import me.zzd.webapp.core.handler.ClassSearch;

@SuppressWarnings({ "rawtypes", "unchecked" })
public final class AutoRouteBindPlugin extends Routes {
	private Log log = Log.getLog(getClass());
	private String scanPackage;
	private Class target;

	public AutoRouteBindPlugin(String scanPackage) {
		this(scanPackage, Controller.class);
	}

	public AutoRouteBindPlugin(String scanPackage, Class target) {
		super();
		this.scanPackage = scanPackage;
		if (Controller.class.isAssignableFrom(target)) {
			this.target = target;
		} else {
			this.target = null;
			log.error("设置的target扫描类类型不是Controller类类型的子类！");
		}
	}

	@Override
	public void config() {
		if (target == null) {
			return;
		}
		try {
			List<Class> scanResults = ClassSearch.ofTarget(target).ofScanPackege(scanPackage).search();
			for (Class cls : scanResults) {
				BindController controller = (BindController) cls.getAnnotation(BindController.class);
				if (controller != null) {
					if ("null".equals(controller.viewPath())) {
						add(controller.value(), cls);
					} else {
						add(controller.value(), cls, controller.viewPath());
					}
				}
			}
		} catch (Exception e) {
			log.error("自动注册controller出错！", e);
		}
	}

}
