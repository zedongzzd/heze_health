package com.wisesz.health.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.wisesz.health.common.Result.RespFactory;

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

	/**
	 * 获取科室归类列表
	 */
	@Before(POST.class)
	public void getDepartTypes() {
//		try {
//			Object res = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart_Types);
//			if (res == null) {
//				res = CodeMasterService.dao.find("select * from t_code_master where type=?", Const.Code_Type_Of_Depart);
//				CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart_Types, res);
//			}
//			renderJson(RespFactory.isOk("获取科室归类列表成功!", res));
//		} catch (Exception e) {
//			log.error("获取科室归类列表出错！", e);
//			renderJson(RespFactory.isFail("获取科室归类列表出错!"));
//		}
	}

	/**
	 * 获取科室列表
	 */
	@Before(POST.class)
	public void getDeparts() {
//		try {
//			String hospName = getPara("hospName");
//			if (StringHandler.isEmpty(hospName)) {
//				renderJson(RespFactory.isFail("没有指定医院！"));
//			} else {
//				Integer typeId = getParaToInt("typeId");
//				String departName = getPara("departName");
//				Integer page = getParaToInt("page");
//				page = page != null ? page : 1;
//				Integer pageSize = getParaToInt("pageSize");
//				pageSize = pageSize != null ? pageSize : 20;
//				renderJson(RespFactory.isOk("获取科室列表成功！",
//						DepartService.getDeparts(hospName, typeId, departName, page, pageSize)));
//			}
//		} catch (Exception e) {
//			log.error("获取科室列表出错！", e);
//			renderJson(RespFactory.isFail("获取科室列表失败！"));
//		}
	}

	/**
	 * 获取医生列表
	 */
	@Before(POST.class)
	public void getHospDocs() {
//		try {
//			String docName = getPara("docName");
//			Integer hospId = getParaToInt("hospId");
//			String departName = getPara("departName");
//			if (hospId == null && StringHandler.isEmpty(departName) && StringHandler.isEmpty(docName)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//			} else {
//				renderJson(RespFactory.isOk("获取医生列表成功！", DocService.getDocs(hospId, departName, docName)));
//			}
//		} catch (Exception e) {
//			log.error("获取医生列表出错！", e);
//			renderJson(RespFactory.isFail("获取医生列表出错！"));
//		}
	}

	/**
	 * 获取医生信息
	 */
	@Before(POST.class)
	public void getDoc() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			Integer docId = getParaToInt("id");
