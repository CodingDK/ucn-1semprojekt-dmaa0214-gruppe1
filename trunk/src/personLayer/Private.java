package personLayer;

public class Private extends Customer{
	private String cprNr, pictureID;
	
	public Private(String name, String phoneNr, String address, String email, String city, String postCode, String cprNr, String pictureID){
		super(name, phoneNr, address, email, city, postCode);
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
	
	

}