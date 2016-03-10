package com.wisesz.health.webservice.bean;

import me.zzd.webapp.core.dom.Dom;

public class Sheet extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ReqNo;
	private String ItemClass;
	private String ItemSubClass;
	private String State;
	private String DocId;
	private String Diagnostic;
	private String SendDocName;
	private String AuditDocName;
	private String DeptName;
	private String CheckTime;
	private String ReportTime;
	private String ReceiveTime;
	private String CollectTime;

	public String getReqNo() {
		return ReqNo;
	}

	public void setReqNo(String reqNo) {
		ReqNo = reqNo;
	}

	public String getItemClass() {
		return ItemClass;
	}

	public void setItemClass(String itemClass) {
		ItemClass = itemClass;
	}

	public String getItemSubClass() {
		return ItemSubClass;
	}

	public void setItemSubClass(String itemSubClass) {
		ItemSubClass = itemSubClass;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDocId() {
		return DocId;
	}

	public void setDocId(String docId) {
		DocId = docId;
	}

	public String getDiagnostic() {
		return Diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		Diagnostic = diagnostic;
	}

	public String getSendDocName() {
		return SendDocName;
	}

	public void setSendDocName(String sendDocName) {
		SendDocName = sendDocName;
	}

	public String getAuditDocName() {
		return AuditDocName;
	}

	public void setAuditDocName(String auditDocName) {
		AuditDocName = auditDocName;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getCheckTime() {
		return CheckTime;
	}

	public void setCheckTime(String checkTime) {
		CheckTime = checkTime;
	}

	public String getReportTime() {
		return ReportTime;
	}

	public void setReportTime(String reportTime) {
		ReportTime = reportTime;
	}

	public String getReceiveTime() {
		return ReceiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		ReceiveTime = receiveTime;
	}

	public String getCollectTime() {
		return CollectTime;
	}

	public void setCollectTime(String collectTime) {
		CollectTime = collectTime;
	}

}
