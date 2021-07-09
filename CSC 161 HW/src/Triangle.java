/////////////////////////////////////////////////////////
//
// Daniel Murphy
// CSC 161 Computer Science II
// February 9, 2021
// Exercise 2 - 11.1 class/subclass Triangle Class
//
/////////////////////////////////////////////////////////

/** This program inherits methods from GeometricObject class
 * and creates a default triangle with side lengths of 1, creates
 * a constructor, getters for side 1 2 and 3's lengths, Area,
 * perimeter and toString method.*/

//Extending/inheriting methods from GeometricObject class
public class Triangle extends GeometricObject{
	//creating global variables
	public double side1 , side2 , side3;
	
	//constructing default triangle with sides all equal to 1.0
	Triangle() { side1 = side2 = side3 = 1.0;
	}
	//creating no args constructor to initialize objects side 1 2 and 3 to create a basic triangle
	Triangle (double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	//establishing getters for retrieving the lengths of side 1 2 and 3 for use in calculations and user display
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	//getter for Area uses sides 1 2 and 3 to find area of a triangle by adding all three sides, dividing by two and subtracting that amount from each side and multiplying within a square root 
	public double getArea() {
		double addSides = (side1 + side2 + side3) / 2;
		return Math.sqrt(addSides * (addSides-side1) * (addSides-side2) * (addSides-side3));
	}
	//Perimeter getter finds perimeter of triangle by adding sides 1 2 and 3
	public double getPerimeter() {
		double addSides = (side1 + side2 + side3);
		return addSides;
	}
	//returning value to string type and displays side 1 2 and 3's values in console then invokes a toString String description of the object from superclass GeometricObject consisting of java.util.Date dateCreated and a boolean filled or not filled
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3 + "\n" + super.toString();
	}

}
