package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

/**
 * 1.3医院排班信息
 */
@BindDom(value = "Request")
public class GetArrangementRequest extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doctorId;
	private String deptId;
	private String RBASDate;
	private Integer RBASDay;
	private String transactionId;

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRBASDate() {
		return RBASDate;
	}

	public void setRBASDate(String rBASDate) {
		RBASDate = rBASDate;
	}

	public Integer getRBASDay() {
		return RBASDay;
	}

	public void setRBASDay(Integer rBASDay) {
		RBASDay = rBASDay;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
