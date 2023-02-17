package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Alien {
	private int x, y;
	private int vx, vy;
	private Image img;
	private AffineTransform tx;
	private int newV = 0;
	String difficulty = "";
	public Alien() {
		img = getImage("/imgs/alien.png"); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); // initialize the location of the image
					// use your variables
		x = 20;
		y = 200;

	}

	public Alien(String fileName) {
		img = getImage("/imgs/" + fileName); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); // initialize the location of the image
					// use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
Graphics2D g2 = (Graphics2D) g;
		
		
		if(y>=600) {
			setVXY(difficulty);
			reset();
			
		}
		if (y <= 100 || y >= 580) {
			
			if(vy!=15) {
			vy = -vy;
			}
		}
		
		if (x < 0 || x > 1100) {
			
			vx = -vx;
		}
		
		
		
		
		
		x += vx;
		y += vy;
		update();
		g2.drawImage(img, tx, null);
		g.setColor(new Color(0,0,0));
	}

	public void setNewV(int grabbed) {
		newV=(grabbed+1)*2;
	}
	
	private void update() {
		tx.setToTranslation(x, y);
	}
	public void reset() {
		x = (int)(Math.random() * 751);
		y = 200;
	}
	

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Alien.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setVXY(String diff) {
		if(diff=="easy") {
			vx=5;
			vy=5;
			difficulty = "easy";
		}else if(diff=="medium") {
			vx=10;
			vy=10;
			difficulty = "medium";
		}else if(diff=="hard") {
			vx=16;
			vy=16;
			difficulty = "hard";
		}
	}
	public void pause(boolean ifGame) {
		if(ifGame) {
			vx=0;
			vy=0;
		}
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getVX() {
		return vx;
	}
	public void setVX(int setter) {
		vx = setter;
	}
	public boolean hit(MouseEvent mouse) {
		
		//represent the mouse as a rectangle
		
		Rectangle m = new Rectangle(mouse.getX(),mouse.getY(), 25, 25);
		
		
		//Duck hit box
		
		Rectangle d = new Rectangle(x+20,y,80,140);
		//Rectangle d2 = new Rectangle(x+20,y,75,75);
		
		
		if(m.intersects(d)) {
			vx=0;
			vy=15;
			//System.out.println("HIT");
			return true;
		}
		
		
		return false;
	}
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
