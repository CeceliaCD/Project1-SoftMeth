/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/

import java.util.StringTokenizer;

public class Library {

	private Book[] books; // array-based implementation of the bag data structure 
	private int numBooks; // the number of books currently in the bag
	private int capacity = 4; // is this allowed?
	
	public Library() { //default constructor to create an empty bag
		// books = (Book[])new Object[capacity]; // change this number?
		books = new Book[0];
		numBooks = 0;		
	} 
	
	private int find(Book book) { // helper method to find a book in the bag			
		int serialNum = 0; // change this?
		for (int i = 0; i < books.length; i++) {
			if (books[i].equals(book)) {
				serialNum = Integer.parseInt(books[i].getNumber()); // different way to convert string to int?
				return serialNum;
			}
		}
		return serialNum; // change this?
	} 
	
	private void grow() { // helper method to grow the capacity by 4
		//Book[] a = new Book[1];
		//int i = 0;		
		Book[] temp = new Book[books.length + 4];
		for (int i = 0; i < books.length; i++) { // temp length or books length? revist
			temp[i] = books[i];
		}
		books = temp;
	} 
	
	public void add(Book book) { 
		int bookNum = 10001;	
		if (books.length == numBooks) { // fix this part? maybe if books.length == numBooks
			grow();
		}
		//if (books[] == null) {
		//	books[0] == 
		//}
		if (books[0] == null) { // CHANGE THIS!!!!
			books[0] = book;
			//String num1 = ;		
			books[0].setNumber(String.valueOf(bookNum));
			numBooks++;// what???			
		}
		
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				continue;
			}
			//bookNum++;
			if (books[i] == null) {
				//bookNum++;
				books[i] = book;
				books[i].setNumber(String.valueOf(10002));
				numBooks++;
			}
		}
	}
	
	public boolean remove(Book book) { 
		//checking if book is in our system via serial number
		int serialNum = find(book);
		if(serialNum == 0) {
			return false;
		}

		Book[] newBooks = new Book[books.length-1];
		
		for(int i=0, j=0; i < books.length; i++) {
			if( Integer.parseInt(books[i].getNumber()) == serialNum) {
				continue;
			}else {
				newBooks[j++] = books[i];
				return false;
			}
		}
		return true;
	}
	

	public boolean checkOut(Book book) { 
		
		boolean checkingOut = remove(book);
		
		//checking if book's serial number is within system
		//if not then remove will return false
		//thus we cannot checkout a book that is not in our system
		if(!checkingOut) {
			return false;
		}
		return true;
	}
	
	public boolean returns(Book book) { 
		//was the book checked out
		boolean checkedOut = (checkOut(book) == true) ? true : false;
		
		//if checkedOut returns false that means user cannot return it
		if(!checkedOut) {
			return false;
		}
		
		//Use add() to put book back into array
		add(book);
		return true;
	}
	
	
	//Call for the PA command
	public void print() {  	//print the list of books in the bag
		this.books = new Book[numBooks];
	} 
	
	
	//Call for the PD command
	public void printByDate() { 	//print the list of books by datePublished (ascending)
		this.books = new Book[numBooks];
		Book holdBook;
		Date date1 = new Date();
		Date date2 = new Date();
		
		for(int i=0; i < books.length; i++)
		{
			for(int j=i+1; j< books.length; j++)
			{
				date1= books[i].getDatePublished();
				date2= books[j].getDatePublished();
				
				//String dt1
				//String dt2
				StringTokenizer dtStr1 = new StringTokenizer(date1.toString(), "/");
				int month1 = Integer.parseInt(dtStr1.nextToken().trim());
				int day1 = Integer.parseInt(dtStr1.nextToken().trim());
				int year1 = Integer.parseInt(dtStr1.nextToken().trim());
				
				StringTokenizer dtStr2 = new StringTokenizer(date2.toString(), "/");
				int month2 = Integer.parseInt(dtStr2.nextToken().trim());
				int day2 = Integer.parseInt(dtStr2.nextToken().trim());
				int year2 = Integer.parseInt(dtStr2.nextToken().trim());
				
				//still need to check if the condition in this if statement will check for all possible cases
				if((month1 > month2 && year1 >= year2) || (day1 > day2 && year1 >= year2) || year1 > year2) 
				{
					holdBook = books[i];
					books[i] = books[j];
					books[j] = holdBook;
				}
			}
		}
	} 
	
	
	//Call for the PN command
	public void printByNumber() { 	//print the list of books by number (ascending)
		this.books = new Book[numBooks];
		Book holdBook;
		
		for(int i=0; i < books.length; i++)
		{
			for(int j=i+1; j< books.length; j++) 
			{
				if(Integer.parseInt(books[i].getNumber()) > Integer.parseInt(books[j].getNumber()))
				{	
					holdBook = books[i];
					books[i] = books[j];
					books[j] = holdBook;	
				}
			}
		}
	} 
}
