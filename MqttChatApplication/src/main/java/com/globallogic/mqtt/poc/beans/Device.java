package com.globallogic.mqtt.poc.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author aryan.singh 
 *	Template for Device Registration store
 */
@Table(value="DeviceRegistrationStore")
public class Device {
	
	@NotNull(message="{device.token.empty}")
	@Size(max=64,min=64,message="{device.token.size}")
	@PrimaryKeyColumn(name="deviceToken",type=PrimaryKeyType.PARTITIONED, ordinal = 0)
	private String deviceToken;
	
	@NotNull(message="{device.userid.empty}")
	@Size(min=1,message="{device.userid.empty}")
	@PrimaryKeyColumn(name="userID",type=PrimaryKeyType.CLUSTERED, ordinal = 1, ordering = Ordering.ASCENDING)
	private String userID;
	
	public Device(){
		
	}
	public Device(String deviceToken, String userID) {
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
