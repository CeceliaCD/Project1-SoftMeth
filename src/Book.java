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
	public Book(String num, String bookName, boolean checkOut, Date bookDate) {
		num = number;
		bookName = name;
		checkOut = checkedOut;
		bookDate = datePublished;
	}

// method to generate 5-digital serial number (do we need this in here?)
	public int numGenerator () {
		int bookNum = 10001 + new Random().nextInt(90000);
		// add something about not having 2 of the same serial number?
		num = String.valueOf(bookNum);
		return num;
	}

	// returns true if the serial numbers for the 2 book objects are the same.
	@Override
	public boolean equals(Object obj){
		// question: how do we get the 2 books?
		// book1number = obj.number;
	}

	// format: Book#10007::Design Patterns::5/30/1996::is available.
	@Override
	public String toString() {
		return "Book#" + num +"::" + bookName + "::" + bookDate + "::" + checkOut;
		// have checkedOut = "is available" or "is not available"
	}

}
