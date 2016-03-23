package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_patient",pkName="patientId")
public class Patient extends Model<Patient> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Patient dao = new Patient();

<<<<<<< HEAD
	public String getPhone(){
		return getStr("phone");
	}
	public Patient setPhone(String phone) {
		return set("phone", phone);
	}
	
=======
>>>>>>> b335b2b777a535494d74643b682f63efe7ef0057
	
	public String getPatientId() {
		return getStr("patientId");
	}

	public Patient setPatientId(String patientId) {
		return set("patientId", patientId);
	}

	public String getCardNo() {
		return getStr("cardNo");
	}

	public Patient setCardNo(String cardNo) {
		return set("cardNo", cardNo);
	}

	public String getName() {
		return getStr("name");
	}

	public Patient setName(String name) {
		return set("name", name);
	}

	public String getIdCard() {
		return getStr("idCard");
	}

	public Patient setIdCard(String idCard) {
		return set("idCard", idCard);
	}

	public Integer getType() {
		return getInt("type");
	}

	public Patient setType(Integer type) {
		return set("type", type);
	}

	public String getUid() {
		return getStr("uid");
	}

	public Patient setUid(String uid) {
		return set("uid", uid);
	}

	public String getPhone() {
		return getStr("phone");
	}

	public Patient setPhone(String phone) {
		return set("phone", phone);
	}
}
