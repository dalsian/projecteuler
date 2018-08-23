package net.euler;

public class _6_SumSquareSum {
    public static void main(String[] args) {
        
        int limit = 100;
        long sumOSquare = 0;
        long squareOSum = 0;
            
        for (int i = 1; i <= limit; i++) {
            sumOSquare += (i * i);
            squareOSum += i;
        }
        squareOSum = squareOSum * squareOSum;
        
        System.out.println("SumSquare: " + sumOSquare);
        System.out.println("SquareSum: " + squareOSum);
        System.out.println("Difference: " + (squareOSum - sumOSquare));
    }
}
