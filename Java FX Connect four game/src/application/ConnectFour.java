/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// March 27, 2021
// Lab 3 - JavaFx Connect Four
//
/////////////////////////////////////////////////////////

/** Using a modified version of a tic-tac-toe game from the
 * introduction to Java by Daniel Liang, I made a connect four game.
 * The only needed changes to the code was to change the 2d
 * array side from 3x3 to 6x7 and changing the win check 
 * conditions to check for four in a row vertically, horizontally
 * and diagonally.
 */

package application;

  import javafx.application.Application;
  import javafx.stage.Stage;
  import javafx.scene.Scene;
  import javafx.scene.control.Label;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.layout.GridPane;
  import javafx.scene.layout.Pane;
  import javafx.scene.paint.Color;
  import javafx.scene.shape.Line;
  import javafx.scene.shape.Ellipse;

  public class ConnectFour extends Application {
    // Indicate which player has a turn, initially it is the X player
    private char whoseTurn = 'X';

    // Create and initialize cell
    private Cell[][] cell =  new Cell[6][7]; //was 6 7

    // Create and initialize a status label
    private Label lblStatus = new Label("X's turn to play");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Pane to hold cell
      GridPane pane = new GridPane(); 
      for (int i = 0; i < 6; i++) //was 6
        for (int j = 0; j < 7; j++)	//was 7
          pane.add(cell[i][j] = new Cell(), j, i);

      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(pane);
      borderPane.setBottom(lblStatus);
      
      // Create a scene and place it in the stage
      Scene scene = new Scene(borderPane, 850, 800);
      primaryStage.setTitle("TicTacToe"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage   
    }

    /** Determine if the cell are all occupied */
  public boolean isFull() {
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++)
        if (cell[i][j].getToken() == ' ')
          return false;

    return true;
  }

  /** Determine if the player with the specified token wins */
  public boolean isWon(char token) {
	  //horizontal wins
	  // This checks the horizontal wins by increasing the row value until it has hit the maximum and then increases the col by 1 and repeats the check until col has hit its max allowed value
	  for (int col = 0; col < 4; col++)
		  for (int row = 0; row < 6; row++)
			  if (cell[row][col + 0].getToken() == token
			  && cell[row][col + 1].getToken() == token
			  && cell[row][col + 2].getToken() == token
			  && cell[row][col + 3].getToken() == token) {
				  return true;
			  }

	  //vertical wins
	  //works the same as the above method just with the col and row switched
	  for (int row = 0; row < 3; row++)
		  for (int col = 0; col < 7; col++)
			  if (cell[row + 0][col].getToken() ==  token
			  && cell[row + 1][col].getToken() == token
			  && cell[row + 2][col].getToken() == token
			  && cell[row + 3][col].getToken() == token) {
				  return true;
			  }
	  
	  //up diagonal win
	  //gave me an incredible amount of fits to make this! Truly simple yet hard to conceptualize. It works similar to the methods above but instead of anchoring to a single col or row point and incrementing the non-anchored point within the if statement, it increments both until the 2d array length has been met.
	  for (int row = 3; row < cell.length; row++)
		  for (int col = 0; col < cell[0].length - 3; col++)
			  if (cell[row][col].getToken() ==  token
			  && cell[row - 1][col + 1].getToken() == token
			  && cell[row - 2][col + 2].getToken() == token
			  && cell[row - 3][col + 3].getToken() == token) {
				  return true;
			  }
	  
	  //down diagonal win
	  //same as above code but with changed anchor points and goes in different direction
	  for (int row = 0; row < cell.length - 3; row++)
		  for (int col = 0; col < cell[0].length - 3; col++)
			  if (cell[row][col].getToken() ==  token
			  && cell[row + 1][col + 1].getToken() == token
			  && cell[row + 2][col + 2].getToken() == token
			  && cell[row + 3][col + 3].getToken() == token) {
				  return true;
			  }

	  
      return false;
    }  
  
    // An inner class for a cell
    public class Cell extends Pane {
      // Token used for this cell
      private char token = ' ';

      public Cell() {
        setStyle("-fx-border-color: black"); 
        this.setPrefSize(800, 800);
        this.setOnMouseClicked(e -> handleMouseClick());
      }

      /** Return token */
      public char getToken() {
        return token;
      }

      /** Set a new token */
      public void setToken(char c) {
        token = c;
        
        if (token == 'X') {
          Line line1 = new Line(10, 10, 
            this.getWidth() - 10, this.getHeight() - 10);
          line1.endXProperty().bind(this.widthProperty().subtract(10));
          line1.endYProperty().bind(this.heightProperty().subtract(10));
          Line line2 = new Line(10, this.getHeight() - 10, 
            this.getWidth() - 10, 10);
          line2.startYProperty().bind(
            this.heightProperty().subtract(10));
          line2.endXProperty().bind(this.widthProperty().subtract(10));
          
          // Add the lines to the pane
          this.getChildren().addAll(line1, line2); 
        }
        else if (token == 'O') {
          Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
            this.getHeight() / 2, this.getWidth() / 2 - 10, 
            this.getHeight() / 2 - 10);
          ellipse.centerXProperty().bind(
            this.widthProperty().divide(2));
          ellipse.centerYProperty().bind(
              this.heightProperty().divide(2));
          ellipse.radiusXProperty().bind(
              this.widthProperty().divide(2).subtract(10));        
          ellipse.radiusYProperty().bind(
              this.heightProperty().divide(2).subtract(10));   
          ellipse.setStroke(Color.BLACK);
          ellipse.setFill(Color.WHITE);
          
          getChildren().add(ellipse); // Add the ellipse to the pane
        }
      }

      /* Handle a mouse click event */
      private void handleMouseClick() {
        // If cell is empty and game is not over
        if (token == ' ' && whoseTurn != ' ') {
          setToken(whoseTurn); // Set token in the cell

          // Check game status
          if (isWon(whoseTurn)) {
            lblStatus.setText(whoseTurn + " won! The game is over");
            whoseTurn = ' '; // Game is over
          }
          else if (isFull()) {
            lblStatus.setText("Draw! The game is over");
            whoseTurn = ' '; // Game is over
          }
          else {
            // Change the turn
            whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
            // Display whose turn
            lblStatus.setText(whoseTurn + "'s turn");
          }
        }
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
