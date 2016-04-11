import java.util.Comparator;
import java.util.Date;

public class Order implements Comparable, IAnonymous {

	private String ID;
	private double price;
	private int volume;
	Date dateCreated;

	public Order(String iD, double price, int volume) {
		super();
		ID = iD;
		this.price = price;
		this.volume = volume;
		dateCreated = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String toString() {
		return "OrderBook [ID=" + ID + ", price=" + price + ", volume=" + volume + "]";
	}

	// Equals for volume and id
	@Override
	public int compareTo(Object o) {
		Order order1 = (Order) o;
		if ((order1.getPrice() - this.price) < 0)
			return -1;
		else if ((order1.getPrice() - this.price) > 0)
			return 1;
		// if prices are equal
		else {
			if (order1.getDateCreated().before(this.getDateCreated())) {
				return -1;
			} else if (order1.getDateCreated().after(this.getDateCreated())) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String toStringAnon() {
		return null;
	}

	@Override
	public String FullDetails() {
		return null;
	}

}
