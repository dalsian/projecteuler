package net.euler.util;

public class MathUtil {
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return -1 if no solution.
	 */
	public static float getQuadratic(int a, int b, int c) {
		
		double d = b*b -4 * a * c;
		if (d < 0){
		   // no solution
		   return -1;
		}
		
		int r1 = (int) Math.round((-b - Math.sqrt((int) d)) / (2 * a)); //solution1
		int r2 = (int) Math.round((-b + Math.sqrt((int) d)) / (2 * a)); //solution2
		
		if (r1 > 0) {
			
			return r1;
			
		} else if (r2 > 0) {
			
			return r2;
		}
		
		return r2 < r1 ? r2 : r1;
	}

	public static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	public static long gcd(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
	    return result;
	}
	
	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	
	public static long lcm(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}

	public static long lcm(Long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
}
