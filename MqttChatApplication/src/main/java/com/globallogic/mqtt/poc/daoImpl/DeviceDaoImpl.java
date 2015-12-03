package com.globallogic.mqtt.poc.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.mqtt.poc.beans.Device;
import com.globallogic.mqtt.poc.cassandra.repository.DeviceRepository;
import com.globallogic.mqtt.poc.dao.DeviceDao;
import com.globallogic.mqtt.poc.exceptions.DeviceRegistrationException;
@Repository
public class DeviceDaoImpl implements DeviceDao{

	@Autowired
	DeviceRepository deviceRepository;


	public boolean saveDevice(Device device) {
		Device tempDevice;
		try{
		tempDevice=deviceRepository.save(device);
		}
		catch(Exception ex){
			throw new DeviceRegistrationException(device.getDeviceToken(), device.getUserID());
		}
		return (tempDevice!=null)?true:false;
	}


	public String getDeviceByUserId(String userId) {
		String deviceToken=deviceRepository.getDeviceTokenFromUserId(userId);
		return deviceToken;
	}
	
	

}
