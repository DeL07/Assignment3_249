
public class BidOrder extends Order implements IAnonymous, Comparable{

	public BidOrder(String iD, double price, int volume) {
		super(iD, price, volume);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toStringAnon() {
		return "Bid:	" + this.getPrice() + "	" + this.getVolume();
	}
	
	@Override
	public String FullDetails() {
		return "Bid:	" + this.getPrice() + "	" + this.getVolume() + "	" + this.getID();
	}
}
