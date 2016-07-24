package game.batBallProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

public class Player  {
private int x, y;
private  static final int width =100; 
private  static final int height =10; 

GamePanel gp;

	public Player(int x, int y, GamePanel g) {
		this.x =x;
		this.y =y;
		gp = g;
		
	}
	
	


protected void draw(Graphics2D g2){
	
	
	g2.setColor(Color.red);
	g2.fillRoundRect(x, y, width, height, 10, 10);
	
		
	}
	
public void setdxright(int i){
	x=x + i;
	if(x + width > gp.getWidth()){
		x =gp.getWidth()- width;
	}
}
public void setdxleft(int i){
	x=x - i;
	if(x + width < width){
		x =0;
	}
	
}
public Rectangle getBounds() {
	return new Rectangle(this.x, this.y, width, height);
}


}
	
