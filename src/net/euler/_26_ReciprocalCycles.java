package net.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class _26_ReciprocalCycles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
//		BigDecimal d = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(7), 100, RoundingMode.HALF_UP);
		
//		System.out.println(d);
		
		BigDecimal numerator = new BigDecimal("1");
		BigDecimal val;
		StringBuffer buf;
		StringBuffer a;
		
		String longestStrWhole = "";
		String longestStr = "";
		int longestD = 0;
		
		for (int d = 1; d < 1000; d++) {
//			System.out.print(d + "=");
//			int d = 130;
			
			val = numerator.divide(BigDecimal.valueOf(d), 5000, RoundingMode.HALF_UP);
			
			
			buf = new StringBuffer(val.toString());
			buf.delete(0, 2);
			
//			System.out.println("buff="+buf);
			
			a = new StringBuffer();
			a.append(buf.charAt(0));
			buf.deleteCharAt(0);
			a.append(buf.charAt(0));
			buf.deleteCharAt(0);
			
			while (buf.length() > 0) {
				
				
				if (buf.indexOf(a.toString()) > 0) {
					a.append(buf.charAt(0));
					buf.deleteCharAt(0);
				} else if (buf.indexOf(a.toString()) == -1) {
					a.deleteCharAt(0);
					a.append(buf.charAt(0));
					buf.deleteCharAt(0);
				} else {

					if ( (a.length() > 1)) {
						if (a.length() > longestStr.length()) {
							longestStrWhole = buf.toString();
							longestStr = a.toString();
							longestD = d;
						}
						
//						System.out.println("FoundRepeat " + a);
					}
					
					break;

				}
			}
				
		}
		
		
		System.out.println("1/"+longestD+" = \n"+longestStr);
		System.out.println(longestStrWhole);
	}

}
