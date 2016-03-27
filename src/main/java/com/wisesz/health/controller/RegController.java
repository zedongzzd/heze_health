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
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.interceptor.WebLoginInterceptor;
import com.wisesz.health.model.Patient;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.service.HospitalService;
import com.wisesz.health.service.RegService;
import com.wisesz.health.service.UserService;
import me.zzd.webapp.core.annotation.BindController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.rmi.server.UID;
import java.text.ParseException;
import java.util.*;


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
        uid = "1";

        if(!StringHandler.isEmpty(uid)){
            User user = new User(uid,getPara("uname"),getPara("mobile"),getPara("deviceid"),getPara("platform"));
            UserService.doLogin(getRequest(),getResponse(),user);
        }

        setAttr("hosp"    , HospitalService.getHospital(getPara("hospId")));
        setAttr("dept"    , HospitalService.getDepart(getPara("deptId")));
        setAttr("titleBar", new TitleBar("","智慧医疗","/mine"));
        render("reg/index.html");
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
        Record hosp = HospitalService.getHospital(getPara("hospId"));
        setAttr("titleBar" , new TitleBar(HttpHandler.formatUrl("/reg",getParaMap()),StringHandler.defaultValue(hosp.get("hospName"),"科室选择"),""));
        render("reg/depart.html");
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


        List<Record> scheduals = HospitalService.getDeptScheduals(departId);
        List<String>   weeks   = new ArrayList<>();
        List<String>   dayName = new ArrayList<>();
        String [] week = new String[]{"星期日","星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String [] day  = new String[]{"今天","明天","后天"};
        Date nowDate   = new Date();

        //日期格式化输出
        if(scheduals!=null && scheduals.size()>0) {
            for (Record schedual : scheduals) {
                String date         = schedual.get("date").toString().replace("-","/");
                Date   scheduleDate = new Date(date);
                weeks.add(week[scheduleDate.getDay()]);
                try {
                    int diff =DateHandler.daysBetween(nowDate,scheduleDate);
                    if(diff<3){
                        dayName.add(day[diff]);
                    }else{
                        dayName.add("");
                    }
                } catch (ParseException e) {
                    dayName.add("");
                    log.error("日期处理出错");
                }
            }
        }

        setAttr("scheduals", scheduals);
        setAttr("weeks", weeks);
        setAttr("dayName",dayName);
        Record record = HospitalService.getDepart(getPara("deptId"));
        setAttr("titleBar" ,new TitleBar(HttpHandler.formatUrl("/reg",getParaMap()),StringHandler.defaultValue(record.get("name"),"号源选择"),""));

        render("reg/pools.html");
    }

    @Before(GET.class)
    public void doReg(){
        String hospId    = getPara("hospId");
        String deptId    = getPara("deptId");
        String rBASId    = getPara("rBASId");
        String date      = getPara("date");
        String patientId = getPara("patientId");

        //参数验证
        if(StringHandler.isEmpty(hospId)||StringHandler.isEmpty(deptId)||StringHandler.isEmpty(rBASId)||StringHandler.isEmpty(date)){
            try {
                getResponse().sendRedirect("/reg");
            } catch (IOException e) {
                log.error("跳转至首页出错");
            }
        }

        //获取病人信息
        User user = UserService.getUid(getRequest());

        if(user!=null && !StringHandler.isEmpty(user.getUid()) && !StringHandler.isEmpty(patientId)){
            setAttr("patient" , UserService.getPatient(user.getUid(),patientId));
        }else{
            setAttr("patient",new Patient());
        }

        //医院,科室信息
        Record hosp = HospitalService.getHospital(hospId);
        Record dept = HospitalService.getDepart(deptId);

        setAttr("hosp"     ,hosp);
        setAttr("dept"     ,dept);
        setAttr("rBASId"   ,rBASId );
        setAttr("date"     ,date );
        setAttr("titleBar" ,new TitleBar(HttpHandler.formatUrl("/reg/pools",getParaMap()),"预约挂号",""));
        render("reg/doReg.html");
    }

  /**
   * 挂号
   */
  @Before({POST.class, WebLoginInterceptor.class})
    public void doReg2(){
      String uid       = UserService.getUid(getRequest()).getUid();
      String patientId = getPara("patientId");
      String rBASId    = getPara("rBASId");

      if(!StringHandler.isEmpty(uid) && !StringHandler.isEmpty(patientId) && !StringHandler.isEmpty(rBASId)){
          renderJson(RegService.doRegister(uid,patientId,rBASId));
      }else{
          renderJson(Result.RespFactory.isFail("参数不全"));
      }

    }

    private  String decodeParam(String str){
        return URLDecoder.decode((URLDecoder.decode(URLDecoder.decode(str))));
    }
  /**
   * 挂号成功
   */
  @Before(GET.class)
    public void reg_succ(){
        setAttr("hospName"   , decodeParam(getPara("hospName")) );
        setAttr("deptName"   , decodeParam(getPara("deptName")));
        setAttr("patientName", decodeParam(getPara("patientName")));
        setAttr("date"       , decodeParam(getPara("date")));
        setAttr("address"    , decodeParam(getPara("address")));
        setAttr("admitRange" , decodeParam(getPara("admitRange")));
        setAttr("regFee" , getPara("regFee"));
        setAttr("serviceFee" , getPara("serviceFee"));
        setAttr("hDate" , getPara("hDate"));
        setAttr("titleBar" , new TitleBar("/reg","预约挂号",""));
        render("reg/reg_succ.html");
    }

  /**
   * 取消挂号
   */
  @Before({POST.class,WebLoginInterceptor.class})
  public void un_reg(){
    String appId = getPara("appId");
    if(StringHandler.isEmpty(appId)){
        renderJson(Result.RespFactory.isFail("缺少参数"));
    }else{
        renderJson(RegService.unRegister(UserService.getUid(getRequest()).getUid(),appId));

    }
  }
}
