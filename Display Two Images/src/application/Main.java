/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// February 19, 2021
// Exercise 4 - Display Two Images
//
/////////////////////////////////////////////////////////

/** This program uses Javafx to display two images side by side.
 */

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws FileNotFoundException {  

	      //creating HappyHalloween1 image
	      Image image1 = new Image("HappyHalloween1.jpg");  
	      
	      //setting HappyHalloween1 to imageView1
	      ImageView imageView1 = new ImageView(image1); 
	      
	      //positioning HappyHalloween1 so that the pictures have some nice spacing between them
	      imageView1.setX(25); 
	      imageView1.setY(25); 
	      
	      imageView1.setPreserveRatio(true); 
	       
	      //creating HappyHalloween2 image
	      Image image2 = new Image("HappyHalloween2.png");
	      
	      //setting HappyHalloween2 to imageView2
	      ImageView imageView2 = new ImageView(image2);
	      
	      //positioning HappyHalloween2
	      imageView2.setX(700); 
	      imageView2.setY(25);         
	      
	      imageView2.setPreserveRatio(true); 
	         
	      //creating Group containing imageView1 and imageView2 
	      Group group = new Group(imageView1, imageView2);  
	      
	      //creating scene 
	      Scene scene = new Scene(group, 1375, 525);  
	      
	      //title on the window  
	      stage.setTitle("Displaying multiple images");  
	      
	      //Setting the scene to stage 
	      stage.setScene(scene);  
	      
	      //displaying stage
	      stage.show(); 
	   }  
	   public static void main(String args[]) { 
	      launch(args); 
	   } 
	} 