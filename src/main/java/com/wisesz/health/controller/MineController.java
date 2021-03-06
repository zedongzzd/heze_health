package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Record;

import com.wisesz.health.bean.TitleBar;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.interceptor.WebLoginInterceptor;
import com.wisesz.health.model.Patient;

import com.wisesz.health.service.RegService;
import com.wisesz.health.service.UserService;
import me.zzd.webapp.core.annotation.BindController;


import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/mine",viewPath = "/web/view")
public class MineController extends Controller{
  private Log log = Log.getLog(getClass());
  /**
     * 获取登录信息
     */
    @Before(GET.class)
    public void getUser(){
      try {
        User user = UserService.getUid(getRequest());

        if (user != null && !StringHandler.isEmpty(user.getUid())) {
          renderJson(Result.RespFactory.isOk("", user));
        } else {
          renderJson(Result.RespFactory.isFail("未登录", user));
        }
      }catch (Exception e){
        log.error("验证用户登录出错",e);
        renderJson(Result.RespFactory.isFail("验证用户登录出错"));
      }

    }

  /**
   * 登录成功
   */
  @Before(POST.class)
  public  void loginSuccess(){
    String uid = getPara("uid");

    if(!StringHandler.isEmpty(uid)){
      User user = new User(uid,getPara("nickname"),getPara("phone"));
      UserService.doLogin(getRequest(),getResponse(),user);
      renderJson(Result.RespFactory.isOk("",user));
    }else{
      UserService.doLogin(getRequest(),getResponse(),new User(null,null,null));
      renderJson(Result.RespFactory.isFail(""));
    }
  }

  /**
   * 我的挂号页面
   */
    @Before({GET.class, WebLoginInterceptor.class})
    public void index(){
        User user = UserService.getUid(getRequest());

        List<Record> registList = RegService.getRegists(user.getUid(),1,10);

        setAttr("registers" , addTime(registList));
        setAttr("titleBar"     , new TitleBar("/reg", "我的挂号", "/mine/patients", "常用人"));
        render("mine/registers.html");
    }

  /**
   * 分页获取我的挂号单
   */
  @Before({POST.class,WebLoginInterceptor.class})
    public void post_registers(){
        User user = UserService.getUid(getRequest());

        Integer page     = getParaToInt("page");
        Integer pageSize = getParaToInt("pageSize");

        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = 10;
        }

        List<Record> registList = RegService.getRegists(user.getUid(),page,pageSize);
        setAttr("registers" , addTime(registList));
        render("ftl/mine/register.ftl");
    }

  public List<Record> addTime(List<Record> registerList){

    if(registerList != null && registerList.size() > 0) {
      for (Record record : registerList) {
        boolean isOvertime = false;
        String hDate      = record.get("hDate");
        String admitRange = record.get("admitRange").toString();

        try {
          record.set("isOverTime", new Date().getTime() > DateHandler.dateTimeFormat.parse(hDate+" "+admitRange.split("-")[1]).getTime());
        }catch (Exception e){record.set("isOverTime", false);}
      }
    }

    return registerList;
  }

  /**
   * 就诊人列表
   */
  @Before({GET.class, WebLoginInterceptor.class})
    public void patients(){
        User user = UserService.getUid(getRequest());
        List<Record> patients = UserService.getPatients(user.getUid());
        String type = getPara("type","");
        setAttr("type"     , type);
        setAttr("patients" , patients);

        if(type.equals("reg")){
          setAttr("titleBar" , new TitleBar(HttpHandler.formatUrl("/reg/doReg",getParaMap()),"选择挂号人",""));
        }else{
          setAttr("titleBar" , new TitleBar("/mine","我的挂号人",""));
        }

        render("mine/patients.html");
    }

  /**
   * 就诊人删除
   */
  @Before({POST.class,WebLoginInterceptor.class})
  public void delete_patient(){
    User user = UserService.getUid(getRequest());

    String patientId = getPara("id");

    if(StringHandler.isEmpty(patientId)){
      renderJson(Result.RespFactory.isFail("参数不全"));
    }else {
      renderJson(Result.RespFactory.isOk("",UserService.delPatient(user.getUid(),patientId)));
    }
  }


  /**
   * 就诊人编辑
   */
  @Before({GET.class, WebLoginInterceptor.class})
    public void edit_patient(){
      User user = UserService.getUid(getRequest());

      String patientId = getPara("id"); //病人id
      String type      = getPara("type","");      //为reg时,表示挂号时选择就诊人
      String title     = StringHandler.isEmpty(patientId) ? "新增挂号人" : "编辑挂号人";

      if(!StringHandler.isEmpty(patientId)){
          Record patient   = UserService.getPatient(user.getUid(),patientId);
          setAttr("patient" , patient);
      }else{
          setAttr("patient" , new Patient());
      }

      setAttr("titleBar" , new TitleBar(HttpHandler.formatUrl("/mine/patients",getParaMap()),title,""));

      setAttr("type",type);
      render("mine/patient.html");
    }

   /**
   * 就诊人新增or编辑
   */
    @Before({POST.class,WebLoginInterceptor.class})
    public void patient(){
        String id        = getPara("id");
        String patientId = getPara("patientId");
        String cardNo    = getPara("cardNo");
        String idCard    = getPara("idCard");
        String phone     = getPara("phone");
        String name      = getPara("name");
        Integer type     = getParaToInt("type");
        User user =UserService.getUid(getRequest());
        String uid = user.getUid();
        if(StringHandler.isEmpty(cardNo) || StringHandler.isEmpty(idCard) || StringHandler.isEmpty(phone) || StringHandler.isEmpty(name) || type ==null){
            renderJson(Result.RespFactory.isFail("参数异常"));
        }

        if(StringHandler.isEmpty(id)){//新增
            renderJson(UserService.addPatient(cardNo,idCard,phone,name,type,uid));
        }else{//修改
            renderJson(UserService.updatePatient(id,patientId,cardNo,idCard,phone,name,type,uid));
        }

    }

}
