package com.globallogic.mqtt.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.mqtt.poc.beans.Group;
import com.globallogic.mqtt.poc.beans.GroupOperationsResource;
import com.globallogic.mqtt.poc.response.GroupCreationResponse;
import com.globallogic.mqtt.poc.service.GroupService;

/**
 * 
 * @author aryan.singh Device Controller to intercept REST calls
 */
@RestController
@RequestMapping("/rest/v1/group")
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	private Environment env;
	
	/**
	 * 
	 * @param group
	 * @return Group
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/create", headers = {
			"Content-Type=application/json", "Accept=application/json" })
	public GroupCreationResponse createGroup(@Validated @RequestBody final Group group) {
		return groupService.saveGroup(group);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/update", headers = {
			"Content-Type=application/json", "Accept=application/json" })
	public GroupCreationResponse updateGroup(@Validated @RequestBody final GroupOperationsResource groupOperationsResource){
		return groupService.updateGroup(groupOperationsResource);
		
	}
}
