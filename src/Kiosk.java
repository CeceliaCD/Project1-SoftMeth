/**
The Kiosk class is for processing the command lines from 
the console and giving the required output back to the user.
@Nida Ansari, Cecelia Chollette-Dickson
*/
import java.util.Scanner;

public class Kiosk {

	/**
	The run method is responsible for obtaining the
	input that the user gives in as a string and breaking
	it apart. First the command is obtain and based on that
	input, whatever other input that should follow it to
	discern the correct ouptut.
	*/
	public void run() { 
		
		Scanner input = new Scanner(System.in);
		Library lib = new Library();
	
		while (true) {
			
			String choice = input.nextLine();
			char firstChar = choice.charAt(0);
			
	
			if(choice.equals("")) {
				continue;
			}
			
			if (firstChar == 'A') {
				try {
					String[] split = choice.split(",");
					String name = split[1];
					Date datePub = new Date(split[2]);
				
					if (datePub.isValid() == true) {
						Book book = new Book();
						book.setName(name);
						book.setDatePublished(datePub);
						lib.add(book);
						System.out.println(book.getName() + " added to the library.");
					}
					else {
						System.out.println("Invalid Date!");
					}
				}
				catch(Exception e) {
					System.out.println("Invalid command!");
				}
				
			}else if (firstChar == 'R') { 
				if (choice.charAt(1) != ',') {
					System.out.println("Invalid command!");
				}
				else {
				String serialNum = choice.substring(choice.indexOf(',')+1);
				Book bookRemove = new Book();
				bookRemove.setNumber(serialNum);
				
				boolean removed = lib.remove(bookRemove);
				
				if (removed == true) {
					System.out.println("Book#" + serialNum + " removed.");
				}
				else {
					System.out.println("Unable to remove, the library does not have this book.");
				}
				}
				
			}else if (firstChar == 'O') {
				if (choice.charAt(1) != ',') {
					System.out.println("Invalid command!");
				}
				else {
				try {
					String serialNum1 = choice.substring(choice.indexOf(',')+1);
					Book bookCheckout = new Book();
					bookCheckout.setNumber(serialNum1);
					
					if(lib.checkOut(bookCheckout)) {
						System.out.println("You’ve checked out Book#" + serialNum1 + ". Enjoy!");
					}else {
						System.out.println("Book#" + serialNum1 + " is not available.");
					}
				}
				catch(Exception e) {
					System.out.println("Invalid command!");
				}
				}
			}else if (firstChar == 'I') {
				if (choice.charAt(1) != ',') {
					System.out.println("Invalid command!");
				}
				else {
				try {
					String serialNum2 = choice.substring(choice.indexOf(',')+1);
					Book bookReturn = new Book();
					bookReturn.setNumber(serialNum2);
					
					if(lib.returns(bookReturn)) {
						System.out.println("Book#" + serialNum2 + " return has completed. Thanks!");
					}else {
						System.out.println("Unable to return Book#" + serialNum2 + ".");
					}
				}
				catch(Exception e) {
					System.out.println("Invalid command!");
				}
				}
	
			}else if (choice.equals("PA")) {
				
				lib.print();		
			}else if (choice.equals("PD")) {
				
				lib.printByDate();
			}else if (choice.equals("PN")) {
				
				lib.printByNumber();
			}else if (firstChar == 'Q') {
				System.out.println("Kiosk session ended.");
				input.close();
				break;
			}else{
				System.out.println("Invalid command!");
			}
		}
	}

}

