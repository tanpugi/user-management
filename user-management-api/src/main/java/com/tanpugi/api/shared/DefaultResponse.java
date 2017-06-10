package com.tanpugi.api.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DefaultResponse {
	@JsonInclude(value=Include.ALWAYS)
	private boolean success = true;
	@JsonInclude(value=Include.NON_NULL)
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
