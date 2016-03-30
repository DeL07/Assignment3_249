import java.util.Comparator;

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

	public Order(String iD, double price, int volume) {
		super();
		ID = iD;
		this.price = price;
		this.volume = volume;
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

	// Matching engine - instructions collapsed
	/* @formatter:off 
	 * 
	The matching engine should take a BidOrder or OfferOrder object, attempt to
	match it to the orders in the book and report on any resulting trades.
	Consider a OfferOrder (the BidOrder case is similar). The matching algorithm will
	go through the following steps:
		I. Is the offer price lower than the BestBid? Yes.
			A. Match the order to the best bid, the second best bid, etc. until:
				1. The full volume of the OfferOrder has been satisfied. The last bid to match to
					the offer may still exist in the book but with a lower volume.
				2. No bids are left in the book. In this case, leave the remaining volume of the
					order as a new (best) offer.
				3. All the bids that are left in the book have a lower price than the offer. In this
					case, leave the remaining volume of the order as a new (best) offer.
			B. For each matched order, report the trade (including identities of the buyers and
				seller).
			C. Update the BestBid
		II. Is the offer price lower than the BestBid? No, or there are no bids in the book yet.
			A. Is the offer price lower than the BestOffer? Yes.
				1. Set the offer as the new BestOffer.
			B. Is the offer price lower than the BestOffer? No it is equal.
				1. For two (or more) offers at the same price, the order that comes first gets first
					priority. This means placing new orders closer to the outside of the book
					(further from the best bid/offer).
			C. Is the offer price lower than the BestOffer? No it is greater.
				1. Find the right place in the book for insertion.
			D. Is the offer price lower than the BestBid? No, there are no bids in the book yet. 
				1. Set the offer as the new BestOffer. @formatter:on */

	public static void main(String[] args) {

	}


//	@Override
//	public int compare(Object o1, Object o2) {
//		Order order1 = (Order) o1;
//		Order order2 = (Order) o2;
//		
//		return (int) (order1.getPrice() - order2.getPrice());
//	}

	@Override
	public int compareTo(Object o) {
		Order order1 = (Order) o;
		return (int) (order1.getPrice() - this.price);
	}

	@Override
	public String toStringAnon() {
		// TODO Auto-generated method stub
		return null;
	}

}
