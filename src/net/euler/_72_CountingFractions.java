package net.euler;

import net.euler.util.MathUtil;

public class _72_CountingFractions {

	public static void main(String[] args) {
		int loop = 1;
		long count = 0;
		for (long d = 1000000; d > 0; d--)   { //o(n^2) !!!
			for (long n = 1; n < d; n++) {
				if (MathUtil.gcd(n,d) == 1) {
					//if (((float) n)/d > (1.0/3) && ((float) n)/d < 0.5) {
						count++;
					//}
					
				}
			}
		}
		System.out.println("Total Count : " + count);
	}
	
}

	
	

