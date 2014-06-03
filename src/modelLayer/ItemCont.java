package modelLayer;
import java.util.*;

/**
 * ItemCont contains a list of all items in categories.
 * 
 * @author Group 1
 * @version 0.1
 */
public class ItemCont {

	private static HashMap<Category, ItemCont> instance = new HashMap<Category, ItemCont>();
	private ArrayList<Item> items;

	/**
	 * Constructor for objects of class ItemCont
	 */
	private ItemCont() {
		items = new ArrayList<Item>();
	}

	/**
	 * getInstance - Get only one instance of the ItemCont by Category Object.
	 * @param c The Category object to look in.
	 * @return ItemCont - The instance of the ItemCont.
	 */
	public static ItemCont getInstance(Category c){

		if(instance.get(c) == null){
			instance.put(c, new ItemCont());
		}

		return instance.get(c);

	}

	/**
	 * addItem - Add an Item object to the category instance.
	 * @param i The Item object to add.
	 */
	public void addItem(Item i){
		items.add(i);
	}

	/**
	 * getItem - Get an Item object by id from the category instance.
	 * @param id The id of the Item object.
	 * @return Item - The founded item or null.
	 */
	public Item getItem(int id){
		Item retItem = null;
		boolean found = false;
		int i = 0;
		while(i < items.size() && !found) {
			if(items.get(i).getId() == id) {
				retItem = items.get(i);
				found = true;
			}
			i++;
		}
		return retItem;
	}

	/**
	 * getItem - Get an Item object by name from the category instance.
	 * @param name The name of the Item object.
	 * @return Item - The founded item or null.
	 */
	public Item getItem(String name){
		Item retItem = null;
		boolean found = false;
		int i = 0;
		while(i < items.size() && !found) {
			if(items.get(i).getName().equalsIgnoreCase(name)) {
				retItem = items.get(i);
				found = true;
			}
			i++;
		}
		return retItem;
	}

	/**
	 * getAll - Get a list of all items in the category.
	 * @return ArrayList<Item> List of all items in the category.
	 */
	public ArrayList<Item> getAll(){
		return items;
	}

	/**
	 * removeItem - Remove an Item object from the category.
	 * @param i The Item object to remove.
	 */
	public void removeItem(Item i){
		items.remove(i);
	}

	/**
	 * removeInstance - Remove an instance of the item container.
	 * @param c The category object instance to remove
	 */
	public static void removeInstance(Category c){
		instance.remove(getInstance(c));
	}
}
