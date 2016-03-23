package com.wisesz.health.bean;

/**
 * Created by wangguohao on 16/3/23.
 */
public class User {
    /**
     * 用户UID,没有登录为0
     */
    private String uid;

    /**
     * 用户昵称,没有登录为空
     */
    private String uname;

    /**
     * 用户手机号，没有登录为空
     */
    private String mobile;

    /**
     *  设备唯一标识
     */
    private String deviceid;

    /**
     * 平台 1 ios；2 android
     */
    private String platform;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public User(){}

    public User(String uid ,String uname,String mobile,String deviceid,String platform){}
}
