package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Record;
import com.wisesz.health.bean.TitleBar;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Const;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.service.HospitalService;
import com.wisesz.health.service.UserService;
import me.zzd.webapp.core.annotation.BindController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/reg",viewPath = "/web/view")
public class RegController extends Controller {
    private Log log = Log.getLog(getClass());

    public void baseRender(String viewPath, HttpServletRequest request){
        setAttr("hospId"  , StringHandler.defaultValue(getPara("hospId"),Const.HospitalId));
        setAttr("hospName", StringHandler.defaultValue(getPara("hospName"),"山东菏泽医院"));
        setAttr("deptId"  , StringHandler.defaultValue(getPara("deptId")));
        setAttr("deptName", StringHandler.defaultValue(getPara("deptName")));

        render(viewPath);
    }

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

        setAttr("titleBar",new TitleBar("","智慧医疗","/mine"));

        baseRender("reg/index.html",getRequest());
    }



    /**
     * 科室选择
     */
    @Before(GET.class)
    public void depart(){
        List<Record> types = HospitalService.getDeptTypes();
        List<Record> depts = null;

        if(types !=null && types.size()>0){
            Integer typeId = types.get(0).get("typeId");
            if(typeId != null) {
                HospitalService.getDeptlist(typeId, 1, 20);
            }
        }

        setAttr("titleBar" , new TitleBar("/reg",StringHandler.defaultValue(getPara("hospName"),"科室选择"),""));
        setAttr("depts"    , depts);
        baseRender("reg/depart.html",getRequest());
    }

    /**
     * 号源显示
     */
    @Before(GET.class)
    public void pools(){
        String hospId   = StringHandler.defaultValue(getPara("hospId"));
        String departId = StringHandler.defaultValue(getPara("deptId"));


        if(StringHandler.isEmpty(departId)){
            try {
                getResponse().sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Schedual> scheduals = HospitalService.getDeptScheduals(departId);
        setAttr("scheduals", scheduals);
        setAttr("titleBar" , new TitleBar("/reg",StringHandler.defaultValue(getPara("deptName"),"号源选择"),""));

        baseRender("reg/pools.html",getRequest());
    }
}
