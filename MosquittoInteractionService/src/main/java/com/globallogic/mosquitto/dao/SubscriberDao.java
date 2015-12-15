package com.globallogic.mosquitto.dao;

import com.globallogic.mosquitto.beans.SubscriberStore;

public interface SubscriberDao {
	public boolean saveSubscriber(SubscriberStore subscriberStore);
	public SubscriberStore getSubscribersByTopicId(String topicId);
}
