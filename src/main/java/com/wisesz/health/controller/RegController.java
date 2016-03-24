package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.log.Log;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.service.HospitalService;
import com.wisesz.health.service.UserService;
import me.zzd.webapp.core.annotation.BindController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/reg",viewPath = "/web/view")
public class RegController extends Controller {
    private Log log = Log.getLog(getClass());

    /**
     * 医疗首页
     */
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
        setAttr("departId",1);
        setAttr("hospId", Const.HospitalId);
        render("reg/index.html");
    }



    /**
     * 科室选择
     */
    @Before(GET.class)
    public void depart(){
        render("reg/depart.html");
    }

    /**
     * 号源显示
     */
    @Before(GET.class)
    public void pools(){
        String hospId   = getPara("hospId");
        String departId = getPara("departId");


        if(StringHandler.isEmpty(departId)){
            try {
                getResponse().sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Schedual> scheduals = HospitalService.getDeptScheduals(departId);
        setAttr("scheduals",scheduals);
        render("reg/pools.html");
    }
}
