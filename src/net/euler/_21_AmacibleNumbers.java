package net.euler;

import java.util.HashSet;
import java.util.Set;

public class _21_AmacibleNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Long> amacibles = new HashSet<Long>();
		long sum = 0;
		long b;
		for (long a = 2; a < 10000; a++) {
			
			b = getDivisorSum(a);
			if ((getDivisorSum(b) == a) && (a != b)) {
				amacibles.add(a);
				amacibles.add(b);
			}
		}
	
		for (Long a : amacibles) {
			sum += a;
		}
		
		System.out.println(sum);
	}
	
	private static long getDivisorSum(long n) {
		long sum = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
//		sum += n;
		return sum;
	}

}
