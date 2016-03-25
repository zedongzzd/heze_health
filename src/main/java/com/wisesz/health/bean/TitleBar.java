package com.wisesz.health.bean;


/**
 * Created by wangguohao on 16/3/24.
 */
public class TitleBar {
  private String backUrl;
  private String title  ;
  private String mineUrl;

  public TitleBar(String backUrl,String title,String mineUrl){
    this.backUrl = backUrl;
    this.title   = title;
    this.mineUrl = mineUrl;
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
}
