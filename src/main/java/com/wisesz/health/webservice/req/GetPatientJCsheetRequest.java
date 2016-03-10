package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientJCsheetRequest extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String HospitalId;
	private String TransactionId;
	private String CardNO;
	private String PatName;
	private String StartDate;
	private String EndDate;

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

	public String getCardNO() {
		return CardNO;
	}

	public void setCardNO(String cardNO) {
		CardNO = cardNO;
	}

	public String getPatName() {
		return PatName;
	}

	public void setPatName(String patName) {
		PatName = patName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
}
