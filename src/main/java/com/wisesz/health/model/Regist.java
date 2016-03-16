package com.wisesz.health.model;

import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;

@BindTable(tableName = "t_regist")
public class Regist extends Model<Regist> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Regist dao = new Regist();
}
