package net.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_NumberLetterCount {

	public static void main(String[] args) {
		
//		int totalCount = 0;
//		String w;
//		for (int i = 1; i <= 1000; i++) {
//			w = getNumberWords(Integer.toString(i));
//			w = w.replaceAll(" ", "");
//			totalCount += w.length();
//		}
//		System.out.println(totalCount);
		
		String test = "92428834322436901";
		System.out.println(test + " = " + getNumberWords(test));
		
	}
	
	public static String getNumberWords(String n) {
		
		StringBuffer result = new StringBuffer();
		Map<Integer, String> numberWords = new HashMap<Integer, String>();
		Map<Integer, String> milestones = new HashMap<Integer, String>();
		
		numberWords.put(1, "one");
		numberWords.put(2, "two");
		numberWords.put(3, "three");
		numberWords.put(4, "four");
		numberWords.put(5, "five");
		numberWords.put(6, "six");
		numberWords.put(7, "seven");
		numberWords.put(8, "eight");
		numberWords.put(9, "nine");
		numberWords.put(10, "ten");
		numberWords.put(11, "eleven");
		numberWords.put(12, "twelve");
		numberWords.put(13, "thirteen");
		numberWords.put(14, "fourteen");
		numberWords.put(15, "fifteen");
		numberWords.put(16, "sixteen");
		numberWords.put(17, "seventeen");
		numberWords.put(18, "eighteen");
		numberWords.put(19, "nineteen");
		numberWords.put(20, "twenty");
		numberWords.put(30, "thirty");
		numberWords.put(40, "forty");
		numberWords.put(50, "fifty");
		numberWords.put(60, "sixty");
		numberWords.put(70, "seventy");
		numberWords.put(80, "eighty");
		numberWords.put(90, "ninety");
		
		milestones.put(1, "thousand");
		milestones.put(2, "million");
		milestones.put(3, "billion");
		milestones.put(4, "trillion");
		milestones.put(5, "quadrillion");
		milestones.put(6, "quintillion");
		
		StringBuffer number = new StringBuffer(n);
//		System.out.print(number + " : ");
		number.reverse();
		
		//Create chunks of up to hundred
		List<Integer> chunks = new ArrayList<Integer>();
		StringBuffer chunk = new StringBuffer();
		for (int i = 0; number.length() > 0; ) {
			chunk.insert(0,number.charAt(0));
			number.deleteCharAt(0);
			if ((i == 2) || (number.length() == 0)) {
				i = 0;
				chunks.add(Integer.parseInt(chunk.toString()));
				chunk = new StringBuffer();
			} else {
				i++;
			}
		}
	
		//Combine all chunks
		chunk = new StringBuffer();
		for(int i = 0; i < chunks.size(); i++) {
			
			//Add thousand, million, billion... etc
			if (milestones.containsKey(i)) {
				result.insert(0, " " + milestones.get(i) + " ");
			}
		
//			System.out.print(chunks.get(i) + " : ");
			int currentChunk = chunks.get(i) % 100;
			
			if (numberWords.containsKey(currentChunk)) {
//				System.out.println("contains:"+currentChunk);
				chunk.insert(0, numberWords.get(currentChunk));
			} else if (currentChunk/10 != 0) {
//				System.out.println("does not contain:"+currentChunk);
				chunk.insert(0, numberWords.get((currentChunk/10)*10) + " " + numberWords.get(currentChunk % 10));
			}
			
			int currentChunk2 = chunks.get(i) / 100;
			if (currentChunk2 > 0) {
				chunk.insert(0, numberWords.get(currentChunk2) + " hundred" + 
											((currentChunk / 10 == 0 && currentChunk%10 == 0)?"":" and "));
			}
			
//			System.out.println(chunk);
			
			result.insert(0, chunk);
			chunk = new StringBuffer();
		}
		
		return result.toString();
	}

}
