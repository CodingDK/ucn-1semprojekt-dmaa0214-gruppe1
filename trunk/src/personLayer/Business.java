package personLayer;

public class Business extends Customer{
private String company, cvrNr;
	
	public Business(String name, String phoneNr, String address, String email, String city, String postCode, String company, String cvrNr){
		super(name, phoneNr, address, email, city, postCode);
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
	
	

}
