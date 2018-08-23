package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _24_LexicographicPermutations {

	private static List<Integer> nums;
	
	public static void main(String[] args) {
			
		long start = System.currentTimeMillis();
				
		nums = new ArrayList<Integer>();
		for (int n = 0; n <= 9; n++) { nums.add(n); }
	
		int i = 1000000;  // designated ith term
		
		while (nums.size() >= 1) { //each loop computes each digit of the result
			
			//x is the numbers of terms sharing the same first digit
			int x = (int) _20_FactorialDigitSum.factorial(nums.size() - 1).doubleValue();
			
			int n = nums.get((int)((i - 1) / Math.ceil(x)));
			
			System.out.print(n);
			
			//permutation without repetition (reduce the problem for next iteration)
			nums.remove((Integer) n);
			
			i = ((i % x == 0) ? x : i % x); //new ith term for n-1 permutation
		}
		
		System.out.println("\n" + (System.currentTimeMillis() - start) + "ms");
	}
}
