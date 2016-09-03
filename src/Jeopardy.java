
// Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	JButton[][] buttons = new JButton[6][5];

	private void start() {
		JFrame frame = new JFrame();
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());
		JPanel header = createHeader("Stuff");
		header.setLayout(null);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				buttons[i][j] = createButton("$100");
				header.add(buttons[i][j]);
				buttons[i][j].setLocation(i*100, j*100);
				buttons[i][j].setSize(100, 100);
			}
		}

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Jeopardy Review");
		// 3. Create a JPanel variable to hold the header using the createHeader
		// method

		// 4. Add the header component to the quizPanel
		// quizPanel.add(header);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		frame.add(header);

		// frame.pack();
		quizPanel.setLayout(null);
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
	}

	/*
	 * 13. Use the method provided to play the Jeopardy theme music
	 * 
	 * 14. Add buttons so that you have $200, $400, $600, $800 and $1000
	 * questions
	 *
	 * [optional] Use the showImage or playSound methods when the user answers a
	 * question
	 */

	private JButton createButton(String dollarAmount) {
		// Create a new JButton
		JButton butt = new JButton();
		// Set the text of the button to the dollarAmount
		butt.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount++;
		// Return your new button instead of the temporary button
		return butt;
	}

	public void actionPerformed(ActionEvent arg0) {
		// Remove this temporary message:
		// JOptionPane.showMessageDialog(null, "pressed " + ((JButton)
		// arg0.getSource()).getText() + " button");

		// Use the method that plays the jeopardy theme music.
		playJeopardyTheme();
		JButton buttonPressed = (JButton) arg0.getSource();
		// If the buttonPressed was the firstButton
		if (buttonPressed.getText().equals(firstButton.getText())) {

			// Call the askQuestion() method
			askQuestion("Yes or No", "No", 100);
			// Fill in the askQuestion() method. When you play the game, the
			// score
			// should change.

		}
		// Or if the buttonPressed was the secondButton
		if (buttonPressed.getText().equals(secondButton.getText())) {
			askQuestion("No or Yes", "Yes", 200);
		}
		// Call the askQuestion() method with a harder question

		// Clear the button text (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		// Remove this temporary message
		// JOptionPane.showMessageDialog(null, "this is where the question will
		// be asked");
		// Use a pop up to ask the user the question
		String answer = JOptionPane.showInputDialog(question);
		// If the answer is correct
		if (answer.equals(correctAnswer)) {

			// Increase the score by the prizeMoney
			score = score + prizeMoney;
			// Call the updateScore() method
			updateScore();
			// Pop up a message to tell the user they were correct
			JOptionPane.showMessageDialog(null, "Corrrrect!!");
		}
		// Otherwise
		else {

			// Decrement the score by the prizeMoney
			score = score - prizeMoney;

			// Pop up a message to tell the user the correct answer
			JOptionPane.showMessageDialog(null, "Incorect the correct aswer was No!");
			// Call the updateScore() method
			updateScore();
		}
	}

	public void playJeopardyTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("/Users/Administrator/Google Drive/league-sounds/jeopardy.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
		scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
