package com.wisesz.health.webservice;

import com.wisesz.health.webservice.bean.RBAS;
import com.wisesz.health.webservice.bean.RBASRec;
import com.wisesz.health.webservice.req.GetArrangementRequest;
import com.wisesz.health.webservice.req.GetAvailableRegCountRequest;
import com.wisesz.health.webservice.req.GetDeptRequest;
import com.wisesz.health.webservice.req.GetDoctorRequest;
import com.wisesz.health.webservice.req.Request;
import com.wisesz.health.webservice.res.GetArrangementResponse;
import com.wisesz.health.webservice.res.GetAvailableRegCountResponse;
import com.wisesz.health.webservice.res.GetDeptResponse;
import com.wisesz.health.webservice.res.GetDoctorResponse;

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
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GetArrangementResponse str = Service.getArrangement("20009030500001", "2016-03-15", "7", "1", "19");
		RBAS rbas = str.getRBAS();
		
		
		RBASRec[] ss = rbas.getRBASRec();
		System.out.println(ss.length);
		// RBAS rBAS=new RBAS();
		// RBASRec rbasRec=new RBASRec();
		// rbasRec.setRBASId("2016031529");
		// rbasRec.setRBASDate("2016-3-15");
		// rbasRec.setDeptId("29");
		// //rbasRec.set
		// RBASRec [] aaRecs={rbasRec};
		// rBAS.setRBASRec(aaRecs);
		// Service.getAvailableRegCount("002737", rBAS);

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
	public static GetArrangementResponse getArrangement(String transactionId, String rBASDate, String rBASDay,
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
			System.out.println(SoapClient.connect(new HezeMessage(message.toDocument())).replaceAll("&lt;", "<")
					.replaceAll("&gt;", ">"));
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
			System.out.println(SoapClient.connect(new HezeMessage(message.toDocument())).replaceAll("&lt;", "<")
					.replaceAll("&gt;", ">"));
			countResponse.parse(XmlUtils.xmldomutils(SoapClient.connect(new HezeMessage(message.toDocument()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countResponse;
	}
}
