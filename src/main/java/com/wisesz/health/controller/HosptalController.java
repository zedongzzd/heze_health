package com.wisesz.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.model.Dept;

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
		int page = 0;
		int pageSize = 0;
		if (getPara("len") != null) {
			pageSize = Integer.parseInt(getPara("len"));
		} else {
			pageSize = 15;
		}
		if (getPara("num") != null) {
			page = Integer.parseInt(getPara("num"));
		} else {
			page = 1;
		}
		String sql = "SELECT * FROM t_dept  ORDER BY deptId  ASC limit ?,?";
		List<Dept> list = Dept.dao.find(sql, page, pageSize);
		renderJson(RespFactory.isOk("获取科室分页列表成功！", list));
	}
}
