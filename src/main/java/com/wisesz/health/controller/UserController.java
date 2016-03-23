<<<<<<< HEAD
package com.wisesz.health.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Patient;
import com.wisesz.health.service.UserService;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.bean.UserInfo;
import com.wisesz.health.webservice.res.HisCheckPatientInfoResponse;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/user")
public class UserController extends Controller {
	private Log log = Log.getLog(getClass());

	/**
	 * 登陆接口
	 */
	@Before(POST.class)
	public void login() {
		try {
			String uid = getPara("uid");
			if (!StringHandler.isEmpty(uid)) {
				if (UserService.doLogin(getRequest(), getResponse(), uid)) {
					renderJson(RespFactory.isOk("登陆成功！"));
					return;
				}
			}
			renderJson(RespFactory.isFail());
		} catch (Exception e) {
			log.error("登陆接口出错！", e);
			renderJson(RespFactory.isFail("登陆接口出错！"));
		}
	}

	/**
	 * 添加病人信息
	 */
	@Before(POST.class)
	public void setpatient() {
		try {
			String name = getPara("name");
			String cardNo = getPara("cardNo");
			String idCard = getPara("idCard");
			String phone = getPara("phone");
			HisCheckPatientInfoResponse response = Service.getHisCheckPatientInfo(null, cardNo, name, idCard, null);
			if (response.getResultCode() == 0) {
				UserInfo info = response.getUserInfo();
				String patientId = info.getPatientId();
				if (!StringHandler.isEmpty(patientId) && !StringHandler.isEmpty(name) && !StringHandler.isEmpty(cardNo)
						&& !StringHandler.isEmpty(idCard) && !StringHandler.isEmpty(phone)) {
					Patient patient = new Patient();
					patient.set("patientId", patientId).set("name", name).set("idCard", idCard).set("phone", phone)
							.set("cardNo", cardNo).save();
					renderJson(RespFactory.isOk("添加挂号人信息成功！", patient));
				} else {
					renderJson(RespFactory.isFail("填写信息不完整!"));
				}
			} else {
				renderJson(RespFactory.isFail(response.getErrorMsg()));
			}
		} catch (Exception e) {
			log.error("添加病人信息失败！",e);
			renderJson(RespFactory.isFail("添加病人信息失败!"));
		}
	}

	/**
	 * 读取挂号人信息
	 */
	@Before(POST.class)
	public void getpatient() {
		try {
			String uid = getPara("uid");
			String patientId = getPara("patientId");
			StringBuilder sb = new StringBuilder("select * from t_patient where uid=? ");
			if (!StringHandler.isEmpty(patientId)) {
				sb.append(" and patientId=?");
				renderJson(RespFactory.isOk("获取挂号人信息成功!", Patient.dao.findFirst(sb.toString(), uid, patientId)));
			} else {
				renderJson(RespFactory.isOk("获得挂号人列表成功！", Patient.dao.find(sb.toString(), uid)));
			}
		} catch (Exception e) {
			log.error("读取挂号人信息失败!",e);
			renderJson(RespFactory.isFail("读取挂号人信息失败!"));
		}
	}
	
	/**
	 * 删除挂号人信息
	 */
	@Before(POST.class)
	public void deletepatient() {
		try {
			String patientId = getPara("patientId");
			String uid = getPara("uid");
			if (!StringHandler.isEmpty(patientId)&&!StringHandler.isEmpty(uid)){
				Record record=new Record();
				record.set("patientId", patientId);
				record.set("uid", uid);
				Db.delete("t_patient", "patientId ,uid",record );
				renderJson(RespFactory.isOk("删除挂号人信息成功！"));
			} else {
				renderJson(RespFactory.isFail("删除挂号人信息失败！"));
			}
		} catch (Exception e) {
			log.error("删除挂号人信息失败！",e);
			renderJson(RespFactory.isFail("删除挂号人信息失败！"));
		}
	}

