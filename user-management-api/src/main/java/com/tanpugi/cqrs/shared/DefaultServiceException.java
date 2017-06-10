package com.tanpugi.cqrs.shared;

public class DefaultServiceException extends RuntimeException {

	private static final long serialVersionUID = 7611930799507451386L;
	
	public DefaultServiceException(String msg) {
		super(msg);
	}

}
