package net.euler;

public class _39_IntegerRightTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int maxCount = 0;
		int maxP = 0;
		for (int p = 1; p <= 1000; p++) {
			
			int count = 0;
			for (int a = 1; a < p; a++) {
				for (int b = 1; b < p; b++) {
					if (a * a + b * b == (p - a - b) * (p - a - b)) {
//						System.out.println("a = " + a + ", b = " + b);
						count++;
					}
				}
			}
//			System.out.println(p + " = " + count / 2);
			if ((count / 2) >= maxCount) {
				maxCount = (count / 2);
				maxP = p;
//				System.out.println(maxP + " with counts " + maxCount);
			}
			
		}
		
		System.out.println(maxP + " with counts " + maxCount);
	}

}
