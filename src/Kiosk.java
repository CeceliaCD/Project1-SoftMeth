/*
 * @Nida Ansari
 * @Cecelia Chollette-Dickson
*/
import java.util.Scanner;
import java.util.StringTokenizer;

//Can use System.out in this class
public class Kiosk {

	public void run() { 
		
		Scanner input = new Scanner(System.in);
		private Book[] books;
		private int numBooks; //don't know if needed 
		private Book theBook;
	
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
				theBook = new Book(serialNum);
				
				//hopefully doesn't give prob for calling class, since under same package
				if(library.remove(theBook)) {
					System.out.printf("Book#%s %s\n", serialNum, "removed.");
				}else {
					System.out.println("Unable to remove, the library does not have this book.");
				}
			}
			
			if (firstChar == 'O') {
				serialNum = input.nextLine();
				theBook = new Book(serialNum);
				
				if(library.checkOut(theBook)) {
					System.out.printf("You’ve checked out Book#%s %s\n", serialNum, ". Enjoy!");
				}else {
					System.out.printf("Book#%s %s\n", serialNum, "is not available.");
				}
			}
			
			if (firstChar == 'I') {
				serialNum = input.nextLine();
				theBook = new Book(serialNum);
				
				if(library.returns(theBook)) {
					System.out.printf("Book#  %s %s\n", serialNum, "return has completed. Thanks!");
				}else {
					System.out.println("Unable to return Book#" + serialNum + ".");
				}
			}
			
			if (choice.equals("PA")) {
				books = new Book[numBooks];
				
				if(library.print()) {
					
					System.out.println("**List of books in the library.");
					for(int i=0; i < books.length; i++) {
						System.out.println(books[i]);
					}
					System.out.println("**End of list");
				}
			}
			
			if (choice.equals("PD")) {
				//dateAscOrder();
			}
			
			if (choice.equals("PN")) {
				//bookAscOrder();
			}
			
			if (firstChar == 'Q') {
				System.out.println("Kiosk session ended.");
				System.exit(0);
			}
			
			System.out.println("Invalid command!");
		}
	}

}

