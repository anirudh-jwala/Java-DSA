package arrays2;

public class ArraysClass {

	// Question 1
	public static void leadersOfArray(int[] arr) {
		// leader: an element is called a leader if it has no value greater than itself
		// on its right
		int n = arr.length;

		// First algorithm Big O(n^2)
		System.out.print("Leaders are: ");
		for (int i = 0; i < n; i++) {
			int currentElement = arr[i];
			boolean isLeader = true;

			for (int j = i + 1; j < n; j++) {
				if (currentElement < arr[j]) {
					isLeader = false;
					break;
				}
			}

			if (isLeader) {
				System.out.print(currentElement + " ");
			}
		}
		System.out.println();
	}

	public static void leadersOfArray1(int[] arr) {
		int n = arr.length;

		// Second algorithm Big O(n) - BAD ANIRUDH Solution
		int[] temp = new int[n];
		int largest = arr[n - 1];
		temp[0] = largest;

		for (int i = n - 2; i > 0; i--) {
			if (arr[i] > largest) {
				largest = arr[i];
				temp[n - i] = largest;
			}
		}

		System.out.print("Leaders are: ");
		for (int i = 0; i < n; i++) {
			System.out.print(temp[i] + " ");
		}
	}

	public static void leadersOfArray2(int[] arr) {
		// Second algorithm Big O(n) - Good Solution
		int largest = Integer.MIN_VALUE; // something like -infinity kind of to consider
		int n = arr.length;

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] > largest) {
				largest = arr[i];
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	// Question 2
	public static void largestSumSubArrary(int[] arr) {
		int currentSum = 0, maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			currentSum += arr[i];

			if (maxSum < currentSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}

		}

		System.out.println("Largest sum of the sub array: " + maxSum);
	}

	// Question 3
	public static void containerWithMostWater(int[] arr) {
		// Time Complexity: Big O(n^2) which is bad - brute force
		int n = arr.length;
		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			int leftIndex = arr[i];

			for (int j = i + 1; j < n; j++) {
				int rightIndex = arr[j];

				int distanceBtwRods = j - i;

				int areaOfCotainer = Math.min(leftIndex, rightIndex) * distanceBtwRods;
				maxArea = Math.max(areaOfCotainer, maxArea);
			}

		}

		System.out.println("Max water containing is of: " + maxArea);
	}

	public static void containerWithMostWater1(int[] arr) {
		// Time Complexity: Big O(n) - two pointer approach
		int n = arr.length;
		int left = 0, right = n - 1;
		int area = 0, maxArea = Integer.MIN_VALUE;

		while (left < right) {
			int height = Math.min(arr[left], arr[right]);
			int distance = right - left;

			area = height * distance;
			maxArea = Math.max(area, maxArea);

			if (arr[left] < arr[right]) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println("Max water containing is of: " + maxArea);
	}

	public static void watterTrappedInsideContainer(int[] arr) {
		int n = arr.length;
		int[] l = new int[n];
		int[] r = new int[n];
		int water = 0;

		// Generate left array
		l[0] = arr[0];
		for (int i = 1; i < n; i++) {
			l[i] = Math.max(arr[i], l[i - 1]);
		}

		// Generate right array
		r[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			r[i] = Math.max(arr[i], r[i + 1]);
		}

		for (int i = 0; i < n; i++) {
			water += Math.min(l[i], r[i]) - arr[i];
		}

		System.out.println("Max water trapped inside container: " + water);
	}

	public static void main(String[] args) {
		int[] findLeaders = { 2, 7, 6, 1, 4, 3 };
		leadersOfArray2(findLeaders);

		int[] elements = { 6, -7, 4, -2, 1, 5, -4 };
		largestSumSubArrary(elements);

		int[] containerRods = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		containerWithMostWater1(containerRods);

		int[] fatContainers = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		watterTrappedInsideContainer(fatContainers);
	}

}
