package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Result;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.service.UserService;

/**
 * Created by wangguohao on 16/3/23.
 */
public class MineController extends Controller{

    /**
     * 获取登录信息
     */
    @Before(GET.class)
    public void getUser(){
        User user = UserService.getUid(getRequest());
        if(user !=null && !StringHandler.isEmpty(user.getUid())){
            renderJson(Result.RespFactory.isOk("",user));
        }
        renderJson(Result.RespFactory.isFail("未登录",null));

    }
}
