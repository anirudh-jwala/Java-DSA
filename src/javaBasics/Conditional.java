package javaBasics;

import java.util.Scanner;

public class Conditional {

	public static void main(String[] args) {

		System.out.println("Voting started");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your age: ");
		int age = sc.nextInt();

		// if statement
		if (age >= 18) {
			System.out.println("You can vote");
			System.out.println("hurray");
		}

		// if-else statement
		if (age >= 18) {
			System.out.println("You can vote");
		} else {
			System.out.println("Enjoy your ferris ride");
		}

		System.out.println("Voting ended");

		// if - else if ladder
		int marks = 90;

		if (marks > 90) {
			System.out.println("A+");
		} else if (marks > 80) {
			System.out.println("A");
		} else if (marks > 70) {
			System.out.println("B+");
		} else if (marks > 60) {
			System.out.println("B");
		} else {
			System.out.println("D");
		}

		// nested if
		int a = 34;
		int b = 12;
		int c = 4;

		if (a > b) {
			if (a > c) {
				System.out.println("a is bigger");
			} else {
				System.out.println("c is bigger");
			}
		} else {
			if (b > c) {
				System.out.println("b is bigger");
			} else {
				System.out.println("c is bigger");
			}
		}

		// switch-case
		int number = 23;

		switch (number) {
			case 12: {
				System.out.println("It's small");
				break;
			}
	
			case 16: {
				System.out.println("It's medium");
				break;
			}
	
			case 20: {
				System.out.println("It's large");
				break;
			}
	
			case 24: {
				System.out.println("It's extra large");
				break;
			}
	
			default: {
				System.out.println("Invalid");
			}
		}

		sc.close();
	}

}
