package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientVisitIdRequest extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String HospitalId;
	private String TransactionId;
	private String PatientId;
	private String PatientName;
	private Integer State;

	public String getHospitalId() {
		return HospitalId;
	}

	public void setHospitalId(String hospitalId) {
		HospitalId = hospitalId;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getPatientId() {
		return PatientId;
	}

	public void setPatientId(String patientId) {
		PatientId = patientId;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}
	
}
