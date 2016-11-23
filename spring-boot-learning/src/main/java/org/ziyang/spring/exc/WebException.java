package org.ziyang.spring.exc;

public class WebException extends BizException {
	private static final long serialVersionUID = 1L;

	public WebException(int status, String message) {
		super(status, message);
	}

	public WebException(int status) {
		super(status);
	}

}
