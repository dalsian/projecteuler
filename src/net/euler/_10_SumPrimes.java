package net.euler;

public class _10_SumPrimes {
    public static void main(String[] args) {
        
        //N.B I NEED TO USE SEIVE!!! TOOOO SLOW!
        Long prime = 2L;
        Long sum = 0L;
        
        do {
            sum += prime;
            prime =  _7_10001Prime.nextPrime(prime);
            
           
        } while (prime < 2000000);
        
        System.out.println(sum);
    }
}
