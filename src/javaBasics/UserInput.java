package javaBasics;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter age: ");
		int age = sc.nextInt();
		System.out.println("Your age is : " + age);

		// control flow doesn't stop if you don't write this, as we type age and click
		// on enter then that is captured here as an intermediately
		sc.nextLine();

		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Your name is : " + name);

		sc.close();
	}

}
