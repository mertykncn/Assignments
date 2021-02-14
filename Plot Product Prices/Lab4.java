/*11.11.2020
 * Mert Yakincan
 * 041901039
 * 
 */

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> productNames = new ArrayList<>(); // An arraylist for storing the product names.
		ArrayList<Integer> productPrices = new ArrayList<>(); // An arraylist for storing the prices of the products.

		String filename = "products.txt";
		File file = new File(filename);
		if (!file.exists()) { // Checking if the file exists.
			System.out.println(filename + " can not be found!");
			System.exit(1);

		}
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) { // While file has next line storing string items and integer items every time.
			String name = input.next();
			int price = input.nextInt();
			productNames.add(name);
			productPrices.add(price);
		}
		// System.out.println(productNames);
		/*
		 * This block of code creates an object Objects gets their product name from the
		 * productNames ArrayList Objects gets their prices from the productPrices
		 * ArraList And prints the objects with the help of toString method
		 */
		product Dutti = new product(productNames.get(0));
		Dutti.price = productPrices.get(0);
		System.out.println(Dutti);

		product Nike = new product(productNames.get(1));
		Nike.price = productPrices.get(1);
		System.out.println(Nike);

		product Adidas = new product(productNames.get(2));
		Adidas.price = productPrices.get(2);
		System.out.println(Adidas);

		product Tanca = new product(productNames.get(3));
		Tanca.price = productPrices.get(3);
		System.out.println(Tanca);

		product Inci = new product(productNames.get(4));
		Inci.price = productPrices.get(4);
		System.out.println(Inci);

		product Camper = new product(productNames.get(5));
		Camper.price = productPrices.get(5);
		System.out.println(Camper);

		product Vans = new product(productNames.get(6));
		Vans.price = productPrices.get(6);
		System.out.println(Vans);

		product Puma = new product(productNames.get(7));
		Puma.price = productPrices.get(7);
		System.out.println(Puma);

		product Nike2 = new product(productNames.get(8));
		Nike2.price = productPrices.get(8);
		System.out.println(Nike2);

		// set the size of the drawing canvas
		int canvas_width = 800;
		int canvas_height = 800;
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		// set the scale of the coordinate system
		StdDraw.setXscale(0, 1); // x axis scale is in the range [0, 1]
		StdDraw.setYscale(0, 1); // y axis scale is in the range [0, 1]

		// bar chart parameters
		double halfWidth = 0.035; // fixed half width for each bar (set manually)
		double xPosition = 0.08; // centerX position for the first bar (set manually)
		double xStep = 3 * halfWidth; // distance between centers of two adjacent bars
		double yScale = 1.0 / canvas_height; // to scale price values to the range [0, 1]

		// draw a bar for each product using a for loop
		for (int i = 0; i < productPrices.size(); i++) {
			// drawing bars as filled rectangles
			double centerX = xPosition;
			double halfHeight = yScale * productPrices.get(i) / 2; // half height based on price
			double centerY = halfHeight;
			StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			StdDraw.filledRectangle(centerX, centerY, halfWidth, halfHeight);
			// displaying product names above bars
			StdDraw.setPenColor(StdDraw.BLACK);
			Font font = new Font("Arial", Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(centerX, centerY + halfHeight + 0.01, productNames.get(i));
			// updating xPosition for drawing the next bar
			xPosition += xStep;
		}

	}
}
