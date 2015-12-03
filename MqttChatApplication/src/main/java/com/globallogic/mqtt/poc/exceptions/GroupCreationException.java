package com.globallogic.mqtt.poc.exceptions;

public class GroupCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099319807590600902L;
	private String groupName;
	/**
	 * @param groupName
	 */
	public GroupCreationException(String groupName) {
		super();
		this.groupName = groupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
