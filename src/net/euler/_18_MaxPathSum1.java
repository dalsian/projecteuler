package net.euler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _18_MaxPathSum1 {

	private static int[] triangular;
			
	public static void main(String[] args) {
		
		int totalLines = 100;
		triangular = new int[(totalLines * (totalLines + 1)) / 2];
		readFile("_67_input.txt");
		
		int rightChild, leftChild = 0;
		int currentRow = totalLines - 1;
		
		for (int i = triangular.length - 1 - totalLines, j = currentRow; i >= 0; i--, j--) {
			leftChild = triangular[i + currentRow];
			rightChild = triangular[i + currentRow + 1];
			triangular[i] += ((rightChild > leftChild) ? rightChild : leftChild);
			
			if (j == 1) {
				j = currentRow;
				currentRow--;
			}
		}
		
		System.out.print(triangular[0]);
	}
	
	private static void readFile(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int i = 0;
			while (scanner.hasNextInt()) {
				triangular[i++] =  scanner.nextInt();
			}
		} catch (IOException e) { e.printStackTrace(); }
	}

}
