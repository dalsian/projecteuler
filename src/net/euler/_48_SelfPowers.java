package net.euler;

import java.math.BigInteger;

public class _48_SelfPowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String lastTen = new String("0");
		String selfPower;
		BigInteger bigPower = null;
		
		for (int i = 1; i <= 1000; i++) {
			bigPower = new BigInteger(Integer.toString(i));
			
			bigPower = bigPower.pow(i);
			
//			System.out.println(bigPower);
			selfPower = bigPower.toString();
			if (selfPower.length() > 10) {
				selfPower = selfPower.substring(selfPower.length() - 10);
//				System.out.println(selfPower);
			}
			
			lastTen = Long.toString(Long.parseLong(lastTen) + Long.parseLong(selfPower));
			if (lastTen.length() > 10) {
				lastTen = lastTen.substring(lastTen.length() - 10);
//				System.out.println(lastTen);
			}
		}
		
		System.out.println(lastTen);
	}
	
	

}
