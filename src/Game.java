import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements MouseListener, ActionListener, KeyListener {
	JFrame menuFrame = new JFrame("HERO?");
	BufferedImage gameImage;
	Ball ball;
	Paddle trampoline;
	Paddle cloud;
	Paddle turtle;
	Paddle bunny;
	boolean w;
	boolean s;
	boolean a;
	boolean d;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	public void start() {
		try {
			gameImage = ImageIO.read(Game.class.getResourceAsStream("image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		w = false;
		
		ball = new Ball(0,0,25,25,15);
		trampoline = new Paddle(250,528,75,25,"trampoline.png");
		turtle = new Paddle(25,478,25,75,"turtle.png");
		cloud = new Paddle(250,50,75,25,"cloud.png");
		bunny = new Paddle(575,478,25,75,"umturtle.png");
		
		menuFrame.setSize(601, 601);
		menuFrame.setVisible(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.add(this);
		menuFrame.addKeyListener(this);
		menuFrame.validate();
		menuFrame.repaint();
		
		this.setLayout(null);
		this.addMouseListener(this);
	}
	
	public void keyCheck(){
		if(w){
			System.out.println("asdf");
			bunny.up();
		}
		if (s) {
			bunny.down();
		}
		if (a) {
			cloud.left();
		}
		if (d) {
			cloud.right();
		}
		if (up) {
			turtle.up();
		}
		if (down) {
			turtle.down();
		}
		if (left) {
			trampoline.left();
		}
		if (right) {
			trampoline.right();
		}
	}

	Font backFont = new Font("Arial", Font.PLAIN, 12);

	public void paint(Graphics g) {
			g.drawImage(gameImage, 0, 0, 601, 601, null);
			
			ball.draw(g);
			trampoline.draw(g);
			cloud.draw(g);
			turtle.draw(g);
			bunny.draw(g);
			
			g.setColor(Color.black);
			g.fillRect(10, 10, 40, 15);
			g.setColor(Color.white);
			g.setFont(backFont);
			g.drawString("<back", 10, 22);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		System.out.println(mX + ", " + mY);
		if (mX > 10 && mX < 50 && mY > 10 && mY < 25) {
			System.out.println("gameBackButton" + 10 + ", " + 10 + ", "
					+ 50 + ", " + 25);
			repaint();
			MainMenu newMenu = new MainMenu();
			newMenu.start();
			menuFrame.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("asdf");
		keyCheck();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_W) {
			System.out.println("bunny up");
			w = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_S) {
			System.out.println("bunny down");
			s = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_A) {
			System.out.println("cloud right");
			a = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_D) {
			System.out.println("cloud left");
			d = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("turtle up");
			up = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("turtle down");
			down = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("trampoline left");
			left = true;
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("trampoline right");
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_W) {
			w = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_S) {
			s = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_A) {
			a = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			d = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			up = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			down = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			right = false;
		}
	}

}