package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class JCSheetDetail extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Description;
	private String Impression;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImpression() {
		return Impression;
	}
	public void setImpression(String impression) {
		Impression = impression;
	}
}
