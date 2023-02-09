package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class StartMenu {
	private int x, y;
	private Image img;
	private AffineTransform tx;

	public StartMenu() {
		img = getImage("/imgs/FIXED Start Menu.png"); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(400, 100); // initialize the location of the image
					// use your variables

		

	}

	public StartMenu(String fileName) {
		img = getImage("/imgs/" + fileName); // load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y);
		init(400, 100); // initialize the location of the image
					// use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage("/imgs/" + newFileName);
		init(400, 100);
	}

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}

	private void update() {
		tx.setToTranslation(4000, 1000);
		tx.scale(1, 1);
	}
	public void leave() {
		update();
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = StartMenu.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
