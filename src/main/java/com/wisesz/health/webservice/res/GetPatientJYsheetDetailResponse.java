package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.JYSheetDetails;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJYsheetDetailResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private JYSheetDetails JYSheetDetails;
	private String ErrorMsg;

	public JYSheetDetails getJYSheetDetails() {
		return JYSheetDetails;
	}

	public void setJYSheetDetails(JYSheetDetails jYSheetDetails) {
		JYSheetDetails = jYSheetDetails;
	}

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
}
