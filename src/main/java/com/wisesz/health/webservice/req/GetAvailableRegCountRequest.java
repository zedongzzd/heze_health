package com.wisesz.health.webservice.req;

import com.wisesz.health.webservice.bean.RBAS;

import me.zzd.webapp.core.dom.Dom;

/**
 * 1.4查询可挂号数（医院无限号）
 */
public class GetAvailableRegCountRequest extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TransactionId;
	private RBAS RBAS;

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	
	public RBAS getRBAS() {
		return RBAS;
	}

	public void setRBAS(RBAS rBAS) {
		RBAS = rBAS;
	}
}
