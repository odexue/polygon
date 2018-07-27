package com.odexue.polygon.service;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.model.Polygon;

public interface PolygonService {

	boolean isValidPolygon(int[] sides);
	Polygon classify(int[] sides) throws InvalidPolygonException;
	
	default int[] sidesConverter(String sideString) {
		
		String[] sideStringArr = sideString.split(" ");
		
		int[] sides = new int[sideStringArr.length];
		for(int x = 0; x < sideStringArr.length; x++) {
			sides[x] = Integer.valueOf(sideStringArr[x]);
		}
		return sides;
	}
}
