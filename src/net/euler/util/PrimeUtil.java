package net.euler.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtil {
	
	private static List<Long> primes = new ArrayList<Long>();
   
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
                
                
                for (int p = 0; p < ((primes.size()/2) - 1); p++) {
                    if (num % primes.get(p) == 0) {
                        isDivisible = true;
                    }
                }
                if (!isDivisible) {
                    next = num;
                }
                
            }
        } while(next == 0);
        
        if (!primes.contains(next)) {
        	primes.add(next);
        }
        
        return next;
    }
    public static boolean isPrime(long num) {
    	
    	if(num < 0) num *= -1;
    			
    	if ((num % 2 != 0) && (num % 3 != 0) && (num != 1)) {
    		for (long i = 5; i < num; i ++) {
    			if (num % i == 0) {
    				return false;
    			}
    		}
    	} else if (num != 2 && num != 3 && num != 5) {
    		return false;
    	}
    	return true;
    }
    
    public static boolean isPrime2(long num) {
        if(num == 2)
            return true;

        if(num % 2 == 0 || num == 1 || num == 0)
            return false;

        long root = (int) Math.sqrt((double)num) + 1;
        for(long i = root; i >= 2; i--) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
