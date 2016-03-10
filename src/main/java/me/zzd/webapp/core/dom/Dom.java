package me.zzd.webapp.core.dom;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.jfinal.log.Log;

import me.zzd.webapp.core.annotation.BindDom;
import me.zzd.webapp.core.annotation.BindDomField;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Dom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = Log.getLog(Dom.class);

	/**
	 * 讲domStr转化为本对象 (T extends Dom) new T().parse(domStr)
	 * 
	 * @param domStr
	 */
	public void parse(Element root) {
		String name = root.getName();
		Class thiscls = getClass();
		BindDom bindDom = (BindDom) thiscls.getAnnotation(BindDom.class);
		if ((bindDom != null && name.equals(bindDom.value()))
				|| (bindDom == null && name.equals(thiscls.getSimpleName()))) {
			Field[] fields = thiscls.getDeclaredFields();
			for (Field field : fields) {
				if (isDomField(field.getModifiers())) {
					String fieldName = null;
					BindDomField bindDomField = field.getAnnotation(BindDomField.class);
					if (bindDomField == null) {
						fieldName = captureName(field.getName());
					} else {
						fieldName = bindDomField.value();
					}
					Class fieldClass = field.getType();
					if (fieldClass.isArray()) {
						List<Element> els = root.elements(fieldName);
						if (els != null && els.size() > 0) {
							Class generic = fieldClass.getComponentType();
							Object array = Array.newInstance(generic, els.size());
							if (Dom.class.isAssignableFrom(generic)) {
								for (int i = 0; i < els.size(); i++) {
									try {
										Dom dom = (Dom) generic.newInstance();
										dom.parse(els.get(i));
										Array.set(array, i, dom);
									} catch (Exception e) {
										log.error("dom转换出错", e);
									}
								}
							} else if (Enum.class.isAssignableFrom(generic)) {
								for (int i = 0; i < els.size(); i++) {
									Array.set(array, i, getEnumValue(generic, els.get(i).getStringValue()));
								}
							} else {
								for (int i = 0; i < els.size(); i++) {
									Array.set(array, i, transformation(generic.getName(), els.get(i).getStringValue()));
								}
							}
							field.setAccessible(true);
							try {
								field.set(this, array);
							} catch (Exception e) {
								log.error("field.set出错", e);
							}
						}
					} else {
						if (List.class.isAssignableFrom(fieldClass)) {
							List<Element> els = root.elements(fieldName);
							if (els != null && els.size() > 0) {
								Type type = field.getGenericType();
								if (type instanceof ParameterizedType) {
									ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
									Type[] types = parameterizedType.getActualTypeArguments();
									if (types.length > 0) {
										try {
											Class c = Class.forName(types[0].getTypeName());
											List list = new ArrayList<>();
											if (Dom.class.isAssignableFrom(c)) {
												for (Element el : els) {
													try {
														Dom dom = (Dom) c.newInstance();
														dom.parse(el);
														list.add(dom);
													} catch (Exception e) {
														log.error("dom转换出错", e);
													}
												}
											} else if (Enum.class.isAssignableFrom(c)) {
												for (Element el : els) {
													list.add(getEnumValue(c, el.getStringValue()));
												}
											} else {
												for (Element el : els) {
													list.add(transformation(c.getName(), el.getStringValue()));
												}
											}
											field.setAccessible(true);
											try {
												field.set(this, list);
											} catch (Exception e) {
												log.error("field.set出错", e);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}

							}
						} else if (Dom.class.isAssignableFrom(fieldClass)) {
							Element element = root.element(fieldName);
							if (element != null) {
								try {
									field.setAccessible(true);
									Dom dom = (Dom) fieldClass.newInstance();
									dom.parse(element);
									field.set(this, dom);
								} catch (Exception e) {
									log.error("dom转换出错", e);
								}
							}
						} else {
							Element element = root.element(fieldName);
							if (element != null) {
								field.setAccessible(true);
								// 如果是枚举类
								if (Enum.class.isAssignableFrom(fieldClass)) {
									try {
										field.set(this, getEnumValue(fieldClass, element.getStringValue()));
									} catch (Exception e) {
										log.error("field.set出错", e);
									}
								} else {
									try {
										field.set(this, transformation(fieldClass.getName(), element.getStringValue()));
									} catch (Exception e) {
										log.error("field.set出错", e);
									}
								}
							}
						}
					}
				}
			}
		} else {
			log.error("domStr与转换的实体类不符");
		}
	}

	public void parse(String domStr) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(domStr);
		} catch (DocumentException e) {
			log.error("domStr格式错误！", e);
			return;
		}
		Element root = document.getRootElement();
		parse(root);
	}

	public XmlDocument toDocument() {
		String name = null;
		Class cls = getClass();
		BindDom bindDom = (BindDom) cls.getAnnotation(BindDom.class);
		if (bindDom == null) {
			name = cls.getSimpleName();
		} else {
			name = bindDom.value();
		}
		XmlDocument document = new XmlDocument(name);
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			if (isDomField(field.getModifiers())) {
				try {
					setFieldValue(document, field);
				} catch (Exception e) {
					log.error("field值转换xmldocument出错", e);
				}
			}
		}
		return document;
	};

	/**
	 * 只转换用单单用private public protected修饰的变量
	 * 
	 * @param mod
	 * @return
	 */
	private static boolean isDomField(int mod) {
		return (mod & Modifier.ABSTRACT) == 0 && (mod & Modifier.STATIC) == 0 && (mod & Modifier.FINAL) == 0
				&& (mod & Modifier.TRANSIENT) == 0 && (mod & Modifier.VOLATILE) == 0
				&& (mod & Modifier.SYNCHRONIZED) == 0 && (mod & Modifier.NATIVE) == 0 && (mod & Modifier.STRICT) == 0
				&& (mod & Modifier.INTERFACE) == 0;
	}

	private void setFieldValue(XmlDocument document, Field field) throws Exception {
		field.setAccessible(true);
		Object value = field.get(this);
		if (value == null) {
			return;
		}
		String fieldName = null;
		BindDomField bindDomField = field.getAnnotation(BindDomField.class);
		if (bindDomField == null) {
			fieldName = captureName(field.getName());
		} else {
			fieldName = bindDomField.value();
		}
		Class fieldClass = field.getType();
		if (fieldClass.isArray()) {
			Class generic = fieldClass.getComponentType();
			if (Dom.class.isAssignableFrom(generic)) {
				int len = Array.getLength(value);
				for (int i = 0; i < len; i++) {
					document.addChild(((Dom) Array.get(value, i)).toDocument());
				}
			} else {
				int len = Array.getLength(value);
				for (int i = 0; i < len; i++) {
					document.addChild(fieldName, Array.get(value, i).toString());
				}
			}
		} else {
			if (List.class.isAssignableFrom(fieldClass)) {
				List list = (List) value;
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
					ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
					Type[] types = parameterizedType.getActualTypeArguments();
					if (types.length > 0) {
						Class c = Class.forName(types[0].getTypeName());
						if (Dom.class.isAssignableFrom(c)) {
							for (int i = 0; i < list.size(); i++) {
								document.addChild(((Dom) list.get(i)).toDocument());
							}
						} else {
							for (int i = 0; i < list.size(); i++) {
								document.addChild(fieldName, list.get(i).toString());
							}
						}
					} else {
						for (int i = 0; i < list.size(); i++) {
							document.addChild(fieldName, list.get(i).toString());
						}
					}
				} else {
					for (int i = 0; i < list.size(); i++) {
						document.addChild(fieldName, list.get(i).toString());
					}
				}
			} else {
				if (Dom.class.isAssignableFrom(fieldClass)) {
					document.addChild(((Dom) value).toDocument());
				} else {
					document.addChild(fieldName, value.toString());
				}
			}
		}
	}

	/**
	 * 首字母大写
	 * 
	 * @param name
	 * @return
	 */
	private static String captureName(String name) {
		char[] cs = name.toCharArray();
		char h = cs[0];
		if (h >= 'a' && h <= 'z') {
			cs[0] -= 32;
			return String.valueOf(cs);
		}
		return name;
	}

	/**
	 * 首字母小写
	 * 
	 * @param name
	 * @return
	 */
	private static String captureNameLow(String name) {
		char[] cs = name.toCharArray();
		char h = cs[0];
		if (h <= 'Z' && h >= 'A') {
			cs[0] += 32;
			return String.valueOf(cs);
		}
		return name;
	}

	private <E extends Enum<E>> E getEnumValue(Class<E> fieldClass, String vStr) {
		if (vStr == null || vStr.length() == 0) {
			return null;
		}
		try {
			return Enum.valueOf(fieldClass, vStr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * String的值转换为对应的基本类型的包装类
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	private Object transformation(String type, String value) {
		try {
			if ("String".equals(type)) {
				return value;
			} else if ("java.lang.Integer".equals(type) || "int".equals(type)) {
				return Integer.parseInt(value);
			} else if ("java.lang.Boolean".equals(type) || "boolean".equals(type)) {
				return Boolean.parseBoolean(value);
			} else if ("java.lang.Long".equals(type) || "long".equals(type)) {
				return Long.parseLong(value);
			} else if ("java.lang.Double".equals(type) || "double".equals(type)) {
				return Double.parseDouble(value);
			} else if ("java.lang.Float".equals(type) || "float".equals(type)) {
				return Float.parseFloat(value);
			} else if ("java.lang.Character".equals(type) || "char".equals(type)) {
				return value.charAt(0);
			} else if ("java.math.BigDecimal".equals(type)) {
				return new BigDecimal(value);
			} else if ("java.lang.Short".equals(type) || "short".equals(type)) {
				return Short.parseShort(value);
			} else if ("java.lang.Byte".equals(type) || "byte".equals(type)) {
				return Byte.parseByte(value);
			} else {
				return value;
			}
		} catch (Exception e) {
			log.error("transformation类型转换出错！", e);
			return null;
		}
	}

	public static Map<String, Object> xml2Map(String xmlStr) {
		try {
			Document document = DocumentHelper.parseText(xmlStr);
			return xml2Map(document.getRootElement());
		} catch (DocumentException e) {
			log.error("xmlStr不是合法的xml格式", e);
		}
		return null;
	}

	public static Map<String, Object> xml2Map(Element element) {
		Map<String, Object> map = new HashMap<>();
		List<Element> es = element.elements();
		List<String> list = null;
		for (Element e : es) {
			String key = captureNameLow(e.getName());
			Object o = map.get(key);
			if (e.isTextOnly()) {
				if (o != null) {
					if (list == null) {
						list = new ArrayList<>();
					}
					if (list.contains(key)) {
						((List) o).add(e.getStringValue());
					} else {
						list.add(key);
						List<Object> el = new ArrayList<>();
						el.add(o);
						el.add(e.getStringValue());
						map.put(key, el);
					}
				} else {
					map.put(key, e.getStringValue());
				}
			} else {
				if (o != null) {
					if (list == null) {
						list = new ArrayList<>();
					}
					if (list.contains(key)) {
						((List) o).add(xml2Map(e));
					} else {
						list.add(key);
						List<Object> el = new ArrayList<>();
						el.add(o);
						el.add(xml2Map(e));
						map.put(key, el);
					}
				} else {
					map.put(key, xml2Map(e));
				}
			}
		}
		if (list != null && list.size() > 0) {
			list.clear();
		}
		list = null;
		return map;
	}

}
