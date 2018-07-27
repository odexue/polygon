package com.odexue.polygon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.exception.UnknownPolygonException;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.strategy.PolygonStrategy;

@Service
public class PolygonInteractor implements PolygonService {

	@Autowired
	@Qualifier("triStrategy")
	private PolygonStrategy triStrategy;
	
	@Autowired
	@Qualifier("quadStrategy")
	private PolygonStrategy quadStrategy;

	
	@Override
	public boolean isValidPolygon(int[] sides) {
		
		if(sides.length == 3) {
			return triStrategy.validate(sides);
		}
		
		if(sides.length == 4) {
			return quadStrategy.validate(sides);
		}
		
		return false;
	}

	@Override
	public Polygon classify(int[] sides) throws InvalidPolygonException {
		
		if(sides.length == 3) {
			return triStrategy.classify(sides);
		} else if(sides.length == 4) {
			return quadStrategy.classify(sides);
		} else if (sides.length <= 2) {
			throw new InvalidPolygonException();
		} else {
			throw new UnknownPolygonException();
		}
		
	}

}






