package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;

public class Driver extends JPanel implements ActionListener, MouseListener, KeyListener  {
	
	
	boolean start = true;
	boolean option = false;
	public boolean game = false;
	public boolean pause = false;
	String difficulty = "easy";
	Background bckg = new Background();
	StartMenu m = new StartMenu();
	Button b1 = new Button(1);
	Button b2 = new Button(2);
	Button b3 = new Button(3);
	Button s1 = new Button(4);
	Character c = new Character();
	Boom e = new Boom();
	Alien a = new Alien();
	int score = 0;
	public void paint(Graphics g) {
		super.paintComponent(g);
		bckg.paint(g);
		m.paint(g);
		b1.paint(g, 1);
		b2.paint(g, 2);
		b3.paint(g, 3);
		e.paint(g);
		if(game) {
			c.paint(g);
			a.paint(g);
			s1.changePicture("settings icon.png");
			s1.updateSettings();
			s1.paint(g,4);
			Font plainFont = new Font("SanSerif", Font.PLAIN, 60);
			g.setFont(plainFont);
			g.setColor(new Color(Color.white.getBlue()));
			g.drawString("Score: "+score, 0, 800);
		}
		
		//Font gameEndFont = new Font("SansSerif", Font.PLAIN,60);
		//Font restartFont = new Font("SansSerif", Font.PLAIN,25);
		
	}

	public static void main(String[] arg) {
		Driver f = new Driver();
		
	}

	public Driver() {
		
		JFrame f = new JFrame("IDK Yet");
		f.setSize(new Dimension(1200, 900));
		f.setBackground(new Color(0, 0, 0));
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1, 2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		BufferedImage cursorImg;
		try {
					cursorImg =  ImageIO.read(new File("crosshair img.png"));
					Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
						    cursorImg, new Point(0, 0), "blank cursor");
					f.getContentPane().setCursor(blankCursor);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		

		
	}
	
public boolean hit(MouseEvent mouse) {
		
		//represent the mouse as a rectangle
		
		Rectangle m = new Rectangle(mouse.getX(),mouse.getY(), 35, 35);
		
		
		//Duck hit box
		
		Rectangle d = new Rectangle(0,0,1200,900);
		//Rectangle d2 = new Rectangle(x+20,y,75,75);
		
		if(m.intersects(d)) {
			//System.out.println("HIT");
			return true;
		}
	
		
		return false;
	}
	
	
	
	public boolean gameStatus() {
		return game;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if((start==false&&option==false)&&e.hit(arg0)) {
			
			e.update();
		}
		
		if(pause==false) {
			if(a.hit(arg0)) {
			score++;
		}
		}
		
		if(b1.hit(arg0, 1)) {
			//System.out.println("Button 1");
			if(start==true) {
				m.leave();
				b1.update(0);
				b2.update(0);
				b3.update(0);
				a.setVXY(difficulty);
				start=false;
				game=true;
				pause = false;
			}else if(option==true) {
				m.changePicture("lighter StartMenu.png");
				bckg.changePicture("daytimeBackground.png");
				difficulty = "easy";
				start=true;
				option=false;
			}
			
		}
		if(b2.hit(arg0,2)) {
			//System.out.println("Button 2");
			//System.out.println("Start "+start);
			//System.out.println("Option "+option);
			if(start==true) {
				m.changePicture("lighter Difficulty Menu.png");
				option=true;
				start=false;
			}else if(option==true) {
				m.changePicture("lighter StartMenu.png");
				bckg.changePicture("UPDATED afternoonBackground.png");
				difficulty = "medium";
				start=true;
				option=false;
			}
			
			
			
		}
		
		if(b3.hit(arg0, 3)) {
			//System.out.println("Button 3");
			//System.out.println("Start "+start);
			//System.out.println("Option "+option);
			if(start==true) {
				System.exit(0);
			}else if(option==true) {
				m.changePicture("lighter StartMenu.png");
				bckg.changePicture("nighttimeBackground.png");
				difficulty = "hard";
				start=true;
				option=false;
			}
			
			
		}
		
		if(s1.hit(arg0,4)) {
			System.out.println("settings worked");
			pause = true;
			start = true;
			a.pause(pause);
			b1.update(1);
			b2.update(2);
			b3.update(3);
			m.changePicture("lighter StartMenu.png");
			m.update();
		}
			
				
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg32) {
		// TODO Auto-generated method stub
		
		System.out.println(arg32.getKeyCode());
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
