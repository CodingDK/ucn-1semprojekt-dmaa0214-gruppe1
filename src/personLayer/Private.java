package personLayer;

/**
 * Private holds information for private customers.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Private extends Customer{
	@SuppressWarnings("unused")
	private String cprNr, pictureID;
	
	/**
	 * Constructor for Private objects.
     * @param name The name of the privateCustomer.
     * @param phoneNr The phoneNr of the privateCustomer.
     * @param street The street of the privateCustomer.
     * @param email The email of the privateCustomer.
     * @param city The city of the privateCustomer.
     * @param postCode The postCode of the privateCustomer.
	 * @param cprNr The cprNr of the privateCustomer.
	 * @param pictureID The pictureID of the privateCustomer.
	 */
	public Private(String name, String phoneNr, String street, String email, String city, String postCode, String cprNr, String pictureID){
		super(name, phoneNr, street, email, city, postCode);
		this.cprNr = cprNr;
		this.pictureID = pictureID;
	}

	/**
	 * @param cprNr the cprNr to set
	 */
	public void setCprNr(String cprNr) {
		this.cprNr = cprNr;
	}

	/**
	 * @param pictureID the pictureID to set
	 */
	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}
	
	public String toString(){
		return super.toString() + " Navn: " + name;
	}

}
