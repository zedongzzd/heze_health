package com.wisesz.health.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.HttpKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.wisesz.health.common.Const;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.SecurityHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.interceptor.ManageLoginInterceptor;
import com.wisesz.health.interceptor.ManageLoginInterceptor.LoginUser;
import com.wisesz.health.model.Dept;
import com.wisesz.health.model.Doctor;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.res.GetDeptResponse;
import com.wisesz.health.webservice.res.GetDoctorResponse;

import me.zzd.webapp.core.annotation.BindController;

@BindController(value = "/manage", viewPath = "/")
public class ManageController extends Controller {

	private Log log = Log.getLog(getClass());

	@Before(GET.class)
	public void login() {
		setAttr("a","1");
		render("login.html");
	}

	@Before({ GET.class, ManageLoginInterceptor.class })
	public void notifyDataPage() {
		render("notifyDataPage.html");
	}

	@Before(POST.class)
	public void doLogin() {
		String json = HttpKit.readData(getRequest());
		JSONObject jsonObject = JSONObject.parseObject(json);
		String name = jsonObject.getString("name");
		name = SecurityHandler.getMd5(name).toUpperCase();
		String password = jsonObject.getString("password");
		password = SecurityHandler.getMd5(password).toUpperCase();
		if (Const.adminUser.equals(name) && Const.adminPwd.equals(password)) {
			String flag = getRequest().getSession().getId();
			HttpHandler.addCookie(getResponse(), Const.Manage_Fag, flag);
			LoginUser user = new LoginUser();
			user.userName = name;
			user.userPwd = password;
			CacheHandler.cache(Const.Cache_Name_login, flag, user);
			renderJson(RespFactory.isOk());
		} else {
			renderJson(RespFactory.isFail("非法操作！"));
		}
	}

	@Before({ POST.class, ManageLoginInterceptor.class })
	public void notifyDepts() {
		try {
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
				String sql = "INSERT INTO t_dept (deptId,name,address,hospitalId) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE address = VALUES (address)";
				Db.batch(sql, "deptId,name,address,hospitalId", batchs, 100);
			}
			renderJson(RespFactory.isOk("更新科室列表成功！"));
		} catch (Exception e) {
			log.error("更新科室列表出错！", e);
			renderJson(RespFactory.isFail("更新科室列表出错！"));
		}
	}

	@Before({ POST.class, ManageLoginInterceptor.class })
	public void notifyDocs() {
		String deptId = getPara("deptId");
		if (StringHandler.isEmpty(deptId)) {
			renderJson(RespFactory.isFail("参数异常！"));
			return;
		}
		try {
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
				batchs.add(d);
			}
			if (batchs.size() > 0) {
				String sql = "INSERT INTO t_doctor (doctorId,name,title,deptId,dept,address) VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE title=VALUES(title),deptId=VALUES(deptId),dept=VALUES (dept),address=VALUES(address)";
				Db.batch(sql, "doctorId,name,title,deptId,dept,address", batchs, 100);
			}
			renderJson(RespFactory.isOk("更新医生列表成功！	deptId:" + deptId));
		} catch (Exception e) {
			log.error("更新医生列表出错！", e);
			renderJson(RespFactory.isFail("更新医生列表出错！	deptId:" + deptId));
		}

	}

	@Before({ POST.class, ManageLoginInterceptor.class })
	public void getDepts() {
		try {
			String sql = "select deptId from t_dept";
			renderJson(RespFactory.isOk("获取科室列表成功！", Dept.dao.find(sql)));
		} catch (Exception e) {
			log.error("获取科室列表出错！", e);
			renderJson(RespFactory.isFail());
		}
	}
}
