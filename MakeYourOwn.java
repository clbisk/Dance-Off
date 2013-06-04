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
public class MakeYourOwn extends JPanel {
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
	public MakeYourOwn() {
		//draws three panels inside itself
		setFocusable(true);
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		add(panel1, BorderLayout.CENTER);
	
		JPanel dancerPnl = new dancerPanel();
		panel1.add(dancerPnl, BorderLayout.EAST);
		
		JPanel makeyrwn = new MakeYerOwn();
		panel1.add(makeyrwn, BorderLayout.CENTER);

		addKeyListener(new ArrowPressed());
		playSong();
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "GamePlayPanel"));
	}
	/**Plays WAV file corresponding to the song selected previously */
	public static void playSong() {
		int songChoice = Danceoff.getSong();
		// if (songChoice == -1) { //Song C
// 			try{
// 				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
// 				Clip clip = AudioSystem.getClip();
// 				clip.open(audioInputStream);
// 				clip.start();
//    		}catch(Exception ex){
// 				System.out.println("Error with playing sound.");
// 				ex.printStackTrace();
//    		}
// 		}
// 		else if (songChoice == 0) { //Song B
// 			try{
// 				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
// 				Clip clip = AudioSystem.getClip();
// 				clip.open(audioInputStream);
// 				clip.start();
//    		}catch(Exception ex){
// 				System.out.println("Error with playing sound.");
// 				ex.printStackTrace();
//    		}
// 		}
// 		else { //Song A
// 			try{
// 				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
// 				Clip clip = AudioSystem.getClip();
// 				clip.open(audioInputStream);
// 				clip.start();
//    		}catch(Exception ex){
// 				System.out.println("Error with playing sound.");
// 				ex.printStackTrace();
//    		}
// 		}
			try{
				//AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Love Love Love - Epik High (INSTRUMENTAL).wav").getAbsoluteFile());
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
   		}catch(Exception ex){
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
   		}
	} 
	private class ArrowPressed implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println(e.toString());
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				//System.out.println("right");
				dancerPanel.turnRight();
				MakeYerOwn.right();
				System.out.print("new RightArrow("+(MakeYerOwn.getSongTime())+"), ");
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				//System.out.println("left");
				dancerPanel.turnLeft();
				MakeYerOwn.left();
				System.out.print("new LeftArrow("+(MakeYerOwn.getSongTime())+"), ");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				//System.out.println("up");
				dancerPanel.turnUp();
				MakeYerOwn.up();
				System.out.print("new UpArrow("+(MakeYerOwn.getSongTime())+"), ");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				//System.out.println("down");
				dancerPanel.turnDown();
				MakeYerOwn.down();
				System.out.print("new DownArrow("+(MakeYerOwn.getSongTime())+"), ");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}
