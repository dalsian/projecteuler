package net.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _22_NamesScores {

	/**
	 * @param args
	 */
	private static List<String> names = new ArrayList<String>();

	public static void main(String[] args) {
	
		populate();
		Collections.sort(names);
		
		long sum = 0;
		for (int i = 0; i < names.size(); i++) {
			sum += (i + 1) * getValue(names.get(i));
		}
		
		
		System.out.println(sum);
	}
	
	private static void populate() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("_22_input.txt"));
			String str = reader.readLine();
			StringTokenizer token = new StringTokenizer(str, ",");
			while (token.hasMoreElements()) {
				names.add(((String) token.nextElement()).replace("\"", ""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int getValue(String s) {
		int val = 0;
		char[] cAry = s.toCharArray();
		for (int i = 0; i < cAry.length; i++) {
			val += (Character.getNumericValue(cAry[i]) - 9);
		}
		
		return val;
	}

}
