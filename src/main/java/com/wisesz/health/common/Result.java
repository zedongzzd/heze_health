package com.wisesz.health.common;

import java.io.Serializable;

public class Result<O> implements Serializable {

	public static class RespFactory {
		public static final int isOK = 0;
		public static final int isFail = 1;

		public static <T> Result<T> newInstance(int code, String msg, T o) {
			Result<T> res = new Result<T>();
			res.resultCode = code;
			res.resultMsg = msg;
			res.obj = o;
			return res;
		}

		public static <T> Result<T> isOk() {
			return newInstance(isOK, null, null);
		}

		public static <T> Result<T> isOk(String msg) {
			return newInstance(isOK, msg, null);
		}

		public static <T> Result<T> isOk(String msg, T o) {
			return newInstance(isOK, msg, o);
		}

		public static <T> Result<T> isFail() {
			return newInstance(isFail, null, null);
		}

		public static <T> Result<T> isFail(String msg) {
			return newInstance(isFail, msg, null);
		}

		public static <T> Result<T> isFail(String msg, T o) {
			return newInstance(isFail, msg, o);
		}
	}

	private static final long serialVersionUID = 1L;
	private int resultCode;
	private String resultMsg;
	private O obj;

	private Result() {
		super();
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public O getObj() {
		return obj;
	}

	public void setObj(O obj) {
		this.obj = obj;
	}

}
