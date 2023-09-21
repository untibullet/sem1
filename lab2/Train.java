package lab2;

public class Train {
	public Train() {
	}
	
	public void setDeparturePoint(String point) {
		this.departurePoint = point;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public void setNumberOfSeatsByType(int count, int t) {
		switch (t) {
		case 0 :
			this.commonSeats = count;
			break;
		case 1:
			this.theCoupe = count;
			break;
		case 2:
			this.reservedSeat = count;
			break;
		case 3:
			this.luxSeats = count;
			break;
		}
	}
	
	public void updateSeats() {
		this.numberOfSeats = commonSeats + theCoupe + reservedSeat + luxSeats;
	}
	
	public String getDeparturePoint() {
		return departurePoint;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getNumberOfSeatsByType(int t) {
		switch (t) {
		case 0 :
			return commonSeats;
		case 1:
			return theCoupe;
		case 2:
			return reservedSeat;
		case 3:
			return luxSeats;
		default:
			return 0;
		}
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	public String toString() {
		String str = "";
		
		str += "train №" + Integer.toString(number) + "\n";
		str += "to " + this.departurePoint + "\n";
		str += "departure time: " + Integer.toString(hours) + ":" 
		+ Integer.toString(minutes) + "\n";
		str += "number of seats: " + Integer.toString(numberOfSeats);
		
		return str;
	}
	
	private String departurePoint;
	private int number;
	private int hours;
	private int minutes;
	private int commonSeats;
	private int theCoupe;
	private int reservedSeat;
	private int luxSeats;
	private int numberOfSeats;
}
