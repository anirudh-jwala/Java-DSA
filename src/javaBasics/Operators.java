package javaBasics;

public class Operators {

	public static void main(String[] args) {
		int a = 34;
		int b = 12;

		// Arithmetic operators
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a / b);
		System.out.println(a * b);
		System.out.println(a % b);

		// Assignment operator
		b = 14;
		b += a;

		// Relational operator
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a == b);
		System.out.println(a != b);

		// Unary operator
		++a;
		--a;
		b++;
		b--;

		// Bitwise operator
		System.out.println(a << 1);
		System.out.println(a >> 1);
	}

}
