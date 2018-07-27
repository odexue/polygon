package com.odexue.polygon.exception;

@SuppressWarnings("serial")
public class UnknownPolygonException extends InvalidPolygonException {

	public UnknownPolygonException() {
		super("Unable to identify type of polygon");
	}
}
