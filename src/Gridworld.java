import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	
public static void main(String[] args) {
World w= new World();
Bug bug= new Bug();
Location loc= new Location(5,5);
Bug bugg= new Bug();
Random random=new Random();
Location looc= new Location(random.nextInt(10), random.nextInt(9));
Location loco= new Location(5,4);
Location locos= new Location(5,6);
Flower f= new Flower();
Flower f2= new Flower();
w.show();
w.add(loc, bug);
w.add(looc, bugg);
bugg.setColor(Color.BLUE);
bugg.turn();
w.add(loco, f);
w.add(locos, f2);
for (int i = 0; i < 10; i++) {
	for (int j = 0; j < 10; j++) {
		Location lococ = new Location(i,j);
		Flower f3 = new Flower();
		w.add(lococ, f3);
	}
}

}

	
}


