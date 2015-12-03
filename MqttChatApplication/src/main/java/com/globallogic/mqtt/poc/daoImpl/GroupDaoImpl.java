package com.globallogic.mqtt.poc.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.mqtt.poc.beans.Group;
import com.globallogic.mqtt.poc.cassandra.repository.GroupRepository;
import com.globallogic.mqtt.poc.dao.GroupDao;

@Repository
public class GroupDaoImpl implements GroupDao{

	@Autowired
	GroupRepository groupRepository;
	
	@Override
	public boolean saveGroup(Group group) throws Exception {
		Group tempGroup = groupRepository.save(group);
		return (tempGroup!=null)?true:false;

	}

	
}
