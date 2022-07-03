package doubtSessionRecursion;

import java.util.Arrays;

public class MainClass {

	// Rod cutting problem - in recursion
	// https://www.geeksforgeeks.org/maximise-number-of-cuts-in-a-rod-if-it-can-be-cut-only-in-given-3-sizes/
	// Q: Maximize number of cuts in a rod if it can be cut only in given 3 sizes
	static int maxRods(int N, int a, int b, int c) {
		// Base conditions
		if (N == 0)
			return 0;

		if (N < 0)
			return -1;

		int cutA = maxRods(N - a, a, b, c);
		int cutB = maxRods(N - b, a, b, c);
		int cutC = maxRods(N - c, a, b, c);

		int res = Math.max(cutA, Math.max(cutB, cutC));

		if (res == -1)
			return -1;

		return res + 1;
		// Time complexity: Big O (3 ^ n)
	}

	static int maxRodsDp(int N, int a, int b, int c, int[] dp) {
		// Base conditions
		if (N == 0)
			return dp[N] = 0;

		if (N < 0)
			return -1;

		if (dp[N] != -2)
			return dp[N];

		int cutA = maxRodsDp(N - a, a, b, c, dp);
		int cutB = maxRodsDp(N - b, a, b, c, dp);
		int cutC = maxRodsDp(N - c, a, b, c, dp);

		int res = Math.max(cutA, Math.max(cutB, cutC));

		if (res == -1)
			return dp[N] = -1;

		dp[N] = res + 1;
		return dp[N];
		// Time complexity: Big O (n)
	}

	// Question 2: Sum of subset
	// Given a set of non-negative integers, and a value sum, determine if there is
	// a subset of the given set with sum equal to given sum
	static boolean subSetSum(int sum, int a[], int index) {
		// Time complexity: Big O (2 ^ n)

		// as numbers of array are non-negative
		if (sum < 0)
			return false;

		if (index < 0)
			return false;

		if (sum == 0)
			return true;

		return subSetSum(sum - a[index], a, index - 1) || subSetSum(sum, a, index - 1);
	}

	public static void main(String[] args) {
		int N = 25;
		int a = 6;
		int b = 7;
		int c = 13;

		System.out.println(maxRods(N, a, b, c));

		int dp[] = new int[N + 1];
		Arrays.fill(dp, -2);

		System.out.println(maxRodsDp(N, a, b, c, dp));

		for (int i = 0; i <= N; i++) {
			if (dp[i] != -2)
				System.out.println(i + " " + dp[i]);
		}

		int[] arr = { 3, 34, 4, 12, 5, 2 };
		int sum = 31;

		System.out.println(subSetSum(sum, arr, arr.length - 1));
	}

}
