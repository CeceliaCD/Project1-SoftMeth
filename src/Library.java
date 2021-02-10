/**
The library class consists of methods that are called
within other methods and also methods that commit the action
that matches the user's command. This class allows the user
to add books to a library, find books in a library via their serial
number, increase the library's size, remove books from the library,
checkout books from the library, return books, and print out the current
list of books in the library in the order they came, by day or by serial number.
@Nida Ansari, Cecelia Chollette-Dickson
*/
import java.util.StringTokenizer;

public class Library {

	private Book[] books; // array-based implementation of the bag data structure
	private int numBooks; // the number of books currently in the bag
	private int CAPACITY = 4; 
	public static int bookNums = 0;
	public int serialNum = 0;
	
	/**
	The default constructor called to create an empty book array (a.k.a. library).
	*/
	public Library() { 
		this.books = new Book[CAPACITY];
		this.numBooks = 0;	
		this.serialNum = 10001;
	} 
	
	/**
	A helper method to find a book within the book array.
	*/
	private int find(Book book) { 
		for (int i = 0; i < books.length; i++) 
		{
			if (this.books[i] == null) { 
				return -1;
			}
			if (books[i].getNumber().equals(book.getNumber())) 
			{
				return i;
			}
		}
		return -1;
	} 
	
	/**
	A helper method that helps grow the book array by a capacity of 4.
	*/
	private void grow() { 	
		Book[] temp = new Book[books.length + 4];
		for (int i = 0; i < books.length; i++) 
		{ 
			temp[i] = books[i];
		}
		books = temp;
	} 
	
	/**
	This method allows users to add books into our book array
	and also gives that book a serial number of 10001 or greater.
	It also increments the variable that represents the number of
	books in our array.
	@param Book object being added into library
	*/
	public void add(Book book) { 
		if (bookNums%CAPACITY == 0 && bookNums > 1) {
			grow();
		}
		books[bookNums] = book;
		books[bookNums].setNumber(String.valueOf(bookNums + serialNum));
		books[bookNums].setCheckedOut(true); //the book is available
		
		bookNums++;
		numBooks = bookNums;
	}
	
	/**
	This method permanently removes a book from our book array.
	If a book has already been removed from the library, it cannot be
	removed again. It also decrements the variable representing
	the number of books contained in the array. 
	@param Book object being removed from library
	@return boolean to true if the book can be removed, false otherwise
	*/
	public boolean remove(Book book) {
		int sNum = find(book);
		if (sNum == -1) {
			return false;
		}

		for (int i = sNum; i < numBooks - 1; i++) {
			books[i] = books[i + 1];
		}
		books[numBooks - 1] = null;
		numBooks--;
		return true;
	}
	
	/**
	This method allows users to check out a book. It is
	similar to remove in the sense that only a book that was added
	in the library can be taken and also once a book is taken, it 
	cannot be taken again. However, once it is returned it can be 
	taken.  
	@param Book object whose status we must change to not available
	@return boolean true if successfully being checked out, false otherwise
	*/
	public boolean checkOut(Book book) { 
		int serialNumberindex = find(book);
		
		if(serialNumberindex == -1) {
			return false;
		}else if(books[serialNumberindex].getCheckedOut() == true) { //means the book is available
			books[serialNumberindex].setCheckedOut(false);
			return true;
		}else if(books[serialNumberindex].getCheckedOut() == false) { //means book is already checked out
			return false;
		}
		return true;
	}
	
