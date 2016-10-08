
// Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
		try {
			new Jeopardy().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	JButton[][] buttons = new JButton[6][5];
	String[] headers = new String[6];
	XMLNode[] headerNodes;
	JFrame frame = new JFrame();

	private void start() throws IOException {
		XMLParser parser = new XMLParser(new File(System.getProperty("user.dir") + "/Jeopardy.xml"));

		int index = 0;
		for (XMLNode category : headerNodes = parser.parse()) {
			System.out.println(category.getTagName());
			headers[index++] = category.getAttribute("name");
		}

		quizPanel = new JPanel(null);
		frame.setLayout(new BorderLayout());
		for (int i = 0; i < 6; i++) {
			JPanel header = createHeader(headers[i], 0);
			for (int j = 0; j < 5; j++) {
				buttons[i][j] = createButton("$" + ((j + 1) * 100));
				header.add(buttons[i][j]);
				buttons[i][j].setLocation(0, 50 + j * 100);
				buttons[i][j].setSize(100, 100);
				buttons[i][j].addActionListener(this);
			}
			header.setBounds(i * 100, 0, 100, 600);

			quizPanel.add(header);
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

		// frame.pack();
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
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
		playJeopardyTheme();
		JButton buttonPressed = (JButton) arg0.getSource();
		//buttonPressed.setEnabled(false);

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (buttons[i][j] == buttonPressed) {
					XMLNode h = headerNodes[i];
					XMLNode jeopardy = h.getChildren()[j];
					XMLNode q = jeopardy.getChildren()[0];
					String answer = JOptionPane.showInputDialog(q.getValue());
					XMLNode a = jeopardy.getChildren()[1];
					if (Pattern.compile("(?i)(" + answer + ").+?").matcher(a.getValue()).find()) {
						score += (j + 1) * 100;
						JOptionPane.showMessageDialog(null, "YEA");
					} else {
						score -= (j + 1) * 100;
						JOptionPane.showMessageDialog(null, "Frick u " + a.getValue());
					}
				}
			}
		}

		scoreBox.setText(score + "");
		frame.invalidate();
		frame.repaint();
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
					.getAudioInputStream(new File("/Users/League/Google Drive/league-sounds/jeopardy.wav"));
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

	private JPanel createHeader(String topicName, int x) {
		JPanel panelj = new JPanel();
		panelj.setLayout(null);
		JLabel l1 = new JLabel();
		l1.setSize(100, 50);
		l1.setText("<html><div style='width:50px'>" + topicName + "</div></html>");
		l1.setFont(new Font("Arial", Font.BOLD, 10));
		l1.setLocation(x, 0);
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
