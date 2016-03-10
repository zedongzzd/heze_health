package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class Dept extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String DeptId;
	private String Dept;
	private String AdmitAddress;

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
