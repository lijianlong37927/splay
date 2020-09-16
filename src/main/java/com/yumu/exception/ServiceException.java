package com.yumu.exception;

public class ServiceException extends RuntimeException {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private ExceptionConst codeMsg;
	private Object[] msgArgs;

	public ServiceException(Throwable cause, ExceptionConst codeMsg, Object... msgArgs) {
		super(cause);
		this.codeMsg = codeMsg;
		this.msgArgs = msgArgs;
	}

	public ServiceException(Throwable cause, ExceptionConst codeMsg) {
		super(cause);
		this.codeMsg = codeMsg;
	}

	public ServiceException(ExceptionConst codeMsg, Object... msgArgs) {
		this.codeMsg = codeMsg;
		this.msgArgs = msgArgs;
	}

	public ServiceException(ExceptionConst codeMsg) {
		this.codeMsg = codeMsg;
	}

	public String getMessage() {
		if (this.codeMsg != null) {
			return String.format(this.codeMsg.getMsg(), this.msgArgs);
		}
		return "未知";
	}

	public Object[] getMsgArgs() {
		return msgArgs;
	}

	public ExceptionConst getCodeMsg() {
		return codeMsg;
	}

	public static void throwException(ExceptionConst codeMsg) {
		throw new ServiceException(codeMsg);
	}

	public static void throwException(ExceptionConst codeMsg, Object... msgArgs) {
		throw new ServiceException(codeMsg, msgArgs);
	}

	public static void throwException(Exception ex, ExceptionConst sysError, Object... msgArgs) {
		throw new ServiceException(ex, sysError, msgArgs);
	}
}
