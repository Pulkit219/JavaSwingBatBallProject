package game.batBallProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player plbat;
	PlayerBall plball;
	Timer ti;
	Graphics2D g2;
	private BufferedImage buffer;
	private int getkey;
	private int speed = 4;
public GamePanel() {
	plbat = new Player(200,450, this);
	 plball= new PlayerBall(400,10,this);
	
	ti = new Timer(17, this);
	setPreferredSize(new Dimension(600,500));
	setFocusable(true);
	addKeyListener(this);
	ti.start();
	
	
}




@Override
	public void paintComponent(Graphics g) {
	
	 g2 = (Graphics2D)g;
	
	g2.setColor(Color.black);
	g2.fillRect(0, 0, 600, 500);
		
	plbat.draw(g2);
	plball.draw(g2);
	
}

@Override
public void update(Graphics g2) {
	
	if(buffer == null) {
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
}
	
	 g2 = (Graphics2D)buffer.getGraphics();

	



((Graphics2D) g2).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	
	        
	       g2.drawImage(buffer, 0, 0, null);
	        
		
		repaint();
	}




@Override
public void actionPerformed(ActionEvent arg0) {
	
update(g2);


	}




@Override
public void keyPressed(KeyEvent e) {
	
	 getkey = e.getKeyCode();
	if(getkey == KeyEvent.VK_RIGHT){
		plbat.setdxright(5*speed);
		
	}
	
	else if(getkey == KeyEvent.VK_LEFT){
		plbat.setdxleft(5*(speed));
		
	}


}



@Override
public void keyReleased(KeyEvent e) {
	plbat.setdxright(0);
	plbat.setdxleft(0);

	
}

@Override
public void keyTyped(KeyEvent e) {

	
}
public void gameOver() {
	JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
}

}

