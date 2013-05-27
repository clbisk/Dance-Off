import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Description of class DifficultySlectionScreen */
public class DifficultySelectionScreen extends JPanel {
	/** Selection screen has label: difficulty */
	private JLabel difficulty;
	/** Border layout for Difficulty Selection Screen;
	Has three buttons: Easy, Hard, and Go Back */
	public DifficultySelectionScreen() {
	setLayout(new BorderLayout());
	
	JPanel panel=new JPanel();
	panel.setLayout(new BorderLayout(0,20));
	add(panel, BorderLayout.CENTER);
	
	JPanel panel2= new JPanel();
	panel2.setLayout(new BorderLayout(0, 20));
	panel.add(panel2, BorderLayout.CENTER);
	
	JPanel panel1A= new JPanel();
	panel1A.setLayout(new FlowLayout());
	panel.add(panel1A, BorderLayout.NORTH);
	
	JPanel panel2A= new JPanel();
	panel2A.setLayout(new FlowLayout());
	panel2.add(panel2A, BorderLayout.NORTH);
		
	JPanel panel3A= new JPanel();
	panel3A.setLayout(new FlowLayout());
	panel2.add(panel3A, BorderLayout.SOUTH);
	
	JButton button1 = new JButton("Easy");
	button1.addActionListener(new EasyListener());
	button1.setPreferredSize(new Dimension(200, 30));
	panel1A.add(button1);
	
	JButton button2 = new JButton("Hard");
	button2.addActionListener(new HardListener());
	button2.setPreferredSize(new Dimension(200, 30));
	panel2A.add(button2);
	
	JButton button3 = new JButton("Go Back");
	button3.addActionListener(new BackListener());
	button3.setPreferredSize(new Dimension(200, 30));
		panel3A.add(button3);
	
		//ImageIcon displaying title
		ImageIcon image = new ImageIcon(this.getClass().getResource("danceoff difficulty.png"));
		difficulty = new JLabel(image);
		add(difficulty, BorderLayout.NORTH);
	
	}
	/** Easy Listener for Difficulty*/
	private class EasyListener implements ActionListener {
		/**Calls method to show Difficulty Selection Screen;
		Passes int which signifies difficulty (easy) selected*/
		public void  actionPerformed(ActionEvent b) {
			Danceoff.setDifficulty(0);
			Danceoff.gamePlayStart();
		}
	}
	/**HardListener for Difficulty*/
	private class HardListener implements ActionListener {
		/**Calls method to show Difficulty Selection Screen;
		Passes int which signifies difficulty (hard) selected */
		public void actionPerformed(ActionEvent c) {
			Danceoff.setDifficulty(1);
			Danceoff.gamePlayStart();
		}
	}
	/** Back Listener for Difficulty*/
	private class BackListener implements ActionListener {
		/** Calls method to display title screen*/
		public void actionPerformed(ActionEvent d) {
			Danceoff.startGame();
		}
	}
}