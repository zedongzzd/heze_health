package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.JYSheets;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJYsheetResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private JYSheets JYSheets;
	private String ErrorMsg;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public JYSheets getJYSheets() {
		return JYSheets;
	}

	public void setJYSheets(JYSheets jYSheets) {
		JYSheets = jYSheets;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
}
