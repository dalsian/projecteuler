package net.euler;

import net.euler.util.PrimeUtil;

public class _35_CircularPrimes {
	
	private static StringBuffer buff;
	private static String charDigit;
	
	private static int limit = 1000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        long prime = 1;
        
        int id = 1;
        for (int i = 1; i <= limit; i++) {
            prime = PrimeUtil.nextPrime(prime);
            if ((prime <= limit) && isCircular(prime)) {
            	System.out.println((id++) + " " + prime);
            }
        }
        System.out.println(isCircular(31));
	}
	
	public static boolean isCircular(long p) {
		
		buff = new StringBuffer(Long.toString(p));
		
		for (int i = 0; i < buff.length(); i++) {
			charDigit = buff.substring(0, 1);
			buff = buff.deleteCharAt(0);
			buff.append(charDigit);
			
			long invert = Long.parseLong(buff.toString());
			
			if (invert > limit || !isPrime(invert)) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static boolean isPrime(long p) {
		
        return PrimeUtil.isPrime(p);
	}

}
