import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErrorPlayingCustomSongScreen extends JPanel {
	private JLabel title;
	private JLabel instructions;
	public ErrorPlayingCustomSongScreen() {
		setLayout(new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.SOUTH);
		
		JButton button1 = new JButton("Back to Main Menu");
		button1.addActionListener(new BackListener());
		button1.setPreferredSize(new Dimension(200, 30));
		panel.add(button1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.CENTER);
		
		JLabel label = new JLabel("There is no data for your song yet.");
		label.setFont(new Font("Serif", Font.BOLD, 50));
		JLabel label2 = new JLabel("Create a song in \"Create Your Own Dance.\"");
		label2.setFont(new Font("Serif", Font.BOLD, 35));
		panel2.add(label);
		panel2.add(label2);
	}
	//one listener
	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			//calls method to display title screen
			Danceoff.displayTitleScreen();
		}
	}
}