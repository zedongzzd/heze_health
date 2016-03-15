package com.wisesz.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.model.Dept;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.model.Doctor;
import com.wisesz.health.webservice.res.GetDeptResponse;
import com.wisesz.health.webservice.res.GetDoctorResponse;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/hospital")
public class HosptalController extends Controller {
	private static Log log = Log.getLog(HosptalController.class);

	/**
	 * 获取医院列表
	 */
	@Before(POST.class)
	public void list() {
		try {
			Map<String, Object> hospital = new HashMap<>();
			hospital.put("HospitalId", "20009030500001");
			hospital.put("name", "菏泽市立医院");
			renderJson(RespFactory.isOk("获取医院列表成功！", hospital));
		} catch (Exception e) {
			log.error("获取医院列表出错！", e);
			renderJson(RespFactory.isFail("获取医院列表出错！"));
		}
	}

	@Before(POST.class)
	public void notifyDepts() {
		GetDeptResponse res = Service.getDept(Const.TransactionId, Const.HospitalId);
		if (res == null) {
			renderJson(RespFactory.isFail("调用his接口失败！"));
			return;
		}
		if (res.getResultCode() != 0) {
			renderJson(RespFactory.newInstance(res.getResultCode(), res.getErrorMsg(), null));
			return;
		}
		com.wisesz.health.webservice.bean.Dept[] depts = res.getDepts().getDept();
		List<Dept> batchs = new ArrayList<>();
		for (com.wisesz.health.webservice.bean.Dept d : depts) {
			Dept model = new Dept();
			model.setAddress(d.getAdmitAddress());
			model.setDeptId(d.getDeptId());
			model.setHospitalId(Const.HospitalId);
			model.setName(d.getDept());
			batchs.add(model);
		}
		if (batchs.size() > 0) {
			String sql = "INSERT INTO t_dept (deptId,name,address,hospitalId) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE name = VALUES (name), address = VALUES (address)";
			Db.batch(sql, "deptId,name,address,hospitalId", batchs, 100);
		}
		renderJson(RespFactory.isOk("更新科室列表成功！"));
	}

	public void notifyDocs() {
		String deptId = getPara("deptId");
		GetDoctorResponse res = Service.getDoctor(Const.TransactionId, deptId);
		if (res == null) {
			renderJson(RespFactory.isFail("调用his接口失败！"));
			return;
		}
		if (res.getResultCode() != 0) {
			renderJson(RespFactory.newInstance(res.getResultCode(), res.getErrorMsg(), null));
			return;
		}
		com.wisesz.health.webservice.bean.Doctor[] docs = res.getDoctors().getDoctor();
		List<Doctor> batchs = new ArrayList<>();
		for (com.wisesz.health.webservice.bean.Doctor doc : docs) {
			Doctor d = new Doctor();
			d.setDoctorId(doc.getDoctorId());
			d.setName(doc.getDoctorName());
			d.setTitle(doc.getDoctorTitle());
			d.setAddress(doc.getAdmitAddress());
			d.setDeptId(doc.getDeptId());
			d.setDept(doc.getDept());
			batchs.add(d);
		}
		if (batchs.size() > 0) {
			String sql = "INSERT INTO t_doctor (doctorId,name,title,deptId,dept,address) VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE title=VALUES(title),deptId=VALUES(deptId),dept=VALUES (dept),address=VALUES(address)";
			Db.batch(sql, "doctorId,name,title,deptId,dept,address", batchs, 100);
		}
		renderJson(RespFactory.isOk("更新医生列表成功！"));
	}
}
