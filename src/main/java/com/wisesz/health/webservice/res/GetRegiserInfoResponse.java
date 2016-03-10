package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.RegItems;

import me.zzd.webapp.core.dom.Dom;

public class GetRegiserInfoResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private RegItems RegItems;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public RegItems getRegItems() {
		return RegItems;
	}

	public void setRegItems(RegItems regItems) {
		RegItems = regItems;
	}
}
