import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements MouseListener, ActionListener {
	JFrame menuFrame = new JFrame("HERO?");
	BufferedImage gameImage;

	public void start() {
		try {
			gameImage = ImageIO.read(Game.class.getResourceAsStream("menuArt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuFrame.setSize(601, 601);
		menuFrame.setVisible(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.add(this);
		menuFrame.validate();
		menuFrame.repaint();
		
		this.setLayout(null);
		this.addMouseListener(this);
	}

	Font backFont = new Font("Arial", Font.PLAIN, 12);

	public void paint(Graphics g) {
			g.drawImage(gameImage, 0, 0, 601, 601, null);
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
		repaint();
	}

}