import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) {
		TreeSet<Order> order1 = new TreeSet<Order>();
		Order o1 = new Order("a", 170, 100);
		Order o2 = new Order("b", 153, 50);
		Order o3 = new Order("c", 178, 150);
		
		order1.add(o1);
		order1.add(o2);
		order1.add(o3);
		
		for(Order o: order1){
			System.out.println(o.toString());
		}
		
		IAnonymous iO1 = (IAnonymous) o1;
		iO1.toStringAnon();
	}

}
