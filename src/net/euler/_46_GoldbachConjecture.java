package net.euler;

public class _46_GoldbachConjecture {

	static boolean[] sieve;
	
	public static void main(String[] args) {
		
		sieve = Sieve.getPrimes(6000);
		
		int p;
		double y = 0;
		boolean exists;
		
		String str = "";
		
		for (int c = 9; c < 6000; c += 2) {
			
			exists = false;
			if (sieve[c]) {
				
				p = 2;
				
				while (p < c && p != -1) {
					
					y = Math.sqrt((c - p) / 2);
					
					if (y == ((double)(int)y)) {
						str = c + " = " + p + " + 2 (" + y + ")^2   true";
						System.out.println(str);
						exists = true;
					} else {
						str = c + " = " + p + " + 2 (" + y + ")^2   false";
					}
					
					p = Sieve.getNextPrime(sieve, p);
					
				}
				
				if (p <= Sieve.getNextPrime(sieve, c) && !exists) {
					
					System.out.println(str);
					System.out.println(c);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Conjecture false! <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					break;
				}
			}
		}
	}

}
