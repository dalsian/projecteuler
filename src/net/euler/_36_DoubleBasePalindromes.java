package net.euler;

import java.math.BigInteger;

public class _36_DoubleBasePalindromes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (_4_Palindrome.isPalindrome(new BigInteger(Integer.toString(i))) && 
					_4_Palindrome.isPalindrome(new BigInteger(Integer.toBinaryString(i)))) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

}
