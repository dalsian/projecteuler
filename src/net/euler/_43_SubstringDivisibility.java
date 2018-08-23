package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _43_SubstringDivisibility {

	public static int[] dividers = new int[] {17,13,11,7,5,3,2};
	public static long result = 0;
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		StringBuffer pandigital;
		
		for (int i = 999; i >= 1; i--) {
			if (i % dividers[0] == 0) {
				pandigital = new StringBuffer(Integer.toString(i));
				for (int j = pandigital.length() + 1; j <= 3; j++) {
					pandigital.insert(0, '0');
				}
				appendDigit(1, pandigital);
			}
		}
		System.out.println("Sum : " + result);
		System.out.println(System.currentTimeMillis() - startTime + " ms");
	}
	
	public static void appendDigit(int dividerIdx, StringBuffer pandigital) {
		//is divisible
		String sub = null;
		StringBuffer pandigital2 = null;
		
		for (int i = 0; i < 10; i++) {
			pandigital2 = new StringBuffer(pandigital);
			pandigital2.insert(0, i);
			
			if (noOverlap(pandigital2.toString())) {

				sub = pandigital2.substring(0, 3);
				if (pandigital2.length() == 10) {
//					System.out.println(pandigital2.toString());
					result += Long.parseLong(pandigital2.toString());
					continue;
				}
				if (Integer.parseInt(sub) % dividers[dividerIdx] == 0) {
					appendDigit(dividerIdx + 1, pandigital2);
				}
			}
		}
	}
	
	public static boolean noOverlap(String out) {
		StringBuffer buff = new StringBuffer(out);
		String c;
		while(buff.length() > 0) {
			c = buff.substring(0, 1);
			buff.deleteCharAt(0);
			if (buff.indexOf(c) != -1) {
				return false;
			}
		}
		return true;
	}

}
