package net.euler;

public class _30_DigitFifthPower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int power = 5;
		int sum;
		StringBuffer digits;
		int d;
		int result = 0;
		
		for (int i = 2; i < 1000000; i++) {
			
			sum = 0;
			
			digits = new StringBuffer(Integer.toString(i));
			
			while (digits.length() > 0) {
				
				d = Character.getNumericValue(digits.charAt(0));
				digits.deleteCharAt(0);
				
				sum += Math.pow(d, power);
				
				if (sum > i) {
					break;
				} 
			}
			
			if (sum == i) {
				System.out.print("found:" + sum + " and i = ");
				System.out.println(i );
				result += sum;
			}
		}
		System.out.println("Result" + result);
	}

}
