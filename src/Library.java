/**
 * The library class consists of methods that are called
 * within other methods and also methods that commit the action
 * that matches the user's command. This class allows the user
 * to add books to a library, find books in a library via their serial
 * number, increase the library's size, remove books from the library,
 * checkout books from the library, return books, and print out the current
 * list of books in the library in the order they came, by day or by serial number.
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
import java.util.StringTokenizer;

public class Library {

	private Book[] books; // array-based implementation of the bag data structure 
	private int numBooks; // the number of books currently in the bag
	private int capacity = 4; 
	public static int bookNums = 0;
	
	/*
	 * The default constructor called to create an empty book array (a.k.a. library).
	 */
	public Library() { 
		books = new Book[capacity];
		numBooks = 0;		
	} 
	
	/*
	 * A helper method to find a book within the book array.
	 */
	private int find(Book book) { 			
		int serialNum = 0;
		for (int i = 0; i < books.length; i++) 
		{
			if (books[i].equals(book)) 
			{
				serialNum = Integer.parseInt(books[i].getNumber());
				return serialNum;
			}
		}
		return serialNum;
	} 
	
	/*
	 * A helper method that helps grow the book array by a capacity of 4.
	 */
	private void grow() { 	
		Book[] temp = new Book[books.length + 4];
		for (int i = 0; i < books.length; i++) 
		{ 
			temp[i] = books[i];
		}
		books = temp;
	} 
	
	/*
	 * This method allows users to add books into our book array
	 * and also gives that book a serial number of 10001 or greater.
	 * It also increments the variable that represents the number of
	 * books in our array.
	 */
	public void add(Book book) { 
		if (bookNums%capacity == 0 && bookNums > 1) {
			grow();
		}
		this.books[bookNums] = book;
		this.books[bookNums].setNumber(String.valueOf(bookNums + 10001));
		
		bookNums++;
		numBooks = bookNums;
	}
	
	/*
	 * This method permanently removes a book from our book array.
	 * If a book has already been removed from the library, it cannot be
	 * removed again. It also decrements the variable representing
	 * the number of books contained in the array.
	 */
	public boolean remove(Book book) { 
		//checking if book is in our system via serial number
		int serialNum = find(book);
		if(serialNum == 0) 
		{
			return false;
		}

		Book[] newBooks = new Book[books.length];
		
		for(int i=0, j=0; i < books.length; i++) 
		{
			if( Integer.parseInt(books[i].getNumber()) == serialNum) {
				continue;
			}else {
				newBooks[j++] = books[i];
				numBooks--;
				return false;
			}
		}
		return true;
	}
	
	/*
	 * This method allows users to check out a book. It is
	 * similar to remove in the sense that only a book that was added
	 * in the library can be taken and also once a book is taken, it 
	 * cannot be taken again. However, once it is returned it can be 
	 * taken.
	 */
	public boolean checkOut(Book book) { 
		
		boolean checkingOut = remove(book);
		
		//checking if book's serial number is within system
		//if not then remove will return false
		//thus we cannot checkout a book that is not in our system
		if(checkingOut == false) 
		{
			book.setCheckedOut(false);
			return false;
		}
		book.setCheckedOut(true);
		return true;
	}
	
	/*
	 * Allows the user to return a book after they have checked it out.
	 * Similar to add, and actually calls add to have book back in
	 * the library.
	 */
	public boolean returns(Book book) { 
		boolean checkedOut = (checkOut(book) == true) ? true : false;
		
		//if checkedOut returns false that means user cannot return it
		if(checkedOut == false) 
		{
			book.setCheckedOut(false);
			return false;
		}
		book.setCheckedOut(true);

		add(book);
		book.setCheckedOut(false);
		return true;
	}
	
	
	/*
	 * This method allows the user, once the PA command is
	 * called through Kiosk, to print the library's contents
	 * in the order they were placed.
	 */
	public void print() {  	//print the list of books in the bag
		this.books = new Book[numBooks];
	} 
	
	
	/*
	 * This method allows the user, once the PD command is called 
	 * through Kiosk, to print the library's books by date (datePublished)
	 * in ascending order.
	 */
	public void printByDate() { 	
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
				
				StringTokenizer dtStr1 = new StringTokenizer(date1.toString(), "/");
				int month1 = Integer.parseInt(dtStr1.nextToken().trim());
				int day1 = Integer.parseInt(dtStr1.nextToken().trim());
				int year1 = Integer.parseInt(dtStr1.nextToken().trim());
				
				StringTokenizer dtStr2 = new StringTokenizer(date2.toString(), "/");
				int month2 = Integer.parseInt(dtStr2.nextToken().trim());
				int day2 = Integer.parseInt(dtStr2.nextToken().trim());
				int year2 = Integer.parseInt(dtStr2.nextToken().trim());
				

				if((month1 > month2 && year1 >= year2) || (month1 == month2 && day1 > day2 && year1 >= year2) 
						|| (month1 == month2 && day1 == day2 && year1 > year2)) 
				{
					holdBook = books[i];
					books[i] = books[j];
					books[j] = holdBook;
				}
			}
		}
	} 
	
	
	/*
	 * This method allows the user, once the PN command is called
	 * through Kiosk, to print the library's books by their serial
	 * numbers in ascending order.
	 */
	public void printByNumber() { 
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
