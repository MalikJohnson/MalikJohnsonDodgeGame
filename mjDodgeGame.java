package mjDodgeGame;


import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class mjDodgeGame extends Application {

	
	//score count variable. It is incremented by moving the player across the boulders.
    private static Double STARTTIME = 0.0;
    private Timeline timeline;
    private Label timerLabel = new Label();
    //Binding timeSeconds to starttime
    private DoubleProperty timeSeconds =
            new SimpleDoubleProperty(STARTTIME);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
  		Application.launch(args);
  		
	}
	
	

	public void start(Stage primaryStage) {
	
		//Timer set to end the program after 14 seconds.
		Timer timer = new Timer();
		TimerTask task = new TimerTask()
		{
		        public void run()
		        {
		        	System.exit(0);
		        }

		};
		timer.schedule(task,14000l);
		
		DodgeGame test = new  DodgeGame(3, 3);
		test.addboulders(test.getPane());
		
		// Setup the Stage and the Scene (the scene graph)
        primaryStage.setTitle("FX Timer");
        Group root = new Group();
		
		// Configure the Label
        timerLabel.setText(timeSeconds.toString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
        // Bind the timerLabel text property to the timeSeconds property
        timerLabel.textProperty().bind(timeSeconds.asString());
	
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
        // Add the button and timerLabel to the VBox
        vb.getChildren().addAll(timerLabel);
        // Add the VBox to the root component
        root.getChildren().add(vb);
        test.getPane().getChildren().add(root);


        
	
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
            		checkShapeIntersection(test.getPlayer(), test.getboulder());
            	}
                break;
            case RIGHT:
            	if(test.getPlayer().getCenterX()<350)
            	{
            		test.getPlayer().setCenterX(test.getPlayer().getCenterX() + 10);
            		checkShapeIntersection(test.getPlayer(), test.getboulder());
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
	 private void checkShapeIntersection(Shape block, Circle [] nodes) {
		    boolean collisionDetected = false;
		    for (Shape static_bloc : nodes) {
		      if (static_bloc != block) {
		       

		        Shape intersect = Shape.intersect(block, static_bloc);
		        if (intersect.getBoundsInLocal().getWidth() != -1) {
		        	 collisionDetected = true;
		        }
		      }
		    }
		    if (collisionDetected) {
		        //If collision is detected change the color of the player to blue. Also increment the start time by 0.1 and round. Else set the player circle to black
		        block.setFill(Color.BLUE);
		        STARTTIME = STARTTIME + 0.1;
		        timeSeconds.set(Math.round(STARTTIME * 100.0) / 100.0);
		        
		      } else {
		        block.setFill(Color.BLACK);
		      }
		    }
	 
    
    }