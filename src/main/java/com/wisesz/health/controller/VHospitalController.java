package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.log.Log;
import me.zzd.webapp.core.annotation.BindController;

/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/web",viewPath = "/web/")
public class VHospitalController extends Controller {
    private Log log = Log.getLog(getClass());

    @Before(GET.class)
    public void index(){
        setAttr("title","智慧医疗");
        setAttr("backUrl","#");
        setAttr("mineUrl","/web/mine");
        render("index.html");
    }
}
