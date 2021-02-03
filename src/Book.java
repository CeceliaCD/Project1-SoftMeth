/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
public class Book {

	private String number; //a 5-digit serial number unique to the book private String name;
	private String name;
	private boolean checkedOut;
	private Date datePublished;

	// start of my code (nida), don't know what's acceptable yet
	public Book(String number, String name, boolean checkedOut, Date datePublished) {
		this.number = number;
		this.name = name;
		this.checkedOut = checkedOut;
		this.datePublished = datePublished;
	}
	
	// getter methods
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getCheckedOut() {
		return checkedOut;
	}
	
	public Date getDatePublished() {
		return datePublished;
	}
	
	// setter methods
	public void setNumber() {
		this.number = number;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public void setCheckedOut() {
		this.checkedOut = checkedOut;
	}
	
	public void setDatePublished() {
		this.datePublished = datePublished;
	}		

// method to generate 5-digital serial number (do we need this in here?)
	/* public int numGenerator () {
		 int bookNum = 10001 + new Random().nextInt(90000);
		// add something about not having 2 of the same serial number?
		num = String.valueOf(bookNum);
		return num; 
		return 10001; // change this
		}
*/

	// returns true if the serial numbers for the 2 book objects are the same.
	@Override
	public boolean equals(Object obj){ // FIX THIS!!!!
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Book) {
			return false;
		}
		//Book book = (Book)obj;
		//return number.equals(obj.number);
		//return number == obj.number;
		return false;
	}

	// format: Book#10007::Design Patterns::5/30/1996::is available.
	@Override
	public String toString() {
		return "Book#" + number +"::" + name + "::" + datePublished + "::" + checkedOut;
		// have checkedOut = "is available" or "is not available"
	}

}
