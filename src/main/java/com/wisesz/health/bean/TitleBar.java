package com.wisesz.health.bean;


/**
 * Created by wangguohao on 16/3/24.
 */
public class TitleBar {
 //左链接
  private String backUrl;
//  标题
  private String title  ;
//  右连接
  private String mineUrl;
//  右连接文字
  private String mineText;

  public TitleBar(String backUrl,String title,String mineUrl){
    this.backUrl = backUrl;
    this.title   = title;
    this.mineUrl = mineUrl;
  }

  public TitleBar(String backUrl,String title,String mineUrl,String mineText){
    this.backUrl = backUrl;
    this.title   = title;
    this.mineUrl = mineUrl;
    this.mineText= mineText;
  }
  public String getBackUrl() {
    return backUrl;
  }

  public void setBackUrl(String backUrl) {
    this.backUrl = backUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMineUrl() {
    return mineUrl;
  }

  public void setMineUrl(String mineUrl) {
    this.mineUrl = mineUrl;
  }

  public String getMineText() {
    return mineText;
  }

  public void setMineText(String mineText) {
    this.mineText = mineText;
  }
}
