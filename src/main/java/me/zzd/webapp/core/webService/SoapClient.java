package me.zzd.webapp.core.webService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import me.zzd.webapp.core.dom.XmlDocument;

public class SoapClient {

	public static String connect(String endPoint, Message message) throws IOException {
		String param = message.toString();
		URL url = new URL(endPoint);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
		if (HttpURLConnection.HTTP_OK == responseCode) {
			InputStream is = conn.getInputStream();
			byte[] b = new byte[1024];
			int len = 0;
			StringBuilder result = new StringBuilder();
			while ((len = is.read(b)) != -1) {
				result.append(new String(b, 0, len, "utf-8"));
			}
			return result.toString();
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

		public Message(String targetName, XmlDocument header, XmlDocument body) throws EmptyBody {
			super();
			this.result = new StringBuilder();
			result.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"");
			result.append(targetName);
			result.append("\">");
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
		}

		public Message(String targetName, XmlDocument body) throws EmptyBody {
			this(targetName, null, body);
		}

		@Override
		public String toString() {
			return result.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		XmlDocument body = new XmlDocument("ehrService","<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GetCheckRptReq><Action>GetLabReport</Action><Message><IdCard>320504196002074025</IdCard><DocumentNo>LY51502091550</DocumentNo></Message></GetCheckRptReq>]]>");
		Message message = new Message("http://service.ws.com/", body);
		System.out.println(SoapClient.connect("http://211.143.239.187:8080/EhrService/services/EhrService?wsdl", message));
	}
}
