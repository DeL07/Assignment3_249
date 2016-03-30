import java.util.TreeSet;

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
		
//		OrderBook.offerBook.add(o1);
//		OrderBook.offerBook.add(o2);
//		OrderBook.offerBook.add(o3);
//		
//		OrderBook.bidBook.add(b1);
//		OrderBook.bidBook.add(b2);
//		OrderBook.bidBook.add(b3);
//		OrderBook.bidBook.add(b4);
		
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
