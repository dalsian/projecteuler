package net.euler;
import static net.euler._20_FactorialDigitSum.factorial;

import java.math.BigInteger;

public class _53_CombinatoricSelections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int result = 0;
		BigInteger temp;
		BigInteger limit = new BigInteger("1000000");
		
		for (int n = 23; n <= 100; n++) {
			
			for (int r = 1; r < (n); r++) {
				
				temp = nCr(n, r);
				
				if (temp.compareTo(limit) > 0) {
//					System.out.println(n + " C " + r + " = " + temp);
					result++;
				}
			}
		}
		
		System.out.println("Result = " + result);
	}

	public static BigInteger nCr(int n, int r) {
				
		BigInteger result = factorial(n).divide(factorial(r).multiply(factorial(n - r)));
	
		return result;
	}
}
