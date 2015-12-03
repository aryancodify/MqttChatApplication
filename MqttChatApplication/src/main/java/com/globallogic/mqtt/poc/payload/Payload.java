package com.globallogic.mqtt.poc.payload;

public class Payload {
	private String message;

	/**
	 * @param message
	 */
	public Payload(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
