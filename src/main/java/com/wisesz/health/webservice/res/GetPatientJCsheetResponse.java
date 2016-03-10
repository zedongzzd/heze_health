package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.JCSheets;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJCsheetResponse extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private JCSheets JCSheets;
	private String ErrorMsg;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public JCSheets getJCSheets() {
		return JCSheets;
	}

	public void setJCSheets(JCSheets jCSheets) {
		JCSheets = jCSheets;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

}
