package com.wisesz.health.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static String getDate(Date date) {
		return dateFormat.format(date);
	}
	public static String parseDate(Date date){
		return dateFormat.format(date);
	}
	public static String getDate() {
		return dateFormat.format(new Date());
	}

	public static String getDateTime(Date date) {
		return dateTimeFormat.format(date);
	}
	public static String parseDateTime(Date date){
		return dateTimeFormat.format(date);
	}
	public static String getDateTime() {
		return dateTimeFormat.format(new Date());
	}

}
