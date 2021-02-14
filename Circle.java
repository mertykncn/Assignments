/*Mert Yakincan
041901039
08.12.2020
Lab7
This code will draw randomly generated shapes.
 */

import java.awt.*;

public class Circle extends Shape {

    private double radius;

     public Circle(double x, double y, double radius ) { // constructor
         setX(x);
         setY(y);
         this.radius = radius;
     }

    public double computeArea() { //area

         return radius * radius * 3.1415;
    }
//set and get method
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw() {//Draw method prints the area of the circle at the center. Also draws a outline circle to make it look better.
         Font font = new Font("Arial", Font.BOLD, 20);
         StdDraw.setFont(font);
         StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        if (computeArea() > 0.005) {
         StdDraw.filledCircle(x, y, radius);
         StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(x, y, radius); }
        if (computeArea() > 0.005)
         StdDraw.text(x, y, String.format("%.2f", computeArea()));

    }
}
