package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.service.UserService;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/user")
public class UserController extends Controller {
	private Log log = Log.getLog(getClass());

	/**
	 * 登陆接口
	 */
	@Before(POST.class)
	public void login() {
		try {
			String uid = getPara("uid");
			if (!StringHandler.isEmpty(uid)) {
				if (UserService.doLogin(getRequest(), getResponse(), uid)) {
					renderJson(RespFactory.isOk("登陆成功！"));
					return;
				}
			}
			renderJson(RespFactory.isFail());
		} catch (Exception e) {
			log.error("登陆接口出错！", e);
			renderJson(RespFactory.isFail("登陆接口出错！"));
		}
	}

}