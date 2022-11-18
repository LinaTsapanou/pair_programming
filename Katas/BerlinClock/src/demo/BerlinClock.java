package demo;

import java.util.Scanner;

public class BerlinClock {

	public static String berlinClock(int hours, int minutes, int seconds) {
		return getSeconds(seconds) + " " + getHours(hours) + " " + getMinutes(minutes);
	}

	public static String getSeconds(int seconds) {

		String output = "O";
		if (seconds % 2 == 0) {
			output = "Y";
		}

		return output;
	}

	public static String getHours(int hours) {
		int numberTopHourLamps = hours / 5;
		int numberBottomHourLamps = hours % 5;

		StringBuilder sb = new StringBuilder();
		sb.append(getLampRow(4, numberTopHourLamps, "R")).append(" ").append(getLampRow(4, numberBottomHourLamps, "R"));

		return sb.toString();
	}

	public static String getMinutes(int minutes) {
		int numberTopMinutesLamps = minutes / 5;
		int numberBottomMinutesLamps = minutes % 5;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 11; i++) {

			String lamp = "O";
			if (i <= numberTopMinutesLamps) {
				if (i % 3 == 0) {
					lamp = "R";
				} else {
					lamp = "Y";
				}
			}

			sb.append(lamp);
		}

		sb.append(" ");
		sb.append(getLampRow(4, numberBottomMinutesLamps, "Y"));
		return sb.toString();
	}

	public static String getLampRow(int totalNumberLamps, int numberLampsOn, String lampSymbol) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= totalNumberLamps; i++) {

			String lamp = "O";
			if (i <= numberLampsOn) {
				lamp = lampSymbol;
			}

			sb.append(lamp);
		}

		return sb.toString();
	}

	
	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);

		System.out.println("Berlin Clock");

		System.out.println("Enter Hours:");
		int h = myObj.nextInt();

		System.out.println("Enter Minutes:");
		int m = myObj.nextInt();

		System.out.println("Enter Seconds:");
		int s = myObj.nextInt();

		System.out.println(berlinClock(h, m, s));

		myObj.close();
	}

}