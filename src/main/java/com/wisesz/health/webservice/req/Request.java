package com.wisesz.health.webservice.req;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class Request {
	private XmlDocument document;

	public <T extends Dom> Request(String busicode, T invalue) {
		super();
		document = new XmlDocument("f_interface");
		document.addAttr("xmlns", "http://tempurl.org");
		document.addChild("busicode", busicode);
		document.addChild("invalue", "<![CDATA[" + invalue.toDocument().toString() + "]]>");
	}

	public XmlDocument toDocument() {
		return document;
	}
}
