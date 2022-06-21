package javaBasics2;

public class Loops {

	public static void main(String[] args) {
		// for loop
		// (initialization; test expression; update expression)

		for (int i = 1; i <= 5; i++) {
			System.out.println("Anirudh :: " + i);
		}

		/**
		 * infinite for loop
		 * 
		 * for (int i = 1;; i++) { 
		 * 		System.out.println("Anirudh"); 
		 * }
		 * 
		 * for (int i = 1; i >= 1; i++) { 
		 * 		System.out.println("Anirudh");
		 * }
		 * 
		 * for (int i = 1; i <= 10;) {
		 * 		System.out.println("Anirudh");
		 * }
		 */
		
		// Nested loops
		
		/**
		 * Print stars in a row; row number = no of stars
		 */
		int n = 5;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		// while loop
		int index = 1;
		while (index <= 5) {
			System.out.println("Abhi");
			index += 2;
		}
		System.out.println();
		
		// do-while loop - it runs atleast once
		int doIndex = 1;
		do {
			System.out.println("Anuj");
			doIndex++;
		} while (false); // doIndex <= 5
	}

}
