import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**Description of class SongSelectionScreen*/

public class SongSelectionScreen extends JPanel {
	/** Song Selection Screen has title: "Song Selection" */
	private JLabel songSelection;
	/** Border layout with four buttons:
	*Song A,
	*Song B,
	*Song C,
	*and Go back.
	*/
	public SongSelectionScreen() {
	
		setLayout( new BorderLayout());
	
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 20));
		add(panel);
	
		JPanel panel2= new JPanel();
		panel2.setLayout(new BorderLayout(0, 20));
		panel.add(panel2, BorderLayout.CENTER);
	
		JPanel panel3= new JPanel();
		panel3.setLayout(new BorderLayout(0, 20));
		panel2.add(panel3, BorderLayout.CENTER);
		
		JPanel panel4= new JPanel();
		panel4.setLayout(new BorderLayout(0, 20));
		panel3.add(panel4, BorderLayout.CENTER);
	
		JPanel panelA = new JPanel();
		panelA.setLayout(new FlowLayout());
		panel.add(panelA, BorderLayout.NORTH);
	
		JPanel panel2A = new JPanel();
		panel2A.setLayout(new FlowLayout());
		panel2.add(panel2A, BorderLayout.NORTH);
	
		JPanel panel3A = new JPanel();
		panel3A.setLayout(new FlowLayout());
		panel3.add(panel3A, BorderLayout.NORTH);
	
		JPanel panel4A = new JPanel();
		panel4A.setLayout(new FlowLayout());
		panel.add(panel4A, BorderLayout.SOUTH);
		
		JPanel panel5A = new JPanel();
		panel5A.setLayout(new FlowLayout());
		panel4.add(panel5A, BorderLayout.NORTH);
		
	
		JButton button1= new JButton("Song C (Bad Girl -- Instrumental)");
		button1.addActionListener(new SongAListener());
		button1.setPreferredSize(new Dimension(300, 30));
		JButton button2= new JButton("Song B (Stop It -- Instrumental)");
		button2.addActionListener(new SongBListener());
		button2.setPreferredSize(new Dimension(300, 30));
		JButton button3= new JButton("Song A (Wordkill -- Instrumental)");
		button3.addActionListener(new SongCListener());
		button3.setPreferredSize(new Dimension(300, 30));
		JButton button4= new JButton("Go Back");
		button4.addActionListener(new BackListener());
		button4.setPreferredSize(new Dimension(300, 30));
		
		if ("customdance.ser" != null){
			JButton button5 = new JButton("Your Song");
			button5.addActionListener(new SongDListener());
			button5.setPrefferedSize(new Dimension(300, 30));
			panel5A.add(button5, BorderLayout.NORTH);
		}
		
		panel3A.add(button1, BorderLayout.NORTH);
		panel2A.add(button2, BorderLayout.NORTH);
		panelA.add(button3, BorderLayout.NORTH);
		panel4A.add(button4, BorderLayout.SOUTH); 
		
		//ImageIcon displaying title
		ImageIcon image = new ImageIcon(this.getClass().getResource("danceoff selectasong.png"));
		songSelection = new JLabel(image);
		add(songSelection, BorderLayout.NORTH);
	}
	/** SongA Listener for Selection Screen*/
	private class SongAListener implements ActionListener {
		/** Calls method to show difficulty selection screen;
		Passes int signifying the selected song (Song A)*/
		public void actionPerformed(ActionEvent a) {
			Danceoff.setSong(-1);
			Danceoff.difficultySelect();

		}
	}
	/** SongB Listener for Selection Screen*/
	private class SongBListener implements ActionListener {
		/**Calls method to show difficulty selection screen;
		Passes int signifying the selected song (Song B)*/
		public void actionPerformed(ActionEvent b) {
			Danceoff.setSong(0);
			Danceoff.difficultySelect();

		}
	}
	/** SongC Listener for Selection Screen*/
	private class SongCListener implements ActionListener {
		/**Calls method to show difficulty selection screen;
		Passes int signifying the selected song (Song C)*/
		public void actionPerformed(ActionEvent c) {
			Danceoff.setSong(1);
			Danceoff.difficultySelect();

		}
	}
	/** SongD Listener for Selection Screen*/
	private class SongDListener implements ActionListener {
		/**Calls method to show difficulty selection screen;
		Passes int signifying the selected song (Song C)*/
		public void actionPerformed(ActionEvent d) {
			Danceoff.setSong(2);
			Danceoff.gamePlayStart();
		}
	}
	/** Back Listener for Selection Screen*/
	private class BackListener implements ActionListener {
		/** Calls method to display title screen*/
		public void actionPerformed(ActionEvent d) {
			Danceoff.displayTitleScreen();
		}
	}
}
