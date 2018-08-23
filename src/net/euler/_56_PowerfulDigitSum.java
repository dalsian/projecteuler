package net.euler;

import java.math.BigInteger;

public class _56_PowerfulDigitSum {

	/**
	 * @param args
	 */
	
	static int maxSum = 0;
	
	public static void main(String[] args) {
		
		BigInteger num;
		char[] numAry;
		int tempSum;
		
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				
				tempSum = 0;
				
				num = new BigInteger(Integer.toString(i));
				num = num.pow(j);
				
				numAry = num.toString().toCharArray();
				
				for (char c : numAry) {
					tempSum += Character.getNumericValue(c);
				}
				
				if (maxSum < tempSum) {
					maxSum = tempSum;
				}
				
				System.out.println(num);
			}
		}
		
		System.out.println(maxSum);
	}
	 
}

