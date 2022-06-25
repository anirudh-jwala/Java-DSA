package mathematics1;

public class MainClass {

	// Question 1: Is number a Palindrome
	static boolean isPalindromeNum(int number) {
		// Time complexity: Big O( log n ) as it is integer
		// For string of length n -> Big O (n)

		// HOW?

		// Total no of digits -> log(n) if no of digits in your number is 'n'
		// total no of digits = log base 10 (n) + 1
		// 10 -> log base 10 (10) = 1 + 1 = 2
		// 20 -> log base 10 (20) = 1.. + 1 = 2
		// 100 -> log base 10 (100) = 2 * log base 10 (10) + 1 = 2 + 1 = 3
		int reverse = 0;
		int temp = number;

		while (temp > 0) {
			int lastDigit = temp % 10;
			reverse = (reverse * 10) + lastDigit;
			temp /= 10;
		}

		return number == reverse;
	}

	// Question 2: HCF/GCD of two numbers
	static int hcfOfNumber(int a, int b) {
		// Time complexity: Big O( min(a, b) )

		for (int i = Math.min(a, b); i > 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}

		return 1;
	}

	// Read euclid's gcd theorem
	// Hypothesis
	// => gcd(a, b) = gcd(a - b, b)
	// such that a is greater than b (a>b)
	static int gcd(int a, int b) {
		System.out.println(a + " " + b);
		if (a == b)
			return a;

		if (a < b)
			return gcd(b, a);

		// When a > b - euclid's theorem
		return gcd(a - b, b);
	}

	// Optimized we can write gcd(a, b) = gcd(a - b, b) as,
	// gcd(a, b) = gcd(a % b, b)
	static int gcdEuclidModified(int a, int b) {
		// Time complexity: Big O ( log n )
		System.out.println(a + " " + b);
		if (a < b)
			return gcdEuclidModified(b, a);

		if (a % b == 0)
			return b;

		return gcdEuclidModified(a % b, b);
	}

	// Question 3: LCM of two numbers => LCM = ( (a*b) / HCF )
	static int lcm(int a, int b) {
		int hcf = gcdEuclidModified(a, b);
		return (a * b) / hcf;
	}

	// Question 4: Trailing Zeros in factorial
	static void trailingZeros(int N) {
		int result = 0;
		while (N > 0) {
			result += (N / 5);
			N /= 5;
		}
		System.out.println("No of zeros: " + result);
	}

	// Question 5: Unique paths in a grid
	// m -> no of rows
	// n -> no of cols
	// Total no of steps -> (m + n)
	static int uniquePathsGrid(int m, int n) {
		int res = 1;

		for (int i = 1; i < n; i++) {
			res = (res * (m + i)) / i;
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 1221;
		System.out.println("Is number palindrome? " + n + ": " + isPalindromeNum(n));
		n = 11221;
		System.out.println("Is number palindrome? " + n + ": " + isPalindromeNum(n));

		System.out.println("HCF of two numbers: " + hcfOfNumber(24, 36));
		System.out.println("GCD of two numbers: " + gcd(60, 24));
		System.out.println("Optimized GCD of two numbers: " + gcdEuclidModified(60, 24));

		System.out.println("LCM of two numbers: " + lcm(24, 36));

		trailingZeros(5);
		trailingZeros(10);
		trailingZeros(14);
		trailingZeros(25);
		trailingZeros(125);

		int m = 3;
		n = 2;
		System.out.println("No of unique values in a matrix of dimen: (m x n)" + uniquePathsGrid(m, n));
	}

}
