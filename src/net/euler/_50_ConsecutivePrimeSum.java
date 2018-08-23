package net.euler;

public class _50_ConsecutivePrimeSum {

	private static boolean[] sieve;
	
	public static void main(String[] args) {
		
		int limit = 1000000;
		int maxNum = 0;
		int startNum = 0;
		int endNum = 0;
		int maxSum = 0;
		
		sieve = Sieve.getPrimes(limit);
		
		
		int tempSum = 0;
		int tempMaxNum;
		int tempEndNum = 0;
		
		for (int idx = 2; idx != -1; idx = Sieve.getNextPrime(sieve, idx)) {
			tempSum = 0;
			tempMaxNum = 0;
			
			for (int i = idx; (i != -1); i = Sieve.getNextPrime(sieve, i)) {
				
				if ((tempSum+i) < limit) {
					tempSum += i;
					//tempMaxNum++;
					tempEndNum = i;
					
					if (sieve[tempSum] == false) {
						 
						
						tempMaxNum = 0;
						int s = idx;
						do {
							tempMaxNum++;
							s = Sieve.getNextPrime(sieve, s);
						}
						while (s <= tempEndNum);
						
//						tempMaxNum = tempEndNum - idx;
						
						if (tempMaxNum > limit) {
							continue;
						}
						if (tempMaxNum >= maxNum) {
							maxNum = tempMaxNum;
							startNum = idx;
							endNum = tempEndNum;
							maxSum = tempSum;
							System.out.println(maxSum + " has " + maxNum + " consecutive primes.");
						}
						
						
						
					}
				}
			}
			
		}
		
//		System.out.println(maxSum);
//		System.out.println(maxNum);
//		System.out.println(startNum);
//		System.out.println(endNum);
	}

}
