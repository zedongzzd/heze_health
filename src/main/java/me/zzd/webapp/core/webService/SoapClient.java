package me.zzd.webapp.core.webService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import me.zzd.webapp.core.dom.XmlDocument;
import me.zzd.webapp.core.dom.XmlElement;

public class SoapClient {
	public static String connect(Message message) throws IOException {
		return HttpClient.post("http://173.22.155.86:8085/service", message.toString());
//		return connect("http://192.168.160.167:8001/bank_webservice/n_bank_webservice.asmx", message);
	}

	public static String connect(String endPoint, Message message) throws IOException {
		String param = message.toString();
		URL url = new URL(endPoint);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Length", Integer.toString(param.length()));
			conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
			conn.addRequestProperty("SOAPAction", "http://tempurl.org/f_interface");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(param);
			osw.close();
			// 获得响应状态
			int responseCode = conn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode) {
				StringBuilder result = new StringBuilder();
				InputStream is = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				return result.toString();
			}
		} catch (Exception e) {
		} finally {
			conn.disconnect();
		}
		return null;
	}

	public static class EmptyBody extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyBody() {
			super("body不能为空！");
		}
	}

	public static class Message {
		private StringBuilder result;

		public Message(XmlDocument header, XmlDocument body, XmlElement... attrs) throws EmptyBody {
			super();
			this.result = new StringBuilder();
			result.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ");
			if (attrs != null && attrs.length > 0) {
				for (XmlElement attr : attrs) {
					result.append(" xmlns:").append(attr.name).append("=\"").append(attr.value).append("\" ");
				}
			}
			result.append(" >");
			if (header != null) {
				result.append("<soapenv:Header>");
				result.append(header.toString());
				result.append("</soapenv:Header>");
			}
			if (body == null) {
				throw new EmptyBody();
			}
			result.append("<soapenv:Body>");
			result.append(body.toString());
			result.append("</soapenv:Body>");
			result.append("</soapenv:Envelope>");
		}

		public Message(XmlDocument body, XmlElement... attrs) throws EmptyBody {
			this(null, body, attrs);
		}

		@Override
		public String toString() {
			return result.toString();
		}
	}
}
