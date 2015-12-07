package com.globallogic.mqtt.poc.exceptions;

public class DeviceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3582776440758251545L;
	private String userId;
	public DeviceNotFoundException(String userId) {
		this.userId = userId;
	}
	public DeviceNotFoundException() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
