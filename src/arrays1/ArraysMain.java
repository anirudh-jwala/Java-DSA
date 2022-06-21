package arrays1;

public class ArraysMain {

	/// Search for key in array
	public static void search(int[] a, int key) {
		// Time complexity: Big O(n)
		int result = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				result = i;
				break;
			}
		}

		if (result == -1) {
			System.out.println("Key not found");
		} else {
			System.out.println("key is available at index: " + result);
		}
	}

	/// Delete an element from array

	// Strategy: search for value, first found value should be removed from array
	// Once value is found left shift all the right side values to one location
	// previous
	public static int delete(int[] a, int key) {
		// Time complexity: Big O(n)
		int i = 0;
		int n = a.length;

		for (; i < n; i++) {
			if (a[i] == key) {
				break;
			}
		}

		if (i == n) {
			// when search was done and no element was found
			// return the size of array itself
			return n;
		}

		for (int j = i; j < n - 1; j++) {
			a[j] = a[j + 1];
		}

		return n - 1;
	}

	public static void largestElementOfArray(int a[]) {
		// Time complexity: Theta(n)
		if (a.length == 0) {
			System.out.println("Nothing to find");
			return;
		}

		int maxIndex = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > a[maxIndex]) {
				maxIndex = i;
			}
		}

		System.out.println("Largest element & index in array. Element: " + a[maxIndex] + "; Index:" + maxIndex);
	}

	public static void secondLargestElementOfArray(int[] a) {
		// Time complexity: Theta (n)
		if (a.length < 2) {
			System.out.println("Nothing to find");
			return;
		}

		int largest = 0, secondLargest = -1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[largest]) {
				secondLargest = largest;
				largest = i;
			} else if (a[i] < a[largest]) {

				// check with second value
				if (secondLargest == -1 || a[i] > a[secondLargest]) {
					secondLargest = i;
				}

			}
		}

		System.out.println("Second largest value: " + a[secondLargest] + " index: " + secondLargest);
	}

	public static void removeDuplicatesFromSortedArray(int[] a) {
		// Time complexity: Big O(n)
		int n = a.length;
		int j = 0;

		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[j]) {
				a[j + 1] = a[i];
				++j;
			}
		}
		a[j++] = a[n - 1];

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 1, 4, 6, 5 };
		int key = 6;

		search(a, key);
		delete(a, key);

		int b[] = { 4, 1, 7, 2, 3 };
		largestElementOfArray(b);

		int c[] = { 7, 2, 1, 6, 4 };
		secondLargestElementOfArray(c);

		int d[] = { 2, 2, 3, 4, 4, 7, 7, 7, 7 };
		removeDuplicatesFromSortedArray(d);

	}

}
