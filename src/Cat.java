import javax.swing.JOptionPane;

public class Cat {

		private String name;
		private int lives = 5;

		Cat(String name) {
			this.name = name;
		}

		void meow() {
			System.out.println("meeeeeooooooooooowwwwwwwww!!");
		}

		public void printName() {
			if (name == null)
				System.out.println("i don't know my own name!");
			else
				System.out.println("my name is " + name);
		}

		void kill() {
			lives--;
			if (lives > 0)
				System.out.println("nice try, but I still have " + lives + " lives left");
			else if (lives < 0)
				System.out.println("that's overkill yo!");
			else
				System.out.println("DEAD CAT :(");
		}

		public static void main(String[] args) {
			/* Do the following things without changing the Cat class */
			
			Cat  cat=new Cat("snowball I");
			Cat  cat2=new Cat("snowball I");
			Cat cat3;
			cat= new Cat("snowball II");
			System.out.println(cat.lives);
			// 1. Make the Cat meow
			cat.meow();
			cat2.printName();
			cat2.meow();
			// 2. Get the Cat to print it's name
			cat.printName();
			// 3. Kill the Cat!
			for (int i = 0; i < 10; i++) {
				cat.kill();
			}
			System.out.println(cat.lives);
			System.out.println(cat2.lives);
			
		}
	}




