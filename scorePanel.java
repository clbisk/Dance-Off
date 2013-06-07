//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah, Joanna Gerr

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;

/** Description of class scorePanel */
   public class scorePanel extends JPanel {
   /** scorePanel has a label for score */
      public static JLabel score;
		/** socrePanel int for recording current score */
      public static int currentScore;
   /** Flow layout, with one JLabel displaying current score. JLabel is updated whenever more points are scored.*/ 
      public scorePanel() {
      
         setLayout(new FlowLayout());
         setSize(300, 300);
      	
			currentScore = 0;
         score = new JLabel();
         score.setFont(new	Font("Serif", Font.BOLD, 75));
         score.setForeground(Color.red);
			score.setText("" + currentScore);
         add(score);
      
         //setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,	3), "ScorePanel"));
      }
   
   /** Returns current score*/
      public static int getScore() {
         return currentScore;
      }
   /** Sets score to newScore */
      public static void setScore(int newScore) {
         currentScore = newScore;
			score.setText("" + newScore);
      }
   }
