package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class PatVisitId extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PatientId;
	private String PatientName;
	private String VisitId;
	private String VisitDate;
	private String LeaveDate;

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

	public String getVisitId() {
		return VisitId;
	}

	public void setVisitId(String visitId) {
		VisitId = visitId;
	}

	public String getVisitDate() {
		return VisitDate;
	}

	public void setVisitDate(String visitDate) {
		VisitDate = visitDate;
	}

	public String getLeaveDate() {
		return LeaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		LeaveDate = leaveDate;
	}
}
