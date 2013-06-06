import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreScreen extends JPanel {
	private JLabel title;
	private JLabel instructions;
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
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.CENTER);
		
		JLabel score = new JLabel();
      score.setFont(new	Font("Serif", Font.BOLD, 75));
      score.setForeground(Color.red);
		score.setText("" + scorePanel.getScore());
      panel2.add(score);

		

	}
	//one listener
	private class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			//calls method to display title screen
			Danceoff.startGame();
		}
	}
}