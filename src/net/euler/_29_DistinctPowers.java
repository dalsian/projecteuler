package net.euler;

import java.util.HashSet;
import java.util.Set;

public class _29_DistinctPowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Double> n = new HashSet<Double>();
		
		for (double a = 2; a <= 1000; a++) {
			for (double b = 2; b <= 1000; b++) {	
//				n.add((double) Math.round((b * Math.log(a)) * 100000000) / 100000000);
				n.add(Math.pow(a, b));
			}
		}
		System.out.println(n.size());
		
		System.out.println("\n" + (System.currentTimeMillis() - start) + "ms");
	}

}
