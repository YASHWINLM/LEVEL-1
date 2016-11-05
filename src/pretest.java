import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pretest implements ActionListener {
	JPanel panel = new JPanel();
	JLabel label= new JLabel();
	JFrame frame= new JFrame();
	JTextField answer = new JTextField(20);
	JTextField answer2 = new JTextField(20);
	JButton butt= new JButton(); 
	JButton butt2= new JButton(); 
public static void main(String[] args) {
	pretest pt= new pretest();
	pt.run();
}
pretest(){
	
}
 public void run(){
	 frame.add(panel);
		frame.setVisible(true);
		panel.setVisible(true);
		frame.pack();
		frame.setSize(700, 90);
		panel.add(label);
		panel.add(answer);
		panel.add(butt);
		panel.add(butt2);
		butt.setText("Submit");
		butt2.setText("Hint");
		label.setText("Which vehicle is spelled the same forwards and backwards? ");
		butt.addActionListener(this);
		butt2.addActionListener(this);
}
 public void check(){
	 
 }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

	if(	e.getSource()==butt){
		 if(answer.getText().equals("Racecar")){
			 JOptionPane.showMessageDialog(null, "Correct");
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "ERRRRR! Wrong!");
		 }
	}
	else if (e.getSource()==butt2){
		JOptionPane.showMessageDialog(null, " Pssst ... it's a type of car");
		
	}
}
}
