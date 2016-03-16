package com.wisesz.health.interceptor;

import java.io.Serializable;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;

/**
 * 后台身份认证拦截器
 * 
 * @author Administrator
 *
 */
public class ManageLoginInterceptor implements Interceptor {
	public static class LoginUser implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public String userName;
		public String userPwd;
	}

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		String flag = HttpHandler.getCookie(c.getRequest(), Const.Manage_Fag);
		if (StringHandler.isEmpty(flag)) {
			doIntercept(c);
			return;
		}
		Object o = CacheHandler.cache(Const.Cache_Name_login, flag);
		if (o != null && o instanceof LoginUser) {
			inv.invoke();
		} else {
			doIntercept(c);
		}
	}

	public void doIntercept(Controller c) {
		if ("POST".equalsIgnoreCase(c.getRequest().getMethod().toUpperCase())) {
			c.renderJson(RespFactory.newInstance(-500, "尚未登录！", null));
		} else {
			c.render("login.html");
		}
	}
}
