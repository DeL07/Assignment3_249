import java.util.TreeSet;

/* @formatter:off
 * 	Create an OrderBook object as a linked data structure. Specifically, it
	should be a doubly linked list where unmatched Order objects can be inserted, and
	the list is always sorted from largest price to smallest price. The nodes of the list should
	be implemented as an inner class within the order book object. Because of the way
	orders are matched, the resulting list will always have all the offers at the start of the list
	and then all the bids being at the end of the list.
	
	While every order in the book is important, two orders of particular importance. They
	are called the best bid and best offer. The best bid is the bid with the largest price and
	the best offer is the offer with the lowest price. These two orders will be beside each
	other, somewhere in the middle of the order book. The difference in price between the
	best bid and best order is called the spread. For the doubly linked list in the
	OrderBook object, always maintain a pointer to the BestBid node and the
	BestOffer node. This data structure will allow you to jump directly to either the best
	bid or the best offer and walk through the book in either direction.
	
	Additionally, your OrderBook object should implement the following methods:
		• public void outputBook(): print out the OrderBook (note interface requirements below)
		• public void outputBBO(): print out the best bid and offer (BBO) @formatter:on*/

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
		System.out.println("Order book");
		for (OfferOrder o: offerBook) {
			System.out.println(o.toStringAnon());
		}
		for (BidOrder o: bidBook) {
			System.out.println(o.toStringAnon());
		}
	}
		
	public static void outputBBO() {
		System.out.println(offerBook.last().toStringAnon());
		System.out.println(bidBook.first().toStringAnon());
	}
	
	// Inner class with nodes using ^^ those methods and assigning them?
	
	//Add spread and more functionality for use in matching engine
	
	public static void BestOffer() {
		OfferOrder BestOffer;
		BestOffer = offerBook.last();
	}
	
	public static double BestOfferPrice() {
		OfferOrder BestOffer;
		BestOffer = offerBook.last();
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
		BestBid = bidBook.first();
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

	@Override
	public String toStringAnon() {
	
		return null;
	}

	@Override
	public String FullDetails(Order o) {
		if (this.getClass().equals("BidOrder")) {
			return "Bid:	" + BestBidPrice() + "	" + BestBidVol() + "	" + BestBidID();
		 }
		 
		 if (this.getClass().equals("OfferOrder")) {
			 return "Off:	" + BestOfferPrice() + "	" + BestOfferVol() + "	" + BestOfferID();
		 }
		 
		 return "Clearly you fucked up";
	}
	
}

