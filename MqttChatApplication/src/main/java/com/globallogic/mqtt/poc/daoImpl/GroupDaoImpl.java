package com.globallogic.mqtt.poc.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.mqtt.poc.beans.Group;
import com.globallogic.mqtt.poc.cassandra.repository.GroupRepository;
import com.globallogic.mqtt.poc.dao.GroupDao;
import com.globallogic.mqtt.poc.exceptions.GroupCreationException;
import com.globallogic.mqtt.poc.exceptions.GroupNotFoundException;
import com.globallogic.mqtt.poc.exceptions.GroupUpdationException;

@Repository
public class GroupDaoImpl implements GroupDao{

	@Autowired
	GroupRepository groupRepository;
	
	@Override
	public boolean saveGroup(Group group){
		Group tempGroup = null;
		try{
			tempGroup = groupRepository.save(group);
		}
		catch(Exception ex){
			throw new GroupCreationException(group.getGroupName());
		}
		return (tempGroup!=null)?true:false;

	}

	@Override
	public boolean addMember(Group group) {
		try{
		groupRepository.save(group);
		}
		catch(Exception ex){
			throw new GroupUpdationException(group.getTopicId(), null);
		}
		return true;
	}

	@Override
	public boolean removeMember(Group group) {
		try{
			groupRepository.save(group);
			}
			catch(Exception ex){
				throw new GroupUpdationException(group.getTopicId(), null);
			}
			return true;
	}

	@Override
	public Group getGroupBytopicId(String topicId) {
		Group group = null;
		try{
			group = groupRepository.getGroupBytopicId(topicId);
		}
		catch(Exception ex){
			throw new GroupNotFoundException(topicId);
		}
		return group;
	}

	
}
