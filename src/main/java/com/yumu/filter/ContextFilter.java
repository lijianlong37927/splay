package com.yumu.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.yumu.context.LocalContext;
import com.yumu.context.request.SessionRequestContext;
import com.yumu.init.LocalConfig;
import com.yumu.context.request.RedisRequestContext;
import com.yumu.context.request.RequestContext;

@Order(0)
@WebFilter(filterName = "contextFilter", urlPatterns = { "/*" })
@Component
public class ContextFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		if (LocalConfig.isStoreTypeMemory()) {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			RequestContext requestContext = new SessionRequestContext(request, response);
			LocalContext.setRequestContext(requestContext);
		} else {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			RequestContext requestContext = new RedisRequestContext(request, response);
			LocalContext.setRequestContext(requestContext);
		}
		chain.doFilter(servletRequest, servletResponse);
	}

}
