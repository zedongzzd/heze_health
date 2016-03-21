package com.wisesz.health.controller;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/hospital")
public class HosptalController extends Controller {
	private Log log = Log.getLog(getClass());

	// /**
	// * 获取医院列表
	// *
	// */
	// @Before(POST.class)
	// public void list() {
	// try {
	// Map<String, Object> hospital = new HashMap<>();
	// hospital.put("HospitalId", "20009030500001");
	// hospital.put("name", "菏泽市立医院");
	// renderJson(RespFactory.isOk("获取医院列表成功！", hospital));
	// } catch (Exception e) {
	// log.error("获取医院列表出错！", e);
	// renderJson(RespFactory.isFail("获取医院列表出错！"));
	// }
	// }
	//
	// /**
	// * 分页获取科室
	// */
	// @Before(POST.class)
	// public void deptlist() {
	// Integer page = getParaToInt("page");
	// Integer pageSize = getParaToInt("pageSize");
	// if (page == null) {
	// page = 1;
	// }
	// if (pageSize == null) {
	// pageSize = 15;
	// }
	// String sql = "SELECT * FROM t_dept ORDER BY deptId ASC limit ?,?";
	// List<Dept> list = Dept.dao.find(sql, (page - 1) * pageSize, pageSize);
	// renderJson(RespFactory.isOk("获取科室分页列表成功！", list));
	// }
	//
	// @Before(POST.class)
	// public void getSchedual() {
	// try {
	// String deptId = getPara("deptId");
	// List<Schedual> list = HospitalService.getDeptScheduals(deptId);
	// renderJson(RespFactory.isOk("获取科室排班信息成功！", list));
	// } catch (Exception e) {
	// log.error("获取科室排班信息出错！", e);
	// renderJson(RespFactory.isFail());
	// }
	// }
}
