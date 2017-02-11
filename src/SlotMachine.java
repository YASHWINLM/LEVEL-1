import java.util.Random;

import javax.swing.JOptionPane;

public class SlotMachine {
public static void main(String[] args) {
	String BetAmount=JOptionPane.showInputDialog("How much money do you want to bet?");
	int BetAmt=Integer.parseInt(BetAmount);
	Random r= new Random();
	int rand=r.nextInt(3);
	if (rand==0) {
		JOptionPane.showMessageDialog(null, "0  0  0");
		BetAmt*=0;
		JOptionPane.showMessageDialog(null, "Congragulations! you earned: $"+BetAmt);
	}
	else if (rand==1) {
		JOptionPane.showMessageDialog(null, "1  1  1");
		BetAmt*=1;
		JOptionPane.showMessageDialog(null, "Congragulations! you earned: $"+BetAmt);
	}
	if (rand==2) {
		JOptionPane.showMessageDialog(null, "2  2  2");
		BetAmt*=2;
		JOptionPane.showMessageDialog(null, "Congragulations! you earned: $"+BetAmt);
	}
	
}
}
