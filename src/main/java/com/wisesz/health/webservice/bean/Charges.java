package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class Charges extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Charge[] Charge;

	public Charge[] getCharge() {
		return Charge;
	}

	public void setCharge(Charge[] charge) {
		Charge = charge;
	}
}
