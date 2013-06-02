//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * contains main function and other functions facilitating the transitioning of
 * screens
 */
public class Danceoff {
	// private variables to store difficulty and song choice
	/**
	 * integer representing the song chosen by user when prompted by the song
	 * choice panel; song A being represented by -1, song B being represented by
	 * 0, and song C being represented by 1
	 */
	private static int song;
	/**
	 * integer value representing the difficulty level chosen by user when
	 * prompted by the difficulty selection panel; easy difficulty being
	 * represented by 0, and hard difficulty being represented by 1
	 */
	private static int difficulty;
	private static JFrame frame = new JFrame("Dance-off!");

	// methods
	/** main method to be run for Danceoff program */
	public static void main(String[] args) throws Exception {
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayTitleScreen();
	}

	/** displays the title screen panel */
	public static void displayTitleScreen() {
		// accesses title screen layout from TitleScreen class
		frame.setContentPane(new TitleScreen());
		frame.setVisible(true);
	}

	/** displays instructions panel */
	public static void displayInstructions() {
		// accesses instructions screen layout from InstructionScreen class
		frame.setContentPane(new InstructionScreen());
		frame.setVisible(true);
	}

	/** displays high scores panel */
	public static void displayHighScores() {
		// accesses high scores screen layout from HighScoreScreen class
		frame.setContentPane(new HighScoreScreen());
		frame.setVisible(true);
	}

	/** displays song selection panel */
	public static void startGame() {
		// accesses song selection screen layout from SongSelectionScreen class
		frame.setContentPane(new SongSelectionScreen());
		frame.setVisible(true);
	}

	/** setter for private variable song */
	public static void setSong(int tune) {
		song = tune;
	}

	/** getter for private variable song */
	public static int getSong() {
		return song;
	}

	/** displays difficulty selection panel */
	public static void difficultySelect() {
		// accesses song selection screen layout from DifficultySelectionScreen
		// class
		frame.setContentPane(new DifficultySelectionScreen());
		frame.setVisible(true);
	}

	/** setter for private variable difficulty* */
	public static void setDifficulty(int level) {
		difficulty = level;
	}

	/** getter for private variable difficulty* */
	public static int getDifficulty() {
		return difficulty;
	}

	/** displays panel for game play after selections are complete */
	public static void gamePlayStart() {
		// accesses layout from GamePlayPanel class
		GamePlayPanel panel = new GamePlayPanel();
		//DanceQueuePanel panel = new DanceQueuePanel();
		frame.setContentPane(panel);
		//frame.pack();
		frame.setVisible(true);
		panel.requestFocusInWindow();
	}
	public static void songEnd() {
		displayHighScores();
	}
}