	/**
	 * 修改挂号人信息
	 * 
	 */
	@Before(POST.class)
	public void updatepatient() {
		try {
			String patientId = getPara("patientId");
			String name = getPara("name");
			String cardNo = getPara("cardNo");
			String idCard = getPara("idCard");
			String phone = getPara("phone");
			Patient patient=new Patient();
			if (!StringHandler.isEmpty(patientId)) {
				patient.set("patientId", patientId);
				if (!StringHandler.isEmpty(name)) {
					patient.set("name", name);
				}
				if (!StringHandler.isEmpty(cardNo)) {
					patient.set("cardNo", cardNo);
				}
				if (!StringHandler.isEmpty(idCard)) {
					patient.set("idCard", idCard);
				}
				if (!StringHandler.isEmpty(phone)) {
					patient.set("phone", phone);
				}
				patient.update();
				renderJson(RespFactory.isOk("修改挂号人信息成功！", patient));
			} else {
				renderJson(RespFactory.isFail("修改挂号人信息失败！"));
			}
		} catch (Exception e) {
			log.error("修改挂号人信息失败！",e);
			renderJson(RespFactory.isFail("修改挂号人信息失败！"));
		}
	}
=======
package com.wisesz.health.controller;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;

import me.zzd.webapp.core.annotation.BindController;

@BindController("/user")
public class UserController extends Controller {
	private Log log = Log.getLog(getClass());
//
//	/**
//	 * 登陆接口
//	 */
//	@Before(POST.class)
//	public void login() {
//		try {
//			String uid = getPara("uid");
//			if (!StringHandler.isEmpty(uid)) {
//				if (UserService.doLogin(getRequest(), getResponse(), uid)) {
//					renderJson(RespFactory.isOk("登陆成功！"));
//					return;
//				}
//			}
//			renderJson(RespFactory.isFail());
//		} catch (Exception e) {
//			log.error("登陆接口出错！", e);
//			renderJson(RespFactory.isFail("登陆接口出错！"));
//		}
//	}
//
//	/**
//	 * 添加病人信息
//	 */
//	@Before(POST.class)
//	public void addPatient() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录"));
//				return;
//			}
//			String name = getPara("name");
//			String cardNo = getPara("cardNo");
//			String idCard = getPara("idCard");
//			String phone = getPara("phone");
//			Integer type = getParaToInt("type");
//			if (StringHandler.isEmpty(name) || StringHandler.isEmpty(cardNo) || StringHandler.isEmpty(idCard)
//					|| StringHandler.isEmpty(phone) || type == null) {
//				renderJson(RespFactory.isFail("参数异常！"));
//				return;
//			}
//			HisCheckPatientInfoResponse response = Service.getHisCheckPatientInfo(Const.TransactionId, cardNo, idCard,
//					name, type);
//			if (response != null && response.getResultCode() == 0) {
//				UserInfo info = response.getUserInfo();
//				String patientId = info.getPatientId();
//				Patient patient = new Patient();
//				patient.setPatientId(patientId).setName(name).setIdCard(idCard).setPhone(phone).setCardNo(cardNo);
//				if (patient.save()) {
//					renderJson(RespFactory.isOk("新增挂号人成功！", patient));
//				} else {
//					renderJson(RespFactory.isFail("新增挂号人出错！"));
//				}
//			} else {
//				renderJson(RespFactory.isFail(response.getErrorMsg()));
//			}
//		} catch (Exception e) {
//			log.error("添加病人信息失败！", e);
//			renderJson(RespFactory.isFail("新增挂号人出错！"));
//		}
//	}
//
//	/**
//	 * 读取挂号人信息
//	 */
//	@Before(POST.class)
//	public void getpatient() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录"));
//				return;
//			}
//			String patientId = getPara("patientId");
//			if (!StringHandler.isEmpty(patientId)) {
//				renderJson(RespFactory.isOk("获取挂号人信息成功!", Db.findById("t_patient", "patientId,uid", patientId, uid)));
//			} else {
//				renderJson(RespFactory.isOk("获得挂号人列表成功！", Db.find("select * from t_patient where uid=?", uid)));
//			}
//		} catch (Exception e) {
//			log.error("读取挂号人信息失败!", e);
//			renderJson(RespFactory.isFail("读取挂号人信息失败!"));
//		}
//	}
//
//	/**
//	 * 删除挂号人信息
//	 */
//	@Before(POST.class)
//	public void deletepatient() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录"));
//				return;
//			}
//			String patientId = getPara("patientId");
//			if (StringHandler.isEmpty(patientId)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//				return;
//			}
//			if (Db.deleteById("t_patient", "patientId ,uid", patientId, uid)) {
//				renderJson(RespFactory.isOk("删除挂号人信息成功！"));
//			} else {
//				renderJson(RespFactory.isFail("删除挂号人信息失败！"));
//			}
//		} catch (Exception e) {
//			log.error("删除挂号人信息失败！", e);
//			renderJson(RespFactory.isFail("删除挂号人信息失败！"));
//		}
//	}
//
//	/**
//	 * 修改挂号人信息
//	 * 
//	 */
//	@Before(POST.class)
//	public void updatepatient() {
//		try {
//			String patientId = getPara("patientId");
//			String name = getPara("name");
//			String cardNo = getPara("cardNo");
//			String idCard = getPara("idCard");
//			String phone = getPara("phone");
//			Patient patient = new Patient();
//			if (!StringHandler.isEmpty(patientId)) {
//				patient.set("patientId", patientId);
//				if (!StringHandler.isEmpty(name)) {
//					patient.set("name", name);
//				}
//				if (!StringHandler.isEmpty(cardNo)) {
//					patient.set("cardNo", cardNo);
//				}
//				if (!StringHandler.isEmpty(idCard)) {
//					patient.set("idCard", idCard);
//				}
//				if (!StringHandler.isEmpty(phone)) {
//					patient.set("phone", phone);
//				}
//				patient.update();
//				renderJson(RespFactory.isOk("修改挂号人信息成功！", patient));
//			} else {
//				renderJson(RespFactory.isFail("修改挂号人信息失败！"));
//			}
//		} catch (Exception e) {
//			log.error("修改挂号人信息失败！", e);
//			renderJson(RespFactory.isFail("修改挂号人信息失败！"));
//		}
//	}
>>>>>>> b335b2b777a535494d74643b682f63efe7ef0057
}