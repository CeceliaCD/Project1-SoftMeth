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
	
	while (true) {
		
		String choice = input.nextLine();
		char firstChar = choice.charAt(0);

		//String delim = ",";
		//StringTokenizer st = new StringTokenizer(choice, delim);
		String[] split = choice.split(",");
		//String name = split[1].setName();
		
		// all the if statements have a phrase to output rn, i was just testing!
		if (firstChar == 'A') {
			//addBook();
		}
		
		if (firstChar == 'R') {
			//remove();
		}
		
		if (firstChar == 'O') {
			//checkOut();
		}
		
		if (firstChar == 'I') {
			//returnBook();
		}
		
		if (choice.equals("PA")) {
			//currSequence();
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
	}

}

