package com.yumu.context;

import com.yumu.context.request.RequestContext;

public class LocalContext {
	private static final ThreadLocal<RequestContext> threadLocal = new ThreadLocal<>();

	public static void setRequestContext(RequestContext context) {
		threadLocal.set(context);
	}

	public static RequestContext getRequestContext() {
		return threadLocal.get();
	}

}
