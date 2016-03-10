package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;

public class HisCheckPatientInfoRequest extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TransactionId;
	private String CardNO;
	private String Name;
	private String IDCard;
	private Integer Type;

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

	public Integer getType() {
		return Type;
	}

	public void setType(Integer type) {
		Type = type;
	}

}
