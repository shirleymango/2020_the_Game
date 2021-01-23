import java.util.*;

public class Main {
	private static ArrayList<Event> events;
	private static Scanner in;
	private static Event event1;
	private static Event event2;
	private static int score;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		events = new ArrayList<>(Arrays.asList(new Event("Prince Harry and Meghan Markle quit the royal family", "01/08/2020"),
				new Event("The start of the first impeachment trial of Donald Trump", "01/16/2020"),
				new Event("The first reported U.S. case of COVID-19", "00/00/2020"),
				new Event("Kobe Bryant and his daughter dying in a tragic helicopter accident", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020"),
				new Event("", "00/00/2020")));
		
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
	
	public static int getRandomIndex() {
		return (int) (Math.random() * events.size());
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
