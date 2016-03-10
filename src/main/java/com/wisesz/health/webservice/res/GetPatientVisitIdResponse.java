package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.PatientVisitId;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientVisitIdResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private PatientVisitId PatientVisitId;
	private String ErrorMsg;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public PatientVisitId getPatientVisitId() {
		return PatientVisitId;
	}

	public void setPatientVisitId(PatientVisitId patientVisitId) {
		PatientVisitId = patientVisitId;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
}
