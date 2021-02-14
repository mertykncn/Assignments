/*Mert Yakincan
041901039
08.12.2020
Lab7
This code will draw randomly generated shapes.
 */


import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {

        //Setting the canvas size and also x, y scales.
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);


        Random random = new Random(); // Creating a random generator.

        //Probability values for creating shapes.
        double circleProb = 0.8;
        double RectangleProb = 0.2;

        int n = 50;
        //object arrays for storing the objects.
        Circle[] CircleArray = new Circle[n];
        Rectangle[] RectArray = new Rectangle[n];


        for (int i = 0; i < n; i++) { // Creating the circles adding them in an array then drawing circles.
            if (random.nextDouble() < circleProb) {
                Circle a = new Circle(random.nextDouble(), random.nextDouble(), random.nextDouble() / 10);
                CircleArray[i] = a;
                CircleArray[i].draw();
            }
        }

        for (int i = 0; i < n; i++) {  // Creating the rectangles adding them in an array then drawing rectangles.
            if (random.nextDouble() < RectangleProb) {
                Rectangle b = new Rectangle(random.nextDouble(), random.nextDouble(), random.nextDouble() * 0.2, random.nextDouble() * 0.2);
                RectArray[i] = b;
                RectArray[i].draw();
            }
        }
    }
}
