import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class TypingTeast {
public static void main(String[] args) {
	long StartTime=System.nanoTime();
	ArrayList<String> Words= new  ArrayList<String>();
	Words.add("hat");
	Words.add("pat");
	Words.add("cat");
	Words.add("mat");
	Words.add("sat");
	Words.add("at");
	Words.add("scat");
	Words.add("rat");
	Words.add("fat");
	Words.add("phat");

	for (String CurrentWord : Words) {
		String answer=JOptionPane.showInputDialog("Spell the word "+CurrentWord);
		while(!CurrentWord.equals(answer)){
			JOptionPane.showMessageDialog(null, "UR A SCRUBBBBBBB");
			 answer=JOptionPane.showInputDialog("Spell the word "+CurrentWord);
		}
	}
	long endTime=System.nanoTime();
	long seconds =  TimeUnit.NANOSECONDS.toSeconds(endTime-StartTime);
	JOptionPane.showMessageDialog(null, "It took you "+seconds +" seconds");
		
	
	
	
}
}
