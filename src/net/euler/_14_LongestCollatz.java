package net.euler;

public class _14_LongestCollatz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int number = 0;
		long maxCount = 0;
		long currentCount;
		
		for (int i = 1000000; i > 1; i--) {
			currentCount = countSequence(i);
			if (currentCount > maxCount) { 
				maxCount = currentCount;
				number = i;
			}
		}
		System.out.println(number + " - " + maxCount);
	}
	
	private static long countSequence(long n) {
		long count = 1l;
		while (n > 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = (3 * n) + 1;
			}
			count++;
		}
		return count;
	}

}
