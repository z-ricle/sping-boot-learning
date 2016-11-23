package org.ziyang.spring.exc;

public class JsonException extends BizException {
	private static final long serialVersionUID = 1L;

	public JsonException(int status, String message) {
		super(status, message);
	}

	public JsonException(int status) {
		super(status);
	}

}
