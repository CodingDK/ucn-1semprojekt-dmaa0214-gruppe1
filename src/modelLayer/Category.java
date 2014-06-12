package modelLayer;

/**
 * Category holds information of a categories.
 * 
 * @author Group 1
 * @version 0.1
 */
public class Category {
	private static int idIterator;
	private int id;
	private String name;
	
	/**
	 * Constructor for Category objects.
	 * 
	 * @param name The name of the category.
	 */
	public Category(String name) {
		idIterator++;
		this.name = name;
		id = idIterator;
	}
	
	/**
	 * Get the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
