package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.NullRender;
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
import java.util.*;


/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/reg",viewPath = "/web/view")
public class RegController extends Controller {
    private Log log = Log.getLog(getClass());
    
    public void baseRender(String viewPath,TitleBar titleBar,boolean isAddParam){
        String hospId   = StringHandler.defaultValue(getPara("hospId"),Const.HospitalId);
        String hospName = StringHandler.defaultValue(getPara("hospName"),"菏泽市第一人民医院");
        String deptId   = StringHandler.defaultValue(getPara("deptId"));
        String deptName = StringHandler.defaultValue(getPara("deptName"));
        setAttr("hospId"  , hospId);
        setAttr("hospName", hospName);
        setAttr("deptId"  , deptId);
        setAttr("deptName", deptName);
        Map<String,String> backParam = new HashMap<>();
        backParam.put("hospId"  , hospId);
        backParam.put("hospName", hospName);
        backParam.put("deptId"  , deptId);
        backParam.put("deptName", deptName);

        if(isAddParam){
            titleBar.setBackUrl(HttpHandler.formatUrl(titleBar.getBackUrl(),backParam));
        }
        setAttr("titleBar",titleBar);
        render(viewPath);
    }

    /**
     * 医疗首页
     */
    @Before(GET.class)
    public void index(){
        String uid = getPara("uid");
        uid = "1";

        if(!StringHandler.isEmpty(uid)){
            User user = new User(uid,getPara("uname"),getPara("mobile"),getPara("deviceid"),getPara("platform"));
            UserService.doLogin(getRequest(),getResponse(),user);
        }
        baseRender("reg/index.html",new TitleBar("","智慧医疗","/mine"),false);
    }



    /**
     * 科室选择
     */
    @Before(GET.class)
    public void depart(){
        List<Record> types = HospitalService.getDeptTypes();
        List<Record> depts =  HospitalService.getDeptlist(null, 1, 20);
        setAttr("depts"    , depts);
        setAttr("types"    , types);
        baseRender("reg/depart.html",new TitleBar("/reg",StringHandler.defaultValue(getPara("hospName"),"科室选择"),""),true);
    }
    
    @Before(POST.class)
    public void post_depart(){
        Integer typeId   = getParaToInt("typeId");
        Integer page     = getParaToInt("page");
        Integer pageSize = getParaToInt("pageSize");

        List<Record> depts = null;

        if(page ==null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = 20;
        }
        if(typeId ==null || typeId.compareTo(0)>0){
            depts = HospitalService.getDeptlist(typeId, page, pageSize);
        }

        setAttr("depts", depts);
        render("ftl/reg/dept.ftl");
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
        List<String>   weeks      = new ArrayList<>();
        String [] week = new String[]{"星期日","星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        if(scheduals!=null && scheduals.size()>0) {
            for (Schedual schedual : scheduals) {
                String date = schedual.getDate().replace("-","/");
                weeks.add(week[new Date(date).getDay()]);
            }
        }

        setAttr("scheduals", scheduals);
        setAttr("weeks", weeks);

        baseRender("reg/pools.html",new TitleBar("/reg",StringHandler.defaultValue(getPara("deptName"),"号源选择"),""),true);
    }
}
