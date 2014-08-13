package com.priceit.utilities;

import org.springframework.stereotype.Component;


@Component
public class Response {
	private String statusCode;
	private Object response;

	
	public String toString() {
		return " [" + response + "]";
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

	
	
}
