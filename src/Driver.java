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
	
			public static boolean priceCheck(Order o){
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
			
			public static int volCompare(Order o) {
				if (OrderBook.bidBook.isEmpty() | OrderBook.offerBook.isEmpty())
					return 2;
				else {
					if (OrderBook.offerBook.last().getVolume() > OrderBook.bidBook.first().getVolume()) {
						return 1;
					}
					if (OrderBook.offerBook.last().getVolume() < OrderBook.bidBook.first().getVolume()) {
						return -1;
					}	
				}
				return 0;

			}
	
	// Matching engine
			 public static void matching(Order o) {
				 if (o.getClass().equals(BidOrder.class)) {
					 System.out.println("\nMatching a new Offer Order:");
					 System.out.println(o.toStringAnon());
					 
					 if (OrderBook.offerBook.isEmpty()) {
						 System.out.println("There are no offers currently");
						 System.out.println("Bid has been set");
						 return;
					 }
				 }
				 
				 if (o.getClass().equals(OfferOrder.class)) {
					 System.out.println("\nMatching a new Offer Order:");
					 System.out.println(o.toStringAnon());
					 
					 if (OrderBook.bidBook.isEmpty()) {
						 System.out.println("There are no bids currently");
						 System.out.println("Offer has been set");
						 return;
					 }
					
					while (priceCheck(o)) {
						
						System.out.println("\nMatch found:");
						System.out.println(OrderBook.offerBook.last().FullDetails());
						System.out.println(OrderBook.bidBook.first().FullDetails());

						
						switch(volCompare(o)) {
							
						case 0: 
							OrderBook.offerBook.last().setVolume(0);
							OrderBook.bidBook.first().setVolume(0);
							OrderBook.offerBook.remove(OrderBook.offerBook.last());
							OrderBook.bidBook.remove(OrderBook.bidBook.first());
							break;
						
						case 1: 
							OrderBook.offerBook.last().setVolume(OrderBook.offerBook.last().getVolume()-OrderBook.bidBook.first().getVolume());
							OrderBook.bidBook.first().setVolume(0);
							OrderBook.bidBook.remove(OrderBook.bidBook.first());
							break;	
							
						case -1:
							OrderBook.bidBook.first().setVolume(OrderBook.bidBook.first().getVolume()-o.getVolume());
							OrderBook.offerBook.last().setVolume(0);
							OrderBook.offerBook.remove(OrderBook.offerBook.last());
							break;
						
						case 2:
							System.out.println("No bids left");
							break;
							
						default:
							break;
						}
						
					}
					 
				 }
			 }



	public static void main(String[] args) {
		
		Order o1 = new OfferOrder("Bob", 155.0, 50);
		Order o2 = new OfferOrder("Alice", 152.5, 120);
		Order o3 = new OfferOrder("Charlie", 152.0, 100);
		Order o4 = new OfferOrder("Billy", 142.6, 260);
		Order b1 = new BidOrder("Nana", 156.0, 2600);
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
		
		matching(o4);
		
		System.out.println();
		OrderBook.outputBook();
		System.out.println();
		OrderBook.outputBBO();
		
//		IAnonymous iO1 = (IAnonymous) o1;
//		iO1.toStringAnon();
	}

}
