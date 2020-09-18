package com.yumu.context.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedisRequestContext implements RequestContext {

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private HttpSession session = null;

	private static final String USER_ID = "USER_ID";

	public RedisRequestContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	@Override
	public String getUserId() {
		if (session == null || session.getAttribute(USER_ID) == null) {
			return null;
		}
		return (String) session.getAttribute(USER_ID);
	}

	@Override
	public void setUserId(String userId) {
		if (session == null) {
			session = request.getSession(true);
			session.setMaxInactiveInterval(60 * 15);
		}
		session.setAttribute(USER_ID, userId);

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpSession getSession() {
		return session;
	}

}
