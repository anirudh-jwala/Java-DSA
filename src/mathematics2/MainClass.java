package mathematics2;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		System.out.println(isPrime(1));
		System.out.println(isPrimeOp(49));
		System.out.println(isPrimeEfficient(911));

		allDivisors(30);
		allDivisorsOp(30);
		allDivisorsOpSorted(30);
		allDivisorsOpSorted(36);

		printUntilNPrimes(30);
		sieveOfEratosthenes(30);

		System.out.println(fastPower(3, 3));
	}

	// Question 1: Check if number is Prime or not
	static boolean isPrime(int n) {
		/*
		 * Time complexity: Big O (n)
		 */
		if (n == 1)
			return false;

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Question 2: Efficient solution for isPrime
	static boolean isPrimeOp(int n) {
		/*
		 * Time complexity: Big O (sqrt n)
		 */
		if (n == 1)
			return false;

		// i <= Math.sqrt(n) can also be written as i*i <= n
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Question 3: More Efficient solution for isPrime
	static boolean isPrimeEfficient(int n) {
		if (n == 1)
			return false;

		if (n == 2 || n == 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	// Question 4: Print all divisors of N
	static void allDivisors(int n) {
		// Time complexity: Big O (n) or Theta (n)
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	static void allDivisorsOp(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");

				if ((n / i) != i) {
					System.out.print((n / i) + " ");
				}
			}
		}
		System.out.println();
	}

	static void allDivisorsOpSorted(int n) {
		int i = 1;
		for (; i * i < n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		i--;
		for (; i >= 1; i--) {
			if (n % i == 0)
				if ((n / i) != i)
					System.out.print((n / i) + " ");
		}
		System.out.println();
	}

	// Question 5: Sieve of Eratosthenes
	// Brute force: Print all prime numbers between 1...N
	static void printUntilNPrimes(int n) {
		// Time complexity: Big O ( n sqrt(n) ) => O (n ^ 3/2)
		for (int i = 1; i <= n; i++) {
			if (isPrimeEfficient(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	static void sieveOfEratosthenes(int n) {
		// Time complexity: Big O (n log(log n))

		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				System.out.print(i + " ");
		}
		System.out.println();
	}

	// Question 6: Fast power, calculate pow(a, b)
	static int fastPower(int a, int b) {
		// Time complexity: Big O(log n) where, n = b

		// need to calculate a^b
		// When b is event, a^(b/2) * a^(b/2) => a^b
		// b is odd, a^(b/2) * a^(b/2) * a => a^b

		if (b == 0)
			return 1;

		int halfRes = fastPower(a, b / 2);

		int fullRes = halfRes * halfRes;

		// When b is odd
		if (b % 2 != 0) {
			fullRes = fullRes * a;
		}

		return fullRes;
	}
}
