import java.util.Random;

import javax.swing.JOptionPane;

public class RealSlotMachine {
	public static void main(String[] args) {
		Random rand = new Random();
		int rand1 = rand.nextInt();
		int rand2 = rand.nextInt();
		int rand3 = rand.nextInt();
		String money=JOptionPane.showInputDialog("Enter amount of money that you want to bet on this slot machine!");
		int BetMoney= Integer.parseInt(money);
	}
}
