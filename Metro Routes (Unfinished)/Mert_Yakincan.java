/*Mert Yakincan
 * 041901039
 * 17.11.2020
 * This code creates metro lines and navigates the user through the stations that user chooses.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mert_Yakincan {

	public static void main(String[] args) throws FileNotFoundException {

		StdDraw.setCanvasSize(1920, 1080); // Setting the canvas size to a higher values to get the every station.
		StdDraw.setXscale(-100, 1300); // x and y scales to get every station.
		StdDraw.setYscale(-100, 1300);
		double radius = 7.5; // Setting the circles radius.

		/*
		 * This block creates 4 different ArrayList for the lines, stations and x-y
		 * coordinates.
		 */
		ArrayList<String> metroLines = new ArrayList<>();
		ArrayList<String> metroStations = new ArrayList<>();
		ArrayList<Integer> xCoordinates = new ArrayList<>();
		ArrayList<Integer> yCoordinates = new ArrayList<>();

		/*
		 * This block reads the given txt file and if that files does not exists gives a
		 * message and exits from the program.
		 */
		String fileName = "metro.txt";
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println(fileName + " can not be found.");
			System.exit(1);
		}
		/*
		 * This block scans the input file while the file has next line and split the
		 * txt to the parts by the ";" and put every part to different arrays. Later on
		 * this arrays puts into the ArrayList that has been created before.
		 */
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] parts = line.split(";");

			String lineparts = parts[0];
			String stationparts = parts[1];
			int x = Integer.parseInt(parts[2]);
			int y = Integer.parseInt(parts[3]);

			metroLines.add(lineparts);
			metroStations.add(stationparts);
			xCoordinates.add(x);
			yCoordinates.add(y);

		}
		/*
		 * This whole block is for drawing the metro Stations by using their metro lines
		 * to set their colors different.
		 */
		// M4 LINE STATIONS
		for (int i = 0; i < 8; i++) {
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.filledCircle(xCoordinates.get(i), yCoordinates.get(i), radius);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(xCoordinates.get(i), yCoordinates.get(i) + 10, metroStations.get(i));
		}

		for (int i = 1; i < 8; i++) {
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.line(xCoordinates.get(i - 1), yCoordinates.get(i - 1), xCoordinates.get(i), yCoordinates.get(i));
		}

		// MARMARAY LINE STATIONS
		for (int i = 8; i < 24; i++) {
			StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			StdDraw.filledCircle(xCoordinates.get(i), yCoordinates.get(i), radius);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(xCoordinates.get(i), yCoordinates.get(i) + 10, metroStations.get(i));
		}
		for (int i = 9; i < 24; i++) {
			StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			StdDraw.line(xCoordinates.get(i - 1), yCoordinates.get(i - 1), xCoordinates.get(i), yCoordinates.get(i));
		}
		// M5 LINE STATIONS
		for (int i = 24; i < 33; i++) {
			StdDraw.setPenColor(StdDraw.MAGENTA);
			StdDraw.filledCircle(xCoordinates.get(i), yCoordinates.get(i), radius);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(xCoordinates.get(i), yCoordinates.get(i) + 10, metroStations.get(i));
		}
		for (int i = 25; i < 33; i++) {
			StdDraw.setPenColor(StdDraw.MAGENTA);
			StdDraw.line(xCoordinates.get(i - 1), yCoordinates.get(i - 1), xCoordinates.get(i), yCoordinates.get(i));
		}
		// M1 LINE STATIONS
		for (int i = 33; i < 48; i++) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(xCoordinates.get(i), yCoordinates.get(i), radius);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(xCoordinates.get(i), yCoordinates.get(i) + 10, metroStations.get(i));
		}
		for (int i = 34; i < 48; i++) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(xCoordinates.get(i - 1), yCoordinates.get(i - 1), xCoordinates.get(i), yCoordinates.get(i));
		}
		// M2 LINE STATIONS
		for (int i = 48; i < 63; i++) {
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(xCoordinates.get(i), yCoordinates.get(i), radius);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(xCoordinates.get(i), yCoordinates.get(i) + 10, metroStations.get(i));
		}
		for (int i = 49; i < 63; i++) {
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.line(xCoordinates.get(i - 1), yCoordinates.get(i - 1), xCoordinates.get(i), yCoordinates.get(i));
		}
		/*
		 * Taking user input for the starting destination. Then comparing the input with
		 * the main ArrayList if they are same adding the new input to a new
		 * list(startingLines).
		 */
		System.out.print("Enter starting station: ");
		Scanner scan = new Scanner(System.in);
		String start = scan.next();
		ArrayList<String> startingLines = new ArrayList<>();
		for (int i = 0; i < metroLines.size(); i++) {
			if (start.contains(metroStations.get(i)))
				startingLines.add(metroLines.get(i));

		}
		/*
		 * Taking user input for the final destination. Then comparing the input with
		 * the main ArrayList if they are same adding the new input to a new
		 * list(finishLines).
		 */
		System.out.print("Enter destination station: ");
		String finish = scan.next();
		ArrayList<String> finishLines = new ArrayList<>();
		for (int i = 0; i < metroLines.size(); i++) {
			if (finish.contains(metroStations.get(i)))
				finishLines.add(metroLines.get(i));

		}
		// Printing the destination.
		System.out.println();
		System.out.println("Start: " + start + "  Metrolines: " + startingLines);
		System.out.println("Destination: " + finish + "  Metrolines: " + finishLines);

		/*
		 * This part scans through the starting and final lines and checks if they
		 * match. Then adds the same line to a new ArrayList named sameLine and prints
		 * ArrayList.
		 */
		ArrayList<String> sameLine = new ArrayList<>();
		for (int i = 0; i < startingLines.size(); i++) {
			if (finishLines.contains(startingLines.get(i))) {
				sameLine.add(startingLines.get(i));
				System.out.println("Metro line: " + sameLine);
			} else
				System.out.println(start + " and " + finish + " are not on the same line!");
		}
		/*
		 * In this part I tried to loop through the ArrayLists by comparing the indexOf
		 * the start and finish lines to go forward in the ArrayList or the backwards.
		 * But couldn't implemented it right.
		 */
		System.out.println();
		// System.out.println(metroStations.indexOf(start));
		while (sameLine.contains(metroLines)) {
			if (metroStations.indexOf(start) > metroStations.indexOf(finish)) {
				for (int i = metroStations.indexOf(start); i > 0; i--) {
					System.out.println(metroStations.get(i));
					if (metroStations.get(i) == finish)
						break;

					else if (metroStations.indexOf(finish) > metroStations.indexOf(start)) {
						for (int j = metroStations.indexOf(finish); j > metroLines.size(); j++) {
							System.out.println(metroStations.get(j));
							if (metroStations.get(j) == start)
								break;

						}

					}

				}
			}
		}

	}

}
