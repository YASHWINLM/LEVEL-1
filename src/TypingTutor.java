import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TypingTutor implements KeyListener {
	JFrame frame= new JFrame();
	JPanel panel=new JPanel();
	JLabel label =new JLabel();
	
	 char currentLetter;
	public static void main(String[] args) {
		TypingTutor t = new TypingTutor();
		t.run();
		t.generateRandomLetter();
		

	}
	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}
	
	public void run(){
		
		currentLetter=generateRandomLetter();
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		frame.pack();
		frame.addKeyListener(this);
		label.setText(currentLetter+"");
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
				
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		if(e.getKeyChar()==currentLetter){
			panel.setBackground(Color.GREEN);
			
		}
		else{
			panel.setBackground(Color.RED);
		}
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter=generateRandomLetter();
		label.setText(currentLetter+"");
	}

}