//			if (docId == null) {
//				renderJson(RespFactory.isFail("参数异常！"));
//			} else {
//				String sql = "select doc.*,fa.id as favoriteId from t_doctor doc LEFT JOIN t_favorite fa on fa.docId=doc.id and fa.status=0 and fa.uid=? where doc.id=? ";
//				if (uid == null) {
//					sql = "select doc.* from t_doctor doc  where doc.id=? ";
//					renderJson(RespFactory.isOk("获取医生信息成功！", Db.findFirst(sql, docId)));
//				}
//				renderJson(RespFactory.isOk("获取医生信息成功！", Db.findFirst(sql, uid == null ? "null" : uid, docId)));
//			}
//		} catch (Exception e) {
//			log.error("获取医生信息失败！", e);
//			renderJson(RespFactory.isFail("获取医生信息失败！"));
//		}
	}

	/**
	 * 获取明星信息
	 */
	@Before(POST.class)
	public void getSuperStar() {
//		try {
//			String uid = UserService.getUid(getRequest());
//			Integer type = getParaToInt("type");
//			Object res = null;
//			// 明星医生
//			if (type == 0) {
//				String sql = "SELECT su.id, su.name,de.registryFee as dRegistryFee, su.docId, su.imgUrl, fa.id AS favoriteId,doc.doctorInro,doc.clinicFee,doc.registryFee,  doc.docRank,doc.docMajor, doc.departName, de.id AS departId, doc.hospId, hos.hospName FROM t_superstar su LEFT JOIN t_favorite fa ON su.docId = fa.docId AND fa.status = 0 AND fa.uid =? LEFT JOIN t_doctor doc ON su.docId = doc.id LEFT JOIN t_hospital hos ON hos.id = doc.hospId LEFT JOIN t_depart de ON de.hospId = doc.hospId AND de.departName = doc.departName WHERE su.docId IS NOT NULL AND su.departId IS NULL AND su.status = 0 ORDER BY su.sort DESC";
//				if (StringHandler.isEmpty(uid)) {
//					uid = "null";
//				}
//				res = SuperStarModel.dao.find(sql, uid);
//			}
//			// 明星科室
//			else {
//				Integer departId = getParaToInt("departId");
//				// 明星科室列表
//				if (departId == null) {
//					res = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_SsDepart);
//					if (res == null) {
//						String sql = "SELECT id, name, imgUrl FROM t_superstar WHERE docId IS NULL AND departId IS NULL AND STATUS = 0 ORDER BY sort DESC";
//						res = SuperStarModel.dao.find(sql);
//						CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_SsDepart, res);
//					}
//				}
//				// 明星科室下的医生列表
//				else {
//					String sql = "SELECT su.id, su.name,de.registryFee as dRegistryFee, su.docId, su.imgUrl, fa.id AS favoriteId, doc.docRank,doc.doctorInro,doc.clinicFee,doc.registryFee,doc.docMajor, doc.departName, de.id AS departId, doc.hospId, hos.hospName FROM t_superstar su LEFT JOIN t_favorite fa ON su.docId = fa.docId AND fa.status = 0 AND fa.uid =? LEFT JOIN t_doctor doc ON su.docId = doc.id LEFT JOIN t_hospital hos ON hos.id = doc.hospId LEFT JOIN t_depart de ON de.hospId = doc.hospId AND de.departName = doc.departName WHERE su.docId IS NOT NULL AND su.departId = ? AND su.status = 0 ORDER BY su.sort DESC";
//					res = SuperStarModel.dao.find(sql, uid, departId);
//				}
//			}
//			renderJson(RespFactory.isOk("获取成功！", res));
//		} catch (Exception e) {
//			log.error("获取明星信息失败！", e);
//			renderJson(RespFactory.isFail("获取明星信息失败！"));
//		}
	}

	/**
	 * 获取7天的排班表
	 */
	@Before(POST.class)
	public void getSchedual() {
//		try {
//			String hosName = getPara("hosName");
//			String departName = getPara("departName");
//			if (StringHandler.isEmpty(hosName) || StringHandler.isEmpty(departName)) {
//				renderJson(RespFactory.isFail("参数异常！"));
//				return;
//			}
//			renderJson(RespFactory.isOk("获取排班表成功！",
//					HospitalService.getSchedual(hosName, departName, DateHandler.getDate())));
//		} catch (Exception e) {
//			log.error("获取排班表出错！", e);
//			renderJson(RespFactory.isFail("获取排班表出错！"));
//		}
	}

	/**
	 * 获取号源
	 */
	@Before(POST.class)
	public void getRegPool() {
//		try {
//			String hosName = getPara("hosName");
//			String departName = getPara("departName");
//			String docName = getPara("docName");
//			String workDate = getPara("workDate");
//			String noCachePara = getPara("noCache");
//			if (StringHandler.isEmpty(hosName) || StringHandler.isEmpty(departName)) {
//				renderJson(RespFactory.isFail("参数异常"));
//				return;
//			}
//			if (StringHandler.isEmpty(workDate)) {
//				workDate = DateHandler.getDate();
//			}
//			boolean noCache = Boolean.parseBoolean(noCachePara);
//			List<PoolInfo> list = HospitalService.getPoolInfo(noCache, AuthInfo.newInstance(), hosName, departName,
//					docName, workDate);
//			Map<String, Object> res = new HashMap<>();
//			res.put("hosName", hosName);
//			res.put("departName", departName);
//			res.put("docName", docName);
//			res.put("workDate", workDate);
//			res.put("poolInfo", list);
//			renderJson(RespFactory.isOk("获取号源成功！", res));
//		} catch (Exception e) {
//			log.error("获取号源出错！", e);
//			renderJson(RespFactory.isFail("获取号源出错！"));
//		}
	}

	/**
	 * 获取号源
	 */
	@Before(POST.class)
	public void getRegPools() {
//		try {
//			String hosName = getPara("hosName");
//			String departName = getPara("departName");
//			String docName = getPara("docName");
//			if (StringHandler.isEmpty(hosName) || StringHandler.isEmpty(departName) && StringHandler.isEmpty(docName)) {
//				renderJson(RespFactory.isFail("参数异常"));
//				return;
//			}
//			String date = DateHandler.getDate();
//			List<SchedualModel> scs = HospitalService.getSchedual(hosName, departName, date);
//			Map<String, Object> res = new HashMap<>();
//			for (SchedualModel sc : scs) {
//				RegplatService regplatService = RegplatService.getService();
//				RegInfoFilter filter = new RegInfoFilter();
//				filter.setHospName(hosName);
//				filter.setDepartName(departName);
//				filter.setDoctorName(docName);
//				filter.setWorkDate(sc.getWorkDate());
//				filter.setWorkType(sc.getWorkType());
//				try {
//					String soap = regplatService.getRegPool(AuthInfo.newInstance(), filter);
//					GetRegPoolRsp getRegPoolRsp = DomHandler.soapStr2Object(soap, GetRegPoolRsp.class);
//					if (getRegPoolRsp.getResult().isSuccess()) {
//						res.put(sc.getWorkDate() + ";" + sc.getWorkType(), getRegPoolRsp.getPoolInfo());
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			renderJson(RespFactory.isOk("获取号源成功！", res));
//		} catch (Exception e) {
//			log.error("获取号源出错！", e);
//			renderJson(RespFactory.isFail("获取号源出错！"));
//		}
	}
}
