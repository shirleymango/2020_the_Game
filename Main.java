import java.util.*;

public class Main {
	private static ArrayList<Event> events;
	private static Scanner in;
	private static Event event1;
	private static Event event2;
	private static int score = 0;
	
	public static void main(String[] args) {
		events = new ArrayList<>(Arrays.asList(new Event("Prince Harry and Meghan Markle quit the royal family", "01/08/2020"),
				new Event("The start of the first impeachment trial of Donald Trump", "01/16/2020"),
				new Event("The first reported U.S. case of COVID-19", "01/19/2020"),
				new Event("Kobe Bryant and his daughter dying in a tragic helicopter accident", "01/26/2020"),
				new Event("Brexit", "01/31/2020"),
				new Event("\"Parasite\" sweeping the Oscars", "02/09/2020"),
				new Event("Harvey Weinstein being sentenced to 23 years in prison", "02/24/2020"),
				new Event("The 2020 stock market crash", "03/09/2020"),
				new Event("The death of Breona Taylor", "03/13/2020"),
				new Event("Kim Jon-Un death rumors", "04/15/2020"),
				new Event("Elon Musks's private space company SpaceX launching NASA astronauts into orbit", "05/30/2020"),
				new Event("Trump starting his trial rally in Tulsa, Oklahoma onnly to have it hijacked by K-Pop stans", "06/20/2020"),
				new Event("Ghislaine Maxwell being arrested o multiple charges related to the sexual abuse of young women and girls by Jeffrey Epstein", "07/02/2020"),
				new Event("Kanye West anouncing his 2020 United States presidential election campaign through Twitter", "07/04/2020"),
				new Event("A Florida teen being arrested for taking over the Twitter accounts of Joe Biden, Bill Gates, Elon Musk, and Kanye West inn a bitcoin scam", "07/31/2020"),
				new Event("An ammonium nitrate explosion hittig Beirut, Lebanon", "08/04/2020"),
				new Event("Kamala Harris being chosen as Democratic VP candidate", "08/11/2020"),
				new Event("Biden becoming the Democractic VP candidate", "08/18/2020"),
				new Event("Chadwick Boseman's death", "08/28/2020"),
				new Event("Ruth Bader Ginsburg's death", "09/18/2020"),
				new Event("Trump testing positive for COVID-19", "10/02/2020"),
				new Event("Joe Biden becoming president-elect", "11/07/2020"),
				new Event("Alex Trebek's death", "11/08/2020"),
				new Event("US Food and Drug Administration approving the emergency use of Pfizer’s COVID-19 shot", "12/11/2020"),
				new Event("The first Americans receiving the COVID-19 vaccine", "12/14/2020")));
		in = new Scanner(System.in);
		
		event1 = events.get(0);
		event2 = events.get(1);
		//Printing the first pair of events
		System.out.println("Event 1: " + event1.getName());
		System.out.println("Date: " + event1.getDate());
		System.out.println();
		System.out.println("Event 2: " + event2.getName());
		System.out.println("Date: ?");
		System.out.println("Does Event 2 occur BEFORE or AFTER Event 1?");
		String input = in.nextLine();
		//checking the answer
		checkAnswer(input);
		//set Event 1 to be the previous Event 2
		setEvent1();		
	}
	
	public static void checkAnswer(String ans) {
		if (event2.getDate().compareTo(event1.getDate()) < 0 && ans.equals("BEFORE")) {
			score += 100;
			System.out.println("Correct. " + event2.getName() + " happened on " + event2.getDate());
		}
		else if (event2.getDate().compareTo(event1.getDate()) > 0 && ans.equals("AFTER")) {
			score += 100;
			System.out.println("Correct. " + event2.getName() + " happened on " + event2.getDate());
		}
		else {
			System.out.println("Incorrect. " + event2.getName() + " happened on " + event2.getDate());
		}
	}
	
	public static void setEvent1() {
		event1.setName(event2.getName());
		event1.setDate(event2.getDate());
	}	

}
