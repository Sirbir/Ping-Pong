
package ping.pong;

// QUESTIONS 



//IMPORTS
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;


@SuppressWarnings("serial")
public class PingPong extends JPanel {

    /**
     * @param args the command line arguments
     */
    
    
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    SecondRacquet racquetTwo = new SecondRacquet(this);

    
    public PingPong() {
        addKeyListener(new KeyListener() {
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
                
            racquet.keyReleased(e);
            racquetTwo.keyReleased(e);
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
                
            racquet.keyPressed(e);
            racquetTwo.keyPressed(e);
            
        }
        });
        setFocusable(true);

        }

        private void move() {
            
            ball.move();
            racquet.move();
            racquetTwo.move();
        }
    
   
        @Override
	public void paint(Graphics g) {
            
            super.paint(g);
            setBackground(Color.BLACK);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ball.paint(g2d);
            racquet.paint(g2d);
            racquetTwo.paint(g2d);
	
        }    
        
        public void gameOver() {
            
            JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
            System.exit(ABORT);
	
        }
       
        
    
    
    
    
    public static void main(String[] args) throws InterruptedException { 
        // TODO code application logic here
        
        PingPong game = new PingPong();
        
        JFrame frame = new JFrame("Mini Tennis");

        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {

            game.move();
            game.repaint();
            
            Thread.sleep(10);
        }
    }
        
           
}
        

    

