/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.pong;

/**
 *
 * @author Owner
 */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Racquet {
    
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    
    int x = 0;
    int xa = 0;
    
    private PingPong game;

    public Racquet(PingPong game) {

        this.game = game;

    }

    public void move() {

        if (x + xa > 0 && x + xa < game.getWidth() - 60)

        x = x + xa;
  }
  
    public void paint(Graphics2D g) {
        
          g.setColor(Color.WHITE);
          g.fillRect(x, Y, WIDTH, HEIGHT);

    }
  
    public void keyReleased(KeyEvent e) {

          xa = 0;

    }

    public void keyPressed(KeyEvent e) {

          if (e.getKeyCode() == KeyEvent.VK_LEFT)

              xa = -1;

          if (e.getKeyCode() == KeyEvent.VK_RIGHT)

              xa = 1;
    }


    public Rectangle getBounds() {
        
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    
    }
    
    
    public int getTopY() {
      
        return Y;
    
    }
    
}
