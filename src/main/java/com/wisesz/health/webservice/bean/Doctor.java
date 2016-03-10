package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class Doctor extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String DoctorId;
	private String DoctorName;
	private String DoctorTitle;
	private String DeptId;
	private String Dept;
	private String AdmitAddress;

	public String getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getDoctorTitle() {
		return DoctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		DoctorTitle = doctorTitle;
	}

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public String getAdmitAddress() {
		return AdmitAddress;
	}

	public void setAdmitAddress(String admitAddress) {
		AdmitAddress = admitAddress;
	}

}
