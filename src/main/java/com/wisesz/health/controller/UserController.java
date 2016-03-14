package com.wisesz.health.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.wisesz.health.common.Result.RespFactory;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.service.UserService;

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
	 * 获取常用就诊人
	 */
	@Before(POST.class)
	public void getContacts() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				List<ContactModel> list = UserService.getContacts(uid);
//				renderJson(RespFactory.isOk("获取常用联系人列表", list));
//			}
//		} catch (Exception e) {
//			log.error("获取常用联系人列表失败！", e);
//			renderJson(RespFactory.isFail("获取常用联系人列表失败！"));
//		}
	}

	/**
	 * 添加常用就诊人
	 */
	@Before(POST.class)
	public void configContact() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				Integer id = getParaToInt("id");
//				String name = getPara("name");
//				String idcard = getPara("idCard");
//				String phone = getPara("phone");
//				Integer insureType = getParaToInt("insureType");
//				if (StringHandler.isEmpty(name) || StringHandler.isEmpty(idcard) || StringHandler.isEmpty(phone)
//						|| insureType == null) {
//					renderJson(RespFactory.isFail("参数异常！"));
//				} else {
//					ContactModel model = UserService.addOrUpdateContact(id, uid, name, idcard, phone, insureType);
//					if (model != null) {
//						renderJson(RespFactory.isOk("常用就诊人配置成功！", model));
//					} else {
//						renderJson(RespFactory.isFail());
//					}
//				}
//			}
//		} catch (Exception e) {
//			log.error("添加常用联系人失败！", e);
//			renderJson(RespFactory.isFail());
//		}
	}

	/**
	 * 删除常用就诊人
	 */
	@Before(POST.class)
	public void delContact() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				Integer id = getParaToInt("id");
//				if (id != null) {
//					if (UserService.delContact(uid, id)) {
//						renderJson(RespFactory.isOk());
//					} else {
//						renderJson(RespFactory.isFail());
//					}
//				} else {
//					renderJson(RespFactory.isFail("没有指定id！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("删除常用就诊人失败！", e);
//			renderJson(RespFactory.isFail("删除常用就诊人失败！"));
//		}
	}

	/**
	 * 预约挂号 contactId hosName departName docName（可选） workDate startTime endTime
	 */
	@Before(POST.class)
	public void register() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				Integer registId = getParaToInt("registId");
//				if (registId != null) {
//					RegisterModel tmpRegist = RegisterModel.dao.findById(registId);
//					if (uid.equals(tmpRegist.getUid()) && tmpRegist.getState() == 2) {
//						Integer contactId = getParaToInt("contactId");
//						if (contactId != null) {
//							ContactModel model = UserService.getContact(uid, contactId);
//							tmpRegist.setName(model.getName());
//							tmpRegist.setIdCard(model.getIdCard());
//							tmpRegist.setPhone(model.getPhone());
//							tmpRegist.setInsureType(model.getInsureType());
//						}
//						renderJson(UserService.register(AuthInfo.newInstance(), tmpRegist));
//					} else {
//						renderJson(RespFactory.isFail("没有此挂号单！"));
//					}
//				} else {
//					Integer contactId = getParaToInt("contactId");
//					ContactModel model = UserService.getContact(uid, contactId);
//					if (model != null) {
//						RegisterModel registerModel = new RegisterModel();
//						registerModel.setUid(uid);
//						registerModel.setName(model.getName());
//						registerModel.setIdCard(model.getIdCard());
//						registerModel.setPhone(model.getPhone());
//						registerModel.setInsureType(model.getInsureType());
//						registerModel.setHospName(getPara("hosName"));
//						registerModel.setDepartName(getPara("departName"));
//						registerModel.setDocName(getPara("docName"));
//						registerModel.setIsExpert(registerModel.getDocName() != null);
//						BigDecimal[] fees = HospitalService.getFee(registerModel.getHospName(),
//								registerModel.getDepartName(), registerModel.getDocName());
//						registerModel.setRegistryFee(fees[0]);
//						registerModel.setClinicFee(fees[1]);
//						registerModel.setRegistDate(getPara("workDate"));
//						registerModel.setRegistStartTime(getPara("startTime"));
//						registerModel.setRegistEndTime(getPara("endTime"));
//						registerModel.setCreateTime(DateHandler.getDateTime());
//						registerModel.setUpdateTime(registerModel.getCreateTime());
//						renderJson(UserService.register(AuthInfo.newInstance(), registerModel));
//					} else {
//						renderJson(RespFactory.isFail("未获取常用联系人信息！"));
//					}
//				}
//			}
//		} catch (Exception e) {
//			log.error("预约挂号出错！", e);
//			renderJson(RespFactory.isFail("预约挂号出错！"));
//		}
	}

	/**
	 * 暂存挂号单
	 */
	@Before(POST.class)
	public void tempRegist() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				RegisterModel registerModel = new RegisterModel();
