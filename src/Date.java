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
		
		this.month = inputmnth;
		this.day = inputdy;
		this.year = inputyr;
	} 
	
	//return today’s date
	public Date() { 
		Calendar cal = Calendar.getInstance();
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
	} 
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		
		int oldestPublishedyr = 1900;
		final int quad = 4;
		final int cent = 100;
		final int quater = 400;
		 
		Date currDate = new Date();
		
		//Don't know if the way I printed will be acceptable for Professor Chang
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0 thus I added plus 1 for month numeric values
			
		if(currDate.month > cal.get(Calendar.MONTH+1)) {
			return false;
		}
			
		if(currDate.day > cal.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}
			
		if(currDate.year < oldestPublishedyr || currDate.year > cal.get(Calendar.YEAR)) {
			return false;
		}
	
		
		boolean leapyr = (currDate.year/quad == 0) ? true : false;
		leapyr = (currDate.year/cent == 0) ? true : false;
		leapyr = (currDate.year/quater == 0) ? true : false;
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		while(currDate.month == cal.get(Calendar.JANUARY+1) || currDate.month == cal.get(Calendar.MARCH+1) || currDate.month == cal.get(Calendar.MAY+1) 
				|| currDate.month == cal.get(Calendar.JULY+1) || currDate.month == cal.get(Calendar.AUGUST+1) || currDate.month == cal.get(Calendar.OCTOBER+1) 
				|| currDate.month == cal.get(Calendar.DECEMBER+1)) {
			if(currDate.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || currDate.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(currDate.month == cal.get(Calendar.APRIL+1) || currDate.month == cal.get(Calendar.JUNE+1) 
				|| currDate.month == cal.get(Calendar.SEPTEMBER+1) || currDate.month == cal.get(Calendar.NOVEMBER+1)) {
			if(currDate.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || currDate.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(!leapyr && currDate.month == cal.get(Calendar.FEBRUARY+1)) {
			if(currDate.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || currDate.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return false;
			}
		}
		
		while(leapyr && currDate.month == cal.get(Calendar.FEBRUARY+1)) {
			if(currDate.day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || currDate.day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
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
		Date date1 = new Date("01/20/2020");
		date1.getMonth();
		date1.getDay();
		date1.getYear();
		Boolean bool1 = date1.isValid();
		
		if(bool1) {
			System.out.println(date1.isValid());
		}else {
			System.out.println("Invalid Date!");
		}

	}

}
