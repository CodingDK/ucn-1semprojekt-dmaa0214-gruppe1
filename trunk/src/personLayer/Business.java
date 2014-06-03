package personLayer;

/**
 * Business holds information for business customers.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Business extends Customer {
	private String company, cvrNr;
	
	/**
	 * Constructor for Business objects.
	 * 
	 * @param name The name of the Business.
	 * @param phoneNr The phoneNr of the Business.
	 * @param street The Street of the Business.
	 * @param email The email of the Business.
	 * @param city The city of the Business.
	 * @param postCode The postCode of the Business.
	 * @param company The name of the company.
	 * @param cvrNr The cvrNr of the Business.
	 */
	public Business(final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final String company, final String cvrNr) {
		super(name, phoneNr, street, email, city, postCode);
		this.company = company;
		this.cvrNr = cvrNr;
	}
	
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * @return the cvrNr
	 */
	public String getCvrNr() {
		return cvrNr;
	}
	
	/**
	 * @param company the company to set
	 */
	public void setCompany(final String company) {
		this.company = company;
	}
	
	/**
	 * @param cvrNr the cvrNr to set
	 */
	public void setCvrNr(final String cvrNr) {
		this.cvrNr = cvrNr;
	}
	
	/**
	 * @return superclass tostring and the name of the company.
	 */
	@Override
	public String toString() {
		return super.toString() + " Virksomhed: " + company;
	}
	
}
