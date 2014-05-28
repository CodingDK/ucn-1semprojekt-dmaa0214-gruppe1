package personLayer;

public class Private extends Customer{
	private String cprNr, pictureID;
	
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
