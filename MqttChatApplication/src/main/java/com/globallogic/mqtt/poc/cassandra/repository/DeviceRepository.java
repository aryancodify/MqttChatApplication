package com.globallogic.mqtt.poc.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.mqtt.poc.beans.Device;

@Repository
public interface DeviceRepository extends CassandraRepository<Device> {
	
	@Query("select * from DeviceRegistrationStore")
	public List<Device> getDevices();
	
	
	@Query("SELECT deviceToken FROM DeviceRegistrationStore  WHERE userID = ?0 ALLOW FILTERING")
	public String getDeviceTokenFromUserId(String userId);
	
}
 