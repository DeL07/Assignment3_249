
public interface IAnonymous {
	// Does 2 things: (1) advises toString() should never print name in the
	// orders and (2) it requires a second method, printFullDetails() be
	// implemented, that will print out the name along with the other details
	public String toStringAnon();
	
	public String FullDetails();
}
