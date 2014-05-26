package modelLayer;

import java.util.ArrayList;
import java.util.Iterator;

public class CategoryCont {
	private static CategoryCont instance;
	private ArrayList<Category> categories;

	private CategoryCont() {
		categories = new ArrayList<Category>();
	}
	
	/**
	 * Returns the instance of CategoryCont
	 * @return CategoryCont
	 */
	public static CategoryCont getInstance(){
		if(instance == null){
			instance = new CategoryCont();
		}
		
		return instance;
	}
	
	/**
	 * Adds a Category to the Container
	 * @param c
	 */
	public void addCategory(Category c){
		categories.add(c);
	}
	
	/**
	 * Returns all the Categories as ArrayList
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> getAll(){
		return categories;
	}
	
	/**
	 * Finds the Category by name
	 * @param name
	 * @return Category
	 */
	public Category findCategory(String name){
		boolean found = false;
		Category c = null;
		int i = 0;
		while(i < categories.size() && !found){
			Category ca = categories.get(i);
			if(ca.getName().equalsIgnoreCase(name)){
				c = ca;
				found = true;
			}
			i++;
		}
		
		return c;
	}
	
	/**
	 * Removes the category
	 * @param c
	 */
	public void removeCategory(Category c){
		categories.remove(c);
	}
}
