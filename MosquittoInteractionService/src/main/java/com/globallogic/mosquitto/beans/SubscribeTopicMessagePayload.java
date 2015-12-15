package com.globallogic.mosquitto.beans;

public class SubscribeTopicMessagePayload {
	
	private String userId;
	private String topic;
	private int status;
	/**
	 * @param userId
	 * @param message
	 * @param status
	 */
	public SubscribeTopicMessagePayload(String userId, String topic,
			int status) {
		this.userId = userId;
		this.topic = topic;
		this.status = status;
	}
	/**
	 * 
	 */
	public SubscribeTopicMessagePayload() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTopic() {
		return topic;
	}
	public void setMessage(String topic) {
		this.topic = topic;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
