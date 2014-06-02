package personLayer;
/**
 * Person holds information for persons in the system.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Person {
	private static int idIterator;
	protected int id;
	protected String name, phoneNr, street, email, city, postCode;
	
	/**
	 * Constructor for person objects.
	 * @param name The name of the person.
     * @param phoneNr The phoneNr of the person.
     * @param street The Street of the person.
     * @param email The email of the person.
     * @param city The city of the person.
     * @param postCode The postCode of the person.
	 */
	public Person(String name, String phoneNr, String street, String email, String city, String postCode){
		idIterator++;
		this.id = idIterator;
		this.name = name;
		this.phoneNr = phoneNr;
		this.street = street;
		this.email = email;
		this.city = city;
		this.postCode = postCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNr
	 */
	public String getPhoneNr() {
		return phoneNr;
	}

	/**
	 * @param phoneNr the phoneNr to set
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return id of the person.
	 */
	public String toString(){
		return "#"+id + " ";
	}

}
