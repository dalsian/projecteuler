package net.euler;

import java.util.Arrays;

public class _52_PermutedMultiples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean isPermutedMultiple;
		
		for (int i = 1; i < 999999; i++) {
			
			isPermutedMultiple = true;
			
			for (int j = 2; j < 7; j++) {
				if (!isPermuted(i, i * j)) {
					isPermutedMultiple = false;
				}
			}
			
			if (isPermutedMultiple) {
				System.out.println(i + " is permutable by multiples.");
			}
		}
	}

	private static boolean isPermuted(int i, int j) {
		
		char[] a = Integer.toString(i).toCharArray();
		char[] b = Integer.toString(j).toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		if (String.valueOf(a).equals(String.valueOf(b))) {
			return true;
		}
		return false;
	}
	

}
