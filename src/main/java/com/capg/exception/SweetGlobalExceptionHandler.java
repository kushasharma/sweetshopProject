package com.capg.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capg.controller.CartNotFoundException;
import com.capg.controller.SweetNotFoundException;

@RestController
@ControllerAdvice
public class SweetGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<Object> handleCartNotFoundException(CartNotFoundException ex, WebRequest request)
			throws Exception {
		SweetShopExceptionResponse resp = new SweetShopExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SweetNotFoundException.class)
	public ResponseEntity<Object> handleSweetNotFoundException(SweetNotFoundException ex, WebRequest request)
			throws Exception {
		SweetShopExceptionResponse resp = new SweetShopExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
}