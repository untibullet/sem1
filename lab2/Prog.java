package lab2;

import lab2.Train;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Prog {

	public static void main(String[] args) {
		int countOfTrains;
		System.out.println("Enter a count of trains:");
		Scanner scanner = new Scanner(System.in);
		countOfTrains = Integer.valueOf(scanner.nextLine());
		
		Train[] trains = new Train[countOfTrains];
		
		createTrains(countOfTrains, trains);
		
		List<Train> _trains = new ArrayList<Train>();
		for (int i = 0; i < trains.length; i++) {
			_trains.add(trains[i]);
		}
		
		List<Train> container = new ArrayList<Train>();
		
		container.addAll(_trains);
		doA(container, scanner);
		
		container.clear();
		container.addAll(_trains);
		doB(container, scanner);
		
		container.clear();
		container.addAll(_trains);
		doC(container, scanner);
	}
	
	public static void createTrains(int countOfTrains, Train[] trains) {
		 Scanner scanner = new Scanner(System.in);
		 for (int i = 0; i < countOfTrains; i++) {
			 trains[i] = new Train();
			 System.out.println();
			 System.out.println("Enter parameters of train №" + i);
			 System.out.print("Enter a departure point >> ");
			 trains[i].setDeparturePoint(scanner.nextLine());
			 System.out.print("Enter a number >> ");
			 trains[i].setNumber(Integer.valueOf(scanner.nextLine()));
			 System.out.print("Enter a hour >> ");
			 trains[i].setHours(Integer.valueOf(scanner.nextLine()));
			 System.out.print("Enter a minutes >> ");
			 trains[i].setMinutes(Integer.valueOf(scanner.nextLine()));
			 System.out.print("Enter a count of common seats >> ");
			 trains[i].setNumberOfSeatsByType(Integer.valueOf(scanner.nextLine()), 0);
			 System.out.print("Enter a count of coupe >> ");
			 trains[i].setNumberOfSeatsByType(Integer.valueOf(scanner.nextLine()), 1);
			 System.out.print("Enter a count of reserved seat >> ");
			 trains[i].setNumberOfSeatsByType(Integer.valueOf(scanner.nextLine()), 2);
			 System.out.print("Enter a count of lux >> ");
			 trains[i].setNumberOfSeatsByType(Integer.valueOf(scanner.nextLine()), 3);
			 trains[i].updateSeats();
		 }
	}
	
	public static void giveInfo(List<Train> trains) {
		for (Train train : trains) {
			System.out.println(train);
		}
	}
	
	public static void filterByDeparturePoint(List<Train> trains, String point) {
		int maxCountElements = trains.size();
		int i = 0;
		while (i < maxCountElements) {
			if (!trains.get(i).getDeparturePoint().equalsIgnoreCase(point)) {
				trains.remove(i);
				i--;
				maxCountElements--;
			}
			i++;
		}
	}
	
	public static void filterByDepartureTime(List<Train> trains, int hours, int minutes) {
		int mTime = hours * 60 + minutes;
		
		int maxCountElements = trains.size();
		int i = 0;
		Train train;
		int tMTime;
		while (i < maxCountElements) {
			train = trains.get(i);
			tMTime = train.getHours() * 60 + train.getMinutes();
			if (tMTime < mTime) {
				trains.remove(i);
				i--;
				maxCountElements--;
			}
			i++;
		}
	}
	
	public static void filterByCommonSeats(List<Train> trains) {
		int maxCountElements = trains.size();
		int i = 0;
		Train train;
		while (i < maxCountElements) {
			train = trains.get(i);
			if (train.getNumberOfSeatsByType(0) <= 0) {
				trains.remove(i);
				i--;
				maxCountElements--;
			}
			i++;
		}
	}
	
	public static void doA(List<Train> trains, Scanner scanner) {
		String filter;

		System.out.println();
		System.out.print("a) Enter a departure point by which you want to filter: ");
		filter = scanner.nextLine();
		
		filterByDeparturePoint(trains, filter);
		
		if (trains.isEmpty()) {
			System.out.println("Empty");
			return;
		}
		
		giveInfo(trains);
	}
	
	public static void doB(List<Train> trains, Scanner scanner) {
		String pointFilter;
		int hoursFilter, minutesFilter;

		System.out.println();
		System.out.println("b) Enter a departure point by which you want to filter");
		pointFilter = scanner.nextLine();
		
		System.out.print("Enter a departure hours: ");
		hoursFilter = Integer.valueOf(scanner.nextLine());
		
		System.out.print("Enter a departure minutes: ");
		minutesFilter = Integer.valueOf(scanner.nextLine());
		
		filterByDeparturePoint(trains, pointFilter);
		filterByDepartureTime(trains, hoursFilter, minutesFilter);
		
		if (trains.isEmpty()) {
			System.out.println("Empty");
			return;
		}
		
		giveInfo(trains);
	}
	
	public static void doC(List<Train> trains, Scanner scanner) {
		String pointFilter;
		
		System.out.println();
		System.out.println("c) Enter a departure point by which you want to filter");
		pointFilter = scanner.nextLine();
		
		filterByDeparturePoint(trains, pointFilter);
		filterByCommonSeats(trains);
		
		if (trains.isEmpty()) {
			System.out.println("Empty");
			return;
		}
		
		giveInfo(trains);
	}
}
