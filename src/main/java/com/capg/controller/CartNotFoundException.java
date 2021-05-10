package com.capg.controller;

public class CartNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public CartNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CartNotFoundException [message=" + message + "]";
	}
}