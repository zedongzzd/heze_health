package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_schedual")
public class Schedual extends Model<Schedual> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Schedual dao = new Schedual();

	public String getId() {
		return getStr("id");
	}

	public Schedual setId(String id) {
		return set("id", id);
	}

	public String getDate() {
		return getStr("date");
	}

	public Schedual setDate(String date) {
		return set("date", date);
	}

	public String getHospitalId() {
		return getStr("hospitalId");
	}

	public Schedual setHospitalId(String hospitalId) {
		return set("hospitalId", hospitalId);
	}

	public String getDeptId() {
		return getStr("deptId");
	}

	public Schedual setDeptId(String deptId) {
		return set("deptId", deptId);
	}

	public String getDeptName() {
		return getStr("deptName");
	}

	public Schedual setDeptName(String deptName) {
		return set("deptName", deptName);
	}

	public String getSubjectId() {
		return getStr("subjectId");
	}

	public Schedual setSubjectId(String subjectId) {
		return set("subjectId", subjectId);
	}

	public String getSubject() {
		return getStr("subject");
	}

	public Schedual setSubject(String subject) {
		return set("subject", subject);
	}

	public String getDoctorIntro() {
		return getStr("doctorIntro");
	}

	public Schedual setDoctorIntro(String doctorIntro) {
		return set("doctorIntro", doctorIntro);
	}

	public String getPrice() {
		return getStr("price");
	}

	public Schedual setPrice(String price) {
		return set("price", price);
	}

	public String getTypeId() {
		return getStr("typeId");
	}

	public Schedual setTypeId(String typeId) {
		return set("typeId", typeId);
	}

	public String getType() {
		return getStr("type");
	}

	public Schedual setType(String type) {
		return set("type", type);
	}

	public String getGroupCode() {
		return getStr("groupCode");
	}

	public Schedual setGroupCode(String groupCode) {
		return set("groupCode", groupCode);
	}

	public String getGroupName() {
		return getStr("groupName");
	}

	public Schedual setGroupName(String groupName) {
		return set("groupName", groupName);
	}

	public String getAddress() {
		return getStr("address");
	}

	public Schedual setAddress(String address) {
		return set("address", address);
	}

	public String getResNo() {
		return getStr("resNo");
	}

	public Schedual setResNo(String resNo) {
		return set("resNo", resNo);
	}
}
