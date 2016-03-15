package com.wisesz.health.webservice;
import java.io.ByteArrayInputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class XmlUtils {
	/**
	 * 获得xml指定节点
	 * @param str
	 * @return
	 */
	public static Element xmldomutils(String str) {
		try {
			String xml = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
			SAXReader sr = new SAXReader();
			Document document = sr.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			Element root = document.getRootElement();
			for (int i = 1; i <=4; ++i) {
				root = (Element) root.elements().get(0);
			}
			return root;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}