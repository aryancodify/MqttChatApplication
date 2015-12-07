package com.globallogic.mqtt.poc.exceptions;

public class GroupUpdationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -552783941177157317L;
	
	private String topicId;
	private String userId;
	public GroupUpdationException(String topicId, String userId) {
		super();
		this.topicId = topicId;
		this.userId = userId;
	}
	public GroupUpdationException() {
		super();
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
