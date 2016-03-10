package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.UserInfo;

public class HisCheckPatientInfoResponse {
	private Integer ResultCode;
	private String ErrorMsg;
	private UserInfo UserInfo;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public UserInfo getUserInfo() {
		return UserInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		UserInfo = userInfo;
	}
}
