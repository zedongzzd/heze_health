package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class DoCancelRegisterRequest extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TransactionId;
	private String ApptId;
	private String UserID;
	private String ClientAddress;
	private String Method;
	private String BDate;

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getApptId() {
		return ApptId;
	}

	public void setApptId(String apptId) {
		ApptId = apptId;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getClientAddress() {
		return ClientAddress;
	}

	public void setClientAddress(String clientAddress) {
		ClientAddress = clientAddress;
	}

	public String getMethod() {
		return Method;
	}

	public void setMethod(String method) {
		Method = method;
	}

	public String getBDate() {
		return BDate;
	}

	public void setBDate(String bDate) {
		BDate = bDate;
	}

}
