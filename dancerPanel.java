//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class dancerPanel extends JPanel {
	
	//private variables
	private static ImageIcon position;
	private static JLabel dancer;
	public dancerPanel() {
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(175, 350));

		position = new ImageIcon(this.getClass().getResource("relaxedPos copy.png"));
		dancer = new JLabel(position);
		add(dancer);
		
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "DancerPanel"));
	}
	public static void turnRight() {
		position = new ImageIcon("rightPos.png");
		dancer.setIcon(position);
	}
}