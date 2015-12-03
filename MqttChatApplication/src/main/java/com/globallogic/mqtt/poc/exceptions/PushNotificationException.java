package com.globallogic.mqtt.poc.exceptions;

import java.util.Set;

public class PushNotificationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402219670355149027L;
	private Set<String> deviceTokens;
	private String notificationMessage;
	
	/**
	 * @param deviceTokens
	 * @param message
	 */
	public PushNotificationException(Set<String> deviceTokens, String notificationMessage) {
		super();
		this.deviceTokens = deviceTokens;
		this.notificationMessage = notificationMessage;
	}
	public Set<String> getDeviceTokens() {
		return deviceTokens;
	}
	public void setDeviceTokens(Set<String> deviceTokens) {
		this.deviceTokens = deviceTokens;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	
}
