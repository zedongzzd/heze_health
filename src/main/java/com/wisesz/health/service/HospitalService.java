package com.wisesz.health.service;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;


import com.wisesz.health.common.Const;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.bean.RBAS;
import com.wisesz.health.webservice.bean.RBASRec;
import com.wisesz.health.webservice.res.GetAvailableRegCountResponse;

public class HospitalService {
	public static List<Record> getDeptTypes() {
		List<Record> list = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_DepartTypes);
		if (list == null) {
			String sql = "SELECT * FROM ( SELECT IFNULL(de.type, '-1') AS typeId,IFNULL(de_t.name, '其他') AS typeName FROM t_schedual sc LEFT JOIN t_dept de ON sc.deptId = de.deptId AND sc.deptName = de.name LEFT JOIN t_dept_type de_t ON de.type = de_t.id where sc.date>=? GROUP BY sc.deptId,de.type,de_t.name ) ss GROUP BY ss.typeId,ss.typename ORDER BY typeId =- 1,typeId ASC";
			list = Db.find(sql, DateHandler.getDate());
			CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_DepartTypes, list);
		}
		return list;
	}

	/**
	 * 获取医院（暂时只有一个医院）
	 * @param hospId
	 * @return
   */
	public static Record getHospital(String hospId){
		hospId = Const.HospitalId;
		Record record = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Hospital+hospId);
		if(record == null){
			record = Db.findById("t_hospital","hospitalId",hospId);
			CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Hospital+hospId, record);
		}
		return record;
	}

	/**
	 * 获取科室
	 * @param deptId
	 * @return
   */
	public static Record getDepart(String deptId){
		if(StringHandler.isEmpty(deptId)){
			return new Record();
		}
		Record record = CacheHandler.cache(Const.Cache_Name_request,Const.Cache_Key_DepartINFO+deptId);
		if(record == null){
			record = Db.findById("t_dept","deptId",deptId);
			CacheHandler.cache(Const.Cache_Name_request,Const.Cache_Key_DepartINFO+deptId,record);
		}
		return record;
	}

	/**
	 * 获取科室列表
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public static List<Record> getDeptlist(Integer typeId, Integer page, Integer pageSize) {
		String key = StringHandler.joint('-', Const.Cache_Key_Departs, typeId != null ? typeId.toString() : "null",
				page.toString(), pageSize.toString());
		List<Record> list = CacheHandler.cache(Const.Cache_Name_request, key);
		if (list == null) {
			String sql = "SELECT de.deptId,de.name,de.address FROM t_schedual sc LEFT JOIN t_dept de ON sc.deptId = de.deptId AND sc.deptName = de.name WHERE sc.date>=? ";
			String date = DateHandler.getDate();
			if (typeId == null) {
				sql += " limit ?,? ";
				list = Db.find(sql, date, (page - 1) * pageSize, pageSize);
			} else if (typeId == -1) {
				sql += " and de.type is null  limit ?,? ";
				list = Db.find(sql, date, (page - 1) * pageSize, pageSize);
			} else {
				sql += " and de.type =?  limit ?,? ";
				list = Db.find(sql, date, typeId, (page - 1) * pageSize, pageSize);
			}
			CacheHandler.cache(Const.Cache_Name_request, key, list);
		}
		return list;
	}

	/**
	 * 获取科室排班信息以及剩余挂号数
	 * 
	 * @param deptId
	 * @return
	 */
	public static List<Record> getDeptScheduals(String deptId) {
		List<Record> list = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart + deptId);
		if (list == null) {
			list = Db.find("select * from t_schedual where deptId=? and date > ? ", deptId,DateHandler.getDate(new Date()));
			CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart + deptId, list);
		}
		RBAS rBAS = CacheHandler.cache(Const.Cache_Name_reg, Const.Cache_Key_Depart + deptId);
		String [] week = new String [] { "星期日","星期一","星期二","星期三","星期四","星期五","星期六" };
		if (rBAS == null) {
			rBAS = new RBAS();
			RBASRec[] rBASRec = new RBASRec[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Record sc = list.get(i);
				sc.set("resNo","0");
				rBASRec[i] = new RBASRec();
				rBASRec[i].setRBASId(sc.get("id"));
				rBASRec[i].setRBASDate(sc.get("date").toString());
			}
			rBAS.setRBASRec(rBASRec);
			GetAvailableRegCountResponse res = Service.getAvailableRegCount(Const.TransactionId, rBAS);
			if (res != null && res.getResultCode() == 0) {
				rBAS = res.getRBAS();
				CacheHandler.cache(Const.Cache_Name_reg, Const.Cache_Key_Depart + deptId, rBAS);
			}
		}
		RBASRec[] rBASRec = rBAS.getRBASRec();
		if (rBASRec != null) {
			for (RBASRec rec : rBASRec) {
				for (Record sc : list) {
					if (rec.getRBASDate().equals(sc.get("date").toString())) {
						Integer remain = rec.getRemain();
						if (remain == null) {
							remain = 0;
						}
						sc.set("resNo"  , remain.toString());
						sc.set("rBASId" , rec.getRBASId());
						break;
					}
				}
			}
		}
		return list;
	}
}
