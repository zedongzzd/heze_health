package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class GetPatientChargesRequest extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String HospitalId;
	private String TransactionId;
	private String CardNO;
	private String Name;
	private String IDCard;
	private Integer State;

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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}

}
