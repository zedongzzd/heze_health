package com.wisesz.health.service;

import java.util.List;

import com.wisesz.health.common.Const;
import com.wisesz.health.handler.CacheHandler;
import com.wisesz.health.handler.StringHandler;
import com.wisesz.health.model.Dept;

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
}
