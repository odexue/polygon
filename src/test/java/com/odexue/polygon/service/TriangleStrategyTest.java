package com.odexue.polygon.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Spy;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.exception.InvalidTriangleException;
import com.odexue.polygon.model.Equilateral;
import com.odexue.polygon.model.Isosceles;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.model.Scalene;
import com.odexue.polygon.strategy.TriangleStrategy;

public class TriangleStrategyTest {

	@Spy
	private TriangleStrategy triStrategy = new TriangleStrategy();
	
	@Test
	public void validateTest() {
		int[] sides = {10,4,3};
		assertTrue(!triStrategy.validate(sides));
		
		sides = new int[]{5,6,7};
		assertTrue(triStrategy.validate(sides));
		
		sides = new int[]{10,10,10};
		assertTrue(triStrategy.validate(sides));
		
	}
	
	@Test
	public void classifyTest() throws InvalidPolygonException {
		int[] sides = new int[]{10,10,10};
		Polygon poly = triStrategy.classify(sides);
		assertTrue(poly instanceof Equilateral);
		
		sides = new int[]{1,2,2};
		poly = triStrategy.classify(sides);
		assertTrue(poly instanceof Isosceles);
		
		sides = new int[]{88,33,100};
		poly = triStrategy.classify(sides);
		assertTrue(poly instanceof Scalene);
	}
	
	@Test(expected = InvalidTriangleException.class)
	public void classifyWithExceptionTest() throws InvalidPolygonException {
		int[] sides = new int[]{1,1,1000000};
		Polygon poly = triStrategy.classify(sides);
		assertTrue(poly instanceof Equilateral);
	}
	
}





