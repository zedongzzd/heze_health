package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.annotation.BindDomField;
import me.zzd.webapp.core.dom.Dom;

public class Charge extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@BindDomField(value = "item_name")
	private String item_name;
	private String Cost;
	private String Sum;
	private String Charges;
	private String DeptName;

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}

	public String getSum() {
		return Sum;
	}

	public void setSum(String sum) {
		Sum = sum;
	}

	public String getCharges() {
		return Charges;
	}

	public void setCharges(String charges) {
		Charges = charges;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
}
