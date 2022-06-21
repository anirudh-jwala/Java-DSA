package arrays3;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	public static void printMatrix(int[][] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Question 1
	public static void subArrayWithSumZero(int[] arr) {
		// Brute force approach, Time complexity: Big O(n^2)
		int n = arr.length;
		int start = -1, end = -1;

		for (int i = 0; i < n; i++) {
			start = i;
			int sum = arr[i];

			for (int j = i + 1; j < n; j++) {
				sum += arr[j];
				if (sum == 0) {
					end = j;
					break;
				}
			}

			if (end != -1) {
				break;
			}
		}

		int j = 0;
		int[] result = new int[n];

		for (int i = start; i <= end; i++) {
			result[j++] = arr[i];
		}

		System.out.println("Start index: " + start + " End index: " + end);
		System.out.print("Result: ");

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static void subArrayWithSumZero1(int[] arr) {
		// Optimized approach - Prefix sum

		// Take a value in array and traverse with sum
		// [2, 2+3 = 5, 5+1 = 6, 6+(-4) = 2, 2+3 = 5, 5+(-2)= 3]
		// [2, 5, 6, 2, 5, 3]

		int n = arr.length;

		// Code 1 - Bad way of writing
		/*
		 * int[] prefixSum = new int[n];
		 * 
		 * prefixSum[0] = arr[0];
		 * 
		 * for (int i = 1; i < n; i++) {
		 * 		prefixSum[i] = arr[i] + prefixSum[i - 1];
		 * }
		 * 
		 * for (int i = 0; i < n; i++) {
		 * 		for (int j = i + 1; j < n; j++) {
		 * 			if (arr[i] == arr[j]) { 
		 * 				System.out.println("Sub array is present");
		 * 				break;
		 * 			}
		 * 		}
		 * }
		 */

		// Code 2 - BEST
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			
			if (set.contains(sum)) {
				System.out.println("Sub array is present");
				break;
			}
			set.add(sum);
		}
	}

	// Question 2
	public static void transposeOfMatrix(int[][] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int swap = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = swap;	
			} 
		}
	}
	
	// Question 3
	public static void rotateMatrixBy90(int[][] arr) {
		int n = arr.length;
		
		transposeOfMatrix(arr);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				int swap = arr[i][j];
				arr[i][j] = arr[i][n - j - 1];
				arr[i][n - j - 1] = swap;
			}
		}
		
		printMatrix(arr);
	}

	public static void searchInASortedMatrix(int[][] arr, int key) {
		int n = arr.length;
		
		int row = 0;
		int col = n - 1;
		
		// we will start search from top-right corner element
		while ( (row < n) && (col >= 0) ) {
			
			if (arr[row][col] == key) {
				System.out.println("Found key");
				return;
			} else if (key > arr[row][col]) {
				// search key is bigger than element
				// so it will not exist in this row we need to move to the next row
				
				row++;
			} else {
				col--;
			}
			
		}
		
		System.out.println("Search was unsuccessful");
		return;
	}
	
	public static void main(String[] args) {
		int[] a = { 2, 3, 1, -4, 3, -2 };
		subArrayWithSumZero1(a);
		
		int[][] b = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		transposeOfMatrix(b);
		
		int[][] c = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		rotateMatrixBy90(c);
		
		int[][] d = {
				{1, 4, 5, 7},
				{2, 5, 6, 9},
				{6, 10, 11, 13},
				{8, 12, 15, 18}
		};
		searchInASortedMatrix(d, 10);
		searchInASortedMatrix(d, 14);
	}

}
