package com.capg.controller;

public class SweetNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public SweetNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SweetNotFoundException [message=" + message + "]";
	}
}