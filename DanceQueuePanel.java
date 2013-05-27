//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

/**
 * panel to display dance queues for gameplay -- located to west of the gameplay
 * panel
 */
public class DanceQueuePanel extends JPanel {
	// private variables
	/**
	 * an array of Arrow objects that will serve to store the coordinates of
	 * future arrows drawn on screen
	 */
	private static ArrayList<Arrow> arrows;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer timer;
	/**
	 * variable to store the lowest x-coordinate of the box where keys are
	 * considered "on time"
	 */
	private int boxXMin = 50;
	/**
	 * variable to store the highest x-coordinate of the box where keys are
	 * considered "on time"
	 */
	private int boxXMax = 170;
	/**
	 * variable to store the lowest y-coordinate of the box where keys are
	 * considered "on time"
	 */
	private int boxYMin = 0;
	/**
	 * variable to store the highest y-coordinate of the box where keys are
	 * considered "on time"
	 */
	private int boxYMax = 600;

	/** constructor */
	public DanceQueuePanel() {
		// flow layout
		// uses buffer to draw arrows based on queues in an array
		setFocusable(true);
		addKeyListener(new ArrowPressed());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "DanceQueue"));
	}

	// methods
	/** getter for private array arrows */
	private static Arrow[] getArrows() {
		Arrow[] a = arrows.toArray(new Arrow[arrows.size()]);
		return a;
	}

	/** getter for element of private array arrows */
	private static Arrow getArrow(int arrowPos) {
		Arrow[] a = arrows.toArray(new Arrow[arrows.size()]);
		return a[arrowPos];
	}

	/** listener to redraw panel according to timer */
	private class Listener implements ActionListener {
		/** redraws panel */
		public void actionPerformed(ActionEvent e) {
			// clears buffer and move all arrows
			// repaint();
		}
	}

	private class ArrowPressed implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.toString());
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				System.out.println("right");
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				System.out.println("left");
			if (e.getKeyCode() == KeyEvent.VK_UP)
				System.out.println("up");
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				System.out.println("down");
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}