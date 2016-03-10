package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class UserInfo extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PatientId;

	public String getPatientId() {
		return PatientId;
	}

	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
}
