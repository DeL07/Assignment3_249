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

public class OrderBook {
	
	// arraylist
	// treelist (sorted collection)
	private TreeSet<BidOrder> bidBook = new TreeSet<BidOrder>();
	private TreeSet<OfferOrder> offerBook = new TreeSet<OfferOrder>();
//	for(Order o : orderBook){
//			
//		}
//	}
	public void outputBook() {
		
	}
		
	
	public void outputBBO() {
		
		System.out.println(bidBook.first());
		System.out.println(offerBook.first());
	}
	
}
