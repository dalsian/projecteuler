package net.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _23_NonAbundantSums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Integer> sum_abundants = new HashSet<Integer>();
		
		List<Integer> abundants = new ArrayList<Integer>();
		
		for (int i = 12; i <= 58123; i++) {
			if (isAbundant(i)) {
				abundants.add(i);
				
				for (Integer abundant: abundants) {
					sum_abundants.add(i + abundant);
				}
			}
		}
		
		
		BigInteger total = BigInteger.valueOf(0l);
		
		for (int i = 1; i <= 58123; i++) {
			
			if (!sum_abundants.contains(i)) {
//				System.out.println(BigInteger.valueOf(i));
				total = total.add(BigInteger.valueOf(i));
				sum_abundants.remove(i);
			} 
		}
		
		System.out.println(total.toString());
		
		
//		
//		for (Integer i : sum_abundants) {
//			System.out.println(i);
//		}
	}
	
	private static boolean isAbundant(int n) {
		
		int sum = 0;
		for (int i = (n/2); i >= 1; i--) {
			if (n % i == 0) {
				sum += i;
				if (sum > n) {
//					System.out.println("confirmed at " + sum);
					return true;
				}
			}
		}
		
//		System.out.println("total " + sum);
		return false;
	}

}
