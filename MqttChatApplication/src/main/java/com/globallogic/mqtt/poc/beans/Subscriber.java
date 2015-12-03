package com.globallogic.mqtt.poc.beans;
/**
 * 
 * @author aryan.singh
 *
 */
public class Subscriber {
	private String userId;
	private String deviceToken;
	Subscriber(String userId, String deviceToken) {
		super();
		this.userId = userId;
		this.deviceToken = deviceToken;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	
}
