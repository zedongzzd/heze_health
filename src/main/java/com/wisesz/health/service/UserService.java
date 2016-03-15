package com.wisesz.health.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.log.Log;
import com.wisesz.health.common.Const;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.HttpHandler;
import com.wisesz.health.handler.StringHandler;

public class UserService {
	private static Log log = Log.getLog(UserService.class);

	/**
	 * 登陆
	 * 
	 * @param req
	 * @param uid
	 * @return
	 */
	public static boolean doLogin(HttpServletRequest req, HttpServletResponse res, String uid) {
		try {
			String flag = req.getSession().getId();
			HttpHandler.addCookie(res, Const.Login_Fag, flag);
			CacheHandler.cache(Const.Cache_Name_login, flag, uid);
			return true;
		} catch (Exception e) {
			log.error("登陆失败！", e);
		}
		return false;
	}

	/**
	 * 获取登陆信息
	 * 
	 * @param req
	 * @return
	 */
	public static String getUid(HttpServletRequest req) {
		try {
			String flag = HttpHandler.getCookie(req, Const.Login_Fag);
			if (StringHandler.isEmpty(flag)) {
				String uid = req.getParameter("uid");
				if (StringHandler.isEmpty(uid)) {
					flag = req.getSession().getId();
					return CacheHandler.cache(Const.Cache_Name_login, flag);
				} else {
					return uid;
				}
			}
		} catch (Exception e) {
			log.error("获取登陆uid失败！", e);
		}
		return null;
	}

//	public static List<ContactModel> getContacts(String uid) {
//		return ContactModel.dao.find("select * from t_contact where uid=? and status=0", uid);
//	}
//
//	public static ContactModel getContact(String uid, Integer id) {
//		List<ContactModel> list = getContacts(uid);
//		if (list != null) {
//			for (ContactModel model : list) {
//				if (model.getId() == id) {
//					return model;
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 新增修改常用联系人
//	 * 
//	 * @param id
//	 * @param uid
//	 * @param name
//	 * @param idcard
//	 * @param phone
//	 * @param insureType
//	 * @return
//	 */
//	public static ContactModel addOrUpdateContact(Integer id, String uid, String name, String idcard, String phone,
//			Integer insureType) {
//		try {
//			ContactModel model = new ContactModel();
//			model.setUid(uid);
//			model.setName(name);
//			model.setIdCard(idcard);
//			model.setPhone(phone);
//			model.setInsureType(insureType);
//			if (null != id) {
//				model.setId(id);
//				if (model.update()) {
//					return model;
//				}
//			} else {
//				if (model.save()) {
//					return model;
//				}
//			}
//		} catch (Exception e) {
//			log.error("新增修改常用联系人出错！", e);
//		}
//		return null;
//	}
//
//	/**
//	 * 删除常用联系人
//	 * 
//	 * @param uid
//	 * @param id
//	 * @return
//	 */
//	public static boolean delContact(String uid, Integer id) {
//		try {
//			ContactModel model = new ContactModel();
//			model.setId(id);
//			model.setUid(uid);
//			model.setStatus(1);
//			return model.update();
//		} catch (Exception e) {
//			log.error("删除常用联系人出错!", e);
//		}
//		return false;
//	}
//
//	/**
//	 * 预约挂号
//	 * 
//	 * @param authInfo
//	 * @param hosName
//	 * @param departName
//	 * @param docName
//	 * @param startTime
//	 * @param endTime
//	 * @param workDate
//	 * @param model
//	 * @return
//	 */
//	public static Result<RegisterModel> register(AuthInfo authInfo, RegisterModel registerModel) {
//		try {
//			RegplatService service = RegplatService.getService();
//			// 预约信息
//			RegInfo regInfo = new RegInfo();
//			regInfo.setHospName(registerModel.getHospName());
//			regInfo.setDepartName(registerModel.getDepartName());
//			regInfo.setDoctorName(registerModel.getDocName());
//			regInfo.setStartTime(registerModel.getRegistStartTime());
//			regInfo.setEndTime(registerModel.getRegistEndTime());
//			regInfo.setIsPayed(false);
//			regInfo.setWorkDate(registerModel.getRegistDate());
//			if (registerModel.isMorning()) {
//				regInfo.setWorkType(WorkType.上午);
//			} else {
//				regInfo.setWorkType(WorkType.下午);
//			}
//			// 病人信息
//			PatientInfo patientInfo = new PatientInfo();
//			patientInfo.setIdCard(registerModel.getIdCard());
//			patientInfo.setName(registerModel.getName());
//			patientInfo.setInsureType(registerModel.getInsureType());
//			patientInfo.setPhone(registerModel.getPhone());
//			// 预约来源
//			RegFrom regFrom = new RegFrom();
//			regFrom.setRegVia(RegVia.PHONE_app.value());
//			regFrom.setVendor(Const.Vendor);
//			regFrom.setOperator(registerModel.getName());
//
//			// 请求医院接口 开始预约
//			String soap = service.register(authInfo, OperType.AddReg, null, patientInfo, regInfo, regFrom);
//			RegisterRsp res = DomHandler.soapStr2Object(soap, RegisterRsp.class);
//			registerModel.setState(res.getResult().getCode());
//			if (res.getResult().isSuccess()) {
//				registerModel.setSn(res.getSn());
//				registerModel.setClinicSerialNo(res.getClinicSerialNo());
//
//				String time = res.getFetchTime().trim();
//				registerModel.setFetchStartTime(time.substring(0, 16));
//				registerModel.setFetchEndTime(time.substring(0, 10) + ' ' + time.substring(17, 22));
//
//				registerModel.setFetchVerCode(res.getFetchVerCode());
//				registerModel.save();
//				return RespFactory.isOk("预约成功！", registerModel);
//			} else {
//				// 预约失败
//				registerModel.save();
//				return RespFactory.isFail(res.getResult().getMsg(), registerModel);
//			}
//		} catch (Exception e) {
//			log.error("预约挂号出错！", e);
//			registerModel.setState(RespFactory.isFail);
//			registerModel.save();
//		}
//		return RespFactory.isFail("预约挂号出错！", registerModel);
//	}
//
//	/**
//	 * 取消预约挂号
//	 * 
//	 * @param authInfo
//	 * @param registerId
//	 * @return
//	 */
//	public static String unRegister(AuthInfo authInfo, RegisterModel model) {
//		RegplatService service = RegplatService.getService();
//		PatientInfo info = new PatientInfo();
//		info.setName(model.getName());
//		info.setIdCard(model.getIdCard());
//		info.setPhone(model.getStr("phone"));
//		info.setInsureType(InsureType.valueOf(model.getStr("insureType")));
//		RegFrom regFrom = new RegFrom();
//		regFrom.setVendor(Const.Vendor);
//		regFrom.setRegVia(RegVia.PHONE_app.value());
//		regFrom.setOperator(info.getName());
//		try {
//			return service.register(authInfo, OperType.DelReg, model.getSn(), info, null, regFrom);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static List<NoticeModel> getNoticesFromCache(Integer page, Integer pageSize) {
//		String key = StringHandler.joint('_', Const.Cache_Key_Notice, "all", page != null ? page.toString() : "1",
//				pageSize != null ? pageSize.toString() : "10");
//		List<NoticeModel> list = CacheHandler.cache(Const.Cache_Name_request, key);
//		if (list == null) {
//			String sql = "select id,title,updateTime,author,remark from t_notice where status=0 order by sort desc,updateTime desc limit ?,?";
//			list = NoticeModel.dao.find(sql, (page - 1) * pageSize, pageSize);
//			CacheHandler.cache(Const.Cache_Name_request, key, list);
//		}
//		return list;
//	}
}
