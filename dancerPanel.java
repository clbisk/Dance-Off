//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/** panel to display dancer, located on the right side of the screen */
public class dancerPanel extends JPanel {
	
	/** ImageIcon that varies depending on arrow presses which determine the dancer's "position" */
	private static ImageIcon position;
	/** JLabel to hold the dancer ImageIcon */
	private static JLabel dancer;
	/** contains JLabel with the dancer */
	public dancerPanel() {
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(175, 350));

		position = new ImageIcon(this.getClass().getResource("relaxedPos copy.png"));
		dancer = new JLabel(position);
		add(dancer);
		
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "DancerPanel"));
	}
	/** method to change ImageIcon to appearance of stepping right */
	public static void turnRight() {
		position = new ImageIcon(("rightPos.png"));
		dancer.setIcon(position);
		dancer.revalidate();
	}
	/** method to change ImageIcon to appearance of stepping left */
	public static void turnLeft() {
		position = new ImageIcon(("leftPos.png"));
		dancer.setIcon(position);
		dancer.revalidate();
	}
	/** method to change ImageIcon to appearance of stepping forwards */
	public static void turnUp() {
		//position = new ImageIcon();
		dancer.setIcon(new ImageIcon("frontPos.png"));
		dancer.revalidate();
	}
	/** method to change ImageIcon to appearance of stepping backwards */
	public static void turnDown() {
		//position = new ImageIcon();
		dancer.setIcon(new ImageIcon("backPos.png"));
		dancer.revalidate();
	}

}
