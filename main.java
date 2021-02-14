
/**
 * Mert Yakincan
 * 041901039
 * 01.11.2020
 * This code's purpose is drawing a projectile motion animation by taking angle from the user. 
 */

import java.util.Scanner;

public class Mert_Yakincan {

	public static void main(String[] args) {

		StdDraw.setCanvasSize(600, 600); // Setting the canvas size
		StdDraw.setXscale(0, 2); // Setting x scale of the canvas to 0 to 2. It's set to 2 because when it is set
									// to 1 animation can end up outside of the canvas.
		StdDraw.setYscale(0, 1); // Setting the y scale of the canvas.
		double circleRadius = 0.01; // Setting the radius for every circle used.

		Scanner input = new Scanner(System.in); // Taking user input for the angle which is a must for the formula for
												// projectile motion
		System.out.println("Please enter an angle: ");
		double angle = input.nextDouble();

		double v = 4.0; // Setting the constant velocity value for circles.
		double g = 9.81; // Gravity of earth.

		StdDraw.setPenColor(StdDraw.BLACK); // Setting the pen color to black which will be used for writing the angle
											// for the animation later on.
		StdDraw.textLeft(0.03, 0.96, "Angle: " + angle + " degrees."); // Printing the angle text on the top left of the
																		// canvas.

		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); // Setting the pen color to book light blue which is the main
														// color for circles.
		double t = 0.00; // Declaring a constant time for the circle which has (0,0) coordinates.
		double xCoor = v * Math.cos(Math.toRadians(angle)) * t; // Setting the x coordinate of the circle to 0.
		double yCoor = (v * Math.sin(Math.toRadians(angle)) * t) - (0.5 * g * t * t); // Setting the y coordinate of the
																						// circle to 0.
		StdDraw.filledCircle(xCoor, yCoor, circleRadius); // Drawing the circle at (0,0). This is a unique circle
															// outside of the main animation to prevent the problems for
															// finding the distance travelled.

		double deltaT = 0.01; // Setting the delta T variable for main animation loop which will increase by
								// 0.01 for every circle.

		while (true) { // A loop for animate all the circles.

			double x = v * Math.cos(Math.toRadians(angle)) * deltaT; // Setting the x coordinate.
			double y = (v * Math.sin(Math.toRadians(angle)) * deltaT) - (0.5 * g * deltaT * deltaT); // Setting the y
																										// coordinate.
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.filledCircle(x, y, circleRadius); // Drawing filled circle for every deltaT value.
			StdDraw.show();
			StdDraw.pause(300);
			deltaT += 0.01; // Increasing the value of deltaT by one after every circle drawn.
			if (y <= 0) { // An if statement which will determine when the y coordinate of the circle
							// falls down below 0.
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.textLeft(0.03, 0.92, "x: " + x + " km"); // Printing the distance traveled on the top left of
																	// the canvas.
				break; // Exit when the y coordinates reach 0.

			}
		}

	}

}
