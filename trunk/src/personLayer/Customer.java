package personLayer;

/**
 * Customer holds information for Customers.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Customer extends Person {
	private double credit;
	
	/**
	 * @param name The name of the Customer.
	 * @param phoneNr The phoneNr of the Customer.
	 * @param street The Street of the Customer.
	 * @param email The email of the Customer.
	 * @param city The city of the Customer.
	 * @param postCode The postCode of the Customer.
	 */
	public Customer(final String name, final String phoneNr, final String street, final String email, final String city, final String postCode) {
		super(name, phoneNr, street, email, city, postCode);
	}
	
	/**
	 * @return the credit
	 */
	public double getCredit() {
		return credit;
	}
	
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(final double credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
