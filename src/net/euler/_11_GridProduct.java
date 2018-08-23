package net.euler;

import java.io.File;

import java.io.IOException;

import java.util.Scanner;

public class _11_GridProduct {
    
    private static int[][] M = new int[20][20];
    
    public static void main(String[] args) throws IOException {
        
        populateM();
        
        long gProduct = 0L;
        long product = 1L;
        
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20 - 3; c++) {
                product =  M[r][c] * M[r][c+1] * M[r][c+2] * M[r][c+3];
                if (product > gProduct) {
                    gProduct = product;
                }
//                System.out.print(product + " ");
            }
//            System.out.println();
        }
        
        for (int c = 0; c <20; c++) {
            for (int r = 0; r < 20 - 3; r++) {
                product = M[r][c] * M[r+1][c] * M[r+2][c] * M[r+3][c];
                if (product > gProduct) {
                    gProduct = product;
                }
//                System.out.print(product + " ");
            }
//            System.out.println();
        }
        
        for (int r = 0; r < 20 - 3; r++) {
            for (int c = 0; c < 20 - 3; c++) {
                product = M[r][c] * M[r+1][c+1] * M[r+2][c+2] * M[r+3][c+3];
                if (product > gProduct) {
                    gProduct = product;
                }
//                System.out.print(product + " ");
            }
//            System.out.println();
        }
        
        for (int r = 0; r < 20 - 3; r++) {
            for (int c = 0; c < 20 - 3; c++) {
                product = M[r][c+3] * M[r+1][c+2] * M[r+2][c+1] * M[r+3][c];
                if (product > gProduct) {
                    gProduct = product;
                }
//                        System.out.print(product + " ");
            }
//                    System.out.println();
        }
        
        
        System.out.println(gProduct);
        
//        for(int j = 0; j < 20; j++) {
//            for (int i = 0; i < 20; i++) {
//                System.out.print(M[j][i] + " ");
//            }
//            System.out.println();
//        }
    }
    
    private static void populateM() throws IOException {
        
        Scanner scanner = new Scanner(new File("_11_input.txt"));
        
        int row = 0;
        int col = 0;
        
        while (scanner.hasNextInt()) {

            M[row][col++] = scanner.nextInt();
            
            if(col == 20) {
                row++;
                col = 0;
            }
        }
    }
}
