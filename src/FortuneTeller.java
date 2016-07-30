import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame frame = new JFrame();

    int frameWidth = 954;
    int frameHeight = 800;

    FortuneTeller() throws Exception {
   	 // 1. Choose an image for your fortune teller and put it in your default package
    	
   	 fortuneTellerImage = ImageIO.read(getClass().getResource("fortune_teller.jpeg"));
   	 // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
   	 // 4. add a mouse listener to the frame
   	 frame.addMouseListener(this);

    }

    static void begin() {
   	 // 3. Welcome the user. Give them a hint for the secret location.
    JOptionPane.showMessageDialog(null, "Welcome to my shack that I live in hover your mouse over the jewel on my head plz?");
    }

    @Override
    public void mousePressed(MouseEvent e) {
   	 int mouseX = e.getX();
   	 int mouseY = e.getY();
   	 // 5. Print the mouseX variable
   	 System.out.println(mouseX + " " + mouseY);
   	 // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)
   	 
   	 // 7. Adjust your secret location co-ordinates here:
   	 int secretLocationX = 587;
   	 int secretLocationY = 124;
   	 /** If the mouse co-ordinates and secret location are close, we'll let them ask a question. */
   	 if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
   		 // 8. Get the user to enter a question for the fortune teller
   		 JOptionPane.showInputDialog("Ask me any question and I will answer");
   		 // 9. Find a spoopy sound and put it in your default package (freesound.org)
   		  AudioClip sound = JApplet.newAudioClip(getClass().getResource("spoopy.wav"));
   		
   		  // 10. Play the sound
   		  sound.play();
   		 // 11. Use the pause() method below to wait until your music has finished

   		 // 12. Insert your completed Magic 8 ball recipe (http://bit.ly/Zdrf6d) here
   		int lucky = new Random().nextInt(3);
   		// 3. Print out this variable
   		System.out.println(lucky);
   		// 4. Get the user to enter a question for the 8 ball
   		JOptionPane.showInputDialog("Ask a question");
   		// 5. If the random number is 0
   		if(lucky==0)
   		{
   		// -- tell the user "Yes"
   		JOptionPane.showMessageDialog(null, "YEEE");
   		}
   		// 6. If the random number is 1
   		else if (lucky==1)
   		{
   		// -- tell the user "No"
   		JOptionPane.showMessageDialog(null, "NEIN");
   		}
   		// 7. If the random number is 2
   		else if (lucky==2)
   		{
   		// -- tell the user "Maybe you should ask Google?"
   			JOptionPane.showMessageDialog(null, "ASK BING");
   			JOptionPane.showMessageDialog(null, "NAW JK, ASK goo.gol");
   			JOptionPane.showMessageDialog(null, "NYO JK LOL, Ask Google");
   		}
   		// 8. If the random number is 3
   		else if (lucky==3)
   		{
   		// -- write your own answer
   		JOptionPane.showInputDialog("I sorry your time has expired please input credit card info for more time.");
   		
   		}

   	 }

    }

    private boolean areClose(int mouseX, int secretLocationX) {
   	 return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
    }

    private void pause(int seconds) {
   	 try {
   		 Thread.sleep(1000 * seconds);
   	 } catch (InterruptedException e) {
   		 e.printStackTrace();
   	 }
    }
    
    /**************** don't worry about the stuff under here *******************/
    
    BufferedImage fortuneTellerImage;

    public static void main(String[] args) throws Exception {
   	 SwingUtilities.invokeLater(new FortuneTeller());
   	 begin();
    }

    @Override
    public void run() {
   	 frame.add(this);
   	 setPreferredSize(new Dimension(frameWidth, frameHeight));
   	 frame.pack();
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 frame.setResizable(false);
   	 frame.setVisible(true);
    }

private void showAnotherImage(String imageName) {
   	 try {
   		 fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
   	 } catch (Exception e) {
   		 System.err.println("Couldn't find this image: " + imageName);
   	 }
   	 repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
   	 g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}

// Copyright The League, 2016




