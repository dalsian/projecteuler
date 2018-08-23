package net.euler;

import net.euler.util.PrimeUtil;

public class _41_PandigitalPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long num = 7845361;
		boolean found = false;
		
		while (!found) {
			if (noOverlap(Long.toString(num)) && PrimeUtil.isPrime2(num)) {
				found = true;
				System.out.println(num);
			}
			num--;
		}
		
	}
	
	public static boolean noOverlap(String out) {

		StringBuffer buff = new StringBuffer(out);
		String c;
		
		// eliminate 9 and 8 based on previous runs...
		if ((buff.indexOf("0") != -1) || (buff.indexOf("9") != -1) || ((buff.indexOf("8") != -1))) { 
			return false;
		}
		
		while(buff.length() > 0) {
			c = buff.substring(0, 1);
			buff.deleteCharAt(0);
			if (buff.indexOf(c) != -1) {
				return false;
			}
		}
		return true;
	}

}
