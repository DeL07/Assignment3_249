

import java.util.TreeSet;

public class OrderBook implements IAnonymous{
	
	static TreeSet<BidOrder> bidBook = new TreeSet<BidOrder>();
	static TreeSet<OfferOrder> offerBook = new TreeSet<OfferOrder>();

	public static void addBid(Order o) {
		bidBook.add((BidOrder) o);
	}
	
	public static void addOffer(Order o) {
		offerBook.add((OfferOrder) o);
	}
	
	public static void outputBook() {
		System.out.println("Order book:");
		for (OfferOrder o: offerBook) {
			System.out.println(o.toStringAnon());
		}
		for (BidOrder o: bidBook) {
			System.out.println(o.toStringAnon());
		}
	}
		
	public static void outputBBO() {
		System.out.println("Best Bid & Offer:");
		if (offerBook.pollLast() == null)
			System.out.println("No offers in books");
		else
			System.out.println(offerBook.last().toStringAnon());
		if (bidBook.pollFirst() == null)
			System.out.println("No bids in books");
		else
			System.out.println(bidBook.first().toStringAnon());
	}
	
	public static void BestOffer() {
		OfferOrder BestOffer;
		BestOffer = offerBook.last();
	}
	
	public static double BestOfferPrice() {
		OfferOrder BestOffer;
		BestOffer = offerBook.pollLast();
		return BestOffer.getPrice();
	}
	
	public static int BestOfferVol() {
		OfferOrder BestOffer;
		BestOffer = offerBook.last();
		return BestOffer.getVolume();
	}
	
	public static String BestOfferID() {
		OfferOrder BestOffer;
		BestOffer = offerBook.last();
		return BestOffer.getID();
	}
	
	public static void BestBid() {
		BidOrder BestBid;
		BestBid = bidBook.first();
	}
	
	public static double BestBidPrice() {
		BidOrder BestBid;
		BestBid = bidBook.pollFirst();
		if (BestBid == null)
				return 0;
		return BestBid.getPrice();
	}
	
	public static int BestBidVol() {
		BidOrder BestBid;
		BestBid = bidBook.first();
		return BestBid.getVolume();
	}
	
	public static String BestBidID() {
		BidOrder BestBid;
		BestBid = bidBook.first();
		return BestBid.getID();
	}

	public String toStringAnon() {
		return null;
	}
	
	// Override for Full Details
	public String FullDetails(Order o) {
		if (this.getClass().equals(BidOrder.class)) {
			return "Bid:	" + BestBidPrice() + "	" + BestBidVol() + "	" + BestBidID();
		 }
		 
		 if (this.getClass().equals(OfferOrder.class)) {
			 return "Off:	" + BestOfferPrice() + "	" + BestOfferVol() + "	" + BestOfferID();
		 }
		 
		 return null;
	}
	
	public String FullDetails() {
		return null;
	}

	// Inner class for linked lists 
	// Conceptually, this is so a regular linked list interacts STRICTLY with
	// these node controllers. But since we are using treesets, there is no need to ensure the nodes
	// are properly linked between the data.
	// Furthermore, our pointers using treeset are the simply the first bid and last offer
	// As such:
	//	- BidBook.first() - Represents top bid (highest purchase price)
	//  - OfferBook.last() - Represents top offer (lowest offer price)
	
	public class Node{
		protected Node nextNode;
		protected Node prevNode;		
	}
	
}

