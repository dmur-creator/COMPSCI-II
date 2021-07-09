/////////////////////////////////////////////////////////
//
// Mike McFadden, Daniel Murphy, Alex Brewer, Ricardo Cadena, Bryce Greenleaf and Grady Rowedder
// CSC 161 Computer Science II
// March 5, 2021
// Final Project - Ball Bounce GUI
//
/////////////////////////////////////////////////////////

/** By Daniel: 
 * 
 * This final project encompasses all of the work of everyone
 * mentioned above. It is from Introduction to Java by Daniel Liang
 * listing 20.05 where the basic display ball program has been
 * added to so that balls collide and combine radius, the viewer
 * can be paused and resumed and you can click on a ball to remove it.
 * 
 * All comments by Mike will start with M- 
 * All comments by Daniel will start with D- 
 * All comments by Alex will start with A- 
 * All comments by Ricardo will start with R- 
 * All comments by Bryce will start with B- 
 * All comments by Grady will start with G- 
 * 
 * */

//Mikes general explanation:
/* 20.5 (Combine colliding bouncing balls)
The example in Section 20.8 displays multiple bouncing balls.
Extend the example to detect collisions. Once two balls collide,
remove the later ball that was added to the pane and add its radius to the other ball, as shown in Figure 20.17b .
Use the Suspend button to suspend the animation, and the Resume button to resume the animation.
Add a mouse-pressed handler that removes a ball when the mouse is pressed on the ball. */

package application;
//R- Imports all necessary components that will be used in code
//B- Adding all of the imports
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration; 

