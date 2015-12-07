package com.globallogic.mqtt.poc.exceptions;

public class DeviceDeletionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 799402294259178425L;

	private String deviceToken;

	/**
	 * @param deviceToken
	 */
	public DeviceDeletionException(String deviceToken) {
		super();
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
