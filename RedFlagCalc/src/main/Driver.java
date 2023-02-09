package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
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

public class Driver extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	
	boolean start = true;
	boolean option = false;
	public boolean game = false;
	Background bckg = new Background();
	StartMenu m = new StartMenu();
	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		bckg.paint(g);
		m.paint(g);
		b1.paint(g, 1);
		b2.paint(g, 2);
		b3.paint(g, 3);
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
			
		if(b1.hit(arg0, 1)) {
			System.out.println("Button 1");
			if(start==true) {
				m.leave();
				start=false;
			}else if(option==true) {
				m.changePicture("FIXED Start Menu.png");
				start=true;
				option=false;
			}
			
		}
		if(b2.hit(arg0,2)) {
			System.out.println("Button 2");
			System.out.println("Start "+start);
			System.out.println("Option "+option);
			if(start==true) {
				m.changePicture("Difficulty Menu.png");
				option=true;
				start=false;
			}else if(option==true) {
				m.changePicture("FIXED Start Menu.png");
				start=true;
				option=false;
			}
			
			
			
		}
		
		if(b3.hit(arg0, 3)) {
			System.out.println("Button 3");
			System.out.println("Start "+start);
			System.out.println("Option "+option);
			if(start==true) {
				System.exit(0);
			}else if(option==true) {
				m.changePicture("FIXED Start Menu.png");
				start=true;
				option=false;
			}
			
			
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
