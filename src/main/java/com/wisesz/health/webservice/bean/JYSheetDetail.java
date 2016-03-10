package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class JYSheetDetail extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ItemName;
	private String Result;
	private String Units;
	private String Indicator;
	private String ResultRange;
	private String Code;

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getUnits() {
		return Units;
	}

	public void setUnits(String units) {
		Units = units;
	}

	public String getIndicator() {
		return Indicator;
	}

	public void setIndicator(String indicator) {
		Indicator = indicator;
	}

	public String getResultRange() {
		return ResultRange;
	}

	public void setResultRange(String resultRange) {
		ResultRange = resultRange;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

}
