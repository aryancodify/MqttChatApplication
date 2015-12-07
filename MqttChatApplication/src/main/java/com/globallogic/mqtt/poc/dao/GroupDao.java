package com.globallogic.mqtt.poc.dao;

import com.globallogic.mqtt.poc.beans.Group;

public interface GroupDao {
	public boolean saveGroup(Group group);

	public boolean addMember(Group group);

	public boolean removeMember(Group group);
	
	public Group getGroupBytopicId(String topicId);
}
