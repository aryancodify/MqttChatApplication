package com.globallogic.mqtt.poc.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.globallogic.mqtt.poc.beans.Group;
import com.globallogic.mqtt.poc.dao.DeviceDao;
import com.globallogic.mqtt.poc.dao.GroupDao;
import com.globallogic.mqtt.poc.exceptions.GroupCreationException;
import com.globallogic.mqtt.poc.payload.GroupCreationPayload;
import com.globallogic.mqtt.poc.response.Error;
import com.globallogic.mqtt.poc.response.GroupCreationResponse;
import com.globallogic.mqtt.poc.service.GroupService;
import com.globallogic.mqtt.poc.utility.PushNotifications;

@PropertySource("classpath:PayloadMessages.properties")
@PropertySource("classpath:ErrorMessages.properties")
@PropertySource("classpath:PushNotifications.properties")
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	Environment env;

	@Autowired
	GroupDao groupDao;

	@Autowired
	DeviceDao deviceDao;

	@Override
	public GroupCreationResponse saveGroup(Group group) {
		Set<String> deviceTokens = new HashSet<String>(0);
		GroupCreationResponse groupCreationResponse;
		group.setTopicId(group.getGroupOwner() + group.getGroupName());
		boolean success = false;
		for (String tempUserId : group.getMembers()) {
			deviceTokens.add(deviceDao.getDeviceByUserId(tempUserId));
		}
		String message = env.getProperty("pns.message").replace(":groupName", group.getGroupName());
		message = message.replace(":groupOwner", group.getGroupOwner());
		PushNotifications.getPushNotificationInstance().pushNotification(deviceTokens, message,group.getTopicId());
		try {
			success = groupDao.saveGroup(group);
		} catch (Exception ex) {
			throw new GroupCreationException(group.getGroupName());
		}
		if (success) {
			groupCreationResponse = new GroupCreationResponse(
					new GroupCreationPayload(env.getProperty("group.creation.success"),
							group.getTopicId()), null, false);
		} else {
			groupCreationResponse = new GroupCreationResponse(null, new Error(
					"GRO1555", env.getProperty("GRO1555")), true);
		}
		return groupCreationResponse;
	}

}
