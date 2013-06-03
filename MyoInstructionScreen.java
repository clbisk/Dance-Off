import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyoInstructionScreen extends JPanel {
	private JLabel title;
	private JLabel instructions;
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
		
		ImageIcon text = new ImageIcon(this.getClass().getResource("instructionsss.png"));
		instructions = new JLabel(text);
		panel2.add(instructions);
	}
	//one listener
	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			//calls method to display title screen
			Danceoff.displayTitleScreen();
		}
	}
	private class MakeYourOwnListener implements ActionListener {
		public void actionPerformed(ActionEvent a){
			Danceoff.newSong();
		}
	}
}