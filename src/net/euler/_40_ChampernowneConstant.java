package net.euler;

public class _40_ChampernowneConstant {

	
	public static void main(String[] args) {
	
		int target = 1000000;
		int checkPoint = 1;
		int n = 1;
		int i = 1;
		int dn = 1;
		int result = 1;
		
		char[] charN;
		
		while (n  <= target) {
			charN = String.valueOf(i).toCharArray();
			
			for (int c = 0; c < charN.length && n <= target; c++) {
				dn = Character.getNumericValue(charN[c]);
				
				if (n == checkPoint) {
					result *= dn;
					System.out.println(dn);
					System.out.println("check" + checkPoint);
					checkPoint *= 10;
				}
//				System.out.println("n = " + n + ", dn = " +dn);
				
				n++;
			}
			i++;
		}
		
		System.out.println(result);
		
	}

}
