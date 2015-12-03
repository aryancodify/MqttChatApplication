package com.globallogic.mqtt.poc.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.mqtt.poc.beans.Group;

@Repository
public interface GroupRepository extends CassandraRepository<Group>{
	
	
	@Query("select * from groups")
	public List<Group> getGroups();

}