//				registerModel.setUid(uid);
//				Integer contactId = getParaToInt("contactId");
//				if (contactId != null) {
//					ContactModel model = UserService.getContact(uid, contactId);
//					registerModel.setName(model.getName());
//					registerModel.setIdCard(model.getIdCard());
//					registerModel.setPhone(model.getPhone());
//					registerModel.setInsureType(model.getInsureType());
//				}
//				registerModel.setHospName(getPara("hosName"));
//				registerModel.setDepartName(getPara("departName"));
//				registerModel.setDocName(getPara("docName"));
//				registerModel.setIsExpert(registerModel.getDocName() != null);
//				BigDecimal[] fees = HospitalService.getFee(registerModel.getHospName(), registerModel.getDepartName(),
//						registerModel.getDocName());
//				registerModel.setRegistryFee(fees[0]);
//				registerModel.setClinicFee(fees[1]);
//				registerModel.setRegistDate(getPara("workDate"));
//				registerModel.setRegistStartTime(getPara("startTime"));
//				registerModel.setRegistEndTime(getPara("endTime"));
//				registerModel.setCreateTime(DateHandler.getDateTime());
//				registerModel.setUpdateTime(registerModel.getCreateTime());
//				registerModel.setState(2);
//				if (registerModel.save()) {
//					renderJson(RespFactory.isOk("暂存成功！", registerModel));
//				} else {
//					renderJson(RespFactory.isFail("暂存出错！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("暂存出错！", e);
//			renderJson(RespFactory.isFail("暂存出错！"));
//		}
	}

	/**
	 * 取消预约挂号
	 */
	@Before(POST.class)
	public void unRegister() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				Integer registerId = getParaToInt("registerId");
//				String phone = getPara("phone");
//				String name = getPara("name");
//				String insureType = getPara("insureType");
//				if (registerId == null || StringHandler.isEmpty(phone) || StringHandler.isEmpty(name)
//						|| StringHandler.isEmpty(insureType)) {
//					renderJson(RespFactory.isFail("参数异常！"));
//					return;
//				}
//				// 针对没有退号 没有取号
//				List<RegisterModel> list = RegService.getRegisters(uid, registerId, RespFactory.isOK, false, null,
//						false);
//				if (list != null && list.size() == 1) {
//					RegisterModel model = list.get(0);
//					model.put("phone", phone);
//					model.put("insureType", insureType);
//					String soap = UserService.unRegister(AuthInfo.newInstance(), model);
//					RegisterRsp res = DomHandler.soapStr2Object(soap, RegisterRsp.class);
//					Result<String> renderjson = RespFactory.newInstance(0, null, null);
//					model.setState(res.getResult().getCode());
//					if (res != null && res.getResult() != null) {
//						int code = res.getResult().getCode();
//						if (code == RespFactory.isOK) {
//							model.setIsQuit(true);
//							model.update();
//						}
//						renderjson.setResultCode(code);
//						renderjson.setResultMsg(res.getResult().getMsg());
//					} else {
//						renderjson.setResultCode(1);
//						renderjson.setResultMsg("服务器繁忙，请多试几次，给您带来不便，请谅解。");
//					}
//					renderJson(renderjson);
//				} else {
//					renderJson(RespFactory.isFail("未获取到挂号信息！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("取消预约挂号失败！", e);
//			renderJson(RespFactory.isFail("取消预约挂号失败！"));
//		}
	}

	/**
	 * 获取预约挂号信息 type
	 * 
	 * @param 0全部
	 * @param 1待就诊
	 * @param 2已完成
	 * @param 3已失效(余号0等挂号失败，专家听诊，提交失败，超过就诊时间当天未取号)
	 */
	@Before(POST.class)
	public void getRegisters() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//			} else {
