package modelLayer;

public class Category {
	private static int idIterator;
	private int id;
	private String name;
	
	public Category(String name){
		idIterator++;
		this.name = name;
		this.id = idIterator;		
	}

	/**
	 * Get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
}
