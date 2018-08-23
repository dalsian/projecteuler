package net.euler;

import java.math.BigInteger;

public class _20_FactorialDigitSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String res = factorial(100).toString();
		
		System.out.println(res);
		
		StringBuffer buf = new StringBuffer(res);
		int sum = 0;
		
		while (buf.length() > 0) {
			sum += Character.getNumericValue(buf.charAt(0));
			buf.deleteCharAt(0);
		}
		
		System.out.println(sum);
	}
	
	public static BigInteger factorial(int n) {
		
		BigInteger i = BigInteger.valueOf(n);
	
		if (n == 0 || n == 1) {
			return BigInteger.valueOf(1l);
		}
		
		return i.multiply(factorial(n - 1));
	}

}
