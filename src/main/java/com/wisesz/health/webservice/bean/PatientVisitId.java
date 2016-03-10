package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class PatientVisitId extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PatVisitId[] PatVisitId;

	public PatVisitId[] getPatVisitId() {
		return PatVisitId;
	}

	public void setPatVisitId(PatVisitId[] patVisitId) {
		PatVisitId = patVisitId;
	}
}
