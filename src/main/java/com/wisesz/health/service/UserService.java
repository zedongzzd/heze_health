package com.wisesz.health.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.wisesz.health.common.Const;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Patient;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.bean.UserInfo;
import com.wisesz.health.webservice.res.HisCheckPatientInfoResponse;

public class UserService {
	private static Log log = Log.getLog(UserService.class);

	/**
	 * 登陆
	 * 
	 * @param req
	 * @param uid
	 * @return
	 */
	public static boolean doLogin(HttpServletRequest req, HttpServletResponse res, String uid) {
		try {
			String flag = "pre_" + req.getSession().getId();
			HttpHandler.addCookie(res, Const.Login_Fag, flag);
			CacheHandler.cache(Const.Cache_Name_login, flag, uid);
			return true;
		} catch (Exception e) {
			log.error("登陆失败！", e);
		}
		return false;
	}

	/**
	 * 获取登陆信息
	 * 
	 * @param req
	 * @return
	 */
	public static String getUid(HttpServletRequest req) {
		try {
			String flag = HttpHandler.getCookie(req, Const.Login_Fag);
			if (StringHandler.isEmpty(flag)) {
				return req.getParameter("uid");
			} else {
				return CacheHandler.cache(Const.Cache_Name_login, flag);
			}
		} catch (Exception e) {
			log.error("获取登陆uid失败！", e);
		}
		return null;
	}

	public static boolean addPatient(String cardNo, String idCard, String phone, String name, Integer type) {
		HisCheckPatientInfoResponse response = Service.getHisCheckPatientInfo(Const.TransactionId, cardNo, idCard, name,
				type);
		if (response != null && response.getResultCode() == 0) {
			UserInfo info = response.getUserInfo();
			String patientId = info.getPatientId();
			Patient patient = new Patient();
			patient.setPatientId(patientId).setName(name).setIdCard(idCard).setPhone(phone).setCardNo(cardNo);
			return patient.save();
		} else {
			return false;
		}
	}

	public static Object getPatients(String uid, String patientId) {
		if (!StringHandler.isEmpty(patientId)) {
			return Db.findById("t_patient", "patientId,uid", patientId, uid);
		} else {
			return Db.find("select * from t_patient where uid=?", uid);
		}
	}

	public static boolean delPatient(String uid, String patientId) {
		return Db.deleteById("t_patient", "patientId ,uid", patientId, uid);
	}
}
