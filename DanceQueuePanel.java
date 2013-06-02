//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah,	Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.*;
import java.util.logging.*;

/**
 *	panel	to	display dance queues	for gameplay -- located	to	west of the	gameplay
 *	panel
 */
public class DanceQueuePanel extends JPanel {
	//	private variables
	/**
	 *	an	array	of	Arrow	objects that will	serve	to	store	the coordinates of
	 *	future arrows drawn on screen
	 */
	private static	Arrow[] arrows;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer timer;
	private BufferedImage rightArrowImg;
	private BufferedImage leftArrowImg;
	private BufferedImage upArrowImg;
	private BufferedImage downArrowImg;
	/**scale	factor to determine how	long the	arrow	will take to get up the	screen*/
	private static	double scaling	= 0.6;
	public static int	time;
	/**
	 *	variable	to	store	the lowest x-coordinate	of	the box where keys are
	 *	considered "on	time"
	 */
	private static	int boxXMin	= 0;
	/**
	 *	variable	to	store	the highest	x-coordinate of the box	where	keys are
	 *	considered "on	time"
	 */
	private static	int boxXMax	= 600;
	/**
	 *	variable	to	store	the lowest y-coordinate	of	the box where keys are
	 *	considered "on	time"
	 */
	private static	int boxYMin	= 50;
	/**
	 *	variable	to	store	the highest	y-coordinate of the box	where	keys are
	 *	considered "on	time"
	 */
	private static	int boxYMax	= 170;

	/** constructor */
	public DanceQueuePanel() {
		//	flow layout
		setLayout(new FlowLayout());
		//	uses buffer	to	draw arrows	based	on	queues in an array
		myImage =  new	BufferedImage(600, 600,	BufferedImage.TYPE_INT_RGB);
		myBuffer	= myImage.getGraphics();
		//uses timer to queue buffer changes
		time = 0;
		timer	= new	Timer(5,	new Listener());
		timer.start();
		setFocusable(true);
		//picks instructions	based	on	song & level
		if	(Danceoff.getSong() == -1 && Danceoff.getDifficulty()	==	0)	{
			arrows =	new Arrow[]	{new UpArrow(1000), new	DownArrow(1000), new	LeftArrow(3000)};
		}
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),	"DanceQueuePanel"));
		//load images for arrows
		rightArrowImg = null;
		leftArrowImg = null;
		upArrowImg = null;
		downArrowImg = null;
		try {
		    rightArrowImg = ImageIO.read(new File("arrowB right.png"));
			 leftArrowImg = ImageIO.read(new File("arrowB left.png"));
			 upArrowImg = ImageIO.read(new File("arrowB up copy.png"));
			 downArrowImg = ImageIO.read(new File("arrowB down.png"));
		} catch (IOException e) {
			warn("YOU FAIL", e);
			System.exit(2);
		}
	}
		
	public void	paintComponent(Graphics	g)	{
		g.drawImage(myImage,	0,	0,	getWidth(),	getHeight(), null);
	}

	//	methods
	/**warns events*/
	private void warn(String msg, Throwable t) {
		Logger.getLogger(getClass().getName()).log(Level.WARNING, msg, t);
	}
	
	/** getter for	private array arrows	*/
	private static	Arrow[] getArrows() {
		if	(arrows != null) {
			return arrows;
		}
		else {
			return null;
		}
	}

	/** getter for	element of private array arrows */
	private static	Arrow	getArrow(int arrowPos) {
		return arrows[arrowPos];
	}

	/** listener to redraw panel according	to	timer	*/
	private class Listener implements ActionListener {
		/** redraws	panel	*/
		public void	actionPerformed(ActionEvent e) {
			//clears	buffer
			myBuffer.setColor(new Color(237,	237, 237));
			myBuffer.fillRect(0,0,600,600);
			//draws box
			myBuffer.setColor(Color.LIGHT_GRAY);
			myBuffer.fillRect(boxXMin,	boxYMin,	(boxXMax-boxXMin), (boxYMax-boxYMin));
			//draw arrows
			if	(arrows != null) {
				for (int	i = 0; i	< arrows.length; i++) {
					drawArrow(myBuffer, time, DanceQueuePanel.arrows[i]);
				}
			}
			else {
				System.out.println("This level has not	yet been	created!");
			}
			//increments time	count
			time += 5;
			//repaints
			repaint();
			//scheduleNextFrame();
		}
		public void	drawArrow(Graphics myBuffer, int	time,	Arrow	arrow) {
			int x;
			int y = (int)((arrow.startTime	- time)*scaling);
			if	(arrow instanceof	LeftArrow) {
				x = 0;
				myBuffer.drawImage(leftArrowImg, x, y, null);
			}
			else if (arrow	instanceof RightArrow) {
				x = 150;
				myBuffer.drawImage(rightArrowImg, x, y, null);
			}
			else if (arrow	instanceof UpArrow) {
				x = 300;
				myBuffer.drawImage(upArrowImg, x, y, null);
			}
			else {
				x = 450;
				myBuffer.drawImage(downArrowImg, x, y, null);
			}
			
			//myBuffer.setColor(Color.black);
			//myBuffer.drawLine(0,0,x,y);
			
			//Image	img = Toolkit.getDefaultToolkit().getImage("arrowB down.png");
			myBuffer.finalize();
		}
	}
	
	/**method to handle right arrow key	presses*/
	public static void right()	{
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof RightArrow) {
				double currentPos	= (int)((arrows[i].startTime - time) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle left arrow key presses*/
	public static void left() {
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof LeftArrow)	{
				double currentPos	= (int)((arrows[i].startTime - time) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle down arrow key presses*/
	public static void up()	{
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof UpArrow) {
				double currentPos	= (int)((arrows[i].startTime - time) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle up arrow key	presses*/
	public static void down() {
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof DownArrow)	{
				double currentPos	= (int)((arrows[i].startTime - time) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
}
