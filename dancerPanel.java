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
		position = new ImageIcon(("rightPos.png"));
		dancer.setIcon(position);
		dancer.revalidate();
	}
	public static void turnLeft() {
		position = new ImageIcon(("leftPos.png"));
		dancer.setIcon(position);
		dancer.revalidate();
	}
	public static void turnUp() {
		//position = new ImageIcon();
		dancer.setIcon(new ImageIcon("frontPos.png"));
		dancer.revalidate();
	}
	public static void turnDown() {
		//position = new ImageIcon();
		dancer.setIcon(new ImageIcon("backPos.png"));
		dancer.revalidate();
	}

}
