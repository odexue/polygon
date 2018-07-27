package com.odexue.polygon.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.exception.UnknownPolygonException;
import com.odexue.polygon.model.Equilateral;
import com.odexue.polygon.strategy.PolygonStrategy;


@RunWith(SpringRunner.class)
public class PolygonServiceTest {

	@Mock
	@Qualifier("triStrategy")
	private PolygonStrategy triStrategy;
	
	@Mock
	@Qualifier("quadStrategy")
	private PolygonStrategy quadStrategy;
	
	
	@Spy
	@InjectMocks
	private PolygonInteractor poly = new PolygonInteractor();
	
	@Test
	public void sidesConverTest() {
		String sideString = "10 10 10";
		int[] sides = new int[]{10,10,10};
		int[] sidesTest = poly.sidesConverter(sideString);
		Assert.assertTrue(Arrays.equals(sides, sidesTest));
	}
	
	@Test
	public void isValidPolygonTest() {
		int[] sides = new int[]{10,10,10};
		Mockito.when(triStrategy.validate(sides)).thenReturn(true);
		Assert.assertTrue(poly.isValidPolygon(sides));
	}
	
	@Test
	public void classifyTest() throws InvalidPolygonException {
		int[] sides = new int[]{10,10,10};
		Mockito.when(triStrategy.classify(sides)).thenReturn(new Equilateral());
		Assert.assertTrue(poly.classify(sides) instanceof Equilateral);
	}
	
	@Test(expected = InvalidPolygonException.class)
	public void classifyInvalidPolygonExceptionTest() throws InvalidPolygonException {
		int[] sides = new int[]{10,10};
		Assert.assertTrue(poly.classify(sides) instanceof Equilateral);
	}
	
	@Test(expected = UnknownPolygonException.class)
	public void classifyWithUnknownPolygonExceptionTest() throws InvalidPolygonException {
		int[] sides = new int[]{10,10,33,22,12};
		Assert.assertTrue(poly.classify(sides) instanceof Equilateral);
	}
}







