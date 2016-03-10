package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class RBASRec extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RBASId;
	private String RBASDate;
	private String DeptId;
	private String DeptName;
	private String RBASPrice;
	private String RBASSessionTypeId;
	private String RBASSessionType;
	private String ClinicGroupCode;
	private String ClinicGroupName;
	private String AdmitAddress;
	// 可预约挂号数量
	private String ResNo;
	// 可挂号数
	private Integer Remain;

	public String getRBASId() {
		return RBASId;
	}

	public void setRBASId(String rBASId) {
		RBASId = rBASId;
	}

	public String getRBASDate() {
		return RBASDate;
	}

	public void setRBASDate(String rBASDate) {
		RBASDate = rBASDate;
	}

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getRBASPrice() {
		return RBASPrice;
	}

	public void setRBASPrice(String rBASPrice) {
		RBASPrice = rBASPrice;
	}

	public String getRBASSessionTypeId() {
		return RBASSessionTypeId;
	}

	public void setRBASSessionTypeId(String rBASSessionTypeId) {
		RBASSessionTypeId = rBASSessionTypeId;
	}

	public String getRBASSessionType() {
		return RBASSessionType;
	}

	public void setRBASSessionType(String rBASSessionType) {
		RBASSessionType = rBASSessionType;
	}

	public String getClinicGroupCode() {
		return ClinicGroupCode;
	}

	public void setClinicGroupCode(String clinicGroupCode) {
		ClinicGroupCode = clinicGroupCode;
	}

	public String getClinicGroupName() {
		return ClinicGroupName;
	}

	public void setClinicGroupName(String clinicGroupName) {
		ClinicGroupName = clinicGroupName;
	}

	public String getAdmitAddress() {
		return AdmitAddress;
	}

	public void setAdmitAddress(String admitAddress) {
		AdmitAddress = admitAddress;
	}

	public String getResNo() {
		return ResNo;
	}

	public void setResNo(String resNo) {
		ResNo = resNo;
	}

	public Integer getRemain() {
		return Remain;
	}

	public void setRemain(Integer remain) {
		Remain = remain;
	}

}
