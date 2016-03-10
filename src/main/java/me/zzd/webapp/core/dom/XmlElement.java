package me.zzd.webapp.core.dom;

public class XmlElement {
	public String name;
	public String value;

	public XmlElement(String name) {
		this(name, null);
	}

	public XmlElement(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return name + "=\"" + value + "\"";
	}
}
