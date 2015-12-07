package com.globallogic.mqtt.poc.exceptions;

public class GroupNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -410800459864215582L;

	private String topicid;

	public GroupNotFoundException(String topicid) {
		super();
		this.topicid = topicid;
	}

	public GroupNotFoundException() {
		super();
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}
	
}
