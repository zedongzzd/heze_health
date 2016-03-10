package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJYsheetDetailRequest extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String HospitalId;
	private String TransactionId;
	private String ReqNo;
	private String ItemClass;

	public String getHospitalId() {
		return HospitalId;
	}

	public void setHospitalId(String hospitalId) {
		HospitalId = hospitalId;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getReqNo() {
		return ReqNo;
	}

	public void setReqNo(String reqNo) {
		ReqNo = reqNo;
	}

	public String getItemClass() {
		return ItemClass;
	}

	public void setItemClass(String itemClass) {
		ItemClass = itemClass;
	}
}
