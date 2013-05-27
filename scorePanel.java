//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/** Description of class scorePanel */
public class scorePanel extends JPanel {
	/** scorePanel has one label: score */
	private JLabel score;
	public static int currentScore;
	/** Flow layout, with one JLabel displaying current score. JLabel is updated whenever more points are scored.*/ 
	public scorePanel() {
	
	setLayout(new FlowLayout());
	setSize(300, 300);
	
	JLabel score = new JLabel("0");
	score.setFont(new Font("Serif", Font.BOLD, 100));
	score.setForeground(Color.red);
   add(score);
	
	}
	
	/** Returns current score*/
	public static int getScore() {
		return currentScore;
	}
	/** Sets score to newScore */
	public static void setScore(int newScore) {
		currentScore = newScore;
	}
}