package com.odexue.polygon.strategy;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.model.Polygon;

public interface PolygonStrategy {

	/**
	 * Checks if given sides can form a valid polygon
	 * @param sides
	 * @return
	 */
	boolean validate(int[] sides);
	
	Polygon classify(int[] sides) throws InvalidPolygonException;
	
	
}
