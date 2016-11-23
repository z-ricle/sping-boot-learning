package org.ziyang.spring.pojo;

import org.springframework.http.HttpStatus;

public class JsonResult<T> extends ResponseResult {

	private T data;

	public JsonResult(T data) {
		super();
		this.setStatus(HttpStatus.OK.value());
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
