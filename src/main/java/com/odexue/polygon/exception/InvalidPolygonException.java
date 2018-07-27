package com.odexue.polygon.exception;

@SuppressWarnings("serial")
public class InvalidPolygonException extends Exception {

	public InvalidPolygonException() {
		super("Given sides does not make a valid polygon");
	}
	
	public InvalidPolygonException(String message) {
		super(message);
	}
}
