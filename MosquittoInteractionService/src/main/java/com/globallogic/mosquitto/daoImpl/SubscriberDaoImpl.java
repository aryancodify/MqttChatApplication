package com.globallogic.mosquitto.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.mosquitto.beans.SubscriberStore;
import com.globallogic.mosquitto.cassandra.repository.SubscriberRepository;
import com.globallogic.mosquitto.dao.SubscriberDao;

@Repository
public class SubscriberDaoImpl implements SubscriberDao{

	@Autowired
	SubscriberRepository subscriberRepository;
	
	public boolean saveSubscriber(SubscriberStore subscriberStore) {
		try{
		subscriberRepository.save(subscriberStore);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public SubscriberStore getSubscribersByTopicId(String topicId) {
		return subscriberRepository.getSubscribersByTopicId(topicId);
	}

}
