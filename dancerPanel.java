//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class dancerPanel extends JPanel {
	
	//private variables
	private BufferedImage myImage;
	private Timer timer;
	private JLabel dancer;
	public dancerPanel() {
		
		setLayout(new FlowLayout());
		setSize(300, 450);

		ImageIcon position = new ImageIcon("relaxedPos.png");
		JLabel dancer = new JLabel(position);
		add(dancer);
			
		//displays "dancing" avatar
		//flow layout
		//uses buffer to draw dancer's position based on last key pressed
	}
	
		
	//listeners for key presses
	private class rightArrowPressed implements KeyListener {
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		 	
			 	ImageIcon position = new ImageIcon("rightPos.png");
				dancer.setIcon(position);
 				System.out.println("Right");   
			}

			
			//ImageIcon position = new ImageIcon("rightPos.png");
			//dancer.setIcon(position);
			
			//switches appearance of avatar to stepping right
		}
		public void keyReleased(KeyEvent e) {
			//doesn't do anything...
		}
		public void keyTyped(KeyEvent e) {
			//doesn't do anything...
		}
	}
	private class leftArrowPressed implements KeyListener {
		public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
   	   	
			 	ImageIcon position = new ImageIcon("leftPos.png");
				dancer.setIcon(position);
				System.out.println("Left"); 
   		 }
		
		//ImageIcon position = new ImageIcon("leftPos.png");
		//dancer.setIcon(position);
			
			//switches appearance of avatar to stepping left
		}
		public void keyReleased(KeyEvent e) {
			//doesn't do anything...
		}
		public void keyTyped(KeyEvent e) {
			//doesn't do anything...
		}
	}
	private class upArrowPressed implements KeyListener {
		public void keyPressed(KeyEvent e) {

			 if (e.getKeyCode() == KeyEvent.VK_UP) {
    			
				ImageIcon position = new ImageIcon("upPos.png");
				dancer.setIcon(position);
				System.out.println("Up"); 
   		 }


		//ImageIcon position = new ImageIcon("upPos.png");
		//dancer.setIcon(position);
		
			//switches appearance of avatar to stepping up
		}
		public void keyReleased(KeyEvent e) {
			//doesn't do anything...
		}
		public void keyTyped(KeyEvent e) {
			//doesn't do anything...
		}
	}
	private class downArrowPressed implements KeyListener {
		public void keyPressed(KeyEvent e) {
		
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      	
			ImageIcon position = new ImageIcon("downPos.png");
			dancer.setIcon(position);
 			System.out.println("Down");  
	 		}
		
		//ImageIcon position = new ImageIcon("downPos.png");
		//dancer.setIcon(position);
		
			//switches appearance of avatar to stepping down
		}
		public void keyReleased(KeyEvent e) {
			//doesn't do anything...
		}
		public void keyTyped(KeyEvent e) {
			//doesn't do anything...
		}
	}
}