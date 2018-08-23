package net.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class _8_ConsecutiveProduct {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("_8_input.txt"));
        int[] N = new int[1000];
        
        char[] c = new char[1];
        int[] nums = new int[5];
        Long gProduct = 1L;
        int i = 0;
        int d;
        
        while (br.read(c) != -1) { 
            d = Character.digit(c[0], 10);
            if (d != -1) {
                N[i++] = d;
            }
        }
        
        for (int j = 0; j < N.length - 5; j++) {
            
            Long product = 1L;
            
            for (int k = j; k < j+5; k++) {
                product *= N[k];
            }
            if (product > gProduct) {
                gProduct = product;
            }
        }
        System.out.println(gProduct);
        
    }
}
