package com.globallogic.mosquitto.service;

import com.globallogic.mosquitto.beans.SubscribeTopicMessagePayload;

public interface SubscriberService {
	public boolean saveSubscriber(SubscribeTopicMessagePayload messagePayload);
}
