package com.wisesz.health.service;

import java.awt.geom.Arc2D;
import java.text.DecimalFormat;
import java.util.List;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.mysql.fabric.xmlrpc.base.Data;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Patient;
import com.wisesz.health.model.Regist;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.res.DoCancelRegisterResponse;
import com.wisesz.health.webservice.res.DoRegisterResponse;

public class RegService {
	private static Log log = Log.getLog(Regist.class);

	/**
	 * 挂号
	 * 
	 * @param uid
	 * @param patientId
	 * @param rBASId
	 * @return
	 */
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
			reg.setCreateDate(DateHandler.getDateTime());
			reg.setDeptId(sc.getDeptId());
			String date = res.getHDate();
			reg.sethDate(sc.getDate());
			reg.setHospitalId(Const.HospitalId);
			reg.setPatientId(patientId);
			DecimalFormat g=new DecimalFormat("0.00");
			Double regFee = Double.parseDouble(StringHandler.defaultValue(res.getRegFee(),"0"));
			Double serviceFee = Double.parseDouble(StringHandler.defaultValue(res.getServiceFee(),"0"));
			reg.setRegFee(g.format(regFee));
			reg.setServiceFee(g.format(serviceFee));
			reg.setSeqCode(res.getSeqCode());
			reg.setState(res.getResultCode());
			reg.setUid(uid);
			reg.setErrorMsg(res.getErrorMsg());
//			reg.setCreateDate(DateHandler.getDate());
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

	/**
	 * 取消挂号
	 * 
	 * @param uid
	 * @param appId
	 * @return
	 */
	public static Result<Regist> unRegister(String uid, String appId) {
		String sql = "select * from t_regist where apptId=? and uid=? and state=0";
		Regist model = Regist.dao.findFirst(sql, appId, uid);
		DoCancelRegisterResponse res = Service.doCancelRegister(appId, model.gethDate());
		if (res != null) {
			if (res.getResultCode() != null && res.getResultCode() == 0) {
				model.sethDate(res.getHDate());
				model.setState(-1);
				model.setCreateDate(DateHandler.getDate());
				model.update();
				return RespFactory.isOk("退号成功！", model);
			} else {
				return RespFactory.isFail(res.getErrorMsg(), model);
			}
		} else {
			return RespFactory.isFail("连接医院服务器异常！");
		}
	}

	/**
	 * 挂号单列表
	 * 
	 * @param uid
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public static List<Record> getRegists(String uid, Integer page, Integer pageSize) {

		String sql="select t_regist.*, t_patient.name as patientName,t_hospital.name as hospName, t_dept.name as deptName, t_dept.address from  t_regist inner join   t_patient on  t_regist.uid=? and  t_regist.patientId=t_patient.patientId inner join   t_dept on t_regist.deptId=t_dept.deptId inner join    t_hospital  on t_regist.hospitalId=t_hospital.hospitalId  left join t_doctor on t_regist.deptId=t_doctor.doctorId order by createDate desc limit ?,?";


		return Db.find(sql,uid,(page - 1) * pageSize, pageSize);
	}


	/**
	 * 查询指定挂号单
	 * @param uid
	 * @param registerId
	 * @return
   */
	public static Record getRegist(String uid ,String registerId){
		String sql="select t_regist.*, t_patient.name as patientName,t_hospital.name as hospName, t_dept.name as deptName, t_dept.address from  t_regist inner join   t_patient on  t_regist.uid=? and  t_regist.patientId=t_patient.patientId inner join   t_dept on t_regist.deptId=t_dept.deptId inner join    t_hospital  on t_regist.hospitalId=t_hospital.hospitalId  left join t_doctor on t_regist.deptId=t_doctor.doctorId where t_regist.id = ? order by createDate desc ";
		//String sql = "select * from t_regist where uid=? order by createDate desc limit ?,?";
		return Db.findFirst(sql,uid,registerId);
	}

}
