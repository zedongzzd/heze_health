package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

/**
 * 1.2科室医生(只要专家医生)
 */
@BindDom(value = "Request")
public class GetDoctorRequest extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transactionId;
	private String deptId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
