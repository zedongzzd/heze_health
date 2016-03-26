package com.wisesz.health.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Record;
import com.wisesz.health.bean.TitleBar;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.interceptor.WebLoginInterceptor;
import com.wisesz.health.model.Patient;
import com.wisesz.health.service.RegService;
import com.wisesz.health.service.UserService;

import me.zzd.webapp.core.annotation.BindController;

/**
 * Created by wangguohao on 16/3/23.
 */
@BindController(value = "/mine",viewPath = "/web/view")
public class MineController extends Controller{

  /**
     * 获取登录信息
     */
    @Before(GET.class)
    public void getUser(){
        User user = UserService.getUid(getRequest());
        if(user !=null && !StringHandler.isEmpty(user.getUid())){
            renderJson(Result.RespFactory.isOk("",null));
        }
        renderJson(Result.RespFactory.isFail("未登录",null));

    }

  /**
   * 我的挂号页面
   */
    @Before({GET.class,WebLoginInterceptor.class})
    public void index(){
        //User user = UserService.getUid(getRequest());
    	String uid=getPara("uid");
        List<Record> registList = RegService.getRegists(uid,1,10);
        setAttr("registers" , registList);
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

        List<Record> registList = RegService.getRegists(user.getUid(),1,10);
        setAttr("registers" , registList);
        render("ftl/mine/register.ftl");
    }


  /**
   * 就诊人列表
   */
  @Before({GET.class, WebLoginInterceptor.class})
    public void patients(){
        User user = UserService.getUid(getRequest());

        List<Record> patients = UserService.getPatients(user.getUid());


        setAttr("patients" , patients);
        setAttr("titleBar" , new TitleBar("/mine","我的常用人",""));
        render("mine/patients.html");
    }


  /**
   * 就诊人编辑
   */
  @Before({GET.class, WebLoginInterceptor.class})
    public void edit_patient(){
      User user = UserService.getUid(getRequest());

      String patientId = getPara("patientId"); //病人id
      String type      = getPara("type","");      //为reg时,表示挂号时选择就诊人
      String title     = StringHandler.isEmpty(patientId) ? "新增挂号人" : "编辑挂号人";

      if(!StringHandler.isEmpty(patientId)){
          Record patient   = UserService.getPatient(user.getUid(),patientId);
          setAttr("patient" , patient);
      }else{
          setAttr("patient" , new Patient());
      }


      if(type.equals("reg")){//科室选择
          setAttr("titleBar" , new TitleBar(HttpHandler.formatUrl("/reg/doRegister",null),title,""));
      }else{
          setAttr("titleBar" , new TitleBar("/patients",title,""));
      }

      setAttr("type",type);
      render("mine/patient.html");
    }

   /**
   * 就诊人新增or编辑
   */
    @Before({POST.class,WebLoginInterceptor.class})
    public void patient(){
        String patientId = getPara("patientId");
        String cardNo    = getPara("cardNo");
        String idCard    = getPara("idCard");
        String phone     = getPara("phone");
        String name      = getPara("name");
        Integer type     = getParaToInt("type");

        if(StringHandler.isEmpty(cardNo) || StringHandler.isEmpty(idCard) || StringHandler.isEmpty(phone) || StringHandler.isEmpty(name) || type ==null){
            renderJson(Result.RespFactory.isFail("参数异常"));
        }

        if(StringHandler.isEmpty(patientId)){
            renderJson(Result.RespFactory.isOk("",UserService.addPatient(cardNo,idCard,phone,name,type)));
        }else{
            //todo 新增
        }

    }

}
