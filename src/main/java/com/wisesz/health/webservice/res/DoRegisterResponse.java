package com.wisesz.health.webservice.res;

import me.zzd.webapp.core.dom.Dom;

public class DoRegisterResponse extends Dom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ResultCode;
	private String ApptId;
	private String SeqCode;
	private String RegFee;
	private String ServiceFee;
	private String HDate;
	private String AdmitRange;
	private String ErrorMsg;

	public String getResultCode() {
		return ResultCode;
	}

	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}

	public String getApptId() {
		return ApptId;
	}

	public void setApptId(String apptId) {
		ApptId = apptId;
	}

	public String getSeqCode() {
		return SeqCode;
	}

	public void setSeqCode(String seqCode) {
		SeqCode = seqCode;
	}

	public String getRegFee() {
		return RegFee;
	}

	public void setRegFee(String regFee) {
		RegFee = regFee;
	}

	public String getServiceFee() {
		return ServiceFee;
	}

	public void setServiceFee(String serviceFee) {
		ServiceFee = serviceFee;
	}

	public String getHDate() {
		return HDate;
	}

	public void setHDate(String hDate) {
		HDate = hDate;
	}

	public String getAdmitRange() {
		return AdmitRange;
	}

	public void setAdmitRange(String admitRange) {
		AdmitRange = admitRange;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

}
