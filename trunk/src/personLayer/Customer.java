package personLayer;

public class Customer extends Person{
	protected double credit;
	
	public Customer(String name, String phoneNr, String address, String email, String city, String postCode){
		super(name, phoneNr, address, email, city, postCode);
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
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
}
