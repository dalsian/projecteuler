package net.euler;

import net.euler.util.MathUtil;

public class _44_PantagonNumbers {

	
	public static void main(String[] args) {
		int pK = 0;
		int pJ = 0;
		int plus;
		int minus = 0;
		
		for (int k = 2; k < 100000; k++) {
//			
			for (int j = k; j > 0; j--) {
				
				pK = p(k);
				pJ = p(j);
				
				if ((pK + pJ) == p((int) MathUtil.getQuadratic(3, -1, -2 * (plus = pK + pJ)))) {
					
					
					if ((pK - pJ) == p((int) MathUtil.getQuadratic(3, -1, -2 * (minus = pK - pJ)))) {
						
						System.out.println("Plus OK" + plus);
						System.out.println("Minus OK" + minus);
					}
				}
//				System.out.println("p(" + k + ") = " + pK + ", p(" + (j) + ") = " + pJ);
//				
//				System.out.println((int) MathUtil.getQuadratic(3, -1, -2 * (plus)));
//				System.out.println((int) MathUtil.getQuadratic(3, -1, -2 * (minus)));
			}
		}
		
	}

	public static int p(int n) {
		return (n * ((3 * n) - 1)) / 2;
	}
}
