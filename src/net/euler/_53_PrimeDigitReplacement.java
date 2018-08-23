package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _53_PrimeDigitReplacement {

	private static boolean[] sieve;
	private static int max = 0;
	
	public static void main(String[] args) {
		
		sieve = Sieve.getPrimes(999999);
		StringBuffer s;
		int localMax = 0;
		List<String> ary;
		List<String> digits = new ArrayList<String>();
		int rpl;
		
		for (int lower = 10; lower < 999999; lower *= 10) {
		int limit = lower * 10 - 1;
		
		for (int j = 0; j < Integer.toString(limit).length(); j++) {
			for (int k = 0; k < Integer.toString(limit).length(); k++) {
				for (int l = 0; l < Integer.toString(limit).length(); l++) {
					digits.add(""+j+k+l);
				}
			}
		}

		for (int i = lower; i < limit && i != -1; ) {
			
			i = Sieve.getNextPrime(sieve, i);
		
			if (i != -1)
			for (String d : digits) {
				
				localMax = 0;
				s = new StringBuffer(Integer.toString(i));
				ary = new ArrayList<String>();
				
				for (int replaceble = 0; replaceble <= 9; replaceble++) {
					
					for (int idx = 0; idx < d.length(); idx++) {
						rpl = Character.getNumericValue(d.charAt(idx));
	
						s = s.replace(rpl, rpl + 1, Integer.toString(replaceble));
					}
				
					try {
					if (sieve[Integer.parseInt(s.toString())] == false && s.toString().charAt(0) != '0') {

						localMax++;
						ary.add(s.toString());
					}
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
				}
				
				if (localMax > max) {
					max = localMax;
					if (localMax == 8) {
						for (String p: ary) {
							System.out.println(p);
						}
						break;
					}
				}
				
//				System.out.println("========================");
				
//			System.out.println("++++++++++++++++++");
			}
		}
		
		}
		
		System.out.println(max);
		
	}
		
	

}
