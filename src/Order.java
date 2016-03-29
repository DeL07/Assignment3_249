/*	Create a parent Order object that is not specifically a bid or offer but contains
	all the common members a bid and an offer would have. Then create a BidOrder
	object and an OfferOrder object, both which extend the parent offer object
	(depending on your design, they may not add any new instance variables but will allow
	you to tell the types of orders apart using instance of and/or getClass()). An
	order of either type should have a string ID for the person submitting the order, a
	double price, and an int volume. They should have appropriate getters and setters
	for the variables, a toString method (which we will return to below when discussing
	the anonymous interface), and other standard methods. In this assignment, we will
	assume there is only one stock being traded and so we will not include it as a variable
	in any Order object */

public class Order {

	private String ID;
	private double price;
	private int volume;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// Must interact with anonymous class
	public String toString() {
		return "OrderBook [ID=" + ID + ", price=" + price + ", volume=" + volume + "]";
	}
}
