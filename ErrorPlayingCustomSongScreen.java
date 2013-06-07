import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Warns if there is an error when trying to play custom song */
public class ErrorPlayingCustomSongScreen extends JPanel {
	/** JLabel containing title of screen */
	private JLabel title;
	/** JLabel containing content of screen */
	private JLabel instructions;
	/** Screen contains title, error message, one button  */
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
	/** listener to go back to title screen  */
	private class BackListener implements ActionListener {
		/** calls method to display title screen  */
		public void actionPerformed(ActionEvent a) {
			Danceoff.displayTitleScreen();
		}
	}
}