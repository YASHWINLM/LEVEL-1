import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class binaryConverter implements ActionListener {
	JPanel panel = new JPanel();
	JFrame frame= new JFrame();
	JTextField answer = new JTextField(20);
	JTextField answer2 = new JTextField(20);
	JButton butt= new JButton(); 
	String convert(String binary) {
	   	int num= 0;
	   	double add;
		 char[] letter= binary.toCharArray();
	   	//for (int i = 0; i < letter.length; i++)
	   	for (int i = letter.length-1; i >= 0; i--){
	   		//System.out.println(letter[i]);
			if ((letter[i]=='0')||(letter[i]=='1')) {
				if (letter[i]=='1') {
					System.out.println(i+" " +num+" "+(Math.pow(2,i)));
					add=Math.pow(2, i);
					num=num + (int) Math.round(add);
				}
					
			}
		
	   	}
	   	char n=(char) num;
	 System.out.println(num);
	   	return "hi"+num;   
	 }

	public static void main(String[] args) {
		binaryConverter b=new binaryConverter();
		b.run();
	
}







void run(){
	
	frame.add(panel);
	frame.setVisible(true);
	panel.setVisible(true);
	//frame.pack();
	frame.setSize(700, 80);
	panel.add(answer);
	panel.add(butt);
	butt.setText("convert");
	panel.add(answer2);
	butt.addActionListener(this);
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
System.out.println("hi");
answer2.setText(convert(answer.getText()));

		
	}
}	

