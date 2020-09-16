package com.yumu.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.yumu.controller.Response;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;

@ControllerAdvice
@RestController
public class ServiceExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@ExceptionHandler({ Exception.class, ServiceException.class })
	public Response<Void> handleException(Exception exception) {
		logger.error(exception.toString(), exception);
		if (exception instanceof ServiceException) {
			ExceptionConst exceptionConst = ((ServiceException) exception).getCodeMsg();
			if (exceptionConst != null) {
				return Response.error(exceptionConst);
			} else {
				return Response.error(ExceptionConst.SYS_ERROR);
			}
		} else {
			return Response.error(ExceptionConst.SYS_ERROR);
		}
	}
}
