package review;

import java.util.Scanner;

public class DayOfTheWeek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dayalyzer dayOfWeek;
		Scanner scanner = new Scanner(System.in);
		int day, month, year;
		
		
		System.out.println("Enter the day (1..31): ");
		day = scanner.nextInt();
		System.out.println("Enter the month (1..12): ");
		month = scanner.nextInt();
		System.out.println("Enter the year (1900..2100): ");
		year = scanner.nextInt();
		
		System.out.println (new Dayalyzer(day,month,year).analyze());
	}

}
