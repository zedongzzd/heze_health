package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_dept")
public class Dept extends Model<Dept> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Dept dao = new Dept();

	public String getDeptId() {
		return getStr("deptId");
	}

	public Dept setDeptId(String deptId) {
		return set("deptId", deptId);
	}

	public String getName() {
		return getStr("name");
	}

	public Dept setName(String name) {
		return set("name", name);
	}

	public String getAddress() {
		return getStr("address");
	}

	public Dept setAddress(String address) {
		return set("address", address);
	}

	public String getHospitalId() {
		return getStr("hospitalId");
	}

	public Dept setHospitalId(String hospitalId) {
		return set("hospitalId", hospitalId);
	}

	public Integer getType() {
		return getInt("type");
	}

	public Dept setType(Integer type) {
		return set("type", type);
	}
}
