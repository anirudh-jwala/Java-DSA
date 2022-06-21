package javaBasics2;

public class MultiDimentionalArray {

	/**
	 * Array of arrays
	 * 
	 * Each element of multi-dimentional array is an array
	 * 
	 * int[][] a = new int[3][4];
	 * 
	 * 3 => no of rows
	 * 4 => no of columns
	 * 
	 * In memory they are actually stored sequentially only, but for out
	 * visualization you can draw as a matrix
	 * 
	 * 		a ==> [ [a, b, c, d], [...], [...] ]
	 * 
	 * or you can write as 
	 * 
	 * 		a ==> [ [a, b, c, d]
	 * 				[e, f, g, h]
	 * 				[i, j, k, l] ]
	 */

	public static void main(String[] args) {
		
		int[][] a = new int[2][3];
		a[0][0] = 2;
		
		int directInitalization[] = {2, 1, 4, 5, 6};
		
		int[][] b = {
				{2, 1, 4},
				{4, 1, 3},
		};
	}

}
