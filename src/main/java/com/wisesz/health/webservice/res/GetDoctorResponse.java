package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.Doctors;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

@BindDom(value = "Response")
public class GetDoctorResponse extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private String ErrorMsg;
	private Doctors Doctors;

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

	public Doctors getDoctors() {
		return Doctors;
	}

	public void setDoctors(Doctors doctors) {
		Doctors = doctors;
	}

}
