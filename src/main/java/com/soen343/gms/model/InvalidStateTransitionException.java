package com.soen343.gms.model;

public class InvalidStateTransitionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidStateTransitionException() {};
	
	public InvalidStateTransitionException(String message) {
		super(message);
	}

}
