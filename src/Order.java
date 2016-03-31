import java.util.Comparator;
import java.util.Date;

/*	Create a parent Order object that is not specifically a bid or offer but contains
	all the common members a bid and an offer would have. Then create a BidOrder
	object and an OfferOrder object, both which extend the parent offer object
	(depending on your design, they may not add any new instance variables but will allow
	you to tell the types of orders apart using instance of and/or getClass()). 
	
	An order of either type should have a string ID for the person submitting the order, a
	double price, and an int volume. They should have appropriate getters and setters
	for the variables, a toString method (which we will return to below when discussing
	the anonymous interface), and other standard methods. In this assignment, we will
	assume there is only one stock being traded and so we will not include it as a variable
	in any Order object */

public class Order implements Comparable, IAnonymous {

	private String ID;
	private double price;
	private int volume;
	Date dateCreated;

	public Order(String iD, double price, int volume) {
		super();
		ID = iD;
		this.price = price;
		this.volume = volume;
		dateCreated = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

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

	


//	@Override
//	public int compare(Object o1, Object o2) {
//		Order order1 = (Order) o1;
//		Order order2 = (Order) o2;
//		
//		return (int) (order1.getPrice() - order2.getPrice());
//	}

	//Equals for volume and id
	@Override
	public int compareTo(Object o) {
		Order order1 = (Order) o;
		if ((order1.getPrice() - this.price) < 0)
			return -1;
		if ((order1.getPrice() - this.price) > 0)
			return 1;
		return 0;
	}

	@Override
	public String toStringAnon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String FullDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
