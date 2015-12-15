package com.globallogic.mosquitto.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.globallogic.mosquitto.beans.SubscriberStore;

@Repository
public interface SubscriberRepository extends CassandraRepository<SubscriberStore>{
	
	@Query("SELECT * FROM SubscriberStore")
	public List<SubscriberStore> getSubscribers();
	
	@Query("SELECT subscribers FROM SubscriberStore WHERE topicId = ?0 ALLOW FILTERING")
	public SubscriberStore getSubscribersByTopicId(String topicId);
}
