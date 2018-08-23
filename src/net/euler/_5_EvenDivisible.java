package net.euler;

public class _5_EvenDivisible {
    private static int limit = 20;
    
    private static boolean isDivisible(int n) {
        
        for (int i = limit; i > 0; i--) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 10;
        
        while (!isDivisible(n)) {
            n++;
        }
        System.out.println(n--);
    }
}
