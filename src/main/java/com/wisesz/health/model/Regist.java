package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_regist")
public class Regist extends Model<Regist> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Regist dao = new Regist();
	
	public int getId() {
		return getInt("id");
	}

	public Regist setId(int id) {
		return set("id", id);
	}
	
	public String getApptId() {
		return getStr("apptId");
	}

	public Regist setApptId(String apptId) {
		return set("apptId", apptId);
	}
	
	public String getSeqCode() {
		return getStr("seqCode");
	}

	public Regist setSeqCode(int seqCode) {
		return set("seqCode", seqCode);
	}
	
	public String getRegFee() {
		return getStr("regFee");
	}

	public Regist setRegFee(String regFee) {
		return set("regFee", regFee);
	}
	
	public String getServiceFee() {
		return getStr("serviceFee");
	}

	public Regist setServiceFee(String serviceFee) {
		return set("serviceFee", serviceFee);
	}
	
	public String getHDate() {
		return getStr("hDate");
	}

	public Regist setHDate(String hDate) {
		return set("hDate", hDate);
	}
	
	public String getAdmitRange() {
		return getStr("admitRange");
	}

	public Regist setAdmitRange(String admitRange) {
		return set("admitRange", admitRange);
	}
	
	public String getPatientId() {
		return getStr("patientId");
	}

	public Regist setPatientId(String patientId) {
		return set("patientId", patientId);
	}
	
	public String getUid() {
		return getStr("uid");
	}

	public Regist setUid(String uid) {
		return set("uid", uid);
	}
	
	public String getCreateDate() {
		return getStr("createDate");
	}

	public Regist setCreateDate(String createDate) {
		return set("createDate", createDate);
	}
	
	public String getUserID() {
		return getStr("userID");
	}

	public Regist setUserID(String userID) {
		return set("userID", userID);
	}
	
	public String getHospitalId() {
		return getStr("hospitalId");
	}

	public Regist setHospitalId(String hospitalId) {
		return set("hospitalId", hospitalId);
	}
	
	public String getDeptId() {
		return getStr("deptId");
	}

	public Regist setDeptId(String deptId) {
		return set("deptId", deptId);
	}
	
	public String getDocId() {
		return getStr("docId");
	}

	public Regist setDocId(String docId) {
		return set("docId", docId);
	}
	
	public int getState() {
		return getInt("state");
	}

	public Regist setState(int state) {
		return set("state", state);
	}
}
