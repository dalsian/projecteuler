package net.euler;

import java.util.ArrayList;
import java.util.List;

import net.euler.util.PrimeUtil;

public class _38_PandigitalMultiples {
	// test with 7 digits first (9999999 to 1). 932718654
	// then 8. doesn't exist
	// then 9. doesn't exist
	// greater than 9 would exceed limit of 9 digits.
	private static final long num = 9999999;
	private static long maxPan = 1;
	private static List<Long> nineDigitPans;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		nineDigitPans = new ArrayList<Long>();
		final long loopEnd = 1;
		for (long n = num; n > loopEnd; n--) {
			if (yieldPandigital(n)) {
//				System.out.println("Yields pandigital " + n);
				
			}
		}
		
		System.out.println("Largest : " + maxPan);
		System.out.println("end " + (System.currentTimeMillis() - startTime));
		
	}

	private static boolean yieldPandigital(long num) {
		int i = 1;
		List<Character> digitBag = new ArrayList<Character>();
		StringBuffer digitBuff;
		long out = 0;
		while (noOverlap(out = (num * i), digitBag)) {
			if (digitBag.contains('1') && digitBag.contains('2')
					&& digitBag.contains('3') && digitBag.contains('4')
					&& digitBag.contains('5') && digitBag.contains('6')
					&& digitBag.contains('7') && digitBag.contains('8')
					&& digitBag.contains('9') && (!digitBag.contains('0'))
					&& (i > 1)) {
				
				digitBuff = new StringBuffer("");
				for (char c : digitBag) {
					digitBuff.append(c);
				}
				long pandigital = Long.parseLong(digitBuff.toString());
				nineDigitPans.add(pandigital);
				
				if (pandigital > maxPan) {
					maxPan = pandigital;
				}
				return true;
			}
			i++;
		}
		;
		return false;
	}

	public static boolean noOverlap(long out, List<Character> bag) {
		StringBuffer buff = new StringBuffer(Long.toString(out));
		while (buff.length() > 0) {
			if (bag.contains(buff.charAt(0))) {
				return false;
			} else {
				bag.add(buff.charAt(0));
			}
			buff = buff.deleteCharAt(0);
		}
		return true;
	}
}
