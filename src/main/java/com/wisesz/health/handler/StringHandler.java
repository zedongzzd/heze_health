package com.wisesz.health.handler;



public class StringHandler {
	public static boolean isEmpty(String value) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return false;
	}

	public static String joint(char split, String... strs) {
		if (strs == null || strs.length == 0) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			if (i != 0) {
				sb.append(split);
			}
			if (isEmpty(strs[i])) {
				sb.append("null");
			} else {
				sb.append(strs[i]);
			}

		}
		return sb.toString();
	}

	public static String defaultValue(Object value, String defaultValue) {
		String str = "";
		String s   = "";

		try {
			s = value.toString();
		}catch (Exception e){
			s = defaultValue;
		}

		return s;
	}

	public  static String defaultValue(Object value){
		return defaultValue(value,"");
	}
}
