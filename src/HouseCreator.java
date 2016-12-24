import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class HouseCreator {
	 Robot bender;
	
	HouseCreator(){
		 bender = new Robot();
		
	}
	void PutInLeftCorner(){
		
		bender.setX(100);
		bender.setY(900);
		
	}
	void DrawHouse(){
		int num;
		for (int i = 0; i < 10; i++) {
			
			num=new Random().nextInt(91)+10;
			house(num,Color.orange);
			phouse(num,Color.RED);
			}
	}
	private void house(int height, Color color) {
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
	private void phouse(int height, Color color) {
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
