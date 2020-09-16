package com.yumu.controller;

import com.yumu.exception.ExceptionConst;

public class Response<T> extends BaseResponse {
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String msg;
	private T data;

	public Response(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static Response<Void> success() {
		return new Response<Void>(0, null, null);
	}

	public static Response<Void> error() {
		return new Response<Void>(9999, null, null);
	}

	public static Response<Void> error(Integer code, String msg) {
		return new Response<Void>(code, msg, null);
	}

	public static Response<Void> error(ExceptionConst codeMsg) {
		return new Response<Void>(codeMsg.getCode(), codeMsg.getMsg(), null);
	}

	public static <T> Response<T> success(T data) {
		return new Response<T>(0, null, data);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
