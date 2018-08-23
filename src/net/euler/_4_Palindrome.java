package net.euler;

import java.math.BigInteger;

public class _4_Palindrome {

//    public static boolean isPalindrome(long n) {
//        
//        String left = "";
//        String right = "";
//        String s = Long.toString(n);
//        int len = s.length();
//        
//        left = s.substring(0,len/2);
//
//        if (len % 2 == 0) {
//            right = s.substring((len / 2) , len);
//        } else {
//            right = s.substring((len / 2) + 1, len);
//        }
//        StringBuilder b = new StringBuilder(right);
//        right = b.reverse().toString();
////        System.out.println(left + " " + right);
//        return left.equals(right);
//    }
	
	public static boolean isPalindrome(BigInteger n) {
        
        String left = "";
        String right = "";
        String s = n.toString();
        int len = s.length();
        
        left = s.substring(0,len/2);

        if (len % 2 == 0) {
            right = s.substring((len / 2) , len);
        } else {
            right = s.substring((len / 2) + 1, len);
        }
        StringBuilder b = new StringBuilder(right);
        right = b.reverse().toString();
//        System.out.println(left + " " + right);
        return left.equals(right);
    }

    public static void main(String[] args) {
    
        int f1;
        int f2;
        int palindrome = 0;
        int n = 0;
        
        for (f1 = 999; f1 >= 1; f1--) {
            for (f2 = 999; f2 >= 1; f2--) {
                
                n = f1 * f2;
                if (isPalindrome(new BigInteger(Integer.toString(n)))) {
                    if (n > palindrome) {
                        palindrome = n;
                        System.out.println(f1 + " * " + f2 +" = " + palindrome);
                    }
                }
                
            }
        }
    
        
        System.out.println(palindrome);
    }
}
