package com.globallogic.mqtt.poc.dao;

import com.globallogic.mqtt.poc.beans.Group;

public interface GroupDao {
	public boolean saveGroup(Group group) throws Exception;
}
