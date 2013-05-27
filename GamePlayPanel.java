//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;


/** GamePlayPanel */
public class GamePlayPanel extends JPanel {
	/** Timer used in the timing of arrows going across screen*/
	private Timer timer;
	/** int song is used to determine which song was selected previously */ 
	private int song;
	/** int difficulty is used to determine which difficulty was selected previously */
	private int difficulty;
	/** Border layout for GamePlayPanel.
	*Sets up three different panels:
	*Panel danceQueuePanel located in west area of screen;
	*Panel scorePanel located in north area of screen;
	*Panel dancerPanel located in south area of screen
	*/
	public GamePlayPanel() {
		//draws three panels inside itself
		setFocusable(true);
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		add(panel1, BorderLayout.CENTER);
	
		JPanel scorePnl = new scorePanel();
		panel1.add(scorePnl, BorderLayout.NORTH);
	
		JPanel dancerPnl = new dancerPanel();
		panel1.add(dancerPnl, BorderLayout.EAST);
		
		JPanel danceQueuePnl = new DanceQueuePanel();
		panel1.add(danceQueuePnl, BorderLayout.CENTER);

		addKeyListener(new ArrowPressed());
		playSong();
	}
	/**Plays WAV file corresponding to the song selected previously */
	public static void playSong() {
		int songChoice = Danceoff.getSong();
		if (songChoice == -1) { //Baa Baa Black Sheep
			try{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
   		}catch(Exception ex){
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
   		}
		}
		else if (songChoice == 0) { //Mary Had a Little Lamb
			try{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
   		}catch(Exception ex){
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
   		}
		}
		else { //Twinkle Twinkle Little Star
			try{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
   		}catch(Exception ex){
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
   		}
		}
	} 
	/**Creates arrows at intervals determined by the timer */
	public static void timeArrows() {
		//Uses arrays with dance queues inside
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