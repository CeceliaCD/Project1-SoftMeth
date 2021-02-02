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
	
	
	//taking mm/dd/yyyy and create a Date object public Date() { } 
	public Date(String date) {
		Integer mnth = new Integer(month);
		Integer dy = new Integer(day);
		Integer yr = new Integer(year);
		
		date = new String(Integer.toString(mnth) + "/" + Integer.toString(dy) + "/" + Integer.toString(yr));	
	} 
	
	//return today’s date
	public Date() { 
	
		Calendar cal = Calendar.getInstance();
		System.console().writer().println(cal.getTime());
		
	} 
	
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		
		Integer inputmnth;
		Integer inputdy;
		Integer inputyr;
		int oldestPublishedyr = 1900;
		final int quad = 4;
		final int cent = 100;
		final int quater = 400;
		Date published = new Date();
		
		StringTokenizer str = new StringTokenizer(published, "/");
		//Don't know if the way I printed will be acceptable for Professor Chang
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0 thus I added plus 1 for month numeric values
		while(str.hasMoreTokens()) {
			
			inputmnth = Integer.parseInt(str.nextToken().trim());
			if(inputmnth > cal.get(Calendar.MONTH+1)) {
				return false;
			}
			
			inputdy = Integer.parseInt(str.nextToken().trim());
			if(inputdy > cal.get(Calendar.DAY_OF_MONTH)) {
				return false;
			}
			
			inputyr = Integer.parseInt(str.nextToken().trim());
			if(inputyr < oldestPublishedyr || inputyr > cal.get(Calendar.YEAR)) {
				return false;
			}
		}
		
		
		boolean leapyr = (inputyr / quad == 0) ? true : false;
		leapyr = (inputyr/cent == 0) ? true : false;
		leapyr = (inputyr/quater == 0) ? true : false;
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		while(inputmnth == 1 || inputmnth == 3 || inputmnth == 5 || inputmnth == 7 
				|| inputmnth == 8 || inputmnth == 10 || inputmnth == 12) {
			if(inputdy < 1 || inputdy > 31) {
				return false;
			}
		}
		
		while(inputmnth == 4 || inputmnth == 6 || inputmnth == 9 || inputmnth == 11) {
			if(inputdy < 1 || inputdy > 30) {
				return false;
			}
		}
		
		while(!leapyr && inputmnth == 2) {
			if(inputdy < 1 || inputdy > 28) {
				return false;
			}
		}
		
		while(leapyr && inputmnth == 2) {
			if(inputdy < 1 || inputdy > 29) {
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
		Date date1 = new Date("01/31/2020");
		Boolean bool1 = date1.isValid();
		
		if(bool1) {
			System.console().writer().println(date1);
		}else {
			System.console().writer().println("Invalid Date!");
		}

	}

}
