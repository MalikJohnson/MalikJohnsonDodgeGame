package mjDodgeGame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import javafx.scene.shape.*;

public class DodgeGame {
	//Number of levels in game
	private int levelCount;
	//Amount of life left for player
	private int lifeCount;
	//Array of circles that contains the boulders the player will try to hit in game
	private Circle boulder[];
	//Main scene
	Scene scene;
	//Player circle object. The circle that is controlled
	private Circle player;
	//The score of the game
	private double score;
	//Player circle variables
	private int dx = 50;
    private int dy = 50;
    private int radius = 125;
	//Main pane
    private Pane pane;
    
    //For randomly generating the boulders across the scene
    private Random random;
    private int randomNumber;
    private double rx = 1, ry = 3;
    //Animations for the 10 boulders
    private Timeline animationOne;
    private Timeline animationTwo;
    private Timeline animationThree;
    private Timeline animationFour;
    private Timeline animationFive;
    private Timeline animationSix;
    private Timeline animationSeven;
    private Timeline animationEight;
    private Timeline animationNine;
    private Timeline animationTen;
    
   
    
	DodgeGame(int level, int life)
	{
		levelCount=level;
		lifeCount=life;
		boulder = new Circle[100];
		//Creates the player and sets the color
		player = new Circle(radius,dx,dy);
		player.setFill(Color.BLACK);
        player.setStroke(Color.BLACK);
        pane = new Pane();
        pane.getChildren().addAll(player);
        //Player starting position
        player.setCenterY(347);
        player.setCenterX(49);
        //Creating the main scene
        scene = new Scene(pane, 400, 400);
        //Colors the boulders and sets thier radius
        this.fillboulder();
        
		 //Drop the 10 boulders 1 by 1 each second. Each boulder is dropped in a strait line down
		 TranslateTransition boulderZero = new TranslateTransition(Duration.millis(2500), boulder[0]);
		 boulderZero.setByY(500);
		 boulderZero.setCycleCount(1);
		 boulderZero.play();
		    
		    
		 TranslateTransition boulderOne = new TranslateTransition(Duration.millis(2500), boulder[1]);
		 boulderOne.setByY(500);
		 boulderOne.setCycleCount(1);
		 boulderOne.setDelay(Duration.seconds(2));
		 boulderOne.play();
		 
		 TranslateTransition boulderTwo = new TranslateTransition(Duration.millis(2500), boulder[2]);
		 boulderTwo.setByY(500);
		 boulderTwo.setCycleCount(1);
		 boulderTwo.setDelay(Duration.seconds(3));
		 boulderTwo.play();
		 
		 TranslateTransition boulderThree = new TranslateTransition(Duration.millis(2500), boulder[3]);
		 boulderThree.setByY(500);
		 boulderThree.setCycleCount(1);
		 boulderThree.setDelay(Duration.seconds(4));
		 boulderThree.play();
		 
		 TranslateTransition boulderFour = new TranslateTransition(Duration.millis(2500), boulder[4]);
		 boulderFour.setByY(500);
		 boulderFour.setCycleCount(1);
		 boulderFour.setDelay(Duration.seconds(5));
		 boulderFour.play();
		 
		 TranslateTransition boulderFive = new TranslateTransition(Duration.millis(2500), boulder[5]);
		 boulderFive.setByY(500);
		 boulderFive.setCycleCount(1);
		 boulderFive.setDelay(Duration.seconds(6));
		 boulderFive.play();
		 
		 TranslateTransition boulderSix = new TranslateTransition(Duration.millis(2500), boulder[6]);
		 boulderSix.setByY(500);
		 boulderSix.setCycleCount(1);
		 boulderSix.setDelay(Duration.seconds(7));
		 boulderSix.play();
		 
		 TranslateTransition boulderSeven = new TranslateTransition(Duration.millis(2500), boulder[7]);
		 boulderSeven.setByY(500);
		 boulderSeven.setCycleCount(1);
		 boulderSeven.setDelay(Duration.seconds(8));
		 boulderSeven.play();
		 
		 TranslateTransition boulderEight = new TranslateTransition(Duration.millis(2500), boulder[8]);
		 boulderEight.setByY(500);
		 boulderEight.setCycleCount(1);
		 boulderEight.setDelay(Duration.seconds(9));
		 boulderEight.play();
		 
		 TranslateTransition boulderNine = new TranslateTransition(Duration.millis(2500), boulder[9]);
		 boulderNine.setByY(500);
		 boulderNine.setCycleCount(1);
		 boulderNine.setDelay(Duration.seconds(10));
		 boulderNine.play();
	
	}
	
	
	
	public void dropboulder(int a)
	{
	
		if(boulder[a].getCenterY()<this.getPane().getHeight()+radius)
		{
			//Adjust ball position
			dy += ry;
			boulder[a].setCenterY(dy);
		}
	    
		
	
		
	}
	
	//Sets the level count of the game
	public void setLevel(int level)
	{
		levelCount = level;
	}
    //Sets the life count of the player
	public void setLife(int life)
	{
		lifeCount = life;
	}
	//Gets the level number
	public int getLevel()
	{
		return levelCount;
	}
	//Gets the score of the player
	public double getScore()
	{
		return score;
	}
	//Sets the score of the player
	public void setScore(double newScore)
	{
		score = newScore;
	}
	//Gets the life count of the player
	public int getLife()
	{
		return lifeCount;
	}
	//Gets the player object
	public Circle getPlayer()
	{
		return player;
	}
	//Gets the boulder array. The boulders are the circles that are dropped each second and colored blue.
	public Circle [] getboulder()
	{
		return boulder;
	}
	//Returns the main scene
	public Scene getScene()
	{
		return scene;
	}
	//Populates the boulder array with 
	public void fillboulder()
	{
		for(int a=0; a<100; a++)
		{
			boulder[a] = new Circle(radius,dx,dy);
			boulder[a].setFill(Color.BLUE);
			boulder[a].setStroke(Color.BLACK);
		}
		
	}
	//Returns the main pane
	public Pane getPane(){
		return pane;
	}
	

	//Adds ten boulders to the pane in randomly generated locations on the x coordinate
	public void addboulders(Pane test)
	{
		    
		    for(int a=0; a<10; a++)
		    {
		    	int randomNum = ThreadLocalRandom.current().nextInt(0, 400 + 1);
		    	boulder[a].setCenterY(-20);
		    	boulder[a].setCenterX(randomNum);
		    	test.getChildren().add(boulder[a]);
		    }
	
	}
	


}
