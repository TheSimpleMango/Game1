import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class Paddle{
	int paddleX;
	int paddleY;
	int paddleWidth;
	int paddleHeight;
	String imageName;
	BufferedImage paddleImage;
	public Paddle(){}
	public Paddle(int paddleX, int paddleY, int paddleWidth, int paddleHeight, String imageName){
		this.paddleX = paddleX;
		this.paddleY = paddleY;
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;
		this.imageName = imageName;
		
		try {
			paddleImage = ImageIO.read(Game.class.getResourceAsStream(imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void up(){
		System.out.println("asdf");
		paddleY-=5;
	}
	public void down(){
		paddleY+=5;
	}
	public void left(){
		paddleX-=5;
	}
	public void right(){
		paddleX+=5;
	}
	public void update(){
		
	}
	public void draw(Graphics g){
		g.drawImage(paddleImage, paddleX, paddleY, paddleWidth, paddleHeight, null);
	}
}