package com.wisesz.health.service;

import java.util.List;

import com.wisesz.health.common.Const;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Dept;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.bean.RBAS;
import com.wisesz.health.webservice.bean.RBASRec;
import com.wisesz.health.webservice.res.GetAvailableRegCountResponse;

public class HospitalService {
	public static List<Dept> getDeptlist(Integer page, Integer pageSize) {
		String key = StringHandler.joint('-', Const.Cache_Key_Departs, page.toString(), pageSize.toString());
		List<Dept> list = CacheHandler.cache(Const.Cache_Name_request, key);
		if (list == null) {
			String sql = "SELECT * FROM t_dept  ORDER BY deptId  ASC limit ?,?";
			list = Dept.dao.find(sql, (page - 1) * pageSize, pageSize);
			CacheHandler.cache(Const.Cache_Name_request, key, list);
		}
		return list;
	}

	public static List<Schedual> getDeptScheduals(String deptId) {
		List<Schedual> list = CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart + deptId);
		if (list == null) {
			list = Schedual.dao.find("select * from t_schedual where deptId=? ", deptId);
			RBAS rBAS = new RBAS();
			RBASRec[] rBASRec = new RBASRec[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Schedual sc = list.get(i);
				rBASRec[i] = new RBASRec();
				rBASRec[i].setRBASId(sc.getId());
				rBASRec[i].setRBASDate(sc.getDate());
			}
			rBAS.setRBASRec(rBASRec);
			GetAvailableRegCountResponse res = Service.getAvailableRegCount(Const.TransactionId, rBAS);
			if (res != null && res.getResultCode() == 0) {
				rBAS = res.getRBAS();
				rBASRec = rBAS.getRBASRec();
				if (rBASRec != null) {
					for (int i = 0; i < rBASRec.length; i++) {
						list.get(i).setResNo(rBASRec[i].getRemain() + "");
					}
				}
			}
			CacheHandler.cache(Const.Cache_Name_request, Const.Cache_Key_Depart + deptId, list);
		}
		return list;
	}
}
