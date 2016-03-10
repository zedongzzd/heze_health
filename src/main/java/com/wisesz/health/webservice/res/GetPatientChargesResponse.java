package com.wisesz.health.webservice.res;

import com.wisesz.health.webservice.bean.Charges;

import me.zzd.webapp.core.annotation.BindDomField;
import me.zzd.webapp.core.dom.Dom;

public class GetPatientChargesResponse extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ResultCode;
	private String PatientId;
	private String PatName;
	private String Inpno;
	@BindDomField(value = "visit_date")
	private String visit_date;
	private String LeaveDate;
	private Charges Charges;
	private String ErrorMsg;

	public String getResultCode() {
		return ResultCode;
	}

	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}

	public String getPatientId() {
		return PatientId;
	}

	public void setPatientId(String patientId) {
		PatientId = patientId;
	}

	public String getPatName() {
		return PatName;
	}

	public void setPatName(String patName) {
		PatName = patName;
	}

	public String getInpno() {
		return Inpno;
	}

	public void setInpno(String inpno) {
		Inpno = inpno;
	}

	public String getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}

	public String getLeaveDate() {
		return LeaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		LeaveDate = leaveDate;
	}

	public Charges getCharges() {
		return Charges;
	}

	public void setCharges(Charges charges) {
		Charges = charges;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

}
