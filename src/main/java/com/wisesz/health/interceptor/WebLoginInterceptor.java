package com.wisesz.health.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;

import java.io.IOException;

/**
 * Created by wangguohao on 16/3/24.
 */
public class WebLoginInterceptor implements Interceptor {
  @Override
  public void intercept(Invocation inv) {
    Controller c = inv.getController();
    String flag = HttpHandler.getCookie(c.getRequest(), Const.Login_Fag);
    if (StringHandler.isEmpty(flag)) {
      doIntercept(c);
      return;
    }
    Object o = CacheHandler.cache(Const.Cache_Name_login, flag);
    if (o != null && o instanceof User) {
      inv.invoke();
    } else {
      doIntercept(c);
    }
  }

  public void doIntercept(Controller c) {
    if ("POST".equalsIgnoreCase(c.getRequest().getMethod().toUpperCase())) {
      c.renderJson(Result.RespFactory.newInstance(-500, "尚未登录！", null));
    } else {
      try {
        c.getResponse().sendRedirect("/reg");
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}
