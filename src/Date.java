/**
  The date class helps with verifying that 
  a given date is accurate (not too old and not an
  impossibly made up one).
  @Nida Ansari
  @Cecelia Chollette-Dickson
*/
import java.util.Calendar;
import java.util.StringTokenizer;

public class Date {
	
	private int year;
	private int month; 
	private int day;
	
	
	/**
	  This method is taking a string in mm/dd/yyyy and creates
	  a Date object that the user can input in a similar format. 
	 */
	public Date(String date) {
		StringTokenizer dt = new StringTokenizer(date, "/");
		
		month = Integer.parseInt(dt.nextToken().trim());
		day = Integer.parseInt(dt.nextToken().trim());
		year = Integer.parseInt(dt.nextToken().trim());
	} 
	
	/**
	  This constructor returns today’s date and also
	  helps with checking if the given published date of 
	  a book is sny later than the current (which shouldn't
	  be possible).
	 */
	public Date() { 
		Calendar cal = Calendar.getInstance();
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
	} 
	
	/**
	  Our getter method to help obtain the int value
	  that represents a date's month.
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	  Our getter method that helps obtain the int
	  value that represents a date's day.
	 */
	public int getDay() {
		return day;
	}
	
	/**
	  Our getter method that helps obtain the int
	  value that represents a date's year.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	  This method is used to help verify that the date given,
	  which is representing when a book was published, is not
	  imaginary/impossible or even older than books published 
	  in 1900.Returns a boolean to indicate if the published 
	  date of a book the user has inputted is valid.
	 */
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		int oldestPublishedyr = 1900;
		final int quad = 4;
		final int cent = 100;
		final int quater = 400;
		
		//gives us the current date
		Date currDate = new Date();
		
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0
		//thus I added plus 1 for month numeric values	
		if((month > currDate.getMonth() || month > Calendar.MONTH+1) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(month > Calendar.DECEMBER+1 && year < currDate.getYear()) {
			return false;
		}
			
		if((day > currDate.getDay() || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) && year < currDate.getYear()) {
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
	
	

	/**
	  We designed the test cases to thoroughly test 
	  the isValid() method in this testbed main. 
	  The Test Specifications document will exlpain
	  the purpose of each test case. Will each date
	  and its respective boolean, there should either
	  be an output that prints the given date or prints
	  the string literal "Invalid Date!"
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
		
		Date date2 = new Date("03/10/2022"); 
		Boolean bool2 = date2.isValid();
		if(bool2 == true) {
			System.out.println(date2.getMonth() + "/" + date2.getDay() + "/" + date2.getYear());
		}else {
			System.out.println("Invalid Date!");
		}

		Date date3 = new Date("02/29/2020");
		Boolean bool3 = date3.isValid();
		if(bool3 == true) {
			System.out.println(date3.getMonth() + "/" + date3.getDay() + "/" + date3.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date4 = new Date("06/0/2000");
		Boolean bool4 = date4.isValid();
		if(bool4 == true) {
			System.out.println(date4.getMonth() + "/" + date4.getDay() + "/" + date4.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date5 = new Date("31/31/2021");
		Boolean bool5 = date5.isValid();
		if(bool5 == true) {
			System.out.println(date5.getMonth() + "/" + date5.getDay() + "/" + date5.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date6 = new Date("3/31/1800");
		Boolean bool6 = date6.isValid();
		if(bool6 == true) {
			System.out.println(date6.getMonth() + "/" + date6.getDay() + "/" + date6.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date7 = new Date("01/31/1900");
		Boolean bool7 = date7.isValid();
		if(bool7 == true) {
			System.out.println(date7.getMonth() + "/" + date7.getDay() + "/" + date7.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date8 = new Date("02/35/2021");
		Boolean bool8 = date8.isValid();
		if(bool8 == true) {
			System.out.println(date8.getMonth() + "/" + date8.getDay() + "/" + date8.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
	}

}
