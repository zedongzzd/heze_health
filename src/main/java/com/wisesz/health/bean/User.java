package com.wisesz.health.bean;

import java.io.Serializable;

/**
 * Created by wangguohao on 16/3/23.
 */
public class User implements Serializable {

    /**
     * 用户UID,没有登录为0
     */
    private String uid;

    /**
     * 用户昵称,没有登录为空
     */
    private String nickname;

    /**
     * 用户手机号，没有登录为空
     */
    private String phone;

    public User (String uid,String nickname,String phone){
        this.uid      = uid;
        this.nickname = nickname;
        this.phone    = phone;
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
