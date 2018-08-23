package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _7_10001Prime {
    
    private static List<Long> primes = new ArrayList<Long>();
    
    //
    public static long nextPrime(long num) {
        long next = 0;
        
        if (num < 3) {
            if (num == 1) {
                return 2;
            } else if (num == 2) {
                return 3;
            } else {
                return 1;
            }
        }
        boolean isDivisible;
        do {
            ++num;
            isDivisible = false;
            if ((num % 2 != 0) && (num % 3 != 0)) {
                
                
                for (int p = 0; p < ((primes.size()/2) -1); p++) {
                    if (num % primes.get(p) == 0) {
                        isDivisible = true;
                    }
                }
                if (!isDivisible) {
                    next = num;
                }
                
            }
        } while(next == 0);
        
        primes.add(next);
        
        return next;
    }
    
    public static void main(String[] args) {
        
        int limit = 10001;
        long prime = 1;
        
        for (int i = 1; i <= limit; i++) {
            prime = nextPrime(prime);
            System.out.println(prime);
        }
    }
}
