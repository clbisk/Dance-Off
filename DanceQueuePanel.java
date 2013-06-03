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
	private static long songStart;
	/**scale	factor to determine how	long the	arrow	will take to get up the	screen*/
	private static	double scaling	= 0.6;
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
		timer	= new	Timer(5,	new Listener());
		timer.start();
		setFocusable(true);
		//picks instructions	based	on	song & level
		if	(Danceoff.getSong() == -1 && Danceoff.getDifficulty()	==	0)	{
			arrows =	new Arrow[]	{new LeftArrow(2475), new RightArrow(3460), new LeftArrow(4280), new RightArrow(5205), new LeftArrow(5695), new RightArrow(6165), new LeftArrow(7135), new RightArrow(7610), new LeftArrow(8095), new RightArrow(9060), new LeftArrow(9070), new DownArrow(10040), new UpArrow(10055), new RightArrow(10980), new LeftArrow(10990), new UpArrow(11460), new DownArrow(11470), new LeftArrow(11930), new RightArrow(12840), new LeftArrow(13310), new RightArrow(13820), new LeftArrow(14775), new RightArrow(15255), new LeftArrow(15755), new RightArrow(16685), new LeftArrow(16695), new RightArrow(17615), new LeftArrow(17625), new RightArrow(18115), new LeftArrow(18125), new DownArrow(18600), new UpArrow(18610), new RightArrow(19070), new LeftArrow(19080), new RightArrow(19555), new LeftArrow(19565), new RightArrow(20530), new UpArrow(20540), new UpArrow(21000), new LeftArrow(21010), new RightArrow(21480), new UpArrow(21490), new UpArrow(22455), new LeftArrow(22470), new RightArrow(22900), new UpArrow(22920), new UpArrow(23405), new LeftArrow(23415), new RightArrow(24355), new UpArrow(24370), new LeftArrow(24825), new UpArrow(24835), new RightArrow(25310), new LeftArrow(25325), new DownArrow(25765), new DownArrow(26045), new DownArrow(26315), new DownArrow(26760), new UpArrow(27230), new LeftArrow(27945), new RightArrow(28230), new UpArrow(29145), new RightArrow(29870), new LeftArrow(30135), new DownArrow(31045), new LeftArrow(31770), new RightArrow(32025), new DownArrow(32945), new RightArrow(33400), new LeftArrow(33925), new LeftArrow(34840), new RightArrow(34860), new LeftArrow(34985), new RightArrow(35780), new LeftArrow(35790), new DownArrow(36775), new UpArrow(36785), new RightArrow(37230), new LeftArrow(37240), new UpArrow(37475), new DownArrow(37485)};
		}
		else if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
			arrows = new Arrow[] {new RightArrow(1820), new LeftArrow(1825), new LeftArrow(3385), new UpArrow(3755), new DownArrow(4165), new RightArrow(4530), new RightArrow(4960), new LeftArrow(4970), new LeftArrow(6540), new UpArrow(6905), new DownArrow(7315), new RightArrow(7670), new RightArrow(8095), new LeftArrow(8100), new LeftArrow(9665), new UpArrow(10070), new DownArrow(10440), new RightArrow(10820), new RightArrow(11255), new LeftArrow(11265), new LeftArrow(12785), new UpArrow(13165), new DownArrow(13580), new RightArrow(14015), new RightArrow(14435), new LeftArrow(14450), new RightArrow(14885), new DownArrow(15170), new DownArrow(15350), new LeftArrow(15685), new UpArrow(15830), new DownArrow(15995), new RightArrow(16245), new DownArrow(16430), new LeftArrow(16625), new LeftArrow(17210), new UpArrow(17390), new DownArrow(17555), new DownArrow(18030), new UpArrow(18445), new UpArrow(18645), new LeftArrow(18825), new LeftArrow(19040), new LeftArrow(19805), new UpArrow(20150), new RightArrow(21185), new UpArrow(21330), new UpArrow(21595), new LeftArrow(21935), new UpArrow(22100), new DownArrow(22250), new RightArrow(22520), new DownArrow(22705), new LeftArrow(22900), new LeftArrow(23535), new DownArrow(23745), new UpArrow(24020), new RightArrow(24375), new RightArrow(24770), new UpArrow(24930), new UpArrow(25160), new RightArrow(25360), new UpArrow(25520), new RightArrow(25605), new UpArrow(25690), new UpArrow(26330), new LeftArrow(26515), new LeftArrow(26725), new LeftArrow(27545), new UpArrow(27710), new UpArrow(27930), new RightArrow(28305), new UpArrow(28715), new LeftArrow(29105), new LeftArrow(29545), new LeftArrow(29965), new UpArrow(30305), new RightArrow(30695), new RightArrow(30990), new UpArrow(31355), new LeftArrow(31525), new UpArrow(31695), new LeftArrow(31880), new LeftArrow(33475), new UpArrow(33830), new UpArrow(34260), new RightArrow(34660), new RightArrow(35065), new UpArrow(35445), new UpArrow(35825), new LeftArrow(36210), new UpArrow(36615), new UpArrow(37025), new LeftArrow(37215), new UpArrow(37405), new RightArrow(37625), new RightArrow(37840), new RightArrow(38190), new LeftArrow(38205), new RightArrow(38590), new LeftArrow(38620), new RightArrow(38970), new LeftArrow(39010), new RightArrow(39390), new LeftArrow(39405), new RightArrow(39770), new LeftArrow(39780), new LeftArrow(40185), new UpArrow(40350), new RightArrow(40605), new LeftArrow(40950), new UpArrow(41120), new DownArrow(41365), new RightArrow(41570), new UpArrow(41800), new UpArrow(42000), new LeftArrow(42530), new UpArrow(42685), new DownArrow(42890), new LeftArrow(43280), new UpArrow(43445), new DownArrow(43635), new LeftArrow(44140), new UpArrow(44315), new DownArrow(44540), new UpArrow(44785), new UpArrow(44960), new UpArrow(45165), new LeftArrow(46170), new RightArrow(46590), new UpArrow(46965), new LeftArrow(47365), new UpArrow(47725), new RightArrow(48410), new RightArrow(48575), new UpArrow(48770), new UpArrow(48960), new UpArrow(49350), new LeftArrow(51320), new UpArrow(51740), new RightArrow(52125), new RightArrow(52565), new LeftArrow(52965), new UpArrow(53135), new RightArrow(53340), new LeftArrow(53745), new UpArrow(53915), new RightArrow(54135), new UpArrow(54370), new UpArrow(54555), new UpArrow(54740), new LeftArrow(55340), new UpArrow(55515), new DownArrow(55695), new LeftArrow(56115), new UpArrow(56275), new DownArrow(56490), new LeftArrow(56905), new DownArrow(57095), new RightArrow(57285), new DownArrow(57580), new LeftArrow(57765), new LeftArrow(57945), new RightArrow(58465), new UpArrow(58625), new LeftArrow(58885), new RightArrow(59295), new UpArrow(59465), new LeftArrow(59890), new RightArrow(60405), new LeftArrow(60425), new RightArrow(61220), new LeftArrow(61265), new LeftArrow(62065), new UpArrow(62075), new LeftArrow(62435), new UpArrow(62440), new UpArrow(62815), new LeftArrow(62820), new LeftArrow(63205), new UpArrow(63210), new RightArrow(63570), new UpArrow(63575), new RightArrow(63920), new UpArrow(63925), new RightArrow(64270), new UpArrow(64275), new RightArrow(64625), new UpArrow(64630), new RightArrow(64980), new LeftArrow(64985)};
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
		songStart = System.currentTimeMillis();
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
	
	private static long getSongTime() {
		return System.currentTimeMillis()-songStart;
	}

	/** getter for	element of private array arrows */
	private static	Arrow	getArrow(int arrowPos) {
		return arrows[arrowPos];
	}

	/** listener to redraw panel according	to	timer	*/
	private class Listener implements ActionListener {
		/** redraws	panel	*/
		public void	actionPerformed(ActionEvent e) {
			long songTime = getSongTime();
			if ((Danceoff.getSong() == -1 && songTime < 53000) || (Danceoff.getSong() == 0 && songTime < 68000) || (Danceoff.getSong() == 1 && songTime < 85000)) {
				//clears	buffer
				myBuffer.setColor(new Color(237,	237, 237));
				myBuffer.fillRect(0,0,600,600);
				//draws box
				myBuffer.setColor(Color.LIGHT_GRAY);
				myBuffer.fillRect(boxXMin,	boxYMin,	(boxXMax-boxXMin), (boxYMax-boxYMin));
				//draw arrows
				if	(arrows != null) {
					for (int	i = 0; i	< arrows.length; i++) {
						drawArrow(myBuffer, DanceQueuePanel.arrows[i]);
					}
				}
				else {
					System.out.println("This level has not	yet been	created!");
					timer.stop();
				}
				//repaints
				repaint();
				//scheduleNextFrame();
			}
			else {
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 0) {
					String name = "songCEasy.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 0) {
					String name = "songBEasy.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 0) {
					String name = "songAEasy.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 1) {
					String name = "songCHard.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
					String name = "songBHard.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 1) {
					String name = "songAHard.ser";
					try {
						FileOutputStream fileOut = new FileOutputStream(name);
					 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
					  	out.writeObject(arrows);
						out.close();
					} catch (IOException ioe) {
						warn(name, ioe);
					}
				}
				timer.stop();
				Danceoff.songEnd();
			}
		}
		public void	drawArrow(Graphics myBuffer, Arrow	arrow) {
			int x;
			long time = System.currentTimeMillis()-songStart;
			int y = (int)((arrow.startTime	- time)*scaling);
			if	(arrow instanceof	LeftArrow) {
				x = 0;
				myBuffer.drawImage(leftArrowImg, x, y, null);
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
				myBuffer.drawImage(rightArrowImg, x, y, null);
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
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
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
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
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
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
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
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
}
