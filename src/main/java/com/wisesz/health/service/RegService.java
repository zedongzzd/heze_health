package com.wisesz.health.service;

import com.jfinal.log.Log;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.model.Patient;
import com.wisesz.health.model.Regist;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.res.DoCancelRegisterResponse;
import com.wisesz.health.webservice.res.DoRegisterResponse;

public class RegService {
	private static Log log = Log.getLog(Regist.class);

	public static Result<Regist> doRegister(String uid, String patientId, String rBASId) {
		try {
			Patient patient = Patient.dao.findById(patientId);
			if (patient == null || !patient.getUid().equals(uid)) {
				return RespFactory.isFail("常用联系人信息错误！");
			}
			Schedual sc = Schedual.dao.findById(rBASId);
			if (sc == null) {
				return RespFactory.isFail("排班信息不存在！");
			}
			DoRegisterResponse res = Service.doRegister(patient.getPatientId(), sc.getId(), sc.getHospitalId(),
					sc.getDate(), patient.getPhone(), "", "1");
			if (res == null) {
				return RespFactory.isFail("挂号失败，医院服务器连接异常！");
			}
			Regist reg = new Regist();
			reg.setApptId(res.getApptId());
			reg.setAdmitRange(res.getAdmitRange());
			reg.setCreateDate(DateHandler.getDate());
			reg.setDeptId(sc.getDeptId());
			reg.sethDate(res.getHDate());
			reg.setHospitalId(Const.HospitalId);
			reg.setPatientId(patientId);
			reg.setRegFee(res.getRegFee());
			reg.setSeqCode(res.getSeqCode());
			reg.setServiceFee(res.getServiceFee());
			reg.setState(res.getResultCode());
			reg.setUid(uid);
			reg.setErrorMsg(res.getErrorMsg());
			reg.setCreateDate(DateHandler.getDate());
			reg.save();
			if (res.getResultCode() != null && res.getResultCode() == 0) {
				return RespFactory.isOk("挂号成功", reg);
			} else {
				return RespFactory.isFail(res.getErrorMsg(), reg);
			}
		} catch (Exception e) {
			log.error("挂号失败！", e);
			return RespFactory.isFail("挂号失败！");
		}
	}

	public static Result<Regist> unRegister(String uid, String appId) {
		String sql = "select * from t_regist where apptId=? and uid=? and state=0";
		Regist model = Regist.dao.findFirst(sql, appId, uid);
		DoCancelRegisterResponse res = Service.doCancelRegister(appId, model.gethDate());
		if (res != null) {
			if (res.getResultCode() != null && res.getResultCode() == 0) {
				model.sethDate(res.getHDate());
				model.setState(-1);
				model.update();
				return RespFactory.isOk("退号成功！", model);
			} else {
				return RespFactory.isFail(res.getErrorMsg(), model);
			}
		} else {
			return RespFactory.isFail("连接医院服务器异常！");
		}
	}

}
