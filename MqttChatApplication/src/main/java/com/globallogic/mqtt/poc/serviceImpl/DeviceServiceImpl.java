package com.globallogic.mqtt.poc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.globallogic.mqtt.poc.beans.Device;
import com.globallogic.mqtt.poc.dao.DeviceDao;
import com.globallogic.mqtt.poc.payload.Payload;
import com.globallogic.mqtt.poc.response.DeviceRegistrationResponse;
import com.globallogic.mqtt.poc.response.Error;
import com.globallogic.mqtt.poc.service.DeviceService;

@PropertySource("classpath:PayloadMessages.properties")
@PropertySource("classpath:ErrorMessages.properties")
@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private Environment env;

	@Override
	public DeviceRegistrationResponse saveDevice(Device device){
		String deviceToken = device.getDeviceToken();
		String userID = device.getUserID();
		boolean success = false;
		DeviceRegistrationResponse deviceRegistrationResponse = null;
		success = deviceDao.saveDevice(new Device(deviceToken, userID));
		if (success) {
			deviceRegistrationResponse = new DeviceRegistrationResponse(
					new Payload(env.getProperty("device.registration.success")),
					null, false);
		} else {
			deviceRegistrationResponse = new DeviceRegistrationResponse(null,
					new Error("DEV1463",env.getProperty("DEV1463")), true);
		}
		return deviceRegistrationResponse;
	}

}
