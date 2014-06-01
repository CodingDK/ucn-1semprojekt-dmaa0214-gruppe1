package personLayer;

import java.util.ArrayList;

import modelLayer.Discount;

/**
 * Customer holds information for Customers.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Customer extends Person{
	protected double credit;
	protected ArrayList<Discount> discounts;
	
	/**
	 * @param name The name of the Customer.
     * @param phoneNr The phoneNr of the Customer.
     * @param street The Street of the Customer.
     * @param email The email of the Customer.
     * @param city The city of the Customer.
     * @param postCode The postCode of the Customer.
	 */
	public Customer(String name, String phoneNr, String street, String email, String city, String postCode){
		super(name, phoneNr, street, email, city, postCode);
		this.discounts = new ArrayList<Discount>();
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
	
	public String toString(){
		return super.toString();
	}
	
	public void addDiscount(Discount d){
		discounts.add(d);
	}
	
	public void removeDiscount(Discount d){
		discounts.remove(d);
	}
	
	public ArrayList<Discount> getDiscounts(){
		return discounts;
	}
}
