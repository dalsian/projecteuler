package net.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _54_PokerHands {

	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		Map<Character, Short> vMap = new HashMap<Character, Short>();
		for (short i = 1; i <= 9; i++) {
			vMap.put(Character.valueOf((char) ('0' + i)), i);
		}
		vMap.put(Character.valueOf('T'), (short) 10);
		vMap.put(Character.valueOf('J'), (short) 11);
		vMap.put(Character.valueOf('Q'), (short) 12);
		vMap.put(Character.valueOf('K'), (short) 13);
		vMap.put(Character.valueOf('A'), (short) 14);
		
		Map<Character, Short> sMap = new HashMap<Character, Short>();
		sMap.put(Character.valueOf('S'), (short) 0);
		sMap.put(Character.valueOf('C'), (short) 1);
		sMap.put(Character.valueOf('D'), (short) 2);
		sMap.put(Character.valueOf('H'), (short) 3);
		
		Player p1;
		Player p2;
		int p1Wins = 0;
		
		try {
			Scanner scanner = new Scanner(new File("p054_poker.txt"));
			String line;
			int round;
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				round = 0;
				p1 = new Player();
				p2 = new Player();
				
				for(String s : line.split(" ")) {
					
//					System.out.print(s + ",");
					
					if (round < 5) {
						p1.cards[sMap.get(s.charAt(1))][vMap.get(s.charAt(0))]++;
					} else {
						p2.cards[sMap.get(s.charAt(1))][vMap.get(s.charAt(0))]++;
					}
//					if (round == 4) {
//						System.out.println("   ");
//					}
					round++;
				}
				
//				for (int l = 0; l < 4; l++) {
//					for (int m = 1; m < 15; m++) {
//						System.out.print(p1.cards[l][m] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				for (int l = 0; l < 4; l++) {
//					for (int m = 1; m < 15; m++) {
//						System.out.print(p2.cards[l][m] + " ");
//					}
//					System.out.println();
//				}
				
				
				p1.calculateHands();
				p2.calculateHands();
//				System.out.println("P1 hand = " + p1.hand + ", P2 hand = " + p2.hand);
//				System.out.println(p1.compareHands(p2));
//				System.out.println("=================================\n");
				if (p1.compareHands(p2) > 0) {
					p1Wins++;
				}
				
			}
			
			System.out.println("Total wins for P1 = " + p1Wins);
			
			System.out.println(System.currentTimeMillis() - startTime + "ms");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

class Player {
	
	//TODO remove value 1
	
	public short[][] cards = new short[4][15];
	public short[][] pair = null; //{suit,value} {suit, value}
	public short[][] pair2 = null; //{suit,value} {suit, value}
	public short[][] threeOfAKind = null;
	public short[][] straight = null;
	public short[][] flush = null;
	public boolean isFullHouse = false;
	public short[][] fourOfAKind = null;
	public boolean isStraightFlush = false;
	public boolean isRoyalFlush = false;
	
	public short hand = -1;
	
	/**
	 * Compare hands for current player against a specific player.
	 * @param p2 - next player to compare to.
	 * @return  1 if current player wins, -1 if p2 wins, 0 if draw.
	 */
	public int compareHands(Player p2) {
		
		if (hand == -1) {
			calculateHands();
		}
		if (p2.hand == -1) {
			p2.calculateHands();
		}
		
		int result = compare(this.hand, p2.hand);
		if (result == 0) { 
			
			switch (hand) {
				case 0:
					int val, val2;
					for(int v = 14; v > 1; v--) {
						
						val = val2 = 0;
						for (short s = 0; s < 4; s++) {
							val += cards[s][v];
							val2 += p2.cards[s][v];
							result = compare(val, val2);
							if (result != 0) {
								return result;
							}
						}
					}
					return result;
				case 1: // compare pairs
					for(int i = 1; i > 0 && ((result = compare(pair[i][1], p2.pair[i][1])) == 0); i--) {
					}
					return result;
				case 2: // compare two pairs
					for(int i = 1; i > 0 && ((result = compare(pair2[i][1], p2.pair2[i][1])) == 0); i--) {
					}
					if (result == 0) {
						for(int i = 1; i > 0 && ((result = compare(pair[i][1], p2.pair[i][1])) == 0); i--) {
						}
					}
					return result;
				case 3: // compare three of a kinds
					for(int i = 2; i > 0 && ((result = compare(threeOfAKind[i][1], p2.threeOfAKind[i][1])) == 0); i--) {
					}
					return result;
				case 4: // compare straights
					for(int i = 4; i > 0 && ((result = compare(straight[i][1], p2.straight[i][1])) == 0); i--) {
					}
					return result;
				case 5: // compare flushes
					for(int i = 4; i > 0 && ((result = compare(flush[i][1], p2.flush[i][1])) == 0); i--) {
					}
					return result;
				case 6: // compare full houses
					for(int i = 2; i > 0 && ((result = compare(pair[i][1], p2.pair[i][1])) == 0); i--) {
					}
					if (result == 0) {
						for(int i = 1; i > 0 && ((result = compare(pair[i][1], p2.pair[i][1])) == 0); i--) {
						}
					}
					return result;
				case 7: // compare four of a kinds
					for(int i = 3; i > 0 && ((result = compare(fourOfAKind[i][1], p2.fourOfAKind[i][1])) == 0); i--) {
					}
					return result;
				case 8: // compare straight flushes
					for(int i = 4; i > 0 && ((result = compare(straight[i][1], p2.straight[i][1])) == 0); i--) {
					}
					return result;
				default:
					return 0;
			}
			
		}
		
		return result;
	}
	
	private int compare(int a, int b) {
		if (a > b) {
			return 1;
		} else if (b > a) {
			return -1;
		}
		return 0;
	}
	
	public void calculateHands() {
		
		hand = 0; //flag that hands are calculated.
		
		calculateSameValues();
		
		flush = getFlush();
		
		if (threeOfAKind != null && pair != null) {
			isFullHouse = true;
			hand = 6;
			return;
		}
		
		if (pair == null && threeOfAKind == null && fourOfAKind == null) {
			
			straight = getStraight();
			
			if (straight != null) {
				if (flush != null) {
					
					isStraightFlush = true;
					hand = 8;
					
					if (straight[0][1] == 10) {
						isRoyalFlush = true;
						hand = 9;
					}
				}
			}
		}
	}
	
	/**
	 * Calculate same value groups which includes
	 * pairs, three of a kind, and four of a kind.
	 */
	private void calculateSameValues() {
		
		short val = 0;
		for (short v = 1; v < 15; v++) {
			val = 0;
			for (short s = 0; s < 4; s++) {
				val += cards[s][v];
			}
			if (val == 2) { // getPairs
				if(pair == null) {
					pair = new short[2][2];
					for (short s = 0, i = 0; s < 4; s++) {
						if (cards[s][v] == 1) {
							pair[i][0] = s;
							pair[i++][1] = v;
						}
					}
					hand = 1;
				} else {
					pair2 = new short[2][2];
					for (short s = 0, i = 0; s < 4; s++) {
						if (cards[s][v] == 1) {
							pair2[i][0] = s;
							pair2[i++][1] = v;
						}
					}
					hand = 2;
				}
			} else if (val == 3) {
				threeOfAKind = new short[3][2]; 
				for (short s = 0, i = 0; s < 4; s++) {
					if (cards[s][v] == 1) {
						threeOfAKind[i][0] = s;
						threeOfAKind[i++][1] = v;
					}
				}
				hand = 3;
			} else if (val == 4) {
				fourOfAKind = new short[4][2]; 
				for (short s = 0, i = 0; s < 4; s++) {
					if (cards[s][v] == 1) {
						fourOfAKind[i][0] = s;
						fourOfAKind[i++][1] = v;
					}
				}
				hand = 7;
			}
			
		}
	}
	
	public short[][] getStraight() {
		
		short[][] straight = null;
		int val, consecutives = 0;
		
		for (short v = 1; v < 15; v++) {
			val = 0;
			for (short s = 0; s < 4; s++) {
				val += cards[s][v];
			}
			if (val == 1) {
				consecutives++;
			} 
			if (consecutives == 5) { //is straight
				straight = new short[5][2];
			} else if (val == 0) { 
				consecutives = 0;
			} else if (val > 1) { //two pairs+, cannot be straight.
				return null;
			}
		}
		
		if (straight != null) {
			for (short v = 1, i = 0; v < 15; v++) {
				for (short s = 0; s < 4; s++) {
					if (cards[s][v] == 1) {
						straight[i][0] = s;
						straight[i++][1] = v;
						continue;
					}
				}
			}
			
			hand = 4;
			
			return straight;
		}
		
		return null;
	}
	
	/**
	 * @return Suit index. -1 if no flush.
	 */
	public short[][] getFlush() {
		
		short[][] flush = null;
		short val = 0;
		
		for (short s = 0; s < 4; s++) {
			val = 0;
			for (short v = 1; v < 15; v++) {
				val += cards[s][v];
			}
			if (val == 5) {
//				return s;'
				flush = new short[5][2];
				for (short v = 1, i = 0; v < 15; v++) {
					if (cards[s][v] == 1) {
						flush[i][0] = s;
						flush[i++][1] = v;
					}
				}
				hand = 5;
			}
		}
		
		return flush;
	}
}
