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

public class Boom {
	int x; 
	int y;
	private int vx, vy;
	private Image img;
	private AffineTransform tx;
	private int newV = 0;
	public Boom() {
		img = getImage("/imgs/boom img.png"); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(550, 500); // initialize the location of the image
					// use your variables

		tx.scale(0, 0);

	}

	public Boom(String fileName) {
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
		
		
		//update();
		g2.drawImage(img, tx, null);
		g.setColor(new Color(0,0,0));
		//g.drawRect(x+20,y,75,75);
		
	}

	
	
	
	public void reset() {
		
	}
	
	public void update() {
		
		tx.setToTranslation(x, y);
		
	}

	public void init(double a, double b) {
		System.out.println("BOOM");
		tx.setToTranslation(a, b);
		tx.scale(1,1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Boom.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
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
		
		Rectangle d = new Rectangle(0,0,1200,900);
		//Rectangle d2 = new Rectangle(x+20,y,75,75);
		
		if(m.intersects(d)) {
			//System.out.println("HIT");
			x=mouse.getX()-15;
			//System.out.println(x);
			y=mouse.getY()-30;
			//System.out.println(y);
			return true;
			
		}
	
		
		return false;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
