package com.wisesz.health.webservice;

import com.wisesz.health.webservice.req.GetDeptRequest;
import com.wisesz.health.webservice.req.GetDoctorRequest;
import com.wisesz.health.webservice.req.Request;

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
	public static String getDept(String transactionId, String hospitalId) {
		try {
			GetDeptRequest request = new GetDeptRequest();
			request.setTransactionId(transactionId);
			request.setHospitalId(hospitalId);
			request.setType(2);
			Request message = new Request("I_00100", request);
			return SoapClient.connect(new HezeMessage(message.toDocument()));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 
	 * 1.2科室医生(只要专家医生)
	 * 
	 * @param transactionId
	 * @param deptId
	 * @return
	 */
	public static String getDoctor(String transactionId, String deptId) {
		try {
			GetDoctorRequest request = new GetDoctorRequest();
			request.setTransactionId(transactionId);
			request.setDeptId(deptId);
			Request message = new Request("I_00101", request);
			return SoapClient.connect(new HezeMessage(message.toDocument()));
		} catch (Exception e) {
		}
		return null;
	}

}
