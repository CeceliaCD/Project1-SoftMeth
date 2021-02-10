/**
The book class is responsible for creating the
book object with the variables that consist of 
its serial number, name, published date, and if 
it is checked out. We also override the string so
so that the previously mentioned components are 
formatted a certain way when printed.
@author Nida Ansari, Cecelia Chollette-Dickson
*/
public class Book {

	private String number; //a 5-digit serial number unique to the book private String name;
	private String name;
	private boolean checkedOut;
	private Date datePublished;
	
	/**
	Getter method to obtain a book's serial number.
	@return the serial number of a book
	*/
	public String getNumber() {
		return number;
	}
	
	/**
	Getter method to obtain a book's title.
	@return the title of a book
	*/
	public String getName() {
		return name;
	}
	
	/**
	Getter method to obtain a book's status of which
	it has either been checked out or not.
	@return the status of whether a book is available or not
	*/
	public boolean getCheckedOut() {
		return checkedOut;
	}
	
	/**
	Getter method to  obtain the date in which a book
	has been published.
	@return the date a book was publushed of type Date
	*/
	public Date getDatePublished() {
		return datePublished;
	}
	
	/**
	Setter method to assign the serial number 
	for a book.
	@param num of type string to be given to a book object
	*/
	public void setNumber(String num) {
		this.number = num;
	}
	
	/**
	Setter method to give the book object
	its title.
	@param title to be given to a book object
	*/
	public void setName(String title) {
		this.name = title;
	}
	
	/**
	Setter method to assign the status of whether
	a book is checked out or not.
	@param checkout of type boolean to check status of whether a book will be available or not
	*/
	public void setCheckedOut(boolean checkout) {
		this.checkedOut = checkout;
	}
	
	/**
	Setter method to assign a book object's 
	published date.
	@param datePub of type date in which a given book was published
	*/
	public void setDatePublished(Date datePub) {
		this.datePublished = datePub;
	}		

	/**
	This method returns true if the serial numbers
	for the 2 book objects are the same. The parameter
	of type object compares the object to instances
	of books to verify that they are type Book object.
	@param obj of type object checks if our object is of type Book
	@return true if it is a book variable, false otherwise
	*/
	@Override
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book objBook = (Book) obj;
		if (this.number.equals(objBook.number)) {
			return true;
		}
		return false;
	}

	/**
	Gives the book object a format: 
	Book#10007::Design Patterns::5/30/1996::is available.
	@return the string result of all the variables of the Book object in the array
	*/
	@Override
	public String toString() {
		String bookOutput = "";
		
		if(getCheckedOut() == false) {
			bookOutput = "Book#" + getNumber() +"::" + getName() + "::" + getDatePublished().datetoString() + "::is checked out.";
		}else {
			bookOutput = "Book#" + getNumber() +"::" + getName() + "::" + getDatePublished().datetoString() + "::is available.";
		}
		
		return bookOutput;
	}

}
