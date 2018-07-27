package com.odexue.polygon.exception;

@SuppressWarnings("serial")
public class InvalidTriangleException extends InvalidPolygonException {

	public InvalidTriangleException() {
		super("Given sides does not make a valid triangle");
	}
}
