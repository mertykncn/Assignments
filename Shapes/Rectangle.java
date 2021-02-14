/*Mert Yakincan
041901039
08.12.2020
Lab7
This class is for Rectangle object
 */

import java.awt.*;

public class Rectangle extends Shape {
//data fields
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) { //constructor
        setX(x);
        setY(y);
        this.height = height;
        this.width = width;
    }
//setter and getter methods
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double computeArea() {
        return width * height;
    } //area method

    public void draw() { //Draw method prints the area of the rectangle at the center. Also draws a outline rectangle to make it look better.
        Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        if (computeArea() > 0.005) {
            StdDraw.filledRectangle(x, y, width / 2, height / 2);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.rectangle(x, y, width / 2, height / 2);
        }
        if (computeArea() > 0.005)
            StdDraw.text(x, y, String.format("%.2f", computeArea()));
    }
}
