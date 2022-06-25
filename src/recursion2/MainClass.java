package recursion2;

import java.util.HashSet;
import java.util.Set;

// Recursion
public class MainClass {

	// Question 1
	public static int sumOfDigits(int number) {
		// Formula to calculate no of digits: (Log base 10 (n) + 1)
		// If n = 10, digits = Log (10) base 10 + 1 = 1 + 1 = 2

		// Time complexity: Log(n)
		if (number == 0)
			return 0;

		int lastDigit = number % 10;

		return lastDigit + sumOfDigits(number / 10);
	}

	// Question 2: Generate all subsets/subsequence of a string
	// A String formed using the original string by removing zero or more characters
	public static void generateAllSubsets(String str) {
		// To have only unique values
		Set<String> set = new HashSet<>();
		utilGenerateALlSubsets(str, 0, "", set);

		for (String s : set) {
			System.out.println(s);
		}

		// Time complexity
		// 2^0 + 2^1 + 2^2 + ... + 2^n = 2^(n+1) => Big O(2^n)

		// For n height -> 2^n, "abc" = 3 -> 2^3 nodes in the tree
	}

	// make own utility method
	static void utilGenerateALlSubsets(String str, int index, String currentStr, Set<String> set) {
		// Base case
		if (index == str.length()) {
			// System.out.println(currentStr); -> without unique values
			set.add(currentStr);
			return;
		}

		// Without inclusion of current string
		utilGenerateALlSubsets(str, index + 1, currentStr, set);

		// With inclusion of current string
		utilGenerateALlSubsets(str, index + 1, currentStr + str.charAt(index), set);
	}

	// Question 3: Tower of Hanoi
	static void towerOfHanoi(int n, char from, char to, char aux) {
		if (n == 0)
			return;

		towerOfHanoi(n - 1, from, aux, to);
		System.out.println("Move " + n + " from " + from + " to " + to);

		towerOfHanoi(n - 1, aux, to, from);
	}

	public static void main(String[] args) {
		int n = 2314;
		System.out.println("Sum of digits: " + sumOfDigits(n));

		generateAllSubsets("aaa");

		towerOfHanoi(3, 'A', 'C', 'B');
	}

}
