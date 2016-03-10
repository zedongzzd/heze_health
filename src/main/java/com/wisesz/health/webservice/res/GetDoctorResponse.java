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
	private Doctors Doctor;

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

	public Doctors getDoctor() {
		return Doctor;
	}

	public void setDoctor(Doctors doctor) {
		Doctor = doctor;
	}
}
