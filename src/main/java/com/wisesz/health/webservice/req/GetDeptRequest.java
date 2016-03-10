package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

/**
 * 1.1医院科室（只要临床科室）
 */
@BindDom("Request")
public class GetDeptRequest extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transactionId;
	/**
	 * @param 1
	 *            全部科室
	 * @param 2
	 *            门诊科室
	 * @param 3
	 *            非门诊科室
	 */
	private Integer type;
	private String hospitalId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
}
