package net.euler;

import net.euler.util.PrimeUtil;

public class _37_TruncatablePrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		long prime = 1;
        
        for (int i = 0; i < 11; ) {
            prime = PrimeUtil.nextPrime(prime);
            if (prime > 11) {
                if (isTruncatablePrime(prime)) {
                	i++;
                	sum += prime;
                	System.out.println(prime);
                }
            }
            
        } 
        
        System.out.println(sum);
        
	}
	
	public static boolean isTruncatablePrime(long p) {
		
		StringBuffer prime = new StringBuffer(Long.toString(p));
		StringBuffer prime2 = new StringBuffer(prime.toString());

		
//		System.out.println(prime);
//		System.out.println(prime2);
		
		while (prime.length() > 1) {
			prime.deleteCharAt(0);
			if (!PrimeUtil.isPrime(Long.parseLong(prime.toString()))) {
				return false;
			}
		}
		for (int i = prime2.length() - 1; i > 0; i--) {
			prime2.deleteCharAt(i);
			if (!PrimeUtil.isPrime(Long.parseLong(prime2.toString()))) {
				return false;
			}
		}
		
		return true;
	}
}
