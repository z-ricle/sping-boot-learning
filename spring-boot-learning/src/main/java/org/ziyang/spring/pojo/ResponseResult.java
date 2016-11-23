package org.ziyang.spring.pojo;

import java.util.UUID;

public class ResponseResult { 
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
