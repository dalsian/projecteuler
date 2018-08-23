package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _33_DigitCancelingFraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		float original;
		String strI;
		String strJ;
		float altI;
		float altJ;
		int charIdx;
		List<Long> denominators = new ArrayList<Long>();
		
		for (float i = 99; i > 9; i--) {
			for (float j = i - 1; j > 9; j--) {
				
				original = j / i;
				
				strJ = Float.toString(j);
				strI = Float.toString(i);
				charIdx = strJ.indexOf(strI.charAt(0));
				if (strI.charAt(0) != '0' && charIdx != -1) {
					altJ = Character.getNumericValue(strJ.charAt(charIdx == 0 ? 1 : 0));
					altI = Character.getNumericValue(strI.charAt(1));
					if (altJ / altI == j / i) {
						denominators.add((long) i);
						System.out.println(j + "/" + i + " = " + altJ + "/" + altI + " = " + (j / i));
					}
				} 
				
				charIdx = strJ.indexOf(strI.charAt(1));
				if (strI.charAt(1) != '0' && charIdx != -1) {
					altJ = Character.getNumericValue(strJ.charAt(charIdx == 0 ? 1 : 0));
					altI = Character.getNumericValue(strI.charAt(0));
					if ((altJ / altI == j / i) && (i % j != 0)) {
						denominators.add((long) i);
						System.out.println(j + "/" + i + " = " + altJ + "/" + altI + " = " + (j / i));
					}
				} 
				
//				charIdx = strI.indexOf(strJ.charAt(0));
//				if (charIdx != -1) {
//					altI = Character.getNumericValue(strI.charAt(charIdx == 0 ? 1 : 0));
//					altJ = Character.getNumericValue(strJ.charAt(1));
//					if ((altJ / altI == j / i) && (i % j != 0)) {
//						denominators.add((long) i);
//						System.out.println(j + "/" + i + " = " + altJ + "/" + altI + " = " + (j / i));
//					}
//				} 
			}
		}
		for(long d : denominators) {
			System.out.println(d);
		}
		
		//correct answer
		long[] a = new long[] {4,5,5};
		System.out.println(lcm(a));
		
		//Answer is 100. not looking for LCM!!!
		
	}
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

//	private static long gcd(long[] input)
//	{
//	    long result = input[0];
//	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
//	    return result;
//	}
	
	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	
	private static long lcm(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}

	private static long lcm(Long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
}
