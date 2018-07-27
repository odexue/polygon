package com.odexue.polygon.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Spy;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.model.Rectangle;
import com.odexue.polygon.strategy.QuadStrategy;

public class QuadStrategyTest {

	@Spy
	private QuadStrategy quadStrategy = new QuadStrategy();
	
	@Test
	public void validateTest() {
		int[] sides = {10,4,3,88};
		assertTrue(quadStrategy.validate(sides));
		
		sides = new int[]{10,10,10};
		assertTrue(!quadStrategy.validate(sides));
		
	}
	
	@Test
	public void classifyTest() throws InvalidPolygonException {
		int[] sides = new int[]{10,10,10,10};
		Polygon poly = quadStrategy.classify(sides);
		assertTrue(poly instanceof Rectangle);
		
	}
}
