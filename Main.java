import java.util.*;

public class Main {
	private static ArrayList<Event> events;
	private static Scanner in;
	private static Event event1;
	private static Event event2;
	private static int score = 0;
	private static int numOfLives = 3;
	private static int numOfPoints;
		
	public static void main(String[] args) {
		events = new ArrayList<>(Arrays.asList(new Event("Prince Harry and Meghan Markle quit the royal family", "01/08/2020"),
				new Event("The start of the first impeachment trial of Donald Trump", "01/16/2020"),
				new Event("The first reported U.S. case of COVID-19", "01/19/2020"),
				new Event("Kobe Bryant and his daughter dying in a tragic helicopter accident", "01/26/2020"),
				new Event("Brexit", "01/31/2020"),
				new Event("\"Parasite\" sweeping the Oscars", "02/09/2020"),
				new Event("Harvey Weinstein being sentenced to 23 years in prison", "02/24/2020"),
				new Event("The 2020 stock market crash", "03/09/2020"),
				new Event("The death of Breonna Taylor", "03/13/2020"),
				new Event("Kim Jong-Un death rumors", "04/15/2020"),
				new Event("Elon Musk's private space company SpaceX launching NASA astronauts into orbit", "05/30/2020"),
				new Event("Trump starting his trial rally in Tulsa, Oklahoma only to have it hijacked by K-Pop stans", "06/20/2020"),
				new Event("Ghislaine Maxwell being arrested on multiple charges related to the sexual abuse of young women and girls by Jeffrey Epstein", "07/02/2020"),
				new Event("Kanye West announcing his 2020 United States presidential election campaign through Twitter", "07/04/2020"),
				new Event("A Florida teen being arrested for taking over the Twitter accounts of Joe Biden, Bill Gates, Elon Musk, and Kanye West in a bitcoin scam", "07/31/2020"),
				new Event("An ammonium nitrate explosion hitting Beirut, Lebanon", "08/04/2020"),
				new Event("Biden naming Kamala Harris as his VP running mate", "08/11/2020"),
				new Event("Biden officially becoming the Democratic presidential nominee at the Democratic National Convention", "08/18/2020"),
				new Event("Chadwick Boseman's death", "08/28/2020"),
				new Event("Ruth Bader Ginsburg's death", "09/18/2020"),
				new Event("Trump testing positive for COVID-19", "10/02/2020"),
				new Event("Joe Biden becoming president-elect", "11/07/2020"),
				new Event("Alex Trebek's death", "11/08/2020"),
				new Event("US Food and Drug Administration approving the emergency use of Pfizer’s COVID-19 shot", "12/11/2020"),
				new Event("The first Americans receiving the COVID-19 vaccine", "12/14/2020")));
		in = new Scanner(System.in);
		
		//Printing introduction
		System.out.println("~-~-~-~-~-~-~-~-~-");
		System.out.println("| 2020: THE GAME |");
		System.out.println("-~-~-~-~-~-~-~-~-~");
		System.out.println("Test your knowledge of the 2020 timeline.");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Instructions: Given the name and date of Event 1 and only the name of Event 2, you must guess whether Event 2 happened BEFORE or AFTER Event 1. \nYou have 3 lives and for each incorrect answer, you will lose a life. Good luck!");
		
		//Start game
		System.out.println("Type START to begin.");
		String input = in.nextLine();
		while (!input.equals("START")) {
			System.out.println("Type START to begin.");
      input = in.nextLine();
		}
    System.out.println("-----------------------------------------------------------------");
		
		//Instantiating the first pair of events
		int index = getRandomIndex();
		event1 = events.get(index);
		events.remove(index);
		index = getRandomIndex();
		event2 = events.get(index);
		events.remove(index);
		
		while (numOfLives > 0) {
			//Printing the current score and number of lives
			System.out.print("Lives: ");
			for (int i = 0; i < numOfLives; i++) {
				System.out.print("♥ ");
			}
			System.out.println();
			System.out.println("Score: " + score);
			System.out.println();
			
			//Printing the pair of events
			System.out.println("Event 1: " + event1.getName());
			System.out.println("Date: " + event1.getDate());
			System.out.println();
			System.out.println("Event 2: " + event2.getName());
			System.out.println("Date: ?");
			System.out.println("Does Event 2 occur BEFORE or AFTER Event 1?");
			long startTime = System.currentTimeMillis();
			
			input = in.nextLine();
			while (!input.equals("BEFORE") && !input.equals("AFTER")) {
				System.out.println("Invalid input. Please enter only either BEFORE or AFTER.");
				input = in.nextLine();
			}
			
			long endTime = System.currentTimeMillis();
			//Calculating points based on speed of response
			numOfPoints = calculatePoints(startTime, endTime);
			
			//Checking the answer
			checkAnswer(input);
			System.out.println("-----------------------------------------------------------------");
			
			//Setting Event 1 to be the previous Event 2 and setting Event 2 to a new random event
			setEvent1();
			setEvent2();
		}
		System.out.println("Number of Lives: " + numOfLives);
		System.out.println("Score: " + score);
		System.out.println("Game Over.");
	}
	
	public static int getRandomIndex() {
		return (int) (Math.random() * events.size());
	}
	
	public static void checkAnswer(String ans) {
		if (event2.getDate().compareTo(event1.getDate()) < 0 && ans.equals("BEFORE")) {
			score += numOfPoints;
			System.out.println("Correct! " + event2.getName() + " happened on " + event2.getDate() + ".");
		}
		else if (event2.getDate().compareTo(event1.getDate()) > 0 && ans.equals("AFTER")) {
			score += numOfPoints;
			System.out.println("Correct! " + event2.getName() + " happened on " + event2.getDate() + ".");
		}
		else {
			numOfLives--;
			System.out.println("Incorrect. " + event2.getName() + " happened on " + event2.getDate() + ".");
		}
	}
	
	public static int calculatePoints(long startTime, long endTime) {
		int elapsedTime = (int) ((endTime - startTime) / 1000);
		if (1000-(elapsedTime-1)*50 >= 50) {
			return 1000-(elapsedTime-1)*50;
		}
		return 50;
	}
	
	public static void setEvent1() {
		event1.setName(event2.getName());
		event1.setDate(event2.getDate());
	}
	
	public static void setEvent2() {
		int index = getRandomIndex();
		event2 = events.get(index);
		events.remove(index);
	}

}
