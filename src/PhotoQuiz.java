 // Copyright Wintriss Technical Schools 2013
import java.awt.Component;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public static void main(String[] args) throws Exception {
		Frame quizWindow = new Frame();
		quizWindow.setVisible(true);

		// 1. find an image on the internet, and put its URL in a String variable (from your browser, right click on the image, and select “Copy Image URL”)
		String photo="http://images.akamai.steamusercontent.com/ugc/568898140313187913/CC24DD6759F2240C7BEC378F4732C1AEACE261C9/";
		// 2. create a variable of type "Component" that will hold your image
		Component GabeN;
		// 3. use the "createImage()" method below to initialize your Component
		GabeN=  createImage(photo);
		// 4. add the image to the quiz window
		quizWindow.add(GabeN);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String x=JOptionPane.showInputDialog("How many GabeNs are there?");
		// 7. print "CORRECT" if the user gave the right answer
		if(x.equals("1")){
			JOptionPane.showMessageDialog(null, "YOU'RE RIGHT YOU WIN A FREE TOASTER OVEN YAY!!!!!!!!");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else{
			JOptionPane.showMessageDialog(null, "YOU'RE A FAILIURE AT LIFE AT THIS POINT JUST DO IT END IT ALL !!!!!!!");
		}
		// 9. remove the component from the quiz window (you may not see the effect of this until step 12)
		quizWindow.remove(GabeN);
		// 10. find another image and create it (might take more than one line of code)
		Component pepe;
		pepe=createImage("https://67.media.tumblr.com/4c03b38733f0dacf5ca56ec4ee152a79/tumblr_nxvp7nSSsf1ueiaxzo1_500.jpg");		
		// 11. add the second image to the quiz window
		quizWindow.add(pepe);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		String y=JOptionPane.showInputDialog("How many MAREAJAYWANEIS*(weed/blunts)* are there?");
		// 14+ check answer, say if correct or incorrect, etc.
		if(y.equals("idk")){
			JOptionPane.showMessageDialog(null, "YOU'RE RIGHT YOU WIN A FREE TOASTER OVE YAY!!!!!!!!");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "YOU'RE A FAILIURE AT LIFE AT THIS POINT JUST DO IT END IT ALL !!!!!!!");
		}
		Component hitler;
		hitler=createImage("http://pikastar.com/wp-content/uploads/2015/12/Jacob-Sartorius-Measurements.jpg");		
		
		quizWindow.add(hitler);
		
		quizWindow.pack();
		
		String z=JOptionPane.showInputDialog("How many HITLER are there?");
		
		if(z.equals("all of them")){
			JOptionPane.showMessageDialog(null, "YOU'RE RIGHT YOU WIN A FREE TOASTER OVE YAY!!!!!!!!");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "YOU'RE A FAILIURE AT LIFE AT THIS POINT JUST DO IT END IT ALL we dont need scum like u on this earth!!!!!!!");
		}
		Component rape;
		rape=createImage("http://pikastar.com/wp-content/uploads/2015/12/Jacob-Sartorius-Measurements.jpg");		
		
		quizWindow.add(rape);
		
		quizWindow.pack();
		
		String x2=JOptionPane.showInputDialog("How much RAPE is there?");
		
		if(x2.equals("if every single soul that has been raped in this universe was turned into the living embodiment of it")){
			JOptionPane.showMessageDialog(null, "YOU'RE RIGHT YOU WIN A FREE TOASTER OVE YAY!!!!!!!!");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "YOU'RE A FAILIURE AT LIFE AT THIS POINT JUST DO IT END IT ALL we dont need scum like u on this earth!!!!!!!");
		}

	}

	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}  
	
	/*private static JLabel createLabelImage(String fileName)
			throws MalformedURLException
	{
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null)
		{
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}*/


	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image (imageComponent.addMouseMotionListener()) 
}





