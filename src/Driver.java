import java.util.TreeSet;

//Matching engine - instructions collapsed
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


public class Driver {

	public static void main(String[] args) {

		
		OfferOrder o1 = new OfferOrder("Bob", 155.0, 300);
		OfferOrder o2 = new OfferOrder("Alice", 152.5, 120);
		OfferOrder o3 = new OfferOrder("Charlie", 152.0, 100);
		OfferOrder o4 = new OfferOrder("Billy", 146.6, 400);
		BidOrder b1 = new BidOrder("Nana", 148.0, 75);
		BidOrder b2 = new BidOrder("Lana", 147.0, 200);
		BidOrder b3 = new BidOrder("Jaba", 146.6, 100);
		BidOrder b4 = new BidOrder("Fana", 146.5, 50);
		
		OrderBook.addOffer(o1);
		OrderBook.addOffer(o2);
		OrderBook.addOffer(o3);
		OrderBook.addOffer(o4);
		
		OrderBook.addBid(b1);
		OrderBook.addBid(b2);
		OrderBook.addBid(b3);
		OrderBook.addBid(b4);
		
		System.out.println(OrderBook.offerBook.size());
		
		OrderBook.outputBook();
		System.out.println();
		OrderBook.outputBBO();
		
//		IAnonymous iO1 = (IAnonymous) o1;
//		iO1.toStringAnon();
	}

}
