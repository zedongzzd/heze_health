package com.wisesz.health.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

public class HttpHandler {
	public static String getCookie(HttpServletRequest req, String name) {
		Cookie[] cookies = getCookies(req);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static Cookie[] getCookies(HttpServletRequest req) {
		return req.getCookies();
	}

	public static void addCookie(HttpServletResponse res, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		res.addCookie(cookie);
	}

	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			// "***.***.***.***".length()
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		} else if (ip == null) {
			ip = "未知";
		}
		return ip;
	}

	public static String formatUrl(String pathName, Map<String, String[]> data){
		if(StringHandler.isEmpty(pathName)){
			return "";
		}

		StringBuffer sb = new StringBuffer(pathName);

		boolean isFirst = true;
		for(Map.Entry<String,String[]> entry : data.entrySet()){
			if(isFirst){
				sb.append("?");
				isFirst = false;
			}else{
				sb.append("&");
			}

			sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()[0]));
		}

		return sb.toString();
	}
}
