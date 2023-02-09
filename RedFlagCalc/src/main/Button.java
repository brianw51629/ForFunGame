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

public class Button {
	private int x, y;
	private Image img;
	private AffineTransform tx;
	public boolean playGame;
	
	
	
	
	
	public Button(int num) {
		img = getImage("/imgs/lighter button.png"); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		//init(x, y); // initialize the location of the image
					// use your variables
		if(num==1) {
			init(500, 200);
		}
		if(num==2) {
			init(500, 285);
		}
		if(num==3) {
			init(500, 370);
		}
		if(num==4) {
			init(0,0);
		}
		

	}

	public Button(String fileName) {
		img = getImage("/imgs/" + fileName); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); // initialize the location of the image
					// use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage("/imgs/"+newFileName);
		init(x, y);
	}

	public void paint(Graphics g, int num) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		//System.out.println(num);
		g2.drawImage(img, tx, null);
		
	}

	public void update() {
		init(5000,5000);
	}
	public void updateSettings() {
		tx.scale(0.5,0.5);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Button.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public boolean hit(MouseEvent mouse,int num) {
		
		//represent the mouse as a rectangle
		if(num==1) {
			x=500;
			y=200;
		}
		if(num==2) {
			x=500;
			y=285;
		}
		if(num==3) {
			x=500;
			y=370;
		}
		Rectangle m = new Rectangle(mouse.getX(),mouse.getY(), 35, 35);
		
		
		//Duck hit box
		
		Rectangle d = new Rectangle(x+25,y+25,60,40);
		//Rectangle d2 = new Rectangle(x+20,y,75,75);
		
		if(m.intersects(d)) {
			System.out.println("HIT");
			return true;
		}
	
		
		return false;
	}
	public void leave() {
	tx.setToTranslation(10000,10000);
	}

}
