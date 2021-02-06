/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
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
		for (int i = 0; i < temp.length; i++) { // temp length or books length? revist
			temp[i] = books[i];
		}
		books = temp;
	} 
	
	public void add(Book book) { 
		if ((books.length%capacity) == 0) { // fix this part?
			grow();
			add(book);
		}
		else { // generate random number here
			books[books.length] = book;
			numBooks++;
		}
	}
	
	public boolean remove(Book book) { 
		int serialNum = find(book);
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
	
	//not sure if I did this method correctly
	public boolean checkOut(Book book) { 
		int isSerialNum = (find(book)!= 0) ? find(book) : 0;
		
		if(isSerialNum == 0) {
			return false;
		}
		
		boolean checkingOut = remove(book);
		if(!checkingOut) {
			return false;
		}
		return true;
	}
	
	public boolean returns(Book book) { 
		boolean checkedOut = (checkOut(book) == true) ? true : false;
		
		if(!checkedOut) {
			return false;
		}
		add(book);
		return true;
	}
	
	//print the list of books in the bag
	//Call for the PA command
	public void print() { 
		
	} 
	
	//print the list of books by datePublished (ascending)
	//Call for the PD command
	public void printByDate() { } 
	
	//print the list of books by number (ascending)
	//Call for the PN command
	public void printByNumber() { 
		
	} 
}
