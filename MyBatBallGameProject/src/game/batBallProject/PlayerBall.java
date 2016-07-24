package game.batBallProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class PlayerBall {
	private int x, y;
	private int dx =4;
	private int dy =4;
	private static final int diam = 15;
	 GamePanel gp;
	
	public PlayerBall(int x, int y, GamePanel g) {
		this.x =x;
		this.y =y;
		gp =g;
		
		

	}
	
	protected void draw(Graphics2D g2){
		
		g2.setColor(Color.yellow);
		g2.fillOval(this.x, this.y, diam, diam);
       
		
		redraw();	
	}
	
	protected void redraw(){
		if (x + dx < 0){
			dx=4;
		}
		else	if (x + dx > gp.getWidth() - diam){
			dx = -4;}
		
		else if (y + dy < 0){
			dy = 4;}
		
		else if (y + dy > gp.getHeight() - diam){
			dy=-0;
			dx =0;
			gp.gameOver();
			}
        checkcollision();
		x = x + dx;
		y = y + dy;
		
	}
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, diam, diam);
	}
	
	public void checkcollision(){
		if(this.getBounds().intersects(gp.plbat.getBounds())){
			dx =-4;
			dy =-4;
		}
		else
		{return;
		}
	}
}
