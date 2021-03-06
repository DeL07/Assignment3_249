public class OfferOrder extends Order implements IAnonymous, Comparable{

	public OfferOrder(String iD, double price, int volume) {
		super(iD, price, volume);
	}

	@Override
	public String toStringAnon() {
		return "Off:	" + this.getPrice() + "	" + this.getVolume();
	}

	@Override
	public String FullDetails() {
		return "Off:	" + this.getPrice() + "	" + this.getVolume() + "	" + this.getID();
	}
	
}
