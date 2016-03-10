package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class RegItem extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ApptId;
	private String Hospital;
	private String ClinicGroup;
	private String RBASDate;
	private String AdmitRange;
	private String Doctor;
	private String AdmitAddress;
	private String SeqCode;
	private String RegFee;
	private String ServiceFee;
	private String Apptmethod;
	private String PayFlag;

	public String getApptId() {
		return ApptId;
	}

	public void setApptId(String apptId) {
		ApptId = apptId;
	}

	public String getHospital() {
		return Hospital;
	}

	public void setHospital(String hospital) {
		Hospital = hospital;
	}

	public String getClinicGroup() {
		return ClinicGroup;
	}

	public void setClinicGroup(String clinicGroup) {
		ClinicGroup = clinicGroup;
	}

	public String getRBASDate() {
		return RBASDate;
	}

	public void setRBASDate(String rBASDate) {
		RBASDate = rBASDate;
	}

	public String getAdmitRange() {
		return AdmitRange;
	}

	public void setAdmitRange(String admitRange) {
		AdmitRange = admitRange;
	}

	public String getDoctor() {
		return Doctor;
	}

	public void setDoctor(String doctor) {
		Doctor = doctor;
	}

	public String getAdmitAddress() {
		return AdmitAddress;
	}

	public void setAdmitAddress(String admitAddress) {
		AdmitAddress = admitAddress;
	}

	public String getSeqCode() {
		return SeqCode;
	}

	public void setSeqCode(String seqCode) {
		SeqCode = seqCode;
	}

	public String getRegFee() {
		return RegFee;
	}

	public void setRegFee(String regFee) {
		RegFee = regFee;
	}

	public String getServiceFee() {
		return ServiceFee;
	}

	public void setServiceFee(String serviceFee) {
		ServiceFee = serviceFee;
	}

	public String getApptmethod() {
		return Apptmethod;
	}

	public void setApptmethod(String apptmethod) {
		Apptmethod = apptmethod;
	}

	public String getPayFlag() {
		return PayFlag;
	}

	public void setPayFlag(String payFlag) {
		PayFlag = payFlag;
	}
}
