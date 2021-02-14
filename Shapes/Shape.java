/*Mert Yakincan
041901039
08.12.2020
Lab7
Parent class of circle and rectangle classes.
 */

import java.awt.*;

public class Shape {
    protected double x;
    protected double y;
    protected Color color;

    Shape() {}


    public Shape(double x, double y, Color color) { //constructor
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getX() { // get method for x
        return x;
    }

    public void setX(double x) { // set method for x
        this.x = x;
    }

    public double getY() { // get method for y
        return y;
    }

    public void setY(double y) { // set method for y
        this.y = y;
    }

    public Color getColor() { // get method for color
        return color;
    }

    public void setColor(Color color) { //set method for color
        this.color = color;
    }
}
