//=====================================================================================================
// Assignment 3: Part 1
// Authors: Mylène Haurie (ID: 26767893) & Louis-Simon Carle (ID: 26677266)
// 
// - Program emulates the Order book of a financial market with Bid and Offer objects 
// 	 maintained in their respective sorted lists (using TreeSet) from largest to smallest price.
//   If prices are equal, it sorts it by FIFO.
// - Attached to the order objects are price, volume and name which interact with the 
//   IAnonymous interface depending on the situation. (Names reported upon successful trade)
// - Driver revolves around the matching engine which attempts to match the BBO
//   when the best offer price is less than or equal to the best bid price**.
//   It then compares the volumes of BBO to determine appropriate calculations
//   and volume actions and loops until the best offer price is greater than the best bid price.
//======================================================================================================

import java.util.TreeSet;

public class Driver {
	
	// Matching engine calls priceCheck, verifies if there are entries in the orderbooks
	// Then verifies purchase condition (Best Offer price is less than or equal to Best Bid price)
	// True means the best offer price is LOWER or EQUAL to the best bid price
	// False means the best offer price is HIGHER than the best bid price
	public static boolean priceCheck(Order o) {
		if (o.getClass().equals(OfferOrder.class)) {
			if (OrderBook.bidBook.isEmpty() | OrderBook.offerBook.isEmpty())
				return false;
			if (OrderBook.offerBook.last().getPrice() <= OrderBook.bidBook.first().getPrice())
				return true;
			else
				return false;
		}
		if (o.getClass().equals(BidOrder.class)) {
			if (OrderBook.bidBook.isEmpty() | OrderBook.offerBook.isEmpty())
				return false;
			if (OrderBook.bidBook.first().getPrice() >= OrderBook.offerBook.last().getPrice())
				return true;
			else
				return false;
		}
		return false;
	}
			
	// Checks best offer volume against best bid volume to determine correct course of action
	public static int volCompare(Order o) {
		if (OrderBook.bidBook.isEmpty() | OrderBook.offerBook.isEmpty())
			return 2;
		else {
			// Volume of best offer is greater than volume of best bid
			if (OrderBook.offerBook.last().getVolume() > OrderBook.bidBook.first().getVolume()) {
				return 1;
			}
			// Volume of best bid is greater than volume of best offer
			if (OrderBook.offerBook.last().getVolume() < OrderBook.bidBook.first().getVolume()) {
				return -1;
			}
		}
		return 0;

	}
	
	// Matching engine
	// 1- Checks order type (Bid or Offer)
	// 2- Checks if Bidbook/Offerbook is empty
	// 		- If empty, displays message and breaks from the method
	// 3- PriceCheck method is called in while loop
	// 		- If true (meaning there are orders that can be matched)
	//			- Loops until there are no more matching orders
	// 			- While looping, checks volume condition on every run so appropriate calculations are done
	//			- Appropriate changes are completed based on remaining volume
	public static void matching(Order o) {
		// Order type check = BidOrder
		if (o.getClass().equals(BidOrder.class)) {
			System.out.println("\nMatching a new Bid Order:");
			System.out.println(o.toStringAnon());

			if (OrderBook.offerBook.isEmpty()) {
				System.out.println("There are no offers currently");
				System.out.println("Bid has been set");
				return;
			}
		}
		// Order type check = OfferOrder
		if (o.getClass().equals(OfferOrder.class)) {
			System.out.println("\nMatching a new Offer Order:");
			System.out.println(o.toStringAnon());

			if (OrderBook.bidBook.isEmpty()) {
				System.out.println("There are no bids currently");
				System.out.println("Offer has been set");
				return;
			}
		}
		// Loop for matching orders
		while (priceCheck(o)) {

			System.out.println("\nMatch found:");
			System.out.println(OrderBook.offerBook.last().FullDetails());
			System.out.println(OrderBook.bidBook.first().FullDetails());

			// Switch for conditional volume operations
			switch (volCompare(o)) {

			// When volume is the same for both offers, sets volume for both
			// orders to zero and removes them
			case 0:
				OrderBook.offerBook.last().setVolume(0);
				OrderBook.bidBook.first().setVolume(0);
				OrderBook.offerBook.remove(OrderBook.offerBook.last());
				OrderBook.bidBook.remove(OrderBook.bidBook.first());
				break;
			// When volume of offer is greater than volume of bid
			// Set offer volume = offer volume - bid volume
			// Remove bid
			case 1:
				OrderBook.offerBook.last()
						.setVolume(OrderBook.offerBook.last().getVolume() - OrderBook.bidBook.first().getVolume());
				OrderBook.bidBook.first().setVolume(0);
				OrderBook.bidBook.remove(OrderBook.bidBook.first());
				break;
			// When volume of bid is greater than volume of offer
			// Set bid volume = bid volume - offer volume
			// Remove offer
			case -1:
				OrderBook.bidBook.first()
						.setVolume(OrderBook.bidBook.first().getVolume() - OrderBook.offerBook.last().getVolume());
				OrderBook.offerBook.last().setVolume(0);
				OrderBook.offerBook.remove(OrderBook.offerBook.last());
				break;
			// Break for when there are no more bids left to avoid null pointer
			// exception
			case 2:
				
				System.out.println("No order left");
				break;

			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		Order o1 = new OfferOrder("Bob", 155.0, 5);
		Order o2 = new OfferOrder("Alice", 152.5, 12);
		Order o3 = new OfferOrder("Charlie", 152.0, 10);
		Order o4 = new OfferOrder("Billy", 142.6, 2500);
		Order b1 = new BidOrder("Nana", 156.0, 26);
		Order b2 = new BidOrder("Lana", 145.0, 20);
		Order b3 = new BidOrder("Jaba", 146.6, 10);
		Order b4 = new BidOrder("Fana", 146.5, 50);
		
		OrderBook.addOffer(o1);
		OrderBook.addOffer(o2);
		OrderBook.addOffer(o3);
		OrderBook.addOffer(o4);
		
		OrderBook.addBid(b1);
		OrderBook.addBid(b2);
		OrderBook.addBid(b3);
		OrderBook.addBid(b4);
		
		Order b5 = new OfferOrder("Chuky", 146.9, 100);
		
		OrderBook.addOffer(b5);
		
		System.out.println();
		OrderBook.outputBook();
		
		matching(o1);
		
		System.out.println();
		OrderBook.outputBook();
		System.out.println();
		OrderBook.outputBBO();
		
	}

}
