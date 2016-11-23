package org.ziyang.spring.exc;

import java.util.UUID;

public class BizException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * 建议成功200，失败500
	 */
	private int status;
	/**
	 * 返回信息
	 */
	private String message;
	/**
	 * 建议UUID，日志定位
	 */
	private String tracerId;
	/**
	 * 时间戳
	 */
	private long timestamp;
 
	public BizException(int status) {
		super();
		this.status = status;
	}

	public BizException(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTracerId() {
		return null == tracerId ? UUID.randomUUID().toString() : tracerId;
	}

	public void setTracerId(String tracerId) {
		this.tracerId = tracerId;
	}
	
	public long getTimestamp() {
		return timestamp == 0L ? System.currentTimeMillis() : timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
