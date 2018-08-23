package net.euler;

import java.util.HashMap;
import java.util.Map;

public class _31_CoinSumsV2 {
	
	private static int[] coins;
	private static Map<Integer, Integer> cMap;
	private static int ways = 0;

	public static void main(String[] args) {
		
		coins = new int[] {5, 2, 1};
		cMap = new HashMap<Integer, Integer>();
		
		cMap.put(1, 1);
		
		
		
		System.out.print(sum(coins[0]));
	}
	
	private static int sum(int n) {
		
		int way = 0;
		
		if (cMap.containsKey(n)) {
			return cMap.get(n);  
		} else {
			
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] < n) {
					
					if (n - coins[i] > 0) {
						
						way = 1 + sum(n - coins[i]);
						cMap.put(coins[i], way);
						
						if (n - coins[i] == 0) {
							break;
						}
//						break;
					}
				}
			}
			
			return way;
		}
		
	}

}
