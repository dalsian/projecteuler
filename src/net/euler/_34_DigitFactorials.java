package net.euler;

import java.math.BigInteger;

public class _34_DigitFactorials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		StringBuffer intBuff = null;
		BigInteger currentSum = null;
		BigInteger digitSum = new BigInteger("0");
		int currentInt;
		
		for (int i = 10; i <= 10000000; i++) {
			
			intBuff = new StringBuffer(Integer.toString(i));
			currentSum = new BigInteger("0");
		
			for(int c = 0; c < intBuff.length(); c++) {
				currentInt = Integer.parseInt(intBuff.substring(c, c + 1));
				
				currentSum = currentSum.add(_20_FactorialDigitSum.factorial(currentInt));
		
			}
			if (currentSum.equals(new BigInteger(Integer.toString(i)))) {
				System.out.println(i);
//				digitSum.add(currentSum);
			}
		}
		
//		System.out.println(digitSum);
	}

}
