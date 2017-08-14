
package ping.pong;

//IMPORTS
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class Ball {
    
    private static final int DIAMETER = 10;
   
    int x = 0; int y = 0;
    int xa = 1; int ya = 1;
    

    
    private PingPong game;

    public Ball(PingPong game) {
        
        this.game = game;
    }

    void move() {
        
        if (x + xa < 0)
                xa = 1;
        if (x + xa > game.getWidth() - DIAMETER)
                xa = -1;
        if (y + ya < 0)
                ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
                ya = -1;

        x = x + xa;
        y = y + ya;
        
        if (y + ya > game.getHeight() - DIAMETER || y + ya < 0)
                
            game.gameOver();
        
        if (bottomCollision()){
            
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
           
        }
        
        if (topCollision()){
            
            ya = 1;
            y = game.racquetTwo.getTopY();
           
        }
    }

    public void paint(Graphics2D g) {
                g.setColor(Color.WHITE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
    
    
    private boolean bottomCollision() {
        
        return game.racquet.getBounds().intersects(getBounds());
    
    }
    
   
    private boolean topCollision() {
        
        return game.racquetTwo.getBounds().intersects(getBounds());
    
    }
   
    
    public Rectangle getBounds() {
        
        return new Rectangle(x, y, DIAMETER, DIAMETER);
	
    }
}
