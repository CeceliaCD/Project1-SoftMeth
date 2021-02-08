/**
 * The Kiosk class is for processing the command lines from the console.
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

	/*
	 * The run method is responsible for obtaining the
	 * input that the user gives in as a string and breaking
	 * it apart. First the command is obtain and based on that
	 * input, whatever other input that should follow it to
	 * discern the correct ouptut.
	 */
	public void run() { 
		
		Scanner input = new Scanner(System.in);
		Book[] books;
		int numBooks; //don't know if needed 
		Book theBook;
	
		while (true) {
			
			String choice = input.nextLine();
			char firstChar = choice.charAt(0);
			String serialNum;
	
			//String delim = ",";
			//StringTokenizer st = new StringTokenizer(choice, delim);
			String[] split = choice.split(",");
			//String name = split[1].setName();
			
			// all the if statements have a phrase to output rn, i was just testing!
			if (firstChar == 'A') {
				//addBook();
			}
			
			if (firstChar == 'R') { 
				serialNum = input.nextLine();
				theBook.setNumber(serialNum);
				
				//hopefully doesn't give prob for calling class, since under same package
				if(lib.remove(theBook)) {
					System.out.printf("Book#%s %s\n", serialNum, "removed.");
				}else {
					System.out.println("Unable to remove, the library does not have this book.");
				}
			}
			
			if (firstChar == 'O') {
				serialNum = input.nextLine();
				theBook.setNumber(serialNum);
				
				if(lib.checkOut(theBook)) {
					System.out.printf("You’ve checked out Book#%s %s\n", serialNum, ". Enjoy!");
				}else {
					System.out.printf("Book#%s %s\n", serialNum, "is not available.");
				}
			}
			
			if (firstChar == 'I') {
				serialNum = input.nextLine();
				theBook.setNumber(serialNum);
				
				if(lib.returns(theBook)) {
					System.out.printf("Book#  %s %s\n", serialNum, "return has completed. Thanks!");
				}else {
					System.out.println("Unable to return Book#" + serialNum + ".");
				}
			}
			
			if (choice.equals("PA")) {
				books = new Book[numBooks];
				
				if(lib.print()) {
					
					System.out.println("**List of books in the library.");
					for(int i=0; i < books.length; i++) {
						System.out.println(books[i]);
					}
					System.out.println("**End of list");
				}else {
					System.out.println("Library catalog is empty!");
				}
			}
			
			if (choice.equals("PD")) {
				books = new Book[numBooks];
				
				if(lib.printByDate()) {
					
					System.out.println("**List of books by the dates published.");
					for(int j=0; j < books.length; j++) {
						System.out.println(books[j]);
					}
					System.out.println("**End of list");
				}else {
					System.out.println("Bookshelf is empty!");
				}
			}
			
			if (choice.equals("PN")) {
				books = new Book[numBooks];
				
				if(lib.printByNumber()) {
					
					System.out.println("**List of books by the book numbers.");
					for(int k=0; k < books.length; k++) {
						System.out.println(books[k]);
					}
					System.out.println("**End of list");
				}else {
					System.out.println("Bookshelf is empty!");
				}
			}
			
			if (firstChar == 'Q') {
				System.out.println("Kiosk session ended.");
				System.exit(0);
			}
			
			System.out.println("Invalid command!");
		}
	}

}

