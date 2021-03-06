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
public class MakeYerOwn	extends JPanel	{
	//	private variables
	/**
	 *	an	array	of	Arrow	objects that will	serve	to	store	the coordinates of
	 *	future arrows drawn on screen
	 */
	private static	ArrayList<Arrow> arrows;
	/** buffer for myImage used in updating screen */
	private BufferedImage myImage;
	/** buffer from graphics used for updating screen */
	private Graphics myBuffer;
	/** timer for timing to be used alongside arrows*/
	private Timer timer;
	/** buffer for right arrow */
	private BufferedImage rightArrowImg;
	/** buffer for left arrow */
	private BufferedImage leftArrowImg;
	/** buffer for up arrow */
	private BufferedImage upArrowImg;
	/** buffer for down arrow */
	private BufferedImage downArrowImg;
	/** used in determining when the song starts */
	private static long songStart;
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
	private static	int boxYMin	= 480;
	/**
	 *	variable	to	store	the highest	y-coordinate of the box	where	keys are
	 *	considered "on	time"
	 */
	private static	int boxYMax	= 600;

	/** constructor */
	public MakeYerOwn() {
		long songTime = getSongTime();
		//	flow layout
		setLayout(new FlowLayout());
		//	uses buffer	to	draw arrows	based	on	queues in an array
		myImage =  new	BufferedImage(600, 600,	BufferedImage.TYPE_INT_RGB);
		myBuffer	= myImage.getGraphics();
		//uses timer to queue buffer changes
		timer	= new	Timer(5,	new Listener());
		timer.start();
		setFocusable(true);
		arrows =	new ArrayList();
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),	"MakeYerOwn"));
		//load images for	arrows
		rightArrowImg = null;
		leftArrowImg =	null;
		upArrowImg = null;
		downArrowImg =	null;
		try {
			 rightArrowImg	= ImageIO.read(new File("arrowB right.png"));
			 leftArrowImg = ImageIO.read(new	File("arrowB left.png"));
			 upArrowImg	= ImageIO.read(new File("arrowB up copy.png"));
			 downArrowImg = ImageIO.read(new	File("arrowB down.png"));
		} catch (IOException	e)	{
			warn("Oh no!", e);
			System.exit(2);
		}
		songStart = System.currentTimeMillis();
		Danceoff.songMade = true;
	}
	
	/** graphical paint component redrawing myImage */	
	public void	paintComponent(Graphics	g)	{
		g.drawImage(myImage,	0,	0,	getWidth(),	getHeight(), null);
	}

	//	methods
	/**warns	events*/
	public void warn(String msg,	Throwable t) {
		Logger.getLogger(getClass().getName()).log(Level.WARNING, msg,	t);
	}
	
	/** getter for	private arraylist	arrows */
	public static	ArrayList<Arrow> getArrows() {
		if	(arrows != null) {
			return arrows;
		}
		else {
			return null;
		}
	}
	
	/** gets the length of the duration of the song */
	public static long getSongTime() {
		return System.currentTimeMillis()-songStart;
	}

	/** listener to redraw panel according	to	timer	*/
	private class Listener implements ActionListener {
		/** redraws	panel	*/
		public void	actionPerformed(ActionEvent e) {
			if (getSongTime() < 70000) {
				//clears	buffer
				myBuffer.setColor(new Color(237,	237, 237));
				myBuffer.fillRect(0,0,600,600);
				//draws box
				myBuffer.setColor(Color.LIGHT_GRAY);
				myBuffer.fillRect(boxXMin,	boxYMin,	(boxXMax-boxXMin), (boxYMax-boxYMin));
				//draw arrows
				if	(arrows != null) {
					for (int	i = 0; i	< arrows.size(); i++) {
						drawArrow(myBuffer, getSongTime(), MakeYerOwn.arrows.get(i));
					}
				}
				//repaints
				repaint();
			}
			else {
				DanceQueuePanel.yourArrows = arrows.toArray(new Arrow[arrows.size()]);
				timer.stop();
				Danceoff.displayTitleScreen();
			}
		}
		/** controls drawing instances of the various arrows at various points based off timing*/
		public void	drawArrow(Graphics myBuffer, long time,	Arrow	arrow) {
			int x;
			int y	= (int)((arrow.startTime	- time) * scaling);
			if	(arrow instanceof	LeftArrow) {
				x = 0;
				myBuffer.drawImage(leftArrowImg,	x,	y,	null);
			}
			else if (arrow	instanceof UpArrow) {
				x = 150;
				myBuffer.drawImage(upArrowImg, x, y, null);
			}
			else if (arrow	instanceof DownArrow) {
				x = 300;
				myBuffer.drawImage(downArrowImg, x, y, null);
			}
			else {
				x = 450;
				myBuffer.drawImage(rightArrowImg, x,	y,	null);
			}
			
			//myBuffer.setColor(Color.black);
			//myBuffer.drawLine(0,0,x,y);
			
			//Image	img =	Toolkit.getDefaultToolkit().getImage("arrowB	down.png");
			myBuffer.finalize();
		}
	}
	
	/**method to handle right arrow key	presses*/
	public static void right()	{
		arrows.add(new	RightArrow((int)(getSongTime()+1000)));
	}
	/**method to handle left arrow key presses*/
	public static void left() {
		arrows.add(new	LeftArrow((int)(getSongTime()+1000)));
	}
	/**method to handle down arrow key presses*/
	public static void up()	{
		arrows.add(new	UpArrow((int)(getSongTime()+1000)));
	}
	/**method to handle up arrow key	presses*/
	public static void down() {
		arrows.add(new	DownArrow((int)(getSongTime()+1000)));
	}

}
