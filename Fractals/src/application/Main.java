/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// April 28, 2021
// Exercise 7 - Koch Fractal 
//
/////////////////////////////////////////////////////////

/** This program uses recursion to create points which form 
 * coordinates and draw lines between these coordinates to
 * create Koch's fractal. A value obtained from an action 
 * listener is passed to method KochFractal which will 
 * determine the number of recursions to be called which will
 * create all necessary coordinates and draw lines between them.
 * Some of the base code is recycled from the given code for
 * Sierpinski's triangle from Introduction to Java by Daniel
 * Liang. */

package application;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
	private int counter = -1;
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		KochFractal pane = new KochFractal();
		TextField tfOrder = new TextField("0");
		//added add button which increases the current layer level by 1
		Button add = new Button("+");
		//added remove button which decreases the current layer level by 1
		Button remove = new Button("-");
		//if add is clicked on, increase counter by 1, pass counter value to setOrder Method and set text field tfOrder to counter
		add.setOnMouseClicked(event -> {
			counter++;
			pane.setOrder(counter);
			tfOrder.setText(String.valueOf(counter));
		});
		//if remove is clicked on, decrease counter by 1, pass counter value to setOrder Method and set text field tfOrder to counter
		remove.setOnMouseClicked(event -> {
			if (counter > 0) {
				counter--;
				pane.setOrder(counter);
				tfOrder.setText(String.valueOf(counter));
			}
		});
		//prevents user from entering non int's into the text field by using text formatter 
		   UnaryOperator<TextFormatter.Change> filter = change -> {
		       String text = change.getText();
		 
		       if (text.matches("\\d?")) {
		           return change;
		       }
		        
		       return null;
		   };
		   tfOrder.setTextFormatter(new TextFormatter<String>(filter));
		   
		//if enter key is pressed, take int in text box and equal it to counter and pass value in textfield to setOrder
		tfOrder.setOnKeyPressed(
				event -> { 
					if(event.getCode().equals(KeyCode.ENTER)) {
						
						pane.setOrder(Integer.parseInt(tfOrder.getText()));
						int tempCounter = Integer.parseInt(tfOrder.getText());
						counter = tempCounter;
					}
				});

		tfOrder.setPrefColumnCount(4);
		tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

		// Pane to hold label, text field, and a button
		HBox hBox = new HBox(10);

		hBox.getChildren().addAll(new Label("Enter which layer you want to go to: "), tfOrder, add, remove);
		hBox.setAlignment(Pos.CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 500, 510);
		primaryStage.setTitle("Exercise18_27"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		scene.widthProperty().addListener(ov -> pane.paint());
		scene.heightProperty().addListener(ov -> pane.paint());
	}

	/** method for finding points, drawing lines between said points and thus creating the fractal design on the pane*/
	static class KochFractal extends Pane {
		private int order = 0;

		/** Set a new order */
		public void setOrder(int order) {
			this.order = order;
			paint();
		}

		KochFractal() {
		}

		protected void paint() {
			double side = Math.min(getWidth(), getHeight()) * 0.8;
			double height = side * Math.sin(Math.toRadians(60));

			// Select three points in proportion to the panel size and use side and height to keep it proportioned in the pane properly
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(getWidth() / 2 - side / 2, 10 + height);
			Point2D p3 = new Point2D(getWidth() / 2 + side / 2, 10 + height);

			this.getChildren().clear(); // Clear the pane before redisplay
			//call createKoch and pass in the input layer number and coordinates of p1-3, loop until order is 0
			createKoch(order, p1, p2);
			createKoch(order, p2, p3);
			createKoch(order, p3, p1);
		}

		private void createKoch(int order, Point2D p1, Point2D p2) {
			if (order == 0) {
				this.getChildren().add(new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
			}
			else {
				//finding the total distance between the coordinates p1 and p2 
				double xLength = p2.getX() - p1.getX();
				double yLength = p2.getY() - p1.getY();
				//newX and newY are used to equal the new coordinates of a point that is 1/3 the length of each side
				Point2D newX = new Point2D(p1.getX() + xLength / 3, p1.getY() + yLength / 3);
				Point2D newY = new Point2D(p1.getX() + xLength * 2 / 3, p1.getY() + yLength * 2 / 3);
				//halfTriangle finds the coordinates used to draw the tip of the triangle placed in the mid 1/3 section of each side
				Point2D halfTriangle = new Point2D((p1.getX() + p2.getX()) / 2 + Math.cos(Math.toRadians(30)) * (p1.getY() - p2.getY()) / 3, (p1.getY() + p2.getY()) / 2 + Math.cos(Math.toRadians(30)) * (p2.getX() - p1.getX()) / 3);
				// the parameter order has 1 subtracted from it and the following calls pass the new found coordinates to the if statement to have lines drawn between them, when order gets to 0, the method ends 
				createKoch(order - 1, p1, newX);
				createKoch(order - 1, newX, halfTriangle);
				createKoch(order - 1, halfTriangle, newY);
				createKoch(order - 1, newY, p2);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}