package com.yumu.context.request;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yumu.tool.EncryptTool;
import com.yumu.tool.RedisTool;

public class RedisRequestContext implements RequestContext {

	private static final Logger logger = LoggerFactory.getLogger(RedisRequestContext.class);

	private static final String TOKEN = "token";

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private String token = null;

	public RedisRequestContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		token = request.getHeader(TOKEN);
	}

	@Override
	public String getUserId() {
		return RedisTool.get(token);
	}

	@Override
	public void setUserId(String userId) {
		try {
			if (token == null) {
				token = EncryptTool.sha1Hex(UUID.randomUUID().toString());
			}
			RedisTool.setIfAbsent(token, userId, 60 * 15);
			Cookie cookie = new Cookie(TOKEN, token);
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("setUserId error", e);
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}
