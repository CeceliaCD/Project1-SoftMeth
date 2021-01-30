/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/

import java.util.Calendar;

public class Date {
	
	private int year;
	private int month; 
	private int day;
	
	//Have not utilized calendar class yet
	//taking mm/dd/yyyy and create a Date object public Date() { } //return today’s date
	public Date(String date) {
		Integer yr = new Integer(this.year);
		Integer mnth = new Integer(this.month);
		Integer dy = new Integer(this.day);
		
		String dateFormat = Integer.toString(mnth) + "/" + Integer.toString(dy) + "/" + Integer.toString(yr);	
	} 
	
	public Date() { } //return today’s date
	
	//Question: Is a date that is formatted like mm/d/yyyy and m/dd/yyyy invalid?
	public isValid() { 
		int inputyr = this.year;
		int inputmnth = this.month;
		int daysin = this.day;
		
		//Don't know if the way I printed will be acceptable for Professor Chang
		if(inputyr < 1900) {
			System.console().writer().println("Invalid Date!");
		}
		
		boolean leapyr = (inputyr / 4 == 0) ? true : false;
		leapyr = (inputyr/100 == 0) ? true : false;
		leapyr = (inputyr/400 == 0) ? true : false;
		
		//this was how I kept the days in each month bounded from 1 to whatever the days limit for that month
		while(inputmnth == 1 || inputmnth == 3 || inputmnth == 5 || inputmnth == 7 
				|| inputmnth == 8 || inputmnth == 10 || inputmnth == 12) {
			if(daysin < 1 || daysin > 31) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(inputmnth == 4 || inputmnth == 6 || inputmnth == 9 || inputmnth == 11) {
			if(daysin < 1 || daysin > 30) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(!leapyr && inputmnth == 2) {
			if(daysin < 1 || daysin > 28) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
		while(leapyr && inputmnth == 2) {
			if(daysin < 1 || daysin > 29) {
				System.console().writer().println("Invalid Date!");
			}
		}
		
	}
	
	//testbed main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
