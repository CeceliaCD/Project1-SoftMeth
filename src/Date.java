/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date {
	
	private int year;
	private int month; 
	private int day;
	
	
	//taking mm/dd/yyyy and create a Date object 
	public Date(String date) {
		int inputmnth = 0;
		int inputdy = 0;
		int inputyr = 0;
		
		StringTokenizer dt = new StringTokenizer(date, "/");
		inputmnth = Integer.parseInt(dt.nextToken().trim());
		inputdy = Integer.parseInt(dt.nextToken().trim());
		inputyr = Integer.parseInt(dt.nextToken().trim());
		
		month = inputmnth;
		day = inputdy;
		year = inputyr;
	} 
	
	//return today’s date
	public Date() { 
		int mnth = 0;
		int dy = 0;
		int yr = 0;

		month = mnth;
		day = dy;
		year = yr;
		
		String date = new String(Integer.toString(mnth) + "/" + Integer.toString(dy) + "/" + Integer.toString(yr));		
	} 
	
	
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		
		
		int oldestPublishedyr = 1900;
		final int quad = 4;
		final int cent = 100;
		final int quater = 400;
		 
		Date published = new Date();
		
		//Don't know if the way I printed will be acceptable for Professor Chang
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0 thus I added plus 1 for month numeric values
			
		if(published.month > cal.get(Calendar.MONTH + 1)) {
			return false;
		}
			
		if(published.day > cal.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}
			
		if(published.year < oldestPublishedyr || published.year > cal.get(Calendar.YEAR)) {
			return false;
		}
	
		
		
		boolean leapyr = (published.year/quad == 0) ? true : false;
		leapyr = (published.year/cent == 0) ? true : false;
		leapyr = (published.year/quater == 0) ? true : false;
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		while(published.month == cal.get(Calendar.JANUARY+1) || published.month == cal.get(Calendar.MARCH+1) || published.month == cal.get(Calendar.MAY+1) 
				|| published.month == cal.get(Calendar.JULY+1) || published.month == cal.get(Calendar.AUGUST+1) || published.month == cal.get(Calendar.OCTOBER+1) 
				|| published.month == cal.get(Calendar.DECEMBER+1)) {
			if(published.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || published.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(published.month == cal.get(Calendar.APRIL+1) || published.month == cal.get(Calendar.JUNE+1) 
				|| published.month == cal.get(Calendar.SEPTEMBER+1) || published.month == cal.get(Calendar.NOVEMBER+1)) {
			if(published.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || published.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(!leapyr && published.month == cal.get(Calendar.FEBRUARY+1)) {
			if(published.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || published.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(leapyr && published.month == cal.get(Calendar.FEBRUARY+1)) {
			if(published.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || published.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		return true;	
	}
	
	
	//testbed main
	/*You MUST design the test cases to thoroughly test the isValid() method. 
	 * You must write a testbed main and implement the test cases. You must follow the instructions
	 * in the “Test Specification” section of the Software Development Ground Rules.
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		Date date1 = new Date("01/20/2020");
		Boolean bool1 = date1.isValid();
		
		if(bool1) {
			System.out.println(date1);
		}else {
			System.out.println("Invalid Date!");
		}

	}

}