public class Main extends Application {
	//A- overrides the start method
	@Override //D- Override the start method in the Application class
	public void start(Stage primaryStage) {
		MultipleBallPane ballPane = new MultipleBallPane();
		//A- sets a border color for the pane
		ballPane.setStyle("-fx-border-color: yellow");//R- Sets outer border of application to Yellow //B- Changes border color

		// NEW //

		/** ACTION HANDLERS */

		//Creating the mouse event handler

		//R- If ball is clicked on by mouse, will remove it
		ballPane.setOnMouseClicked(event -> {	//was using ballPane but it removes newest ball instead of specific ball clicked on
			if (event.getButton() == MouseButton.PRIMARY) {	 //D- if mouse button is clicked, enter action handler below   		 	    		
				double mouseX = event.getSceneX();//M- Variable for mouse X coordinate //B- Gets mouse cords //G- Variable for mouse X coordinate //D- getting coordinates from mouse
				double mouseY = event.getSceneY();//M- Variable for mouse Y coordinate //G- Variable for mouse Y coordinate
				Node nodeToRemove = null;
				ObservableList<Node> kids = ballPane.getChildren();


				//R- Sets ball that is clicked on as nodeToRemove
				for (Node node: ballPane.getChildren()) {
					Ball ball = (Ball)node;
					double ballX = ball.getCenterX();//M- Variable for ball X coordinate //G- Variable for ball X coordinate //D- gets coordinates for the center of the ball
					double ballY = ball.getCenterY();//M- Variable for ball Y coordinate //G- Variable for ball Y coordinate
					//D- if the mouse xy was found to be at or within the coord. of the ball by using the center radius formula, remove the node which the ball is attached
					double r = Math.sqrt(Math.pow(mouseX-ballX,2) + Math.pow(mouseY-ballY,2)) ; //was Math.pow(ballX+mouseX,2) + Math.pow(ballY+mouseY,2)
					if (r <= ball.getRadius()){	//was Math.sqrt(calc) <= ball.getRadius()
						nodeToRemove = node;
						break;
					}


				} //R- Removes the ball that is set as nodeToRemove
				ballPane.getChildren().remove(nodeToRemove);

			}
		});


		// END NEW //

		// NEW BUTTONS //

		/** BUTTONS */

		//A- Creates the four buttons
		//D- Making new buttons "Suspend" and "resume"
		Button btPause = new Button("Suspend");//M- Adds a button for suspending the balls //R- Button created for Pausing/Suspending the application //B- button to pause the ball //G- Button for pause
		Button btResume = new Button("Resume");//M- Adds a button for resuming the balls //R- Button created for Resuming the application //B- button to resume the ball //G- Button for resume

		// END NEW BUTTONS //

		//D- buttons for adding and removing nodes
		Button btAdd = new Button("+");//M- Creates a + button. In later code it explains what it is used for //R- Button created for adding a ball to the application //G- Makes a + button
		Button btSubtract = new Button("-");//M- Creates a - button. In later code it explains what it is used for //R- Button created for removing a ball from the application //G- //Makes a - button
		//A- sets the spacing between the buttons
		//D- aliment of said buttons onto pane
		HBox hBox = new HBox(10);//M- Creates a margin for the buttons //G- Creates a margin for the buttons
		hBox.getChildren().addAll(btAdd, btSubtract, btResume, btPause);	//added pause and resume buttons //R- added pause and resume buttons to the bottom of the application //B- added pause and resume buttons //G- added pause, resume, add, and subtract buttons 
		hBox.setAlignment(Pos.CENTER);//M- This centers everything on the pane to make it look goooood //G- Centers everything

		//D- Add or remove a ball
		//A- Adds or removes a ball
		//R- Adds or removes a ball depending on what button is clicked
		btAdd.setOnAction(e -> ballPane.add());//M- When + (add) button pressed, it adds a ball into the mix //G- When Add button pressed, adds a ball
		//A- Removes a ball when it is clicked
		btSubtract.setOnAction(e -> ballPane.subtract());//M- When - (subtraction) button pressed, it will remove a ball //G- When Subtract button pressed, remove ball

		//D- Pause and resume animation
		//A- Will set the pause and resume status
		//R- Pauses application when Pause button is pressed
		btPause.setOnMousePressed(e -> ballPane.pause());	//Modified from using ballPane.setOnMouse...
		//R- Resumes application when Resume button is pressed
		btResume.setOnMouseReleased(e -> ballPane.play());	//Modified from using ballPane.setOnMouse...

		//D- Use a scroll bar to control animation speed
		//A- Uses the scroll bar at the top to set the animation speed.
		//R- Use a scroll bar to control animation speed
		ScrollBar sbSpeed = new ScrollBar();//M- Adds the scroll bar to the pane to control the //G- Adds the scroll bar
		sbSpeed.setMax(20);//M- Fastest animation speed 2.0x faster than default //B- Speed to 20 max //G- Fastest animation speed
		sbSpeed.setValue(10);//M- Default animation speed //B- Speed start at 10 //G- Default animation speed
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		//A- Creates a border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);//M- Window for balls bouncing //G- Window for balls bouncing
		pane.setTop(sbSpeed);//M- This sets the top section for the scroll bar //G- Top section for scroll bar
		pane.setBottom(hBox);//M- This sets the bottom section for all buttons (+,-,suspend,resume) //G- Bottom section for buttons

		// Create a scene and place the pane in the stage
		//A- Creates a scene with a set width and height and places it in the stage
		Scene scene = new Scene(pane, 600, 550);//R- Sets dimensions of the Scene for the application //B- First number is the width and the second is the height
		primaryStage.setResizable(false);//M- This is made so that the window cannot be resized //R- Makes adjusting the dimensions of the Scene impossible //G- Window cannot be resized //D- locked screen size as to avoid any issues caused by the positions of nodes being changed
		//A- Set the stage title
		primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private class MultipleBallPane extends Pane {
		private Timeline animation;

		public MultipleBallPane() {
			// Create an animation for moving the ball
			//A- Creates the animation for moving the ball
			animation = new Timeline(
					new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);//M- Makes the timeline set to an indefinite time //G- Keeps cycling
			//A- starts the animation
			animation.play(); //M- This plays the animation //R- Start animation //B- Start animation
		}

		// ADDING A BALL AND CHOOSING A RANDOM COLOR FOR IT //
		//R- Randomly generates a color for each ball added
		public void add() {
			//A- gets a random color for the ball and adds it to the scene
			Color color = new Color(Math.random(), //D- uses method Random to pick a random color and assign it to the node
					Math.random(), Math.random(), 0.5);//M- Creates random value //B- adds a new color with ball //G- Makes random values

			// NEW //

			/**  Second method for creating action handler by Daniel */

			//	      Ball b = new Ball(30, 30, 20, color);
			//	      b.setOnMouseClicked(event ->  {
			//	    	  
			//	    	  if (event.getButton() == MouseButton.PRIMARY) { 
			//	    		  getChildren().remove(b);
			//	    	  }
			//	    	  
			//	      });
			//	      getChildren().add(b);

			// END NEW //

			getChildren().add(new Ball(30, 30, 20, color)); 	
		}

		 // REMOVING A BALL //
		//R- Function for removing a ball from the application
		public void subtract() {
			//A- removes a ball from the scene
			//M- This establishes that if there are any balls left, remove one of them
			//G- If there are any balls left, remove 1
			if (getChildren().size() > 0) {
				getChildren().remove(getChildren().size() - 1); 
			}
		}

		// COMMANDS FOR RESUMING & SUSPENDING //
		//A- plays the animation
		//R- Starts/resumes the animation of the application
		//G- Commands for stopping and starting
		public void play() {//B- plays
			animation.play();
		}
		
		// INCREASING THE SPEED BY 0.1 INTERVALS //
		//A- pauses the animation
		//R- Pauses the animation of the application
		//G- Increase speed by .1 intervals
		public void pause() {//B- pauses
			animation.pause();
		}

		// ONLY IF IT CAN //
        // DECREASES SPEED BY 0.1 INTERVALS //
		@SuppressWarnings("unused")
		//A- increases animation speed
		//G- If it can, decreases speed by .1 intervals
		public void increaseSpeed() {
			animation.setRate(animation.getRate() + 0.1);//B- increasing speed
		}

		@SuppressWarnings("unused")
		//A- decreases animation speed
		public void decreaseSpeed() {
			animation.setRate(
					animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
		}

		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}

		// BALL MOVEMENT COMMANDS //
		//R- Moves the ball across the scene of the application
		protected void moveBall() {
			for (Node node: this.getChildren()) {
				Ball ball = (Ball)node;
				// Check boundaries
				//A- Check if a ball has hit the boundary then change directions
				if (ball.getCenterX() < ball.getRadius() || 
						ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1; //M-  Changes the ball move direction to a negative x direction //R- Change ball move direction //B- Change ball move direction //G- Change ball move direction to a negative x direction
				}
				if (ball.getCenterY() < ball.getRadius() || 
						ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1; //M- Changes the ball move direction to a negative y direction //R- Change ball move direction //B- Change ball move direction //G- Change ball move direction to a negative y direction
				}

				// Adjust ball position
				//A- get x and y position of the ball
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
			
			// NEW //
			
			/** BALL COLLISION */
			ballCollision();//R- Calls ballCollision function to see if multiple balls intersect
			
			// END NEW //
		}
		
		// NEW VERSION OF MOVE BALL FOUND BY ALEX //
		
		/**
		 * protected void moveBall() {
			for (Node node : this.getChildren()) {
				Ball ball = (Ball) node;
				// Check if a ball has hit the boundary then change directions
				if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1;
				}
				if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1;
				}
				// get x and y position of the ball
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
				// Check if the balls collide
				ArrayList<Node> list = new ArrayList<>(this.getChildren());
				for (int i = getChildren().indexOf(node) + 1;
						i < list.size(); i++) {
					Ball nextBall = (Ball) list.get(i);
					if (intersects(ball, nextBall)) {
						// Remove the last ball that was added and add its size to the first ball
						ball.setRadius(ball.getRadius() + nextBall.getRadius());
						getChildren().remove(nextBall);
					}
				}
			}
		}
		// used to check if balls collide. returns true if they do.
		private boolean intersects(Ball ball, Ball nextBall) {
			return Math.sqrt(Math.pow(ball.getCenterX() - nextBall.getCenterX(), 2) + Math.pow(ball.getCenterY() - nextBall.getCenterY(), 2)) <= ball.getRadius() + nextBall.getRadius();
		}
	}
		*/		 
		
		// NEW //
		
		/** BALL COLLISION METHOD */
		
		//D- if the center coordinates the sqrt of center coordinates a squared - center coordinates of b squared <= radius of a + b
		//D- add <= radius to int temp, remove smaller object, add temp to remaining object
		//A- Check if the balls collide
		private void ballCollision() {
			ObservableList<Node> kids = getChildren();			

			//M- Loops again after comparing ball 1 with every other ball
			//R- compares ballOne to ballTwo and checks to see if they are the same
			//G- Loops again after comparing ball 1 with every other ball
			for (int i = 0; i < kids.size(); i++) {
				Node nodeOne = kids.get(i);
				Ball ballOne = (Ball)nodeOne;//G- Sets ball 1

				//M- Loops again after testing ball 2 against ball 1
				//G- Loops again after testing ball 2 against ball 1
				for (int b = 0; b < kids.size(); b++) {
					Node nodeTwo = kids.get(b);
					Ball ballTwo = (Ball)nodeTwo;//G- Sets ball 2

					//M- If balls are different, continue
					//R- If ballOne and ballTwo are two separate balls, will run the following code
					//G- If balls are different, continue
					if (ballTwo != ballOne) {

						double ballOneX = ballOne.getCenterX();	//M and G- X location of ball 1
						double ballOneY = ballOne.getCenterY();	//M and G- Y location of ball 1

						double ballTwoX = ballTwo.getCenterX();	//M and G- X location of ball 2
						double ballTwoY = ballTwo.getCenterY();	//M and G- Y location of ball 2  

						//R- calculates new larger ball by adding radiuses 
						double combinedR = ballOne.getRadius() + ballTwo.getRadius();//M- Sets value for how far a collision would be from center points //G- Sets value for how far a collision would be from center points

						double xLength = Math.abs(ballOneX - ballTwoX);//M and G- Distance between X coordinates
						double yLength = Math.abs(ballOneY - ballTwoY);//M and G- Distance between Y coordinates
						double distance = Math.hypot(xLength, yLength);//M and G- The distance away in total

						//M and G- If distance is within than the collision distance(combinedR), continue
						//R- Removes the smaller ball and sets the radius of the other ball to the combined radius
						if (distance <= combinedR){
							//M- Compares size of balls, adds smaller one to bigger one
							if (ballOne.getRadius() < ballTwo.getRadius()) {
//								System.out.println("less than");	//debugger
								ballTwo.setRadius(ballTwo.getRadius() + ballOne.getRadius());
								getChildren().remove(nodeOne);
							}
							if (ballOne.getRadius() > ballTwo.getRadius()) {	//second and third if share same logic
//								System.out.println("greater than");	//debugger
								ballOne.setRadius(ballTwo.getRadius() + ballOne.getRadius());
								getChildren().remove(nodeTwo);
							}
							if (ballOne.getRadius() == ballTwo.getRadius()) {
//								System.out.println("equals");	//debugger
								ballOne.setRadius(ballTwo.getRadius() + ballOne.getRadius());
								getChildren().remove(nodeTwo);
							}
							break;							
						}
					}
				}				
			}			
		}
		
		// END NEW //
	}
	//M- This creates the ball when it is called
	//R- Ball Class used to create a ball with x and y components along with color
	//G- Makes the a ball when called
	class Ball extends Circle {
		private double dx = 1, dy = 1;
		//A- adds a ball and sets its color
		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color); // Set ball color
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}