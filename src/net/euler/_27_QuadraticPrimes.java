package net.euler;

import net.euler.util.PrimeUtil;

public class _27_QuadraticPrimes {

	private static int maxN = 0;
	private static int[] ab = new int[2];
	
	public static void main(String[] args) {
		
		for (long a = -999; a < 1000; a++) {
			for (long b = -999; b < 1000; b++) {
				if (a != 0 && b != 0) {
					int n = 0;
					while (PrimeUtil.isPrime((n * n ) + (a * n) + b)) {
						n++;
					}
					if (n > maxN) {
						maxN = n;
						ab[0] = (int) a;
						ab[1] = (int) b;
					}
				}
			}
		}
		
		System.out.println("a = " + ab[0] + " b = " + ab[1]);
		System.out.println("n = " + maxN);
		System.out.println("result : " + (ab[0] * ab[1]));
	}

}
