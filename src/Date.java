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
		StringTokenizer dt = new StringTokenizer(date, "/");
		
		month = Integer.parseInt(dt.nextToken().trim());
		day = Integer.parseInt(dt.nextToken().trim());
		year = Integer.parseInt(dt.nextToken().trim());
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
		
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0 thus I added plus 1 for month numeric values
			
		if(month > currDate.getMonth() && year == currDate.getYear()) 
		{ 
			return false; 
		}
			
		if(day > currDate.getDay() && year == currDate.getYear()) 
		{ 
			return false; 
		}
			
		if(year < oldestPublishedyr || year > currDate.getYear()) 
		{ 
			return false; 
		}
	
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		if(month == cal.get(Calendar.JANUARY+1) || month == cal.get(Calendar.MARCH+1) || month == cal.get(Calendar.MAY+1) 
				|| month == cal.get(Calendar.JULY+1) || month == cal.get(Calendar.AUGUST+1) || month == cal.get(Calendar.OCTOBER+1) 
				|| month == cal.get(Calendar.DECEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		if(month == cal.get(Calendar.APRIL+1) || month == cal.get(Calendar.JUNE+1) 
				|| month == cal.get(Calendar.SEPTEMBER+1) || month == cal.get(Calendar.NOVEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
			
		}
		
		boolean leapyr = (year/quad == 0) ? true : false;
		leapyr = (year/cent == 0) ? true : false;
		leapyr = (year/quater == 0) ? true : false;
		
		
		if(leapyr == false && month == cal.get(Calendar.FEBRUARY+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		
		if(leapyr == true && month == cal.get(Calendar.FEBRUARY+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
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
		Date todaysDate = new Date();
		System.out.println("This is today's date: " + todaysDate.getMonth() + "/" + todaysDate.getDay() + "/" + todaysDate.getYear());
		
		Date date1 = new Date("10/12/1999");
		Boolean bool1 = date1.isValid();
		
		if(bool1 == true) {
			System.out.println(date1.getMonth() + "/" + date1.getDay() + "/" + date1.getYear());
		}else {
			System.out.println("Invalid Date!");
		}

	}

}
