package mjGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player extends Circle {

	//Player circle variables
	private int score;
	
	Player(int radiusC, Color custom)
	{
		this.setRadius(radiusC);
		this.setFill(custom);
		this.setStroke(Color.BLACK);
		this.score=0;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public void setScore(int newScore)
	{
		this.score=newScore;
	}
	

	
	
}