//				Integer page = getParaToInt("page");
//				Integer pageSize = getParaToInt("pageSize");
//				Integer type = getParaToInt("type");
//				// 取全部的时候更新超时的订单状态
//				if (type == 0) {
//					String dateTime = DateHandler.getDateTime();
//					String date = dateTime.substring(0, 10);
//					String time = dateTime.substring(11, dateTime.length());
//					String sql = "select id,idCard,sn from t_register where state=0 and isQuit=? and isFetched=? and (registDate <? OR (registDate =? and AND fetchEndTime <? ))";
//					List<RegisterModel> list = RegisterModel.dao.find(sql, false, false, date, date, time);
//					if (list != null && list.size() > 0) {
//						for (RegisterModel r : list) {
//							PatientIdentify patientIdentify = new PatientIdentify();
//							patientIdentify.setIdCard(r.getIdCard());
//							patientIdentify.setSn(r.getSn());
//							String soap = RegplatService.getService().getRegInfo(AuthInfo.newInstance(),
//									patientIdentify, null);
//							GetRegInfoRsp rsp = DomHandler.soapStr2Object(soap, GetRegInfoRsp.class);
//							RegInfo[] regs = rsp.getRegInfo();
//							if (regs != null && regs.length > 0) {
//								RegInfo reg = regs[0];
//								if (reg.getIsFetched()) {
//									r.setIsFetched(true);
//									r.setFetchedTime(reg.getFetchDateTime());
//									r.setIsPay(!reg.getIsUnPayed());
//								} else {
//									r.setState(3);
//								}
//							}
//						}
//						Db.batchUpdate(list, 50);
//					}
//				}
//				List<RegisterModel> res = RegService.getRegistersFromDb(uid, type, page, pageSize);
//				renderJson(RespFactory.isOk("获取预约挂号信息成功！", res));
//			}
//		} catch (Exception e) {
//			log.error("获取预约挂号信息", e);
//			renderJson(RespFactory.isFail("获取预约挂号信息"));
//		}
	}

	/**
	 * 获取广告
	 */
	@Before(POST.class)
	public void getBanners() {
//		try {
//			String position = getPara("position");
//			if (StringHandler.isEmpty(position)) {
//				Object res = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Banner);
//				if (res == null) {
//					String sql = "SELECT b.id, b. NAME, b.img, b.href, c. NAME AS positionName FROM t_banner b LEFT JOIN t_code_master c ON c.id = b.position WHERE (b. STATUS = 0 or b. STATUS = 3) AND c.type = ? ORDER BY c.id ASC, b.updateTime DESC";
//					res = Db.find(sql, Const.Code_Type_Page_Position);
//					CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Banner, res);
//				}
//				renderJson(RespFactory.isOk("获取广告成功！", res));
//			} else {
//				Object res = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Banner + position);
//				if (res == null) {
//					String sql = "SELECT b.id, b. NAME, b.img, b.href, c. NAME AS positionName FROM t_banner b LEFT JOIN t_code_master c ON c.id = b.position WHERE (b. STATUS = 0 or b. STATUS = 3) AND c.`name` LIKE ? AND c.type = ? ORDER BY c.id ASC, b.updateTime DESC";
//					res = Db.find(sql, "%" + position + "%", Const.Code_Type_Page_Position);
//					CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Banner + position, res);
//				}
//				renderJson(RespFactory.isOk("获取广告成功！", res));
//			}
//		} catch (Exception e) {
//			log.error("获取广告出错！", e);
//			renderJson(RespFactory.isFail("获取广告失败！"));
//		}
	}

	/**
	 * 获取评价列表
	 */
	@Before(POST.class)
	public void getRates() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			Integer docId = getParaToInt("docId");
