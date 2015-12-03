package com.globallogic.mqtt.poc.utility;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globallogic.mqtt.poc.exceptions.DeviceRegistrationException;
import com.globallogic.mqtt.poc.exceptions.GroupCreationException;
import com.globallogic.mqtt.poc.exceptions.PushNotificationException;
import com.globallogic.mqtt.poc.response.BaseResponse;
import com.globallogic.mqtt.poc.response.DeviceRegistrationResponse;
import com.globallogic.mqtt.poc.response.Error;
import com.globallogic.mqtt.poc.response.GroupCreationResponse;

@PropertySource("classpath:ErrorMessages.properties")
@ControllerAdvice
public class ExceptionProcessor {
	
	Logger logger = LoggerFactory.getLogger(ExceptionProcessor.class);
	@Autowired
	Environment env;

	@ExceptionHandler(DeviceRegistrationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public DeviceRegistrationResponse deviceNotRegistered(
			HttpServletRequest req, DeviceRegistrationException ex) {
		DeviceRegistrationResponse deviceRegistrationResponse = new DeviceRegistrationResponse(
				null, new Error("DEV1463", env.getProperty("DEV1463")), true);
		logger.error(ex.getMessage(), ex);
		return deviceRegistrationResponse;
	}

	@ExceptionHandler(GroupCreationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GroupCreationResponse groupNotCreated(HttpServletRequest req,
			GroupCreationException ex) {
		GroupCreationResponse groupCreationResponse = new GroupCreationResponse(
				null, new Error("GRO1555", env.getProperty("GRO1555")), true);
		logger.error(ex.getMessage(), ex);
		return groupCreationResponse;
	}
	
	@ExceptionHandler(PushNotificationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GroupCreationResponse notificationNotPushed(HttpServletRequest req,
			PushNotificationException ex) {
		GroupCreationResponse groupCreationResponse = new GroupCreationResponse(
				null, new Error("PNS1434", env.getProperty("PNS1434")), true);
		logger.error(ex.getMessage(), ex);
		return groupCreationResponse;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResponse invalidMethodArgument(HttpServletRequest req,MethodArgumentNotValidException ex){
		String errorMessage =  ex.getBindingResult().getFieldError().getDefaultMessage();
		Error error =new Error("ERR2000",errorMessage);
		BaseResponse baseResponse = new BaseResponse(null, error, true);
		logger.error(ex.getMessage(), ex);
		return baseResponse;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResponse notificationNotPushed(HttpServletRequest req,Exception ex) {
		Error error =new Error("ERR5000", env.getProperty("ERR5000"));
		BaseResponse baseResponse = new BaseResponse(null, error, true);
		logger.error(ex.getMessage(), ex);
		return baseResponse;
	}
	
	
}
