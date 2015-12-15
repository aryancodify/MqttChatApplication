package com.globallogic.mosquitto.beans;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "SubscriberStore")
public class SubscriberStore {
	
	@NotNull(message="{subscriberstore.topicid.empty}")
	@PrimaryKeyColumn(name="topicId",type=PrimaryKeyType.PARTITIONED,ordinal=0)
	private String topicId;
	@NotNull(message="{subscriberstore.subscribers.empty}")
	@Column
	private Set<String> subscribers;

	public SubscriberStore(String topicId, Set<String> subscribers) {
		this.topicId = topicId;
		this.subscribers = subscribers;
	}
	
	public SubscriberStore() {
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public Set<String> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<String> subscribers) {
		this.subscribers = subscribers;
	}
}
