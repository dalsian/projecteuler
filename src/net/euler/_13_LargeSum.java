package net.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _13_LargeSum {
	
	private static int h;
	
	private static int[][] input;
	public static StringBuffer sum;
	private static int currentColumn;
	private static int extra;

	public static void main(String[] args) throws IOException {
		
		readInput("_13_input.txt");
		add();
		
		System.out.println(sum.reverse().toString());
	}

	public static void initialize(int height, int width, int[][] inputAry) {
		h = height;
		input = inputAry;
		currentColumn = width - 1;
		sum = new StringBuffer();
		extra = 0;
	}
	
	private static void readInput(String fileName) {
		
		try {
			int height = 100;
			int width = 50;
			int[][] inputAry = new int[height][width];
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String str;
			int i = 0;
			char[] cAry;
			
			while ((str = br.readLine()) != null) {
				cAry = str.toCharArray();
				for (int j = 0; j < cAry.length; j++) {
					inputAry[i][j] = Character.getNumericValue(cAry[j]);
				}
				i++;
			}
			
			initialize(height, width, inputAry);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void add() {
		
		// Base case
		if (currentColumn < 0) {
			sum.append(extra);
			return; 
		}
					
		int currentSum = 0;
		// Add the whole column
		for (int i = 0; i < h; i++) {
			currentSum += input[i][currentColumn];
		}
		
		currentSum += extra; // Add carried-over value from previous column	
		sum.append(currentSum % 10); // Store the last digit of the sum
		extra = currentSum / 10; // Save the carry-over digits for next column
		currentColumn--;
		
		add();
	}
	
}
