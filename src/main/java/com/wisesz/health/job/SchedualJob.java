package com.wisesz.health.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jfinal.plugin.activerecord.Db;
import com.wisesz.health.common.Const;
import com.wisesz.health.handler.DateHandler;
import com.wisesz.health.model.Dept;
import com.wisesz.health.model.Schedual;
import com.wisesz.health.webservice.Service;
import com.wisesz.health.webservice.bean.RBASRec;
import com.wisesz.health.webservice.res.GetArrangementResponse;

public class SchedualJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String date = DateHandler.getDate();
		List<Dept> dpts = Dept.dao.find("select * from t_dept");
		List<Schedual> scList = new ArrayList<>();
		for (Dept dpt : dpts) {
			GetArrangementResponse res = Service.getArrangement(Const.TransactionId, date, 7, "", dpt.getDeptId());
			if (res != null && res.getResultCode() == 0) {
				if (res.getRBAS() == null) {
					continue;
				}
				RBASRec[] recs = res.getRBAS().getRBASRec();
				if (recs == null || recs.length == 0) {
					continue;
				}
				for (RBASRec rec : recs) {
					Schedual sc = new Schedual();
					sc.setId(rec.getRBASId());
					sc.setDate(rec.getRBASDate());
					sc.setHospitalId(Const.HospitalId);
					sc.setDeptId(rec.getDeptId());
					sc.setDeptName(rec.getDeptName());
					// sc.setSubjectId(rec.get);
					// sc.setSubject(subject)
					// sc.setDoctorIntro(doctorIntro);
					sc.setPrice(rec.getRBASPrice());
					sc.setTypeId(rec.getRBASSessionTypeId());
					sc.setType(rec.getRBASSessionType());
					sc.setGroupCode(rec.getClinicGroupCode());
					sc.setGroupName(rec.getClinicGroupName());
					sc.setAddress(rec.getAdmitAddress());
					sc.setResNo(rec.getResNo());
					scList.add(sc);
				}
			}
		}
		Db.batchSave(scList, 500);
	}
}
