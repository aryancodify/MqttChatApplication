package com.globallogic.mqtt.poc.service;

import com.globallogic.mqtt.poc.beans.Group;
import com.globallogic.mqtt.poc.response.GroupCreationResponse;

public interface GroupService {
	public GroupCreationResponse saveGroup(Group group);
}
