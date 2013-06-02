import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**displays title screen*/
public class TitleScreen extends JPanel {
	/**JLabel to display title of game ("Dance-Off!")*/
	private JLabel title;
	
	/**constructor*/
	public TitleScreen() {
		setLayout(new BorderLayout());
		//border layout
		JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel.add(panel2, BorderLayout.CENTER);
		
		//four buttons: display instructions, display high scores, start game, and exit
		JButton button1 = new JButton("Instructions");
      button1.addActionListener(new InstructionsListener());
		panel.add(button1, BorderLayout.NORTH);
		JButton button2 = new JButton("High Scores");
		button2.addActionListener(new ShowHighScoresListener());
		panel2.add(button2, BorderLayout.NORTH);
		JButton button4 = new JButton("Quit");
		button4.addActionListener(new QuitListener());
		panel.add(button4, BorderLayout.SOUTH);
		JButton button3 = new JButton("Start Game");
		button3.addActionListener(new StartGameListener());
		panel2.add(button3, BorderLayout.SOUTH);
		
		JButton newSong = new JButton("Create Your Own Dance");
      newSong.addActionListener(new NewSongListener());
		panel.add(newSong, BorderLayout.CENTER);
		
		//JPanel with ImageIcon displaying title
		ImageIcon image = new ImageIcon(this.getClass().getResource("danceoff title1 cleaned.png"));
		title = new JLabel(image);
		panel2.add(title, BorderLayout.CENTER);
	}
	//four listeners
	/**listens for instructions button clicked*/
	private class InstructionsListener implements ActionListener {
		/**calls method to display intructions*/
		public void actionPerformed(ActionEvent a) {
			Danceoff.displayInstructions();
		}
	}
	/**listens for high scores button clicked*/
	private class ShowHighScoresListener implements ActionListener {
		/**calls method to display high scores*/
		public void actionPerformed(ActionEvent b) {
			Danceoff.displayHighScores();
		}
	}
	/**listens for start game button clicked*/
	private class StartGameListener implements ActionListener {
		/**calls method to start game*/
		public void actionPerformed(ActionEvent c) {
			Danceoff.startGame();
		}
	}
	/**listens for exit button clicked*/
	private class QuitListener implements ActionListener {
		/**exits game*/
		public void actionPerformed(ActionEvent d) {
			System.exit(0);
		}
	}
	/**listens for new song button clicked*/
	private class NewSongListener implements ActionListener {
		/**exits game*/
		public void actionPerformed(ActionEvent d) {
			Danceoff.newSong();
		}
	}
}