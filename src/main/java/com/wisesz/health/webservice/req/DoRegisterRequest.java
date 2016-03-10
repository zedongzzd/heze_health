package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class DoRegisterRequest extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PatientId;
	private String RBASId;
	private String TransactionId;
	private String Bdate;
	private String PhoneNumber;
	private String UserID;
	private String ClientAddress;
	private String Method;

	public String getPatientId() {
		return PatientId;
	}

	public void setPatientId(String patientId) {
		PatientId = patientId;
	}

	public String getRBASId() {
		return RBASId;
	}

	public void setRBASId(String rBASId) {
		RBASId = rBASId;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getBdate() {
		return Bdate;
	}

	public void setBdate(String bdate) {
		Bdate = bdate;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
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

}
