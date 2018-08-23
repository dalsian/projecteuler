package net.euler;

import java.math.BigInteger;

public class _63_PowerfulDigitCounts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 1; // for 1 = 1 ^ 1
		BigInteger N;
		
		for(int base = 2; base < 1000; base++) {
			for (int pow = 1; pow < 100; pow++) {
				N = new BigInteger(Long.toString(base));
				N = N.pow(pow);
				if (N.toString().length() == pow) {
					System.out.println(count + ": " + base + " ^ " + pow + " = " + N.toString());
					count++;
				}
			}
		}
	}

}
