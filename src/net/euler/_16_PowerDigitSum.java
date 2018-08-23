package net.euler;

public class _16_PowerDigitSum {

	public static void main(String[] args) {
		
		StringBuffer num = new StringBuffer(power("2",15));
		System.out.print(num + " : ");
		
		int sum = 0;
		while (num.length() > 0) {
			sum += Character.getNumericValue(num.charAt(0));
			num.deleteCharAt(0);
		}
		
		System.out.println(sum);
	}

	private static String power(String x, int y) {
		
		calculatePower(x, y, Integer.parseInt(x));
		
		return _13_LargeSum.sum.reverse().toString();
	}
	
	private static void calculatePower(String x, int y, int initial_x) {
		
		if (initial_x == 0) { initial_x = Integer.parseInt(x); }
		
		int[][] inputAry = new int[initial_x][];
		int xLen = String.valueOf(x).length();
		
		int[] xAry = new int[xLen];
		
		for (int i = 0; i < (xLen); i++) {
			xAry[i] = Integer.parseInt(x.substring(i, i+1));
		}
		
		for (int i = 0; i < initial_x; i++) {
			inputAry[i] = xAry;
		}
		
		_13_LargeSum.initialize(initial_x, xLen, inputAry);
		_13_LargeSum.add();
		
		// Base case
		if (y > 2) {
			calculatePower(_13_LargeSum.sum.reverse().toString(), --y, initial_x);
		}
		
	}
}
