
public class OfferOrder extends Order implements IAnonymous, Comparable{

	public OfferOrder(String iD, double price, int volume) {
		super(iD, price, volume);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toStringAnon() {
		return "Off:	" + this.getPrice() + "	" + this.getVolume();
	}

}
