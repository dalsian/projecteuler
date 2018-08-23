package net.euler;

import java.util.HashSet;
import java.util.Set;

public class _47_DistinctPrimeFactors {

	private static boolean[] sieve;
	private static final int LIMIT = 1000000;
	
	public static void main(String[] args) {
		
		sieve = Sieve.getPrimes(LIMIT);
		
		int numerator;
		StringBuffer divisors;
		int count = 0;
		Set<Integer> factors;
		
		for (int i = 10; i < LIMIT; i++) {
			factors = new HashSet<Integer>();
			numerator = i;
			divisors = new StringBuffer(i + " = ");
			
			for (int p = 2; (p < numerator) && (p != -1); p = Sieve.getNextPrime(sieve, p)) {
				
				
				if (numerator % p == 0) {
					numerator /= p;
					factors.add(p);
					divisors.append(p + " ");
				}
			}
			
			divisors.append(numerator);
			factors.add(numerator);
			if (numerator != i && !sieve[numerator] && factors.size() == 4) {
				
				System.out.println(divisors.toString());
				
				if (++count == 4) {
					System.out.println("=========================================");
					break;
				}
			} else {
				count = 0;
			}
		}

		
	}
}
