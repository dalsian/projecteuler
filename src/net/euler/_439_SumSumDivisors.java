package net.euler;

import java.math.BigInteger;

public class _439_SumSumDivisors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger n = BigInteger.valueOf(10).pow(11);
//		System.out.println(n);
		System.out.println(s(n).mod(BigInteger.valueOf(10).pow(9)));

	}
	
	private static BigInteger s(BigInteger n) {
		
		BigInteger sum = BigInteger.valueOf(0);
		
		BigInteger i = BigInteger.valueOf(1);
		BigInteger j = BigInteger.valueOf(1);
		
		while (!i.equals(n.add(BigInteger.valueOf(1)))) {
			while (!j.equals(n.add(BigInteger.valueOf(1)))) {

//				System.out.println("d(" + i + "*" + j + "=" +  i.multiply(j)  +")" );
				sum = sum.add(d(i.multiply(j)));
				
				
				j = j.add(BigInteger.valueOf(1));
			}
			i = i.add(BigInteger.valueOf(1));
			j = BigInteger.valueOf(1);
		}
		
		return sum;
	}
	
	private static BigInteger d(BigInteger n) {
		
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger i = BigInteger.valueOf(1);
		while (!i.equals(n.add(BigInteger.valueOf(1)))) {
			if (n.mod(i).equals(BigInteger.valueOf(0))) {
				sum = sum.add(i);
			}
			i = i.add(BigInteger.valueOf(1));
		}
//		for (int i = 1; i <= n / 2; i++) {
//			if (n % i == 0) {
//				sum += i;
//			}
//		}
//		sum += n;
		
		
		return sum;
	}

}
