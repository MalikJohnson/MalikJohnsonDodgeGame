package mjGame;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class mjGame extends Application {
	
	private Scene scene;
	private Pane pane;
	private Boulder targets[];
	private Player mainCharacter;
	
	//score count variable. It is incremented by moving the player across the boulders.
    private static Integer PLAYERSCORE = 0;
    private Timeline timeline;
    private Label scoreLabel = new Label();
    //Binding updateScore to PLAYERSCORE
    private IntegerProperty updateScore =
            new SimpleIntegerProperty(PLAYERSCORE);
	

	public mjGame()
	{
		pane = new Pane();
		targets = new Boulder[10];
		scene = new Scene(pane, 400, 400);
		
		mainCharacter = new Player(50,Color.BLACK);
		mainCharacter.setCenterY(347);
		mainCharacter.setCenterX(49);
		pane.getChildren().add(mainCharacter);
		
		/*
		for(int a=0; a<10; a++)
		{
			targets[a] = new Boulder(50,Color.BLUE, 10);
		}
		*/
		
		//Manually assign colors and point values
		targets[0] = new Boulder(50, Color.BLUE, 3);
		targets[1] = new Boulder(50, Color.GREEN, 2);
		targets[2] = new Boulder(50, Color.RED, 1);
		targets[3] = new Boulder(50, Color.BLUE, 3);
		targets[4] = new Boulder(50, Color.GREEN, 2);
		targets[5] = new Boulder(50, Color.RED, 1);
		targets[6] = new Boulder(50, Color.BLUE, 3);
		targets[7] = new Boulder(50, Color.GREEN, 2);
		targets[8] = new Boulder(50, Color.RED, 1);
		targets[9] = new Boulder(50, Color.BLUE, 3);
		
		
		 for(int a=0; a<10; a++)
		    {
		    	int randomNum = ThreadLocalRandom.current().nextInt(0, 400 + 1);
		    	targets[a].setCenterY(-20);
		    	targets[a].setCenterX(randomNum);
		    	pane.getChildren().add(targets[a]);
		    }
		
	}
	
	public Player getPlayer()
	{
		return this.mainCharacter;
	}
	
	public Boulder[] getBoulders()
	{
		return this.targets;
	}
	
	public Scene getScene()
	{
		return this.scene;
	}
	
	public Pane getPane()
	{
		return this.pane;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		mjGame test = new mjGame();
		
		// Setup the Stage and the Scene (the scene graph)
        primaryStage.setTitle("FX Timer");
        Group root = new Group();
		
		// Configure the Label
        scoreLabel.setText(updateScore.toString());
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setStyle("-fx-font-size: 4em;");
        // Bind the timerLabel text property to the timeSeconds property
        scoreLabel.textProperty().bind(updateScore.asString());
	
        // Create and configure VBox
        // gap between components is 20
        VBox vb = new VBox(20);
        // center the components within VBox
        vb.setAlignment(Pos.CENTER);
        // Make it as wide as the application frame (scene)
        vb.setPrefWidth(test.getScene().getWidth());
        //vb.setPrefHeight(test.getScene().getHeight());
        // Move the VBox down a bit
        vb.setLayoutY(30);
        // Add the timerLabel to the VBox
        vb.getChildren().add(scoreLabel);
        // Add the VBox to the root component
        root.getChildren().add(vb);
        test.getPane().getChildren().add(root);
		
		
		
		//Timers for dropping each of the ten boulders
		Timer timer = new Timer();
		TimerTask dropBoulderOne = new TimerTask()
		{
		        public void run()
		        {
		        	test.getBoulders()[0].playAnimation();
		        }

		};
		
	    TimerTask dropBoulderTwo = new TimerTask()
	    		{
	    	    	public void run()
	    	    	{
	    	    		test.getBoulders()[1].playAnimation();
	    	    	}
	    		};
	    		
	    
	    		  TimerTask dropBoulderThree = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[2].playAnimation();
		    	    	}
		    		}; 	
		    		
		    		TimerTask dropBoulderFour = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[3].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderFive = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[4].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderSix = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[5].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderSeven = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[6].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderEight = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[7].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderNine = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[8].playAnimation();
		    	    	}
		    		};
		    		
		    		TimerTask dropBoulderTen = new TimerTask()
		    		{
		    	    	public void run()
		    	    	{
		    	    		test.getBoulders()[9].playAnimation();
		    	    	}
		    		};
	    
		//Schedule timer to drop a different boulder each second
		timer.schedule(dropBoulderOne,0l);
		timer.schedule(dropBoulderTwo, 1000l);
		timer.schedule(dropBoulderThree, 2000l);
		timer.schedule(dropBoulderFour, 3000l);
		timer.schedule(dropBoulderFive, 4000l);
		timer.schedule(dropBoulderSix, 5000l);
		timer.schedule(dropBoulderSeven, 6000l);
		timer.schedule(dropBoulderEight, 7000l);
		timer.schedule(dropBoulderNine, 8000l);
		timer.schedule(dropBoulderTen, 9000l);
		
		//Test left and right key presses. Increment the players x location by 10 left or right based on the key pressed. Also test for intersection on key press.
        test.getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
            /*
            case DOWN:
                circle.setCenterY(circle.getCenterY() + 10);
                break;
            case UP:
                circle.setCenterY(circle.getCenterY() - 10);
                break;
              */  
            case LEFT:
            	if(test.getPlayer().getCenterX()>54)
            	{
            		test.getPlayer().setCenterX(test.getPlayer().getCenterX()-10);
            		checkShapeIntersection(test.getPlayer(), test.getBoulders(), test);
            	}
                break;
            case RIGHT:
            	if(test.getPlayer().getCenterX()<350)
            	{
            		test.getPlayer().setCenterX(test.getPlayer().getCenterX() + 10);
            	checkShapeIntersection(test.getPlayer(), test.getBoulders(), test);
            	}
                break;
            }
        });
		
		
		
		
		primaryStage.setTitle("Dodge Game");
        primaryStage.setScene(test.getScene());
        primaryStage.show();
        test.getPlayer().requestFocus();
		
	}
	
	
	
	//Check for intersection between shapes.
		 private void checkShapeIntersection(Shape block, Circle [] nodes, mjGame testNode) {
			    boolean collisionDetected = false;
			    Boulder collisionBoulder = null;
			    for (Shape static_bloc : nodes) {
			      if (static_bloc != block) {
			       

			        Shape intersect = Shape.intersect(block, static_bloc);
			        if (intersect.getBoundsInLocal().getWidth() != -1) {
			        	 collisionDetected = true;
			        	 static_bloc.setLayoutX(300);
			        	 testNode.getPane().getChildren().remove(static_bloc);
			        	 collisionBoulder=(Boulder) static_bloc;
			        	 
			        }
			      }
			    }
			    if (collisionDetected) {
			        //If collision is detected change the color of the player to blue. Also increment the start time by 0.1 and round. Else set the player circle to black
			        block.setFill(Color.YELLOW);
			        PLAYERSCORE = PLAYERSCORE + collisionBoulder.getScoreValue();
			        updateScore.set(PLAYERSCORE);
			        
			      } else {
			        block.setFill(Color.BLACK);
			      }
			    }

}
