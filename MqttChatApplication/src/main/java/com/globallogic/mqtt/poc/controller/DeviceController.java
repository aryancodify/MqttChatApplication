package com.globallogic.mqtt.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.mqtt.poc.beans.Device;
import com.globallogic.mqtt.poc.response.DeviceRegistrationResponse;
import com.globallogic.mqtt.poc.service.DeviceService;

/**
 * 
 * @author aryan.singh Device Controller to intercept REST calls
 */
@RestController
@RequestMapping("/rest/v1/device")
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	/**
	 * 
	 * @param deviceToken
	 * @param userID
	 * @return boolean
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST, headers = {
			"Content-Type=application/json", "Accept=application/json" })
	public DeviceRegistrationResponse registerDevice(
			@Validated @RequestBody final Device device) {
		return deviceService.saveDevice(device);
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.DELETE, headers = {"Content-Type=application/json", "Accept=application/json"})
	public DeviceRegistrationResponse removeDevice(@Validated @RequestBody final Device device){
		return deviceService.deleteDevice(device);
	}
}
