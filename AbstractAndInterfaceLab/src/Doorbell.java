/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// February 16, 2021
// Lab 4 - Interfaces
//
/////////////////////////////////////////////////////////

/** This program practices creating a class which inherits 
 * an abstract object from an abstract class and an abstract 
 * object from an interface and is able to pass and display
 * information. */

public class Doorbell extends Camera implements Device {
	private  String color = "Black";
	//object ID is Doorbell01
	private  String ID = "Doorbell01";
	
	//abstract methods from Camera
	public void ring() {
		System.out.println("Ring Ring Ring");
	}
	
	public void converse() {
		System.out.println("Mike and Speaker are now on");
	}

	@Override
	public void focus(Integer feet) {
		setFocusRange(feet);		
	}

	@Override
	public void record() {
		System.out.println("Now recording");
	}


	@Override
	//Display ID
	public String getID() {
		System.out.println(ID);
		return ID;
		
	}

	@Override
	//Display sendReport
	public String sendReport() {
		System.out.println("Activity Report");
		return "Activity Report";
		
	}
}
