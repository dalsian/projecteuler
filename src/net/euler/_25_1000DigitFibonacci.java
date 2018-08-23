package net.euler;

import java.math.BigInteger;

public class _25_1000DigitFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean found = false;
		
		BigInteger f1 = BigInteger.valueOf(1);
		BigInteger f2 = BigInteger.valueOf(1);
		BigInteger f3;
		
		for (long n = 3; !found; n++) {
			
			f3 = f2.add(f1);
			f1 = f2;
			f2 = f3;
			
			
			if (f3.toString().length() >= 2500) {
				found = true;
				System.out.println(f3);
				System.out.println(" = " + n + "th term");
				
			}
		}
	}

}
