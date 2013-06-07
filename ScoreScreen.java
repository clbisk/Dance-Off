import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Displays score after finishing a level */
public class ScoreScreen extends JPanel {
	/** JLabel for title of the screen */
	private JLabel title;
	/** Scores screen to be displayed after finishing a song */
	public ScoreScreen() {
		setLayout(new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.SOUTH);
		
		JButton button1 = new JButton("Next");
		button1.addActionListener(new SelectListener());
		button1.setPreferredSize(new Dimension(200, 30));
		panel.add(button1);
		
		ImageIcon image = new ImageIcon(this.getClass().getResource("score.png"));
		title = new JLabel(image);
		add(title, BorderLayout.NORTH);	

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		add(panel2, BorderLayout.CENTER);
		
		JPanel paNel = new JPanel();
		paNel.setLayout(new FlowLayout());
		panel2.add(paNel, BorderLayout.CENTER);
		
		JPanel panel2A = new JPanel();
		panel2A.setLayout(new FlowLayout());
		panel2.add(panel2A, BorderLayout.SOUTH);
		
		JLabel score = new JLabel();
      score.setFont(new	Font("Serif", Font.BOLD, 75));
      score.setForeground(Color.red);
		score.setText("" + scorePanel.getScore());
      paNel.add(score);

		JLabel grade = new JLabel();
      grade.setFont(new	Font("Serif", Font.BOLD,55));
      grade.setForeground(Color.green);
		grade.setText("Your Grade: ");
      panel2A.add(grade);
		//ifs
		int totalPoints = DanceQueuePanel.getLength()*5;
		double yourVal = (double) scorePanel.getScore() / totalPoints;
		if (yourVal < 0.2){
			ImageIcon img = new ImageIcon(this.getClass().getResource("E.png"));
			grade = new JLabel(img);
			panel2A.add(grade);
		}
		else if (yourVal < 0.4){
			ImageIcon img = new ImageIcon(this.getClass().getResource("D.png"));
			grade = new JLabel(img);
			panel2A.add(grade);		
		}
		else if (yourVal < 0.6){
			ImageIcon img = new ImageIcon(this.getClass().getResource("C.png"));
			grade = new JLabel(img);
			panel2A.add(grade);		
		}
		else if (yourVal < 0.8){
			ImageIcon img = new ImageIcon(this.getClass().getResource("B.png"));
			grade = new JLabel(img);
			panel2A.add(grade);		
		}
		else if (yourVal < 1.0){
			ImageIcon img = new ImageIcon(this.getClass().getResource("A.png"));
			grade = new JLabel(img);
			panel2A.add(grade);		
		}
		else if (yourVal == 1){
			ImageIcon img = new ImageIcon(this.getClass().getResource("AA.png"));
			grade = new JLabel(img);
			panel2A.add(grade);
		}
	}
	/** One listener to return to Selection Screen  */
		private class SelectListener implements ActionListener {
	/** method for returning to the Selection screen */
		public void actionPerformed(ActionEvent a) {
			Danceoff.startGame();
		}
	}
}