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
		
		highScoreSongAEasy = new JLabel("There is no top highscore for \"Wordkill\" on easy mode.");
		panel3.add(highScoreSongAEasy);
		highScoreSongBEasy = new JLabel("There is no top highscore for \"Stop It\" on easy mode.");
		panel3.add(highScoreSongBEasy);
		highScoreSongCEasy = new JLabel("There is no top highscore for \"Bad Girl\" on easy mode.");
		panel3.add(highScoreSongCEasy);
		highScoreSongAHard = new JLabel("There is no top highscore for \"Wordkill\" on hard mode.");
		panel3.add(highScoreSongAHard);
		highScoreSongBHard = new JLabel("There is no top highscore for \"Stop It\" on hard mode.");
		panel3.add(highScoreSongBHard);
		highScoreSongCHard = new JLabel("There is no top highscore for \"Bad Girl\" on hard mode.");
		panel3.add(highScoreSongCHard);
		
		//creates a scanner for reading files
		Scanner infile = null;
		try {
			String filename = "high scores.txt";
			infile = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
		}
		//reads all highscores into array
		int[] numbers = new int[6];
		for (int i = 0; i < 6; i++) {
			numbers[i] = infile.nextInt();
		}
		//rewrites JLabels if highscores exist
		if (numbers[0] != 0)
			highScoreSongAEasy.setText("The highscore for \"Wordkill\" on easy mode is" + numbers[0]);
		if (numbers[1] != 0)
			highScoreSongAHard.setText("The highscore for \"Wordkill\" on hard mode is" + numbers[1]);
		if (numbers[2] != 0)
			highScoreSongBEasy.setText("The highscore for \"Stop It\" on easy mode is" + numbers[2]);
		if (numbers[3] != 0)
			highScoreSongBHard.setText("The highscore for \"Stop It\" on hard mode is" + numbers[3]);
		if (numbers[4] != 0)
			highScoreSongCEasy.setText("The highscore for \"Bad Girl\" on easy mode is" + numbers[4]);
		if (numbers[5] != 0)
			highScoreSongCHard.setText("The highscore for \"Bad Girl\" on hard mode is" + numbers[5]);
		
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
