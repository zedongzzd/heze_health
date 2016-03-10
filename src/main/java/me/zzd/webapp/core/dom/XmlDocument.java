package me.zzd.webapp.core.dom;

import java.util.ArrayList;
import java.util.List;

public class XmlDocument {
	private XmlElement me;
	private List<XmlDocument> childs = null;
	private List<XmlElement> attrs = null;

	public XmlDocument(String name) {
		this(name, null);
	}

	public XmlDocument(String name, String value) {
		this.me = new XmlElement(name, value);
	}

	public String getName() {
		return this.me.name;
	}

	public String getValue() {
		return this.me.value;
	}

	public XmlDocument setName(String name) {
		this.me.name = name;
		return this;
	}

	public XmlDocument setValue(String value) {
		this.me.value = value;
		return this;
	}

	public List<XmlDocument> getChildren() {
		return this.childs;
	}

	public List<XmlElement> getAttrs() {
		return this.attrs;
	}

	public XmlDocument addChild(String name, String value) {
		return addChild(new XmlDocument(name, value));
	}

	public XmlDocument addChild(XmlDocument child) {
		return addChildren(child);
	}

	public XmlDocument addChildren(XmlDocument... childs) {
		if (childs == null) {
			return this;
		}
		if (this.childs == null) {
			this.childs = new ArrayList<XmlDocument>();
		}
		for (XmlDocument rp : childs) {
			this.childs.add(rp);
		}
		return this;
	}

	public XmlDocument addAttr(String name, String value) {
		return addAttrs(new XmlElement(name, value));
	}

	public XmlDocument addAttrs(XmlElement... attrs) {
		if (attrs == null) {
			return this;
		}
		if (this.attrs == null) {
			this.attrs = new ArrayList<XmlElement>();
		}
		for (XmlElement attr : attrs) {
			this.attrs.add(attr);
		}
		return this;
	}

	public boolean hasAttr() {
		return this.attrs != null && this.attrs.size() > 0;
	}

	public boolean hasChild() {
		return this.childs != null && this.childs.size() > 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(getName());
		if (hasAttr()) {
			for (XmlElement attr : this.attrs) {
				sb.append(" ").append(attr.toString());
			}
		}
		sb.append(">");
		if (hasChild()) {
			for (XmlDocument re : this.childs) {
				sb.append(re.toString());
			}
		} else if (getValue() != null) {
			sb.append(getValue());
		}
		sb.append("</").append(getName()).append(">");
		return sb.toString();
	}
}
