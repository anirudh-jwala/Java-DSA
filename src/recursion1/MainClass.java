package recursion1;

/**
 * 
 * 3 Steps for Recursion
 * 
 * =======================
 * 
 * - Find the base case
 * 
 * - Find the relation b/w problem and the sub-problem
 * 
 * - Generalize this relation
 *
 */
public class MainClass {

	static int i = 0;

	static void dummyFunction() {
		System.out.println(i++);
		dummyFunction(); // recursion call
	}

	static void printNNatualNumbers(int N) {
		// Base case
		if (N == 0)
			return;

		printNNatualNumbers(N - 1);
		System.out.println(N);
	}

	static int sumOfNNaturualNumbers(int N) {
		if (N == 0)
			return 0;

		return sumOfNNaturualNumbers(N - 1) + N;
	}

	// Math.pow() -> Time complexity Log(n)
	static long powerOfNumber(int N, int power) {
		if (power == 0)
			return 1;

		if (power == 1)
			return N;

		return N * powerOfNumber(N, power - 1);
	}

	// Question: Find the no of paths in an (n x m) matrix
	static int countPathsInAMatrix(int n, int m) {
		// Time complexity: Big O(2^n)
		if (n == 1 || m == 1)
			return 1;

		int downSideAns = countPathsInAMatrix(n - 1, m);
		int rightSideAns = countPathsInAMatrix(n, m - 1);

		return downSideAns + rightSideAns;
	}

	public static void main(String[] args) {
		// dummyFunction(); first invocation caller method

		printNNatualNumbers(5);

		int n = 5;
		System.out.println("Sum of N(" + n + ") Natual numbers: " + sumOfNNaturualNumbers(n));

		int num = 2, power = 3;
		System.out.println("Power of N(" + num + ") to power(" + power + ") is: " + powerOfNumber(num, power));

		n = 4;
		int m = 3;
		System.out.println("No of paths in an (" + n + "x" + m + ") matrix: " + countPathsInAMatrix(n, m));
	}

}
