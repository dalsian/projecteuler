package net.euler;

public class _3_PrimeFactor {
    
    //NB. this primality is incorrect for large numbers. see problem 7 for correct function.
    public static long nextPrime(long n) {
        long next = 0;
        long num = n;
        
        if (num < 3) {
            if (num == 1)
                return 2;
            else if (num == 2)
                return 3;
            else 
                return 1;
        }
        
        do {
            ++num;
            if (((num % 2) != 0) && ((num % 3) != 0)) {
                next = num;
            }
        } while(next == 0);
        
        System.out.println(next);
        return next;
    }
    
    public static void main(String[] args) {
        long N = 600851475143L;
        long prime = 3;
        
        long[] factors = new long[50];
        int i = 0;
        
        while (prime <= N) {
            if (N % prime != 0) {
                prime = nextPrime(prime);
            } else {
                factors[i++] = prime;
                N = N / prime;
            }
        }
        for (int x = 0; x < 50; x++) {
            System.out.print(factors[x] + " ");
        }
    }
    
}
