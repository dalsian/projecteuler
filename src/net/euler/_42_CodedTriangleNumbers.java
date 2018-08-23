package net.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class _42_CodedTriangleNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		final String pattern = "\"[A-Za-z]{1,}\"";
		char[] word = null;
		int wordVal = 0;
		int triangleWordCount = 0;
		try {
			Scanner scanner = new Scanner(new File("_42_input.txt"));
			scanner.useDelimiter(",");
			
			while(scanner.hasNext(Pattern.compile(pattern))) {
				wordVal = 0;
				word = scanner.next(pattern).toCharArray();
				for (int c = 1; c < (word.length - 1); c++) {
					wordVal += ((int) word[c]) - 64; // minus ascii value to make index.
					
				}
				if (isTriangular(wordVal)) {
					triangleWordCount++;
//				System.out.println(String.copyValueOf(word) + "=" + wordVal);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Time elipsed : " + (System.currentTimeMillis() - startTime));
		System.out.println(triangleWordCount);
	}
	
	private static boolean isTriangular(int n) {
		
		//n^2 + n -(2*x) = 0 quadratic
		
		double d = 1 - 4 * (-2 * n);
		if (d < 0){
		   // no solution
		   return false;
		}
		int x1 = (int) Math.round((-1 - Math.sqrt((int) d)) / 2); //solution1
		int x2 = (int) Math.round((-1 + Math.sqrt((int) d)) / 2); //solution2
		
		if (x1 > 0) {
			
			if ((x1 * (x1 + 1)) / 2 == n) {
//				System.out.println(x1);
				return true;
			} 
			
		} else if (x2 > 0) {
			
			if ((x2 * (x2 + 1)) / 2 == n) {
//				System.out.println(x2);
				return true;
			}
		}
		
		return false;
	}

}
