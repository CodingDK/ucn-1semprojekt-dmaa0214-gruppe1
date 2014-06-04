package modelLayer;

import java.util.ArrayList;

/**
 * Category Container holds a list of all categories.
 * 
 * @author Group 1
 * @version 0.1
 */
public class CategoryCont {
	private static CategoryCont instance;
	private final ArrayList<Category> categories;
	
	/**
	 * Constructor for CategoryCont objects.
	 */
	private CategoryCont() {
		categories = new ArrayList<Category>();
	}
	
	/**
	 * getInstance - Returns the instance of CategoryCont
	 * 
	 * @return CategoryCont
	 */
	public static CategoryCont getInstance() {
		if (instance == null) {
			instance = new CategoryCont();
		}
		
		return instance;
	}
	
	/**
	 * addCategory - Adds a Category to the Container
	 * 
	 * @param c The Category object to add.
	 */
	public void addCategory(Category c) {
		categories.add(c);
	}
	
	/**
	 * getAll - Returns all the Categories as ArrayList
	 * 
	 * @return ArrayList<Category> A list of all categories.
	 */
	public ArrayList<Category> getAll() {
		return categories;
	}
	
	/**
	 * findCategory - Finds the Category by name
	 * 
	 * @param name The name to look for.
	 * @return The found Category object or null
	 */
	public Category findCategory(String name) {
		boolean found = false;
		Category c = null;
		int i = 0;
		while (i < categories.size() && !found) {
			final Category ca = categories.get(i);
			if (ca.getName().equalsIgnoreCase(name)) {
				c = ca;
				found = true;
			}
			i++;
		}
		
		return c;
	}
	
	/**
	 * Removes a category
	 * 
	 * @param c The Category object to remove.
	 */
	public void removeCategory(Category c) {
		categories.remove(c);
	}
}