//			Integer registId = getParaToInt("registId");
//			if (docId == null && registId == null) {
//				renderJson(RespFactory.isFail("参数异常！"));
//				return;
//			}
//			Integer page = getParaToInt("page");
//			Integer pageSize = getParaToInt("pageSize");
//			renderJson(RespFactory.isOk("获取评价列表！", DocService.getDocRates(uid, docId, registId, page, pageSize)));
//		} catch (Exception e) {
//			log.error("获取评价出错！", e);
//			renderJson(RespFactory.isFail());
//		}
	}

	@Before(POST.class)
	public void getAvgRate() {
//		try {
//			Integer docId = getParaToInt("docId");
//			String sql = "select AVG(rate) as rate from t_doctor_rate where docId=?";
//			renderJson(RespFactory.isOk("获取医生总评价成功！", Db.find(sql, docId)));
//		} catch (Exception e) {
//			log.error("获取医生总评价出错！", e);
//			renderJson(RespFactory.isFail());
//		}
	}

	/**
	 * 更新评价
	 */
	@Before(POST.class)
	public void updateRate() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//				return;
//			}
//			Integer rateId = getParaToInt("rateId");
//			DocRateModel model = DocRateModel.dao.findById(rateId);
//			if (model == null || !uid.equals(model.getUid()) || model.getStatus() != 0) {
//				renderJson(RespFactory.isFail("没有找到此评论！"));
//			} else {
//				Integer rate = getParaToInt("rate");
//				String serviceRate = getPara("serviceRate");
//				if (rate != null) {
//					model.setRate(rate);
//				}
//				if (!StringHandler.isEmpty(serviceRate)) {
//					model.setServiceRate(serviceRate);
//				}
//				model.update();
//				renderJson(RespFactory.isOk("更新评论成功！", model));
//			}
//		} catch (Exception e) {
//			log.error("更新评论出错！", e);
//			renderJson(RespFactory.isFail("更新评论出错！"));
//		}
	}

	/**
	 * 创建评价
	 */
	@Before(POST.class)
	public void createRate() {
//		try {
//
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//				return;
//			}
//			Integer registerId = getParaToInt("registerId");
//			Integer rate = getParaToInt("rate");
//			String serviceRate = getPara("serviceRate");
//			if (registerId == null || rate == null || StringHandler.isEmpty(serviceRate)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//			} else {
//				String dateTime = DateHandler.getDateTime();
//				String date = dateTime.substring(0, 10);
//				String time = dateTime.substring(11, dateTime.length());
//				RegisterModel model = RegService.getRegisterDoc(registerId, uid, date, time);
//				if (model != null) {
//					DocRateModel rateModel = new DocRateModel();
//					rateModel.setUid(uid);
//					rateModel.setDocId(model.getInt("docId"));
//					rateModel.setRegisterId(registerId);
//					rateModel.setRate(rate);
//					rateModel.setServiceRate(serviceRate);
//					rateModel.setCreateTime(dateTime);
//					rateModel.setStatus(0);
//					if (rateModel.save()) {
//						renderJson(RespFactory.isOk("创建评价成功！", rateModel));
//					} else {
//						renderJson(RespFactory.isFail("创建评价出错！"));
//					}
//				} else {
//					renderJson(RespFactory.isFail("挂号单不存在！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("创建评价出错！", e);
//			renderJson(RespFactory.isFail("创建评价出错！"));
//		}
	}

	/**
	 * @param action:检查报告传参：GetExamReport，检验报告传参：GetLabReport
	 * @param idCard:身份证号码
	 * @param documentNo:单据号码（a.检验单/检查单
	 *            b.发票号 c.门诊号）
	 */
	@Before(POST.class)
	public void ehrService() {
//		try {
//			String idCard = getPara("idCard");
//			String documentNo = getPara("documentNo");
//			String action = getPara("action");
//			if (StringHandler.isEmpty(idCard) || StringHandler.isEmpty(documentNo) || StringHandler.isEmpty(action)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//			} else {
//				String xml = EhrService.ehrService(action, idCard, documentNo);
//				xml = DomHandler.soapStr2Dom(xml).element("ehrServiceResponse").element("return").getStringValue();
//				GetCheckRptRsp res = DomHandler.xmlStr2Object(xml, GetCheckRptRsp.class);
//				if (res != null) {
//					renderJson(RespFactory.isOk("检查报告查询成功！", res));
//				} else {
//					renderJson(RespFactory.isFail("检查报告查询失败！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("检查报告查询失败！", e);
//			renderJson(RespFactory.isFail("检查报告查询失败！"));
//		}
	}

	/**
	 * 关注医生
	 */
	@Before(POST.class)
	public void favoriteDoc() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录！"));
