package mjGame;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Boulder extends Circle {

	//Boulder circle variables
	private int scoreValue;
	private TranslateTransition boulderTransition;
	
	
	
	Boulder(int radius, Color custom, int pointValue)
	{
		this.setRadius(radius);
		this.setFill(custom);
		this.setScoreValue(pointValue);
		this.setStroke(Color.BLACK);
		boulderTransition = new TranslateTransition(Duration.millis(2500), this);
		boulderTransition.setByY(500);
		boulderTransition.setCycleCount(1);
		
		
	}
	
	public void playAnimation()
	{
		boulderTransition.play();
	}
	
	public void stopAnimation()
	{
		boulderTransition.stop();
	}
	
	public TranslateTransition getTranslateTransition()
	{
		return this.boulderTransition;
	}
	
	
	public int getScoreValue()
	{
		return this.scoreValue;
	}
	
	public void setScoreValue(int value)
	{
		this.scoreValue = value; 
	}
	
	

	
}
