package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.log.Log;
import com.wisesz.health.bean.User;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.service.UserService;
import me.zzd.webapp.core.annotation.BindController;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/web",viewPath = "/web/reg")
public class VRegController extends Controller {
    private Log log = Log.getLog(getClass());

    public void Login(){

    }

    @Before(GET.class)
    public void index(){
        String uid = getPara("uid");
        uid = "1600129";

        if(!StringHandler.isEmpty(uid)){
            User user = new User(uid,getPara("uname"),getPara("mobile"),getPara("deviceid"),getPara("platform"));
            UserService.doLogin(getRequest(),getResponse(),user);
        }

        setAttr("title","智慧医疗");
        setAttr("backUrl","#");
        setAttr("mineUrl","/web/mine");

        render("index.html");
    }
}
