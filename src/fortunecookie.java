import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
public class fortunecookie implements ActionListener {
	private String fortune;
	public fortunecookie(){
		this.fortune=fortune;
	}
	
	public void showButton(){
	System.out.println("fortune");
	JFrame jFrame=new JFrame();
	jFrame.setVisible(true);
	JButton butt = new JButton();
	jFrame.add(butt);
	butt.addActionListener(this);
	butt.setText("Click me for your fortune");
	jFrame.pack();

	}
	public static void main(String[] args) {
		fortunecookie fortune = new fortunecookie();
		fortune.showButton();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "WOOHOO!!!!");
		int rand = new Random().nextInt(5);

		if(rand==1){
			JOptionPane.showMessageDialog(null, "you will die");
		}
		else if(rand==2){
			JOptionPane.showMessageDialog(null, "you won't die");
		}
		else if(rand==3){
			JOptionPane.showMessageDialog(null, "you might die");
		}
		else if(rand==4){
			JOptionPane.showMessageDialog(null, "you'll probably die");
		}
		else if(rand==5){
			JOptionPane.showMessageDialog(null, "hi");
		}

	}
}
