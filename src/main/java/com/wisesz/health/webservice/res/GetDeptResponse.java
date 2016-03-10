package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.Depts;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.dom.Dom;

@BindDom("Response")
public class GetDeptResponse extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ResultCode;
	private String ErrorMsg;
	private Depts Depts;

	public Integer getResultCode() {
		return ResultCode;
	}

	public void setResultCode(Integer resultCode) {
		ResultCode = resultCode;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public Depts getDepts() {
		return Depts;
	}

	public void setDepts(Depts depts) {
		Depts = depts;
	}

}
