   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;

    //public class keyTest2{
 /**  
    class Panel extends JPanel {
       Panel(){
         super();
         addKeyListener(new ArrowPressed());
         
      }
         
       public boolean isFocusTraversable(){
         return true;
      }
      
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
   */
      
    public class Frame extends JFrame {
      Panel panely = new Panel();
       Frame(){
               //Panel panely = new Panel();
         getContentPane().add(panely);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(500,500,100,100);
         pack();
         show();
           
      }
         
       public static void main(String[] args){
         new Frame();
               //Frame.setVisible(true);
      }
         
   }

    class Panel extends JPanel {
       Panel(){
         super();
         addKeyListener(new ArrowPressed());
         
      }
         
       public boolean isFocusTraversable(){
         return true;
      }
      
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