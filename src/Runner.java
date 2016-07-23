import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
	Superhero hero= new Superhero();
	hero.setpower("Meat Vision");
	hero.setname("Taco guy");
	Superhero Vape= new Superhero();
	Vape.setpower("Vape ring");
	Vape.setname("Vape Naysh");
	Superhero Ash= new Superhero();
	Ash.setpower("Ketchup slip up");
	Ash.setname("Ash Ketchup");
	System.out.println(hero.toString());
	ArrayList<Superhero> heros=new ArrayList<Superhero>();
	heros.add(hero);
	heros.add(Vape);
	heros.add(Ash);
	System.out.println(heros.get(0).toString());
	}
}
