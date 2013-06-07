import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Instructions for Making Your Own song */
public class MyoInstructionScreen extends JPanel {
	/** JLabel title of the screen  */
	private JLabel title;
	/** JLabel containing instructions on the screen */
	private JLabel instructions;
	/** Screen with title, instructions, and a button */
	public MyoInstructionScreen() {
		setLayout(new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.SOUTH);
		
		JButton button1 = new JButton("Go Back");
		button1.addActionListener(new BackListener());
		button1.setPreferredSize(new Dimension(200, 30));
		panel.add(button1);
		
		JButton button2 = new JButton("Proceed");
		button2.addActionListener(new MakeYourOwnListener());
		button2.setPreferredSize(new Dimension(200,30));
		panel.add(button2);
		//ImageIcon image = new ImageIcon(this.getClass().getResource("danceoff instructionstitle copy.png"));
		//title = new JLabel(image);
		//add(title, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.CENTER);
		
		ImageIcon text = new ImageIcon(this.getClass().getResource("myo instructionsss copy.png"));
		instructions = new JLabel(text);
		panel2.add(instructions);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		add(panel3, BorderLayout.NORTH);
		
		ImageIcon text2 = new ImageIcon(this.getClass().getResource("myo.png"));
		title = new JLabel(text2);
		panel3.add(title);
	}
	/** Listener to go back to title screen */
	private class BackListener implements ActionListener {
		/** calls method to display title screen */
		public void actionPerformed(ActionEvent a) {
			Danceoff.displayTitleScreen();
		}
	}
	/** Listener to continue to MakeYourOwn  */
	private class MakeYourOwnListener implements ActionListener {
		/** calls method to start creation of a new song  */
		public void actionPerformed(ActionEvent a){
			Danceoff.newSong();
		}
	}
}