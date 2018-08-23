package net.euler;

public class _58_SpiralPrimes {

	public static void main(String[] args) {
		
		int primes = 0;
		int n = 1;
		double percent = 100;
		for(int i = 2; percent > 0.10; i += 2) {
			
			for (int j = 0; j < 4; j++) {
				if (isPrime(n = (n + i))) {
					primes++;
					percent = primes / (i * 2.0 + 1);
				} 
			}
			System.out.print(primes + "/" + (i * 2.0 + 1) + " = ");
			System.out.println(primes / (i * 2.0 + 1));
			System.out.println("Sides = " + (i + 1));
		}
	
	}
	
	private static boolean isPrime(int n) {
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for(int i = 3; i * i < n + 1; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}

}
