package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_doctor")
public class Doctor extends Model<Doctor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Doctor dao = new Doctor();

	public String getDoctorId() {
		return getStr("doctorId");
	}

	public Doctor setDoctorId(String doctorId) {
		return set("doctorId", doctorId);
	}

	public String getName() {
		return getStr("name");
	}

	public Doctor setName(String name) {
		return set("name", name);
	}

	public String getTitle() {
		return getStr("title");
	}

	public Doctor setTitle(String title) {
		return set("title", title);
	}

	public String getDeptId() {
		return getStr("deptId");
	}

	public Doctor setDeptId(String deptId) {
		return set("deptId", deptId);
	}

	public String getAddress() {
		return getStr("address");
	}

	public Doctor setAddress(String address) {
		return set("address", address);
	}
}
