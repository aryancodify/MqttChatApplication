package com.globallogic.mqtt.poc.response;

public class Error {
	private String errorCode;
	private String errorMessage;
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public Error(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorCode
	 */
	public final String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public final void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public final String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public final void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
