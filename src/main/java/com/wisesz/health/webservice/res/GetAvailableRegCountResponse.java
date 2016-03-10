package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.RBAS;

import me.zzd.webapp.core.dom.Dom;

public class GetAvailableRegCountResponse extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private RBAS RBAS;
	private String ErrorMsg;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public RBAS getRBAS() {
		return RBAS;
	}

	public void setRBAS(RBAS rBAS) {
		RBAS = rBAS;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
}