	/**
	Allows the user to return a book after they have checked it out.
	Similar to add, and actually calls add to have book back in
	the library. 
	@param Book object whose status we want to change to is available
	@return boolean true if it is being successfully returned, false if it's still available
	*/
	public boolean returns(Book book) { 
		int serialNumberindex = find(book);
		
		if(serialNumberindex == -1) {
			return false;
		}else if(books[serialNumberindex].getCheckedOut() == false) { //was checked out
			books[serialNumberindex].setCheckedOut(true);
			return true;
		}else if(books[serialNumberindex].getCheckedOut() == true) { //is actually still available in library
			return false;
		}
		return true;
	}
	
	
	/**
	This method allows the user, once the PA command is
	called through Kiosk, to print the library's contents
	in the order they were placed.
	*/
	public void print() {  	//print the list of books in the bag
		if(numBooks != 0) {
			System.out.println("**List of books in the library.");
			for(int i=0; i < books.length; i++) 
			{
				if (books[i] != null) //to ensure no null elements are printed
				{  
					System.out.println(books[i]);
				}
			}
			System.out.println("**End of list");
		}else {
			System.out.println("Library catalog is empty!");
		}
		
	} 
	
	
	/**
	This method allows the user, once the PD command is called 
	through Kiosk, to print the library's books by date (datePublished)
	in ascending order.
	*/
	public void printByDate() { 	
		if(numBooks != 0) {
			Book holdBook;
			
			for(int i=0; i < books.length; i++)
			{
				for(int j=i+1; j< books.length; j++)
				{
					if(books[i] != null && books[j] != null) //helps with null elements
					{ 
						String date1= books[i].getDatePublished().datetoString();
						String date2= books[j].getDatePublished().datetoString();
						
						StringTokenizer dtStr1 = new StringTokenizer(date1, "/");
						int month1 = Integer.parseInt(dtStr1.nextToken().trim());
						int day1 = Integer.parseInt(dtStr1.nextToken().trim());
						int year1 = Integer.parseInt(dtStr1.nextToken().trim());
						
						StringTokenizer dtStr2 = new StringTokenizer(date2, "/");
						int month2 = Integer.parseInt(dtStr2.nextToken().trim());
						int day2 = Integer.parseInt(dtStr2.nextToken().trim());
						int year2 = Integer.parseInt(dtStr2.nextToken().trim());
					
						if(year1 > year2 || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2)) 
						{
							
								holdBook = books[i];
								books[i] = books[j];
								books[j] = holdBook;
						}else if(year1 == year2 && month1 == month2 && day1 == day2) {
							if(books[i].getName().compareTo(books[j].getName()) > 0) 
							{
									Book temp = books[i];
									books[i] = books[j];
									books[j] = temp;
							}
						}
					}else if(books[i] == null && books[j] != null) {
						books[i] = books[j];
					}else if(books[i] != null && books[j] == null) {
						continue;
					}
				}
			}
			
			System.out.println("**List of books by the dates published.");
			for(int j=0; j < books.length; j++) {
				if (books[j] != null) 
				{
					System.out.println(books[j]);
				}
				
			}
			System.out.println("**End of list");
		}else {
			System.out.println("Bookshelf is empty!");
		}
		
	} 
	
	
	/**
	This method allows the user, once the PN command is called
	through Kiosk, to print the library's books by their serial
	numbers in ascending order.
	*/
	public void printByNumber() { 
		if(numBooks != 0) {
			Book holdBook;
			
			for(int i=0; i < books.length; i++)
			{
				for(int j=i+1; j< books.length; j++) 
				{
					if (books[i] != null && books[j] != null) //helps with null elements
					{
						if(Integer.parseInt(books[i].getNumber()) > Integer.parseInt(books[j].getNumber()))
						{	
						
							holdBook = books[i];
							books[i] = books[j];
							books[j] = holdBook;	
						
						}
					}else if(books[i] == null && books[j] != null) {
						books[i] = books[j];
					}else if(books[i] != null && books[j] == null) {
						continue;
					}
				}
			}
			
			System.out.println("**List of books by the book numbers.");
			for(int k=0; k < books.length; k++) {
				if (books[k] != null) 
				{
					System.out.println(books[k]);
				}
			}
			System.out.println("**End of list");
		}else {
			System.out.println("Bookshelf is empty!");
		}
	} 
}
