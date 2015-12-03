package com.globallogic.mqtt.poc.payload;

public class GroupCreationPayload extends Payload {

	private String topicId;
	public GroupCreationPayload(String message,String topicId) {
		super(message);
		this.setTopicId(topicId);
		// TODO Auto-generated constructor stub
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

}
