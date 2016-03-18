package com.wisesz.health.webservice;

import com.wisesz.health.webservice.bean.RBAS;
import com.wisesz.health.webservice.req.DoRegisterRequest;
import com.wisesz.health.webservice.req.GetArrangementRequest;
import com.wisesz.health.webservice.req.GetAvailableRegCountRequest;
import com.wisesz.health.webservice.req.GetAvailableRegRequest;
import com.wisesz.health.webservice.req.GetDeptRequest;
import com.wisesz.health.webservice.req.GetDoctorRequest;
import com.wisesz.health.webservice.req.GetRegiserInfoRequest;
import com.wisesz.health.webservice.req.HisCheckPatientInfoRequest;
import com.wisesz.health.webservice.req.Request;
import com.wisesz.health.webservice.res.DoRegisterResponse;
import com.wisesz.health.webservice.res.GetArrangementResponse;
import com.wisesz.health.webservice.res.GetAvailableRegCountResponse;
import com.wisesz.health.webservice.res.GetAvailableRegResponse;
import com.wisesz.health.webservice.res.GetDeptResponse;
import com.wisesz.health.webservice.res.GetDoctorResponse;
import com.wisesz.health.webservice.res.GetRegiserInfoResponse;
import com.wisesz.health.webservice.res.HisCheckPatientInfoResponse;

import me.zzd.webapp.core.dom.XmlDocument;
import me.zzd.webapp.core.dom.XmlElement;
import me.zzd.webapp.core.webService.SoapClient;
import me.zzd.webapp.core.webService.SoapClient.EmptyBody;
import me.zzd.webapp.core.webService.SoapClient.Message;

public class Service {
	public static class HezeMessage extends Message {

		public HezeMessage(XmlDocument body) throws EmptyBody {
			super(null, body, new XmlElement("xsi", "http://www.w3.org/2001/XMLSchema-instance"),
					new XmlElement("xsd", "http://www.w3.org/2001/XMLSchema"));
		}

	}

	/**
	 * 1.1医院科室（只要临床科室）
	 * 
	 * @param transactionId
	 * @param hospitalId
	 * @return
	 */
	public static GetDeptResponse getDept(String transactionId, String hospitalId) {
		GetDeptResponse res = new GetDeptResponse();
		try {
			GetDeptRequest request = new GetDeptRequest();
			request.setTransactionId(transactionId);
			request.setHospitalId(hospitalId);
			request.setType(2);
			Request message = new Request("I_00100", request);
			res.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
		}
		return res;
	}

	/**
	 * 
	 * 1.2科室医生(只要专家医生)
	 * 
	 * @param transactionId
	 * @param deptId
	 * @return
	 */
	public static GetDoctorResponse getDoctor(String transactionId, String deptId) {
		GetDoctorResponse doctor = new GetDoctorResponse();
		try {
			GetDoctorRequest request = new GetDoctorRequest();
			request.setTransactionId(transactionId);
			request.setDeptId(deptId);
			Request message = new Request("I_00101", request);
			doctor.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
		}
		return doctor;
	}

	/**
	 * 1.3 医院排班信息
	 * 
	 * @param transactionId
	 * @param rBASDate
	 * @param rBASDay
	 * @param doctorId
	 * @param deptId
	 * @return
	 */
	public static GetArrangementResponse getArrangement(String transactionId, String rBASDate, Integer rBASDay,
			String doctorId, String deptId) {
		GetArrangementResponse arrangement = new GetArrangementResponse();
		try {
			GetArrangementRequest request = new GetArrangementRequest();
			request.setTransactionId(transactionId);
			request.setRBASDate(rBASDate);
			request.setRBASDay(rBASDay);
			request.setDoctorId(doctorId);
			request.setDeptId(deptId);
			Request message = new Request("I_00102", request);
			arrangement.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrangement;
	}

	/**
	 * 1.4 查询可挂号数（医院无限号）
	 * 
	 * @param transactionId
	 * @param rBAS
	 * @return
	 */
	public static GetAvailableRegCountResponse getAvailableRegCount(String transactionId, RBAS rBAS) {
		GetAvailableRegCountResponse countResponse = new GetAvailableRegCountResponse();
		try {
			GetAvailableRegCountRequest request = new GetAvailableRegCountRequest();
			request.setTransactionId(transactionId);
			request.setRBAS(rBAS);
			Request message = new Request("I_00105", request);
			countResponse.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countResponse;
	}

	/**
	 * 1.5 查询可挂序列号（需要HIS支持，目前暂不支持）
	 * 
	 * @param transactionId
	 * @param rBAS
	 * @return
	 */
	public static GetAvailableRegResponse getAvailableReg(String transactionId, RBAS rBAS) {
		GetAvailableRegResponse response = new GetAvailableRegResponse();
		try {
			GetAvailableRegRequest request = new GetAvailableRegRequest();
			request.setTransactionId(transactionId);
			request.setRBAS(rBAS);
			Request message = new Request("I_00106", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 1.6 病人信息校验
	 * 
	 * @param transactionId
	 * @param cardNO
	 * @param iDCard
	 * @param name
	 * @param type
	 * @return
	 */
	public static HisCheckPatientInfoResponse getHisCheckPatientInfo(String transactionId, String cardNO, String iDCard,
			String name, Integer type) {
		HisCheckPatientInfoResponse response = new HisCheckPatientInfoResponse();
		try {
			HisCheckPatientInfoRequest request = new HisCheckPatientInfoRequest();
			request.setCardNO(cardNO);
			request.setIDCard(iDCard);
			request.setName(name);
			request.setTransactionId(transactionId);
			request.setType(type);
			Request message = new Request("I_00107", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 
	 * @param patientId
	 * @param rBASId
	 * @param transactionId
	 * @param bdate
	 * @param phoneNumber
	 * @param userID
	 * @param clientAddress
	 * @param method
	 * @return
	 */
	public static DoRegisterResponse doRegister(String patientId, String rBASId, String transactionId, String bdate,
			String phoneNumber, String userID, String clientAddress, String method) {
		DoRegisterResponse response = new DoRegisterResponse();
		try {
			DoRegisterRequest request = new DoRegisterRequest();
			request.setPatientId(patientId);
			request.setRBASId(rBASId);
			request.setTransactionId(transactionId);
			request.setBdate(bdate);
			request.setPhoneNumber(phoneNumber);
			request.setUserID(userID);
			request.setClientAddress(clientAddress);
			request.setMethod(method);
			Request message = new Request("I_00108", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 
	 * @param transactionId 暂无实际业务含义
	 * @param patientId  HIS系统产生
	 * @param userID 星锐互动的唯一编号CCB
	 * @param clientAddress 暂不使用
	 * @return
	 */
	public static GetRegiserInfoResponse getRegiserInfo(String transactionId, String patientId, String userID,
			String clientAddress) {
		GetRegiserInfoResponse response = new GetRegiserInfoResponse();
		try {
			GetRegiserInfoRequest request = new GetRegiserInfoRequest();
			request.setTransactionId(transactionId);
			request.setPatientId(patientId);
			request.setUserID(userID);
			request.setClientAddress(clientAddress);
			Request message = new Request("I_00109", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
}
