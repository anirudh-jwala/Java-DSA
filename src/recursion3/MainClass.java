package recursion3;

public class MainClass {

	// Question 1: Rat in a maze
	public static boolean ratInMaze(int[][] arr, boolean[][] visited, int i, int j) {
		int n = arr.length;

		// Base condition
		if (i >= n || j >= n || arr[i][j] == 0 || visited[i][j]) {
			return false;
		}

		// Base condition for successfully reached
		if (i == n - 1 && j == n - 1) {
			// base condition saying that we are on the last cell of the matrix
			return true;
		}

		// Mark this cell as visited
		visited[i][j] = true;

		// Rat is moving down direction -> check if a path is possible from down
		if (ratInMaze(arr, visited, i + 1, j)) {
			return true;
		}

		// Rat is moving right direction -> check if a path is possible from right
		if (ratInMaze(arr, visited, i, j + 1)) {
			return true;
		}

		// if none of the above are true, then we should backtrack -> mark this cell as
		// unvisited & backtrack
		visited[i][j] = false;

		// Backtrack
		return false;
	}

	// Question 2: N Queens
	public static boolean isSafe(int[][] arr, int n, int row, int col) {
		for (int i = 0; i < n; i++) {
			if (arr[i][col] == 1)
				return false;
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 1)
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (arr[i][j] == 1)
				return false;
		}

		return true;
	}

	public static boolean nQueen(int[][] arr, int n, int row) {
		// Base case
		if (row == n) {
			return true;
		}

		for (int col = 0; col < n; col++) {
			if (isSafe(arr, n, row, col)) {
				arr[row][col] = 1;

				if (nQueen(arr, n, row + 1)) {
					return true;
				}

				// Backtracking
				arr[row][col] = 0;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] arr = {
				{ 1, 1, 0, 1 },
				{ 1, 1, 1, 1 },
				{ 0, 0, 1, 0 },
				{ 1, 1, 1, 1 },
			};

		int n = arr.length;
		boolean[][] visited = new boolean[n][n];

		// i, j => 0, 0 where the rat is starting
		boolean isPathPossible = ratInMaze(arr, visited, 0, 0);
		System.out.println("Is the path present? " + isPathPossible);

		int noOfQueens = 4;
		int size = 4;
		int[][] arr2 = new int[size][size];

		System.out.println("N Queens: " + nQueen(arr2, noOfQueens, 0));
		for (int[] array : arr2) {
			for (int e : array) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

}
