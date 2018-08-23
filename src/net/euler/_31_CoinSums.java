package net.euler;

import java.util.ArrayList;
import java.util.List;

public class _31_CoinSums {
	
	private static int[] coins;
	private static int ways = 0;
	private static List<String> combinations;

	public static void main(String[] args) {
		
		combinations = new ArrayList<String>();
		coins = new int[] {5, 2, 1};
//		coins = new int[] {200, 100, 50, 20, 10, 5, 2, 1};
		
		sum(coins[0]);
		
//		System.out.println(ways);
	}
	
	private static String sum(Integer n) {

		if (n == 1) {
			return "1";
		}
		
		StringBuffer comb;
		int temp;
		
		for (int c : coins) { 
			
			comb = new StringBuffer("");
			temp = n;
			
			do {
				temp = n - c;
				
				if (temp == 0) {
					comb.append(c);
					combinations.add(comb.toString());
				} else {
					comb.append(c);
				}
			} while (temp > 0);
		}

		return null;
		
	}

}
