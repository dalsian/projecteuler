package net.euler;

public class _28_SpiralDiagonals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int xByX = 1001;
		int total = (xByX) / 2; // total iterations.
		long na = 24; // first layer;
		long nb = 0; // 
		long sum = 1 + na;
		for (int k = 2; k <= total; k++) {
			
			nb = na + 20 + ((k - 1) * 32);
			sum += nb;
			na = nb;
		}
		
		System.out.println(sum);
	}
}
