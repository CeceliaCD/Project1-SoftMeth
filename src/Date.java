/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/

import java.util.Calendar;

public class Date {
	
	private int year;
	private int month; 
	private int day;
	
	
	//taking mm/dd/yyyy and create a Date object public Date() { } 
	public Date(String date) {
		Integer yr = new Integer(this.year);
		Integer mnth = new Integer(this.month);
		Integer dy = new Integer(this.day);
		
		String dateFormat = Integer.toString(mnth) + "/" + Integer.toString(dy) + "/" + Integer.toString(yr);	
	} 
	
	//return today’s date
	public Date() { 
		Calendar calendar.getInstance();
		System.console().writer().println(calendar.getTime());
		
	} 
	
	//Question: Is a date that is formatted like mm/d/yyyy and m/dd/yyyy invalid?
	public isValid() { 
		//int inputyr = this.year;
		//int inputmnth = this.month;
		//int daysin = this.day;
		
		//Don't know if the way I printed will be acceptable for Professor Chang
		//Calendar class uses Gregorian and Julian calendars in which JAN represents 0 thus I added plus 1 for month numeric values
		if(yr < 1900 || (yr > calendar.getInstance().get(Calendar.YEAR) || dy > calendar.getInstance().get(Calendar.DAY_OF_MONTH)
				|| mnth > calendar.getInstance().get(Calendar.MONTH+1))) {
			System.console().writer().println("Invalid Date!");
		}
		
		boolean leapyr = (yr / 4 == 0) ? true : false;
		leapyr = (yr/100 == 0) ? true : false;
		leapyr = (yr/400 == 0) ? true : false;
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		while(mnth == 1 || mnth == 3 || mnth == 5 || mnth == 7 
				|| mnth == 8 || mnth == 10 || mnth == 12) {
			if(dy < 1 || dy > 31) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(mnth == 4 || mnth == 6 || mnth == 9 || mnth == 11) {
			if(dy < 1 || dy > 30) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(!leapyr && mnth == 2) {
			if(dy < 1 || dy > 28) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(leapyr && mnth == 2) {
			if(dy < 1 || dy > 29) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
	}
	
	//testbed main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
