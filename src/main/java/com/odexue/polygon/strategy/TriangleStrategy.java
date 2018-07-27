package com.odexue.polygon.strategy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.exception.InvalidTriangleException;
import com.odexue.polygon.model.Equilateral;
import com.odexue.polygon.model.Isosceles;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.model.Scalene;

@Service("triStrategy")
public class TriangleStrategy implements PolygonStrategy {

	@Override
	public boolean validate(int[] sides) {
		if(sides != null && sides.length != 3 ) {
			return false;
		} else if(sides.length == 3){
			
			int longest = 0;
			for(int side : sides) {
				if(side > longest)
					longest = side;
			}
			
			int allSidesSum = 0;
			for(int side : sides) {
				allSidesSum = allSidesSum + side;
			}
			
			/*
			 * Triangle Inequality Theorem :
			 * sum of any 2 sides of a triangle must be greater than the measure of the third side.
			 */
			return (longest < (allSidesSum - longest));
		} else {
			return false;
		}
	}

	@Override
	public Polygon classify(int[] sides) throws InvalidPolygonException {
		
		if(validate(sides) == true) {
			
			Set<Integer> set = new HashSet<>();
			
			for(int side : sides) {
				set.add(side);
			}
			
			// no sides are equal
			if(set.size() == sides.length)
				return new Scalene();
			
			// two sides are equal
			if(set.size() == 2)
				return new Isosceles();
			
			// all sides have the same length
			if(set.size() == 1)
				return new Equilateral();
			
		} else {
			throw new InvalidTriangleException();
		}
		
		return null;
	}


}











