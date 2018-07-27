package com.odexue.polygon.strategy;

import org.springframework.stereotype.Service;

import com.odexue.polygon.exception.InvalidQuadException;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.model.Rectangle;

@Service("quadStrategy")
public class QuadStrategy implements PolygonStrategy {

	@Override
	public boolean validate(int[] sides) {
		
		if(sides.length == 4) {
			return true;
		}
		
		return false;
	}

	@Override
	public Polygon classify(int[] sides) throws InvalidQuadException {
		if(validate(sides) == false) {
			throw new InvalidQuadException();
		}
		return new Rectangle();
	}

}
