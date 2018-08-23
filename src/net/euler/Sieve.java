package net.euler;

/**
 * 
 * Implementation of sieve of Erathosthenes
 *
 */
public class Sieve {
	
	public static void main(String[] args) {
		
		int limit = 10000;
		boolean[] sieve = getPrimes(limit);
		
		System.out.println("Sieve complete.");
		
		for (int i = 2; i < limit; i++) {
			if (!sieve[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean[] getPrimes(int N) {
		
		boolean[] sieve = new boolean[N];
		int crossLimit = (int) Math.sqrt((double) N);
		
		for (int i = 4; i < N; i += 2) {
			sieve[i] = true; //eliminate composite numbers.
		}
		
		for (int i = 3; i < crossLimit; i += 2) {
			
			if (!sieve[i]) { //isPrime
				
				for (int j = i * i; j < N; j += (2 * i)) {
					sieve[j] = true;
				}
			}
		}
		
		return sieve;
	}

	public static int getNextPrime(boolean[] sieve, int n) {
		
		for (int i = n + 1; i < sieve.length; i++) {
			if (!sieve[i]) {
				return i;
			}
		}
		
		return -1;
	}
}
