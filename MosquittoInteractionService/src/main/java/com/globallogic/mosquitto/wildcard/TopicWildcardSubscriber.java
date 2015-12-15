package com.globallogic.mosquitto.wildcard;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.mosquitto.beans.SubscribeTopicMessagePayload;
import com.globallogic.mosquitto.service.SubscriberService;
import com.google.gson.Gson;

@Service
public class TopicWildcardSubscriber implements MqttCallback{
	
	@Autowired
	SubscriberService subscriberService;

	private static final Gson gson = new Gson();
	private MqttClient client;
	public TopicWildcardSubscriber(){
		
	}
	
	public void connectionLost(Throwable cause) {
		
	}

	public void messageArrived(String topic, MqttMessage message){
		SubscribeTopicMessagePayload messagePayload = null;
		try{
			messagePayload = gson.fromJson(String.valueOf(message), SubscribeTopicMessagePayload.class);
			subscriberService.saveSubscriber(messagePayload);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	@PostConstruct
	public void initiateWildcardTopicSubscriber(){
		try {
			client = new MqttClient("tcp://172.16.35.218:1883", "subscribeTopic");
			client.connect();
			client.setCallback(this);
			client.subscribe("subscribeTopic");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
