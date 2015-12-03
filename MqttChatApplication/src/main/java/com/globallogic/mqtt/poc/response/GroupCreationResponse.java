package com.globallogic.mqtt.poc.response;

import com.globallogic.mqtt.poc.payload.Payload;

public class GroupCreationResponse extends BaseResponse {

	public GroupCreationResponse(Payload payload, Error error, Boolean isError) {
		super(payload, error, isError);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GroupCreationResponse [getPayload()=" + getPayload()
				+ ", getError()=" + getError() + ", getIsError()="
				+ getIsError() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
