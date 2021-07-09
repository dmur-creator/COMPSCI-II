import java.util.Scanner;

public class TriangleTest {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter the length of three sides of a triangle, the color and if it is filled( True / False ): ");
		double side1 = userInput.nextDouble();
		double side2 = userInput.nextDouble();
		double side3 = userInput.nextDouble();
		String color = userInput.next();
		boolean filled = userInput.nextBoolean();
		
		userInput.close();
		
		Triangle triangle = new Triangle (side1 , side2 , side3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		
		System.out.println(triangle.toString());
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
	}
}
