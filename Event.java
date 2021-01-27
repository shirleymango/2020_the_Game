
public class Event implements Comparable<Event> {
	//Instance variables
	private String name;
	private String date;
	
	//Constructor
	public Event(String n, String d) {
		name = n;
		date = d;
	}
	
	//Setters
	public void setName(String n) {
		name = n;
	}
	public void setDate(String d) {
		date = d;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	
	//compareTo
	public int compareTo(Event other) {
		return this.date.compareTo(other.date);
	}
	
	//toString
	public String toString() {
		return name + " " + date;
	}
	
}
