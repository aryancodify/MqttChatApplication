package com.globallogic.mqtt.poc.service;

import com.globallogic.mqtt.poc.beans.Device;
import com.globallogic.mqtt.poc.response.DeviceRegistrationResponse;

public interface DeviceService {

	public DeviceRegistrationResponse saveDevice(Device device);
	public DeviceRegistrationResponse deleteDevice(Device device);
}
