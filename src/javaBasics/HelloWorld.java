package javaBasics;

// Files of java source code end with ".java" extension

public class HelloWorld {

	// Starting point of a java program is main() method
	public static void main(String[] args) {

		// To show information to user
		System.out.println("Hello, World!");

		/**
		 * Data types in JAVA (1 byte = 8 bits)
		 * 
		 * boolean - 1 bit (true / false)
		 * 
		 * byte - 1 byte (numbers)
		 * 
		 * char - 2 bytes (ASCII character / value)
		 * 
		 * short - 2 bytes (numbers)
		 * 
		 * int - 4 bytes (numbers)
		 * 
		 * long - 8 bytes (numbers)
		 * 
		 * float - 4 bytes (6 to 7 decimals digits)
		 * 
		 * double - 8 bytes (15 decimals digits)
		 */

		// Variable declaration and initialization
		int age = 34;
		age = 25; // reassignment of variable with a different value
		System.out.println("int age (4 bytes): " + age);

		byte bage = 34;
		System.out.println("byte age (1 byte): " + bage);
		
		float rating = 3.45f; // here 'f' is a literal telling this is NOT a double but a float
		double marks = 98.45; // NO need of literal - decimal values are by default "double"
		
		System.out.println("float (4 bytes) rating: " + rating);
		System.out.println("double (8 bytes) marks: " + marks);
		
		// explicit type casting
		float smallRating = (float) 3.379457823986234945893895;
		System.out.println("float can store max of 6-7 digits after decimal :: " + smallRating);
		
		double bigRating = 3.379457823986234945893895;
		System.out.println("double can store max of 15-16 digits after decimal :: " + bigRating);

		char grade = 'F';
		grade = 'A';
		System.out.println("Single charactar :: " + grade);
		
		int upGrad = 'C'; // implicit type casting
		System.out.println("ASCII value :: " + upGrad);
		
		int x = 34;
		double y = x;
		System.out.println("(int) x: " + x + " to " + " (double) y " + y);
		
		double a = 34.12;
		int b = (int) a;
		System.out.println("(double) a: " + a + " to " + " (int) b " + b);
	}

}
