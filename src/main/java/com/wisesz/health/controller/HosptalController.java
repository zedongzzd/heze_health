package com.wisesz.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Dept;
import com.wisesz.health.model.Doctor;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.service.HospitalService;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/hospital")
public class HosptalController extends Controller {
	private static Log log = Log.getLog(HosptalController.class);

	/**
	 * 获取医院列表
	 *
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

	/**
	 * 分页获取科室
	 */
	@Before(POST.class)
	public void deptlist() {
		Integer page = getParaToInt("page");
		Integer pageSize = getParaToInt("pageSize");
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 15;
		}
		String sql = "SELECT * FROM t_dept  ORDER BY deptId  ASC limit ?,?";
		List<Dept> list = Dept.dao.find(sql, (page - 1) * pageSize, pageSize);
		renderJson(RespFactory.isOk("获取科室分页列表成功！", list));
	}

	@Before(POST.class)
	public void getSchedual() {
		try {
			String deptId = getPara("deptId");
			List<Schedual> list = HospitalService.getDeptScheduals(deptId);
			renderJson(RespFactory.isOk("获取科室排班信息成功！", list));
		} catch (Exception e) {
			log.error("获取科室排班信息出错！", e);
			renderJson(RespFactory.isFail());
		}
	}
	
	/**
	 * doctor 分页查询,name模糊查询
	 */
	@Before(POST.class)
	public void selectDoctorByPage() {
		String deptId = getPara("deptId");
		String name = getPara("name");
		Integer page = getParaToInt("page");
		if (page == null) {
			page = 1;
		}
		Integer pageSize = getParaToInt("pageSize");
		if (pageSize == null) {
			pageSize = 15;
		}
		StringBuilder sb = new StringBuilder("SELECT * FROM t_doctor where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (!StringHandler.isEmpty(deptId)) {
			sb.append(" and deptId = ?");
			params.add(deptId);
		}

		if (!StringHandler.isEmpty(name)) {
			sb.append(" and name like ?");
			params.add(name);
		}
		sb.append(" limit ?,?");
		params.add(pageSize * (page - 1));
		params.add(pageSize);
		List<Doctor> doctorList = Doctor.dao.find(sb.toString(), params.toArray());
		renderJson(RespFactory.isOk("查询医生列表成功！", doctorList));
	}
}
