package com.odexue.polygon.exception;

@SuppressWarnings("serial")
public class InvalidQuadException extends InvalidPolygonException {

	public InvalidQuadException() {
		super("Given sides does not make a valid Quadrilateral");
	}
}
