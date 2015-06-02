import java.awt.Graphics;

public class Ball {
	int ballX;
	int ballY;
	int ballWidth;
	int ballHeight;
	int ballSpeed;
	public Ball(){}
	public Ball(int ballX, int ballY, int ballWidth, int ballHeight, int ballSpeed){
		this.ballX = ballX;
		this.ballY = ballY;
		this.ballWidth = ballWidth;
		this.ballHeight = ballHeight;
		this.ballSpeed = ballSpeed;
	}
	public void update(){
		
	}
	public void draw(Graphics g){
		g.fillOval(ballX, ballY, ballWidth, ballHeight);
	}
}
