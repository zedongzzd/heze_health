package com.wisesz.health.webservice.res;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

@BindDom("Response")
public class DoCancelRegisterResponse extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private String ErrorMsg;
	private String HDate;

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

	public String getHDate() {
		return HDate;
	}

	public void setHDate(String hDate) {
		HDate = hDate;
	}

}
