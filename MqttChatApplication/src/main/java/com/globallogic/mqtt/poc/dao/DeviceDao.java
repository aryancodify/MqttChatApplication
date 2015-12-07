package com.globallogic.mqtt.poc.dao;

import com.globallogic.mqtt.poc.beans.Device;


public interface DeviceDao {
	public boolean saveDevice(Device device);
	public String getDeviceByUserId(String userId);
	public boolean deleteDevice(Device device);
	
}
