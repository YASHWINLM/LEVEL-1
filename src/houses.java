import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class houses {
	static Robot bender;
	
	public static void main(String[] args) {
		
	bender = new Robot();
	//1. have the tortoise start in the bottom left corner
	int num;
	bender.setX(100);
	bender.setY(900);
	//2. draw a house of height 100 with grass after it. This shape: |**|_
	for (int i = 0; i < 10; i++) {
	
	num=new Random().nextInt(91)+10;
	house(num,Color.orange);
	phouse(num,Color.RED);
	}
	//3. extract the piece of code that draws the house into a method. Draw 10 houses.

	//4. Change the method to take int height as a parameter. Draw 9 houses of different heights

	//5. Make the method take a String instead of a height. 	
		
	//“small” 		60
	//“medium”	 	120
	//“large”			250

	//6. Make the method take a color as well as a height. The houses are drawn in that color.

	//[optional] Set the scene to night time by setting the background to black using Tortoise.getBackgroundWindow().setColor
	
	//7. Give the houses peaked roofs

	//8. Extract that roof code into a method “drawPointyRoof” and create a new method: “drawFlatRoof”.

	//9. make large h
}

	private static void house(int height, Color color) {
		// TODO Auto-generated method stub
		bender.penDown();
		bender.setPenColor(color);
		bender.setSpeed(10);
		bender.move(height);
		bender.turn(90);
		bender.move(20);
		bender.turn(90);
		bender.move(height);
		bender.turn(-90);
		bender.setPenColor(Color.CYAN);
		bender.move(50);
		bender.turn(-90);
		bender.setPenColor(color);
	}
	private static void phouse(int height, Color color) {
		bender.penDown();
		bender.setPenColor(color);
		bender.setSpeed(10);
		bender.move(height);
		bender.turn(45);
		bender.move(20);
		bender.turn(90);
		bender.move(20);
		bender.turn(45);
		bender.move(height);
		bender.turn(-90);
		bender.setPenColor(Color.CYAN);
		bender.move(50);
		bender.turn(-90);
		bender.setPenColor(color);
	}
}

