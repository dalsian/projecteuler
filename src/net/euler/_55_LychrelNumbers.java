package net.euler;

import java.math.BigInteger;

public class _55_LychrelNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int total = 0;
		StringBuffer s;
		BigInteger currentN;
		int count;
		
		for (int n = 1; n < 10000; n++) {
			
			count = 1;
			s = new StringBuffer(Long.toString(n));
			
			currentN = new BigInteger(Integer.toString(n));
			currentN = currentN.add(new BigInteger(s.reverse().toString()));
			
			
			while (!isPalindrome(currentN) && (++count < 50)) {
				s = new StringBuffer(currentN.toString());
				currentN = currentN.add(new BigInteger(s.reverse().toString()));
			}
		
			if (isPalindrome(currentN)) {
//				System.out.println(n + " is a not Lynchrel number with " + count + " iteration. " + currentN);
				
			} else {
				System.out.println(n + " is a Lynchrel number ");
				total++;
			}
		}
		System.out.println(total);
	}
	
	
	
	private static boolean isPalindrome(BigInteger n) {
		
		String s = n.toString();
		for (int i = 0; i < (s.length() / 2) ; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
