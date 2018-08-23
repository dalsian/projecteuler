package net.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _32_PendigitalProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> products = new ArrayList<Integer>();
		
		int product = 1;
		StringBuffer buff;
		List<Character> c;
		
		for (int a = 9999; a > 0; a--) {
			for (int b = 99; b > 0; b--) {
				
				product = a * b;
				
				buff = new StringBuffer();
				buff.append(a);
				buff.append(b);
				buff.append(product);
				
				c = new ArrayList<Character>();
				
//				System.out.println(buff.toString());
				boolean duplicate = false;
						
				while(buff.length() > 0) {
					if ((buff.charAt(0) == '0') || (c.contains(buff.charAt(0)))) {
						duplicate = true;
					} else {
						c.add(buff.charAt(0));
					}
					buff.deleteCharAt(0);
				}
				
				if (c.size() == 9 && (!duplicate)) {
					
					if (!products.contains(product)) {
						System.out.println(a + " * " + b + " = " + product);
						products.add(product);
					}
				}
			}
		}
		
		int sum = 0;
		for (Integer p : products) {
			sum += p;
		}
		System.out.println(sum);
	}

}
