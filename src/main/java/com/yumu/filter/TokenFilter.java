package com.yumu.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.yumu.context.LocalContext;
import com.yumu.exception.ExceptionConst;
import com.yumu.init.LocalConfig;
import com.yumu.service.MenuUrlService;

@Order(1)
@WebFilter(filterName = "tokenFilter", urlPatterns = { "/*" })
@Component
public class TokenFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
	/** 需要过滤地址*/
	private static final Set<String> ALLOWED_PATHS = new HashSet<String>();
	/** 静态资源*/
	private static final Set<String> STATIC_PATHS = new HashSet<String>();
	/** 登录后通用地址*/
	private static final Set<String> COMMOND_PATHS = new HashSet<String>();

	@Autowired
	private MenuUrlService menuUrlService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 过滤地址
		ALLOWED_PATHS.add("/");
		ALLOWED_PATHS.add("/login");
		ALLOWED_PATHS.add("/errorMsg");
		// 静态资源
		STATIC_PATHS.add("/js/");
		STATIC_PATHS.add("/images/");
		// 登录后通用地址
		COMMOND_PATHS.add("/home");
		COMMOND_PATHS.add("/menuList");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String path = request.getRequestURI();

		if (ALLOWED_PATHS.contains(path) || checkStaticFile(path)) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			logger.info("address:[{}],path:[{}]", request.getRemoteAddr(), path);
			String userId = LocalContext.getRequestContext().getUserId();
			if (StringUtils.isBlank(userId)) {
				response.sendRedirect(request.getContextPath());
			} else if (LocalConfig.isCheckPath() && checkPath(userId, path)) {
				chain.doFilter(servletRequest, servletResponse);
			} else {
				request.setAttribute("ERROR_MSG_CONST", ExceptionConst.NO_AUTH);
				// response.sendRedirect(request.getContextPath() + "/errorMsg");
				request.getRequestDispatcher("/errorMsg").forward(request, response);
			}
		}
	}

	private boolean checkStaticFile(String path) {
		for (String str : STATIC_PATHS) {
			if (StringUtils.isNotBlank(path) && path.startsWith(str)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkPath(String userId, String path) {
		if (COMMOND_PATHS.contains(path)) {
			return true;
		}
		if (CollectionUtils.isEmpty(menuUrlService.qryAuthUrl(userId, path))) {
			return false;
		}
		return true;
	}

}
