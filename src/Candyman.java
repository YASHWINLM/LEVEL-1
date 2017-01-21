import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Candyman implements ActionListener {
	int clicks;
	public static void main(String[] args) {
	
	Candyman man= new Candyman();
	man.run();
}
	void run(){
	JFrame frame= new JFrame();
	JPanel panel= new JPanel();
	JButton butt= new JButton();
	frame.setVisible(true);
	panel.setVisible(true);
	frame.add(panel);
	panel.add(butt);
	frame.pack();
	butt.addActionListener(this);
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clicks=clicks+1;
		System.out.println(clicks);
	}
}
