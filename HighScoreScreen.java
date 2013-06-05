import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/** Description of class HighScoreScreen*/
public class HighScoreScreen extends JPanel {
	/**Displays highest score for SongA on difficulty Easy*/
	private JLabel highScoreSongAEasy;
	/**Displays highest score for SongB on difficulty Easy*/
	private JLabel highScoreSongBEasy;
	/**Displays highest score for SongC on difficulty Easy*/
	private JLabel highScoreSongCEasy;
	/**Displays highest score for SongA on difficulty Hard*/
	private JLabel highScoreSongAHard;
	/**Displays highest score for SongB on difficulty Hard*/
	private JLabel highScoreSongBHard;
	/**Displays highest score for SongC on difficulty Hard*/
	private JLabel highScoreSongCHard;
	
	private JLabel title;
	
	/**Flow layout, with one button to go back to the title screen*/
	public HighScoreScreen() {
		setLayout(new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.SOUTH);
		
		JButton button1 = new JButton("Go Back");
		button1.addActionListener(new BackListener());
		button1.setPreferredSize(new Dimension(200, 30));
		panel.add(button1);
		ImageIcon image = new ImageIcon(this.getClass().getResource("danceoff hiscores copy.png"));
		title = new JLabel(image);
		add(title, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel2.add(panel3);
		
		highScoreSongAEasy = new JLabel("There is no top highscore for \"Bad Girl\" on easy mode.");
		//reads songAEasy.ser for highscore
      try {
			Integer hs;
         FileInputStream fileIn = new FileInputStream("songAEasy.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         hs = (Integer)in.readObject();
         in.close();
         fileIn.close();
			highScoreSongAEasy.setText("The top highscore for \"Bad Girl\" on easy mode is " + hs + " points!");
      }catch(IOException i) {
         System.out.println("error reading highscores");
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("Class not found");
         return;
      }
		panel3.add(highScoreSongAEasy);
		
		highScoreSongBEasy = new JLabel("There is no top highscore for \"Wordkill\" on easy mode.");
		//reads songBEasy.ser for highscore
		panel3.add(highScoreSongBEasy);
		highScoreSongCEasy = new JLabel("There is no top highscore for \"Stop It\" on easy mode.");
		//reads songCEasy.ser for highscore
		panel3.add(highScoreSongCEasy);
		
		highScoreSongAHard = new JLabel("There is no top highscore for \"Bad Girl\" on hard mode.");
		//reads songAHard
		panel3.add(highScoreSongAHard);
		highScoreSongBHard = new JLabel("There is no top highscore for \"Wordkill\" on hard mode.");
		//reads songBHard
		panel3.add(highScoreSongBHard);
		highScoreSongCHard = new JLabel("There is no top highscore for \"Stop It\" on hard mode.");
		//reads songCHard
		panel3.add(highScoreSongCHard);
		
	}
	/** Back Listener for High Scores*/
	//
	private class BackListener implements ActionListener {
		/** Calls method to display title screen*/
		public void actionPerformed(ActionEvent a) {
			Danceoff.displayTitleScreen();
		}
	}
}