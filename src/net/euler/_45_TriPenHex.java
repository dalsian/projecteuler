package net.euler;

import net.euler.util.MathUtil;

public class _45_TriPenHex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long tri = 0;
		long pen = 0;
		long hex = 0;

		for (long n = 285; n < 100000; n++) {
//			tri = (int) MathUtil.getQuadratic(3, -1, -2 * (n));
			tri = triP(n);
			
			for (long j = 1; j < 100000000; j++) {
				if ((pen = penP(j)) == tri) {
//					System.out.println(j);
					
					for (long k = 1; k < 100000000; k++) {
						if ((hex = hexP(k)) == tri) {
							
							System.out.println("n = "  + n + ", yields " + tri);
						}
					}
					
				}
			}
		}
	}

	public static long triP(long n) {
		return (n * (n + 1)) / 2;
	}
	public static long penP(long n) {
		return (n * ((3 * n) - 1)) / 2;
	}
	public static long hexP(long n) {
		return n * ((2 * n) - 1);
	}
}
