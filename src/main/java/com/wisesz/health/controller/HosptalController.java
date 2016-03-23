package com.wisesz.health.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.service.HospitalService;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/hospital")
public class HosptalController extends Controller {
	private static Log log = Log.getLog(HosptalController.class);

	/**
	 * 获取医院列表
	 *
	 */
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
	public void deptlist() {
		Integer page = getParaToInt("page");
		Integer pageSize = getParaToInt("pageSize");
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 15;
		}
<<<<<<< HEAD
		renderJson(RespFactory.isOk("获取科室分页列表成功！", HospitalService.getDeptlist(page, pageSize)));
=======
		String sql = "SELECT * FROM t_dept  ORDER BY deptId  ASC limit ?,?";
		List<Dept> list = Dept.dao.find(sql, (page-1)*pageSize, pageSize);
		renderJson(RespFactory.isOk("获取科室分页列表成功！", list));
>>>>>>> 3623d8fc97e30d96c0a92c292c40eaf059e41d9d
	}
}
