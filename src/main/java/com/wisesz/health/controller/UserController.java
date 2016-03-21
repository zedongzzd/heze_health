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
}