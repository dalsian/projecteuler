package net.euler;

import java.util.HashMap;
import java.util.Map;

public class _19_CountingSundays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	
		int startY = 1901;
		int endY = 2000;
		
		int count = 0;
		
		for (int y = startY; y <= endY; y++) {
			for (int m = 1; m <= 12; m++) {
				if (getDay(y, m, 1).equals("Sunday")) {
//					System.out.println(y + "/" + m + "/1 is sunday");
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static String getDay(int yyyy, int mm, int dd) {
		
		int cent = centuryNumber.get(yyyy / 100);
		int month = monthNumber.get(mm);
		
		boolean isLeapYear = false;
		if (yyyy % 4 == 0){
			isLeapYear = true;	
			if ((yyyy % 100 == 0) && !(yyyy % 400 == 0)) {
				isLeapYear = false;
			}
		}
		
		int year = yyyy % 100;
		year += (year / 4) % 7;
		
		int date = dd % 7;
		if (isLeapYear && (mm == 1 || mm == 2)) {
			date -= 1;
		}
		int day = (cent + year + month + date) % 7;
		
		return numberDay.get(day);
	}
	
	public static void initialize() {
		centuryNumber = new HashMap<Integer, Integer>();
		centuryNumber.put(15, 1);
		centuryNumber.put(16, 0);
		centuryNumber.put(17, 5);
		centuryNumber.put(18, 3);
		centuryNumber.put(19, 1);
		centuryNumber.put(20, 0);
		centuryNumber.put(21, 5);
		centuryNumber.put(22, 3);
		centuryNumber.put(23, 1);
		monthNumber = new HashMap<Integer, Integer>();
		monthNumber.put(1,6);
		monthNumber.put(2,2);
		monthNumber.put(3,2);
		monthNumber.put(4,5);
		monthNumber.put(5,0);
		monthNumber.put(6,3);
		monthNumber.put(7,5);
		monthNumber.put(8,1);
		monthNumber.put(9,4);
		monthNumber.put(10,6);
		monthNumber.put(11,2);
		monthNumber.put(12,4);
		numberDay = new HashMap<Integer, String>();
		numberDay.put(0, "Sunday");
		numberDay.put(1, "Monday");
		numberDay.put(2, "Tuesday");
		numberDay.put(3, "Wednesday");
		numberDay.put(4, "Thursday");
		numberDay.put(5, "Friday");
		numberDay.put(6, "Saturday");
	}
	
	private static Map<Integer, Integer> centuryNumber;
	private static Map<Integer, Integer> monthNumber;
	private static Map<Integer, String> numberDay;
}