//				return;
//			}
//			Integer docId = getParaToInt("docId");
//			Integer id = getParaToInt("id");
//			FavoriteModel favoriteModel = new FavoriteModel();
//			favoriteModel.setUid(uid);
//			favoriteModel.setDocId(docId);
//			boolean op = false;
//			if (id != null) {
//				favoriteModel.setId(id);
//				favoriteModel.setStatus(1);
//				op = favoriteModel.update();
//			} else {
//				favoriteModel.setStatus(0);
//				favoriteModel.setCreateTime(DateHandler.getDateTime());
//				op = favoriteModel.save();
//			}
//			if (op) {
//				renderJson(RespFactory.isOk("操作成功！", favoriteModel));
//			} else {
//				renderJson(RespFactory.isFail());
//			}
//		} catch (Exception e) {
//			log.error("关注医生出错！", e);
//			renderJson(RespFactory.isFail());
//		}
	}

	/**
	 * 获取关注医生
	 */
	@Before(POST.class)
	public void getFavorites() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			if (StringHandler.isEmpty(uid)) {
//				renderJson(RespFactory.isFail("尚未登录!"));
//			} else {
//				Integer page = getParaToInt("page");
//				if (page == null) {
//					page = 1;
//				}
//				Integer pageSize = getParaToInt("pageSize");
//				if (pageSize == null) {
//					pageSize = 10;
//				}
//
//				page = (page - 1) * pageSize;
//				String sql = "SELECT fa.id,doc.doctorInro,doc.clinicFee,de.registryFee as dRegistryFee,doc.registryFee,doc.id as docId,doc.doctorName,doc.doctorName as name, doc.photoURL,doc.photoURL as imgUrl, doc.docRank, doc.docMajor, doc.isExpert, doc.departName, de.id AS departId, doc.hospId, hos.hospName FROM t_favorite fa LEFT JOIN t_doctor doc ON doc.id = fa.docId LEFT JOIN t_depart de ON doc.departName = de.departName AND de.hospId = doc.hospId LEFT JOIN t_hospital hos ON doc.hospId = hos.id WHERE fa.uid =? AND fa.status = 0 LIMIT ?,?";
//				renderJson(RespFactory.isOk("获取关注医生", Db.find(sql, uid, page, pageSize)));
//			}
//		} catch (Exception e) {
//			log.error("获取关注医生", e);
//			renderJson(RespFactory.isFail("获取关注医生"));
//		}
	}

	/**
	 * 获取公告
	 */
	@Before(POST.class)
	public void getNotices() {
//		try {
//			Integer id = getParaToInt("id");
//			if (id == null) {
//				Integer page = getParaToInt("page");
//				Integer pageSize = getParaToInt("pageSize");
//				renderJson(RespFactory.isOk("获取公告成功！",
//						UserService.getNoticesFromCache(page != null ? page : 1, pageSize != null ? pageSize : 10)));
//			} else {
//				NoticeModel notice = NoticeModel.dao.findById(id);
//				if (notice.getStatus() == 0) {
//					renderJson(RespFactory.isOk("获取公告成功！", notice));
//				} else {
//					renderJson(RespFactory.isFail("此公告未发布！"));
//				}
//			}
//		} catch (Exception e) {
//			log.error("获取公告失败！", e);
//			renderJson(RespFactory.isFail("获取公告失败！"));
//		}
	}

	/**
	 * 埋点统计接口
	 */
	@Before(POST.class)
	public void count() {
//		try {
//			String uid = getPara("uid");
//			String position = getPara("position");
//			if (StringHandler.isEmpty(uid) && StringHandler.isEmpty(position)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//				return;
//			}
//			CountModel model = new CountModel();
//			model.setUid(uid).setPosition(position).setCreateTime(DateHandler.getDateTime());
//			if (model.save()) {
//				renderJson(RespFactory.isOk());
//			} else {
//				renderJson(RespFactory.isFail());
//			}
//		} catch (Exception e) {
//			renderJson(RespFactory.isFail());
//		}
	}
}