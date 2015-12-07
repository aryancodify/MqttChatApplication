package com.globallogic.mqtt.poc.beans;

public class GroupOperationsResource {
	private String topicId;
	private String userID;
	private String action;
	public GroupOperationsResource(String topicId, String userID, String action) {
		super();
		this.topicId = topicId;
		this.userID = userID;
		this.action = action;
	}
	public GroupOperationsResource() {
		super();
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	
}
