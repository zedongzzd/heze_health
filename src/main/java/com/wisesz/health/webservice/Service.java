package com.wisesz.health.webservice;

import com.wisesz.health.common.Const;
import com.wisesz.health.model.Dept;
import com.wisesz.health.webservice.bean.Doctor;
import com.wisesz.health.webservice.bean.Doctors;
import com.wisesz.health.webservice.bean.RBAS;
import com.wisesz.health.webservice.bean.RBASRec;
import com.wisesz.health.webservice.req.DoCancelRegisterRequest;
import com.wisesz.health.webservice.req.DoRegisterRequest;
import com.wisesz.health.webservice.req.GetArrangementRequest;
import com.wisesz.health.webservice.req.GetAvailableRegCountRequest;
import com.wisesz.health.webservice.req.GetAvailableRegRequest;
import com.wisesz.health.webservice.req.GetDeptRequest;
import com.wisesz.health.webservice.req.GetDoctorRequest;
import com.wisesz.health.webservice.req.GetRegiserInfoRequest;
import com.wisesz.health.webservice.req.HisCheckPatientInfoRequest;
import com.wisesz.health.webservice.req.Request;
import com.wisesz.health.webservice.res.DoCancelRegisterResponse;
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

import java.util.List;

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
		try {
			GetDeptResponse res = new GetDeptResponse();
			GetDeptRequest request = new GetDeptRequest();
			request.setTransactionId(transactionId);
			request.setHospitalId(hospitalId);
			request.setType(2);
			Request message = new Request("I_00100", request);
			res.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return res;
		} catch (Exception e) {
			return null;
		}

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
		try {
			GetDoctorResponse doctor = new GetDoctorResponse();
			GetDoctorRequest request = new GetDoctorRequest();
			request.setTransactionId(transactionId);
			request.setDeptId(deptId);
			Request message = new Request("I_00101", request);
			doctor.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return doctor;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 1.3 医院排班信息
	 * 
	 * @param transactionId  唯一交易号
	 * @param rBASDate	门诊排班日期 yyyy-MM-dd
	 * @param rBASDay 获取排班天数 1-7
	 * @param doctorId 医生id
	 * @param deptId 科室id
	 * @return
	 */
	public static GetArrangementResponse getArrangement(String transactionId, String rBASDate, Integer rBASDay,
			String doctorId, String deptId) {
		try {
			GetArrangementResponse arrangement = new GetArrangementResponse();
			GetArrangementRequest request = new GetArrangementRequest();
			request.setTransactionId(transactionId);
			request.setRBASDate(rBASDate);
			request.setRBASDay(rBASDay);
			request.setDoctorId(doctorId);
			request.setDeptId(deptId);
			Request message = new Request("I_00102", request);
			arrangement.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return arrangement;
		} catch (Exception e) {
			return null;
		}

	}



	/**
	 * 1.4 查询可挂号数（医院无限号）
	 * 
	 * @param transactionId
	 * @param rBAS
	 * @return
	 */
	public static GetAvailableRegCountResponse getAvailableRegCount(String transactionId, RBAS rBAS) {
		try {
			GetAvailableRegCountResponse countResponse = new GetAvailableRegCountResponse();
			GetAvailableRegCountRequest request = new GetAvailableRegCountRequest();
			request.setTransactionId(transactionId);
			request.setRBAS(rBAS);
			Request message = new Request("I_00105", request);
			countResponse.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return countResponse;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 1.5 查询可挂序列号（需要HIS支持，目前暂不支持）
	 * 
	 * @param transactionId
	 * @param rBAS
	 * @return
	 */
	@Deprecated
	public static GetAvailableRegResponse getAvailableReg(String transactionId, RBAS rBAS) {
		try {
			GetAvailableRegResponse response = new GetAvailableRegResponse();
			GetAvailableRegRequest request = new GetAvailableRegRequest();
			request.setTransactionId(transactionId);
			request.setRBAS(rBAS);
			Request message = new Request("I_00106", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return response;
		} catch (Exception e) {
			return null;
		}
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
		try {
			HisCheckPatientInfoResponse response = new HisCheckPatientInfoResponse();
			HisCheckPatientInfoRequest request = new HisCheckPatientInfoRequest();
			request.setCardNO(cardNO);
			request.setIDCard(iDCard);
			request.setName(name);
			request.setTransactionId(transactionId);
			request.setType(type);
			Request message = new Request("I_00107", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return response;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 确认挂号
	 * 
	 * @param patientId
	 * @param rBASId
	 * @param transactionId
	 * @param bdate
	 * @param phoneNumber
	 * @param clientAddress
	 * @param method
	 * @return
	 */
	public static DoRegisterResponse doRegister(String patientId, String rBASId, String transactionId, String bdate,
			String phoneNumber, String clientAddress, String method) {
		try {
			DoRegisterResponse response = new DoRegisterResponse();
			DoRegisterRequest request = new DoRegisterRequest();
			request.setPatientId(patientId);
			request.setRBASId(rBASId);
			request.setTransactionId(transactionId);
			request.setBdate(bdate);
			request.setPhoneNumber(phoneNumber);
			request.setUserID(Const.UserID);
			request.setClientAddress(clientAddress);
			request.setMethod(method);
			Request message = new Request("I_00108", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return response;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 查询挂号信息
	 * 
	 * @param transactionId
	 *            暂无实际业务含义
	 * @param patientId
	 *            HIS系统产生
	 * @param userID
	 *            星锐互动的唯一编号CCB
	 * @param clientAddress
	 *            暂不使用
	 * @return
	 */
	public static GetRegiserInfoResponse getRegiserInfo(String transactionId, String patientId, String clientAddress) {
		try {
			GetRegiserInfoResponse response = new GetRegiserInfoResponse();
			GetRegiserInfoRequest request = new GetRegiserInfoRequest();
			request.setTransactionId(transactionId);
			request.setPatientId(patientId);
			request.setUserID(Const.UserID);
			request.setClientAddress(clientAddress);
			Request message = new Request("I_00109", request);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return response;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 取消挂号
	 * 
	 * @param appId
	 * @param userID
	 * @param bDate
	 * @return
	 */
	public static DoCancelRegisterResponse doCancelRegister(String appId, String bDate) {
		try {
			DoCancelRegisterResponse response = new DoCancelRegisterResponse();
			DoCancelRegisterRequest cancelRegisterRequest = new DoCancelRegisterRequest();
			cancelRegisterRequest.setApptId(appId);
			cancelRegisterRequest.setUserID(Const.UserID);
			cancelRegisterRequest.setBDate(bDate);
			Request message = new Request("I_00110", cancelRegisterRequest);
			response.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
			return response;
		} catch (Exception e) {
			return null;
		}
	}

}
