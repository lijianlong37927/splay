package com.yumu.controller;

import java.io.Serializable;

import org.slf4j.MDC;

public class BaseResponse implements Serializable {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	Integer code;
	String traceId;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTraceId() {
		return MDC.get("X-B3-TraceId");
	}

}
