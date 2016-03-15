package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.RBAS;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

@BindDom("Response")
public class GetAvailableRegResponse extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ResultCode;
	private RBAS RBAS;
	private String ErrorMsg;

	public String getResultCode() {
		return ResultCode;
	}

	public void setResultCode(String resultCode) {
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
