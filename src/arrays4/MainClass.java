package arrays4;

import java.util.Arrays;

public class MainClass {

	// Trapping rain water with Big O(1) space complexity
	public static int trappingRainWater(int[] arr) {
		int ans = 0;
		int leftMax = 0, rightMax = 0;

		int n = arr.length;
		int l = 0, r = n - 1;

		while (l < r) {

			if (arr[l] < arr[r]) {
				if (arr[l] > leftMax) {
					leftMax = arr[l];
				} else {
					ans += leftMax - arr[l];
				}

				l++;
			} else {
				if (arr[r] > rightMax) {
					rightMax = arr[r];
				} else {
					ans += rightMax - arr[r];
				}
				r--;
			}

		}

		return ans;
	}

	// Question 2: Given an array arr[], find the maximum of (j - i) such that
	// arr[j] > arr[i]
	public static int maxDifferent(int[] arr) {
		// Time complexity: Big O(n^2)
		int ans = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					ans = Math.max(ans, (j - i));
				}
			}
		}

		return ans;
	}

	public static int maxDifferent2(int[] arr) {
		// Time complexity: Big O(n)
		int ans = 0;
		int n = arr.length;

		int[] rightMax = new int[n];
		int[] leftMin = new int[n];

		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		leftMin[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
		}

		int i = 0, j = 0;
		while (i < n && j < n) {
			if (leftMin[i] < rightMax[j]) {
				ans = Math.max(ans, j - i);
				j++;
			} else {
				i++;
			}
		}

		return ans;
	}

	// Question 3: Find two numbers in a sorted array with the given sum
	static void pairWithGivenSum(int[] arr, int key) {
		// Time complexity: Big O(n^2)
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == key) {
					System.out.println("Pair found: " + arr[i] + " " + arr[j]);
					return;
				}
			}
		}

		System.out.println("No pair available");
	}

	static void pairWithGivenSum1(int[] arr, int key) {
		// Time complexity: Big O(n)

		// Two pointer technique seems like binary search
		int n = arr.length;
		int l = 0, r = n - 1;

		while (l < r) {
			int currentSum = arr[l] + arr[r];

			if (currentSum > key) {
				r--;
			} else if (currentSum < key) {
				l++;
			} else {
				System.out.println("Pair found: " + arr[l] + " " + arr[r]);
				break;
			}
		}
	}

	// Question 4: Find three numbers in an unsorted array with the given sum
	static void pairUnsortedGivenSum(int[] arr, int sum) {
		// Time complexity: Big O(n^3)
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						System.out.println("Triplet found: " + arr[i] + " " + arr[j] + " " + arr[k]);
						return;
					}
				}
			}
		}

		System.out.println("No triplet available");
	}

	static void pairUnsortedGivenSum1(int[] arr, int sum) {
		// a + b + c = x
		// So for every c,
		// Find (a + b) such that, => (a + b) = x - c

		// First sort with java utility method and then do your other operations
		int n = arr.length;

		Arrays.sort(arr); // This time complexity: Big O(n * log (n))

		for (int i = 0; i < n; i++) {
			boolean found = twoSum(arr, sum - arr[i], i);

			if (found) {
				System.out.println(arr[i]);
				return;
			}
		}

		System.out.println("No triplet found");

		// Time complexity: sorting + for loop => n*log(n) + n^2 => Big O(n^2)
	}

	static boolean twoSum(int[] arr, int key, int index) {
		int n = arr.length;
		int l = 0, r = n - 1;

		for (int i = index; i < n; i++) {
			int currentSum = arr[l] + arr[r];

			if (currentSum > key) {
				r--;
			} else if (currentSum < key) {
				l++;
			} else {
				System.out.print("Triplet found: " + arr[l] + " " + arr[r] + " ");
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 1, 4, 2, 6 };
		System.out.println("Trapped water: " + trappingRainWater(a));

		int[] b = { 3, 4, 5, 1, 7, 2, 6, 5, 4, 1 };
		System.out.println("Trapped water: " + trappingRainWater(b));

		System.out.println("Max value inside array: " + maxDifferent(b));

		int[] c = { 4, 3, 5, 1, 4, 2, 1 };
		System.out.println("Max value inside array: " + maxDifferent2(c));

		int[] d = { 1, 2, 7, 8, 10, 12 };
		System.out.println("Two numbers in sorted array with given sum: ");
		pairWithGivenSum(d, 10);
		pairWithGivenSum1(d, 15);

		int[] e = { 1, 2, 4, 7, 3, 5, -2, 1 };
		System.out.println("Three numbers in unsorted array with given sum: ");
		pairUnsortedGivenSum(e, 9);
		pairUnsortedGivenSum1(e, 9);
	}

}
