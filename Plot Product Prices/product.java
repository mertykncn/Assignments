/*11.11.2020
 * Mert Yakincan
 * 041901039
 */
public class product {

	public String name;
	public int price;

	product(String name) { //Constructor with an input String:name
		this.name = name; // Using this. to identify input
	}

	public String toString() { //toString method for printing the object
		return "Product: " + name + ", " + "Price: " + price;
	}

}
