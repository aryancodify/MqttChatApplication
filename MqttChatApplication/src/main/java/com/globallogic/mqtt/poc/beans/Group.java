package com.globallogic.mqtt.poc.beans;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="groups")
public class Group {

	@PrimaryKeyColumn(name="topicId",type=PrimaryKeyType.PARTITIONED,ordinal=0)
	private String topicId;
	@NotNull(message="")
	@Size(min=1,message="")
	@Column
	private String groupName;
	@NotNull(message="")
	@Column
	private Set<String> members = new HashSet<String>();
	@NotNull
	@Size(min=1,message="")
	@Column
	private String groupOwner;
	@Transient
	private boolean status;
	public Group(){
		
	}
	Group(String topicId, String groupName, Set<String> members,
			String groupOwner) {
		super();
		this.topicId = topicId;
		this.groupName = groupName;
		this.members = members;
		this.groupOwner = groupOwner;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<String> getMembers() {
		return members;
	}
	public void setMembers(Set<String> members) {
		this.members = members;
	}
	public String getGroupOwner() {
		return groupOwner;
	}
	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.groupName+"  "+this.members.toString();
	}
	
	
	
}
