package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class Doctors extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Doctor[] Doctor;

	public Doctor[] getDoctor() {
		return Doctor;
	}

	public void setDoctor(Doctor[] doctor) {
		Doctor = doctor;
	}

}
