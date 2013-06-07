import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** displays credits to outside resources as a panel */
public class CreditsScreen extends JPanel {
	/** label for the title at the top of the panel */
	private JLabel title;
	/** label for the credits inside of the panel */
	private JLabel credits;
	/** BorderLayout containing FlowLayouts; within are title, credits, and a button */
	public CreditsScreen() {
		setLayout(new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.SOUTH);
		
		JButton button1 = new JButton("Go Back");
		button1.addActionListener(new BackListener());
		button1.setPreferredSize(new Dimension(200, 30));
		panel.add(button1);
		ImageIcon image = new ImageIcon(this.getClass().getResource("credits.png"));
		title = new JLabel(image);
		add(title, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.CENTER);
		
		ImageIcon text = new ImageIcon(this.getClass().getResource("credits text.png"));
		credits = new JLabel(text);
		panel2.add(credits);
	}
	//one listener
	/** listens to return back to title screen */
	private class BackListener implements ActionListener {
		/** calls method to display title screen */
		public void actionPerformed(ActionEvent a) {
			Danceoff.displayTitleScreen();
		}
	}
}