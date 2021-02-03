/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
public class Library {

	private Book[] books; // array-based implementation of the bag data structure 
	private int numBooks; // the number of books currently in the bag
	private int capacity = 4; // is this allowed?
	
	public Library() { //default constructor to create an empty bag
		books = (Book[])new Object[capacity]; // change this number?
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
	public boolean remove(Book book) { }
	public boolean checkOut(Book book) { }
	public boolean returns(Book book) { }
	public void print() { } //print the list of books in the bag
	public void printByDate() { } //print the list of books by datePublished (ascending) public void printByNumber() { } //print the list of books by number (ascending)
}
