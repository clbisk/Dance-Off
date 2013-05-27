//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;


/**panel to display dance queues for gameplay -- located to west of the gameplay panel*/
public class DanceQueuePanel extends JPanel {
	//private variables
	/**an array of Arrow objects that will serve to store the coordinates of future arrows drawn on screen*/
	private static ArrayList<Arrow> arrows;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer timer;
	/**variable to store the lowest x-coordinate of the box where keys are considered "on time"*/
	private int boxXMin = 50;
	/**variable to store the highest x-coordinate of the box where keys are considered "on time"*/
	private int boxXMax = 170;
	/**variable to store the lowest y-coordinate of the box where keys are considered "on time"*/
	private int boxYMin = 0;
	/**variable to store the highest y-coordinate of the box where keys are considered "on time"*/
	private int boxYMax = 600;
	/**constructor*/
	public DanceQueuePanel() {
		//flow layout
		//uses buffer to draw arrows based on queues in an array
		addKeyListener(new ArrowPressed());
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		//  InputMap im = getInputMap();  
//         ActionMap am = getActionMap();  
  
        // Action action = new SimpleAction("Left");  
//         Object key = action.getValue(Action.NAME);  
//         KeyStroke keyStroke = KeyStroke.getKeyStroke("LEFT");  
//         im.put(keyStroke, key);  
//         am.put(key, action);  
//   
//         action = new SimpleAction("Right");  
//         key = action.getValue(Action.NAME);  
//         keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);  
//         im.put(keyStroke, key);  
//         am.put(key, action);
		  
		  Action upAction = new Action() {
		  	public void actionPerformed(ActionEvent event) {
				System.out.println(event.toString());
			}
			public void addPropertyChangeListener(PropertyChangeListener listener) {
			}
			public void removePropertyChangeListener(PropertyChangeListener listener) {
			}
		  };
		  
		  getInputMap().put(KeyStroke.getKeyStroke("UP_ARROW"), "doMyUpArrowness");
		  getActionMap().put("doMyUpArrowness", upAction);

	}
	
	//methods
	/**getter for private array arrows*/
	private static Arrow[] getArrows() {
		Arrow[] a = arrows.toArray(new Arrow[arrows.size()]);
		return a;
	}
	/**getter for element of private array arrows*/
	private static Arrow getArrow(int arrowPos) {
		Arrow[] a = arrows.toArray(new Arrow[arrows.size()]);
		return a[arrowPos];
	}
	/**listener to redraw panel according to timer*/
	private class Listener implements ActionListener {
  		/**redraws panel*/ 	
		public void actionPerformed(ActionEvent e) {
			//clears buffer and move all arrows
			//repaint();
		}
	}
	public boolean isFocusTraversable() {
		return true;
   }
	/**listener for right arrow key*/
	//private class rightArrowPressed extends KeyAdapter {
		/**handles scoring for right arrow dance queues*/
		//public void keyPressed(KeyEvent e) {
			//int key = e.getKeyCode();
			//System.out.println("right arrow pressed");
			//if (key == KeyEvent.VK_RIGHT) {
				//checks if right arrow dance queue is being shown inside
				//Arrow[] a = arrows.toArray(new Arrow[arrows.size()]);
				//for (int i = 0; i < a.length; i ++) {
					//if (a[i] instanceof RightArrow) {
						//if ((a[i].getYPos()+100 > boxYMin && a[i].getYPos() < boxYMax) && (a[i].getXPos() > boxXMin && a[i].getXPos() < boxXMax)) {
							//if so, remove right arrow image from panel and add points to score
						//}
					//}
				//}
			//}			
		//}
	//}
	private class ArrowPressed extends KeyAdapter{
       public void keyPressed(KeyEvent e){
         if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            System.out.print("right"); 
         if(e.getKeyCode()== KeyEvent.VK_LEFT)
            System.out.print("left");
         if(e.getKeyCode()== KeyEvent.VK_UP)
            System.out.print("up");
         if(e.getKeyCode()== KeyEvent.VK_DOWN)
            System.out.print("down");
      }
       public void keyReleased(KeyEvent e){
      }
       public void keyTyped(KeyEvent e){
      }
   }
}