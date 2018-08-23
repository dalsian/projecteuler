package net.euler;

import net.euler.util.MathUtil;

public class _73_CountingFractionsInRange {

	public static void main(String[] args) {
		int count = 0;
		for (long d = 12000; d > 0; d--)   {
			for (long n = 1; n < d; n++) {
				if (MathUtil.gcd(new long[] {n,d}) == 1) {
					if (((float) n)/d > (1.0/3) && ((float) n)/d < 0.5) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	
}

	
	

