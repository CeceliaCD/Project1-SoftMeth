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
		
		//f (firstChar == 'W') {
		String delim = ",";
		StringTokenizer st = new StringTokenizer(choice, delim);
		String[] split = choice.split(",");
		Book books;
		//String name = split[1];
		String name = split[1].setName();
		//int i = 0;
		//String[] line = st.next().toStringArray;
		//while (st.hasMoreElements()) {		
		//	line[i] = (String) st.nextElement();
		//	i++;
		//}
		//System.out.println("3rd element: " + split[2]);
		//}
		
		// all the if statements have a phrase to output rn, i was just testing!
		if (firstChar == 'A') {
			System.out.println("hello!");
		}
		
		if (firstChar == 'R') {
			System.out.println("hello!1");
			//remove();
		}
		
		if (firstChar == 'O') {
			System.out.println("hello!2");
			//checkOut();
		}
		
		if (firstChar == 'I') {
			System.out.println("hello!3");
			//returnBook();
		}
		
		if (choice.equals("PA")) {
			System.out.println("hello!4");
			//currSequence();
		}
		
		if (choice.equals("PD")) {
			System.out.println("hello!5");
			//dateAscOrder();
		}
		
		if (choice.equals("PN")) {
			System.out.println("hello!6");
			//bookAscOrder();
		}
		if (firstChar == 'Q') {
			System.out.println("Kiosk session ended.");
			System.exit(0);
		}
	}

}

