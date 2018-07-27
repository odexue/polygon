package com.odexue.polygon.commandliner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.odexue.polygon.exception.InvalidPolygonException;
import com.odexue.polygon.model.Polygon;
import com.odexue.polygon.service.PolygonService;


@Component
public class CustomCommandLiner implements CommandLineRunner {

	@Autowired
	private PolygonService polySvc;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		
		
		while(quit == false) {
			System.out.print(">> enter number of sides (or enter Q to quit): ");
			String sidesString = scanner.nextLine();
			if(sidesString.equalsIgnoreCase("q")) {
				break;
			}
			int[] sides = polySvc.sidesConverter(sidesString);
			Polygon triangle;
			try {
				triangle = polySvc.classify(sides);
			} catch (InvalidPolygonException ex) {
				System.out.println(ex.getMessage());
				continue;
			}
			System.out.println(">> triangle type: " + triangle.getClass().getSimpleName());
		}

		
		scanner.close();
		System.out.println("-Polygon Application Ended-");
	}

}
