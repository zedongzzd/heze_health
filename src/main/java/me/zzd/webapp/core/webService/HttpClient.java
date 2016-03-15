package me.zzd.webapp.core.webService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	public static String post(String endPoint, String param) throws IOException {
		URL url = new URL(endPoint);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Length", Integer.toString(param.length()));
			conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(param);
			osw.close();
			// 获得响应状态
			int responseCode = conn.getResponseCode();
			InputStream is = null;
			if (HttpURLConnection.HTTP_OK == responseCode) {
				is = conn.getInputStream();
			} else {
				is = conn.getErrorStream();
			}
			if (is != null) {
				byte[] b = new byte[1024];
				int len = 0;
				StringBuilder result = new StringBuilder();
				while ((len = is.read(b)) != -1) {
					result.append(new String(b, 0, len, "utf-8"));
				}
				return result.toString();
			}
		} catch (Exception e) {
		} finally {
			conn.disconnect();
		}
		return null;
	}
}
