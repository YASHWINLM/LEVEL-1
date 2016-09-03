import javax.swing.JButton;
import javax.swing.JFrame;

public class chuckleclicker {
	//Make a ChuckleClicker class, a main method and a makeButtons method. Put a pop-up in the makeButtons method and get it working. You will need to instantiate your class and call method an instance of it. 
	private String name;
	chuckleclicker(){
	this.name=name;
}
	void makeButtons(){
		JFrame jFrame=new JFrame();
		jFrame.setVisible(true);
		jFrame.pack();
	}
	public static void main(String[] args) {


	//Make a JFrame in makeButtons() method and get it to show.

	//Add a JPanel and two JButtons and get them to show up like this:

	//*[Optional] Customize your GUI with setText, setSize, etc.

	//Make a pop-up that says “hi” when either of the buttons are pressed. You will need to add listeners to the buttons for this to work.

	//Check if the ActionEvent came from the joke button or the punchline button.  
	//if(arg0.getSource() == jokeButton){
		
	//}
	//You might need to move the declaration of your buttons above the the makeButtons() method.

	//Use JOptionPane to print the joke or the punchline depending on which button was clicked.


}}
