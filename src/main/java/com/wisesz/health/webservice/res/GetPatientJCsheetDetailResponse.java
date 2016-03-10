package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.JCSheetDetail;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJCsheetDetailResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private JCSheetDetail JCSheetDetail;
	private String ErrorMsg;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public JCSheetDetail getJCSheetDetail() {
		return JCSheetDetail;
	}

	public void setJCSheetDetail(JCSheetDetail jCSheetDetail) {
		JCSheetDetail = jCSheetDetail;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
}
