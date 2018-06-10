import java.util.*;

/**
* To find the last digit of sum of squares of n Fibonacci terms.
* To do this efficiently, we need not square each term and then add it.
* We know that, the sum of squares of n Fibonacci terms is equal to the Product of nth and (n+1)th Fibonacci terms.
* Also using the property of periodicity of last digit recurrence in Fibonacci series, we can solve this problem efficiently for
* large values of n.
*/
public class FibonacciSumOfSquaresLastDigit {

	private static long getFibonacciSumSquaresLastDigit(long n) {
		if (n <= 1)
			return n;

		long current = calc_fib(n % 60);
		long next = calc_fib((n + 1) % 60);
    
                //We need not know what is the actual product to find the last digit. Just the last digit of F(n) and F(n+1) are sufficient.
                //This reduces the multiplication complexity greatly! ;)
		return ((current % 10) * (next % 10) % 10);
	}

        //General code to find the nth Fibonacci term
	private static long calc_fib(long n) {
		if (n == 1 || n == 0) {
			return n;
		}

		long fib1 = 0;
		long fib2 = 1;
		long fib3 = 0;
		for (long i = 2; i <= n; i++) {
			fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
		}
		return fib3;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSumSquaresLastDigit(n);
		System.out.println(s);
	}
}
