package com.globallogic.mqtt.poc.response;

import com.globallogic.mqtt.poc.payload.Payload;

public class BaseResponse {

	private Payload payload;
	private Error error;
	private Boolean isError;

	/**
	 * @param errorCode
	 * @param errorMessage
	 * @param isError
	 * @param payload
	 */
	public BaseResponse(Payload payload, Error error, Boolean isError) {
		super();
		this.error = error;
		this.isError = isError;
		this.payload = payload;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

}
