package com.globallogic.mosquitto.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.mosquitto.beans.SubscribeTopicMessagePayload;
import com.globallogic.mosquitto.beans.SubscriberStore;
import com.globallogic.mosquitto.dao.SubscriberDao;
import com.globallogic.mosquitto.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService{

	@Autowired
	SubscriberDao subscriberDao;
	
	public boolean saveSubscriber(SubscribeTopicMessagePayload messagePayload){
		SubscriberStore subscriberStore = null;
		Set<String> subscribers = new HashSet<String>(0);
		try{
			 subscriberStore = subscriberDao.getSubscribersByTopicId(messagePayload.getTopic());
			 Set<String> tempSubscribers = subscriberStore.getSubscribers();
			if (!tempSubscribers.contains(messagePayload.getUserId())) {
				if (messagePayload.getStatus() == 1) {
					subscribers.addAll(tempSubscribers);
					subscribers.add(messagePayload.getUserId());
				}
			}else{
				if (messagePayload.getStatus() == 0) {
					subscribers.addAll(tempSubscribers);
					subscribers.remove(messagePayload.getUserId());
				}
			}
			subscriberStore = new SubscriberStore(messagePayload.getTopic(), (Set<String>)subscribers);
			subscriberDao.saveSubscriber(subscriberStore);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
}
