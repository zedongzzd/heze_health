package com.wisesz.health.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wisesz.health.bean.User;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
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
	 * @param user
	 * @return
	 */
	public static boolean doLogin(HttpServletRequest req, HttpServletResponse res, User user) {
		try {
			String flag = "pre_" + req.getSession().getId();
			HttpHandler.addCookie(res, Const.Login_Fag, flag);
			CacheHandler.cache(Const.Cache_Name_login, flag, user);
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
	public static User getUid(HttpServletRequest req) {
		try {
			String flag = HttpHandler.getCookie(req, Const.Login_Fag);
			return CacheHandler.cache(Const.Cache_Name_login, flag);
		} catch (Exception e) {
			log.error("获取登陆uid失败！", e);
		}
		return null;
	}

	/**
	 * 添加病人
	 * 
	 * @param cardNo
	 * @param idCard
	 * @param phone
	 * @param name
	 * @param type
	 * @return
	 */
	public static Result<String> addPatient(String cardNo, String idCard, String phone, String name, Integer type) {
		try {
			HisCheckPatientInfoResponse response = Service.getHisCheckPatientInfo(Const.TransactionId, cardNo, idCard,
					name, type);
			if (response != null && response.getResultCode() == 0) {
				UserInfo info = response.getUserInfo();
				String patientId = info.getPatientId();
				Patient patient = new Patient();
				patient.setPatientId(patientId).setName(name).setIdCard(idCard).setPhone(phone).setCardNo(cardNo);
				if(patient.save()){
					return RespFactory.isOk();
				}else{
					return RespFactory.isFail();
				}

			}else{
				return RespFactory.isFail(response.getErrorMsg());
			}
		} catch (Exception e) {
			log.error("添加病人出错！", e);
			return RespFactory.isFail("添加病人出错");
		}

	}

	public static Result<String> updatePatient(String patientId, String cardNo, String idCard, String phone,
			String name, Integer type) {
		try {
			HisCheckPatientInfoResponse response = Service.getHisCheckPatientInfo(Const.TransactionId, cardNo, idCard,
					name, type);
			if (response != null) {
				if (response.getResultCode() == 0) {
					UserInfo info = response.getUserInfo();
					String _patientId = info.getPatientId();
					Patient patient = new Patient();
					patient.setPatientId(_patientId).setName(name).setIdCard(idCard).setPhone(phone).setCardNo(cardNo);
					boolean op = false;
					if (_patientId.equals(patientId)) {
						op = patient.update();
					} else {
						Patient.dao.deleteById(patient);
						op = patient.save();
					}
					if (op) {
						return RespFactory.isOk();
					} else {
						return RespFactory.isFail("服务器繁忙，请多事几次！");
					}
				} else {
					return RespFactory.isFail(response.getErrorMsg());
				}
			} else {
				return RespFactory.isFail("服务器繁忙，请多事几次！");
			}
		} catch (Exception e) {
			log.error("修改常用联系人出错！", e);
			return RespFactory.isFail("服务器繁忙，请多事几次！");
		}

	}

	/**
	 * 获取病人列表
	 * 
	 * @param uid
	 * @return
	 */
	public static List<Record> getPatients(String uid) {
		try {
			return Db.find("select * from t_patient where uid=?", uid);
		} catch (Exception e) {
			log.error("获取病人列表出错！", e);
		}
		return null;
	}

	/**
	 * 获取病人信息
	 * 
	 * @param uid
	 * @param patientId
	 * @return
	 */
	public static Record getPatient(String uid, String patientId) {
		try {
			return Db.findById("t_patient", "patientId,uid", patientId, uid);
		} catch (Exception e) {
			log.error("获取病人信息出错！", e);
		}
		return null;
	}

	/**
	 * 删除病人
	 * 
	 * @param uid
	 * @param patientId
	 * @return
	 */
	public static boolean delPatient(String uid, String patientId) {
		try {
			return Db.deleteById("t_patient", "patientId ,uid", patientId, uid);
		} catch (Exception e) {
			log.error("删除常用病人信息！", e);
		}
		return false;
	}
}
