package com.globallogic.mqtt.poc.exceptions;


public class DeviceRegistrationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3595686909914806428L;
	
	private String deviceToken;
	private String userID;
	/**
	 * @param deviceToken
	 * @param userID
	 */
	public DeviceRegistrationException(String deviceToken, String userID) {
		super();
		this.deviceToken = deviceToken;
		this.userID = userID;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

}
