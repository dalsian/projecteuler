package net.euler;

import java.util.Stack;

public class _12_DivisibleTriangular {
    
    public static void main(String[] args) {
        
        Stack<Integer> a = null;
        Stack<Integer> b = null;
        int ai;
        
        int triangle_no = 0;
        int total_divisors = 0;
        
        for (int n = 2; total_divisors <= 500; n++) {
            
            triangle_no = (n * (n + 1)) / 2;
            
            a = new Stack<Integer>();
            b = new Stack<Integer>();
            a.push(1);
            ai = 1;
            b.push(triangle_no);
            
            while ((b.peek() - ai) > 1) {
                ai++;
                if (triangle_no % ai == 0) {
                    a.push(ai);
                    b.push(triangle_no / ai);
                }
            }
            
            total_divisors = a.size() + b.size() - 1;
    
        }
        
        
        System.out.println(total_divisors);
        System.out.println(triangle_no);
    }
}
