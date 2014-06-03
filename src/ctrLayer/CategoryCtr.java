package ctrLayer;

import java.util.ArrayList;

import modelLayer.Category;
import modelLayer.CategoryCont;
import modelLayer.Item;
import modelLayer.ItemCont;

public class CategoryCtr {
	private final CategoryCont cCont;
	
	public CategoryCtr() {
		cCont = CategoryCont.getInstance();
		if (findCategory("U/K") == null) {
			createCategory("U/K");
			ItemCont.getInstance(findCategory("U/K"));
		}
	}
	
	/**
	 * Creates a new Category
	 * 
	 * @param name
	 */
	public void createCategory(final String name) {
		cCont.addCategory(new Category(name));
	}
	
	/**
	 * Updates the name of the Category
	 * 
	 * @param newName
	 */
	public void updateCategory(final Category c, final String newName) {
		c.setName(newName);
	}
	
	/**
	 * Removes the selected category
	 * 
	 * @param Category
	 */
	public void removeCategory(final Category c) {
		final ItemCont iContDel = ItemCont.getInstance(c);
		final ArrayList<Item> items = iContDel.getAll();
		final Category cat = findCategory("U/K");
		final ItemCont iContAll = ItemCont.getInstance(findCategory("U/K"));
		for (final Item i : items) {
			i.setCategory(cat);
			iContAll.addItem(i);
		}
		ItemCont.removeInstance(c);
		cCont.removeCategory(c);
	}
	
	/**
	 * Finds the category by name
	 * 
	 * @param name
	 * @return Category
	 */
	public Category findCategory(final String name) {
		return cCont.findCategory(name);
	}
	
	/**
	 * Returns all Categorys as ArrayList
	 * 
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> getAllCategories() {
		return cCont.getAll();
	}
	
	/**
	 * searchCategory - Searches for categories containing the param(name), and returns a list with matches
	 * 
	 * @param name
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> searchCategory(final String name) {
		final ArrayList<Category> categories = new ArrayList<Category>();
		final CategoryCtr cCtr = new CategoryCtr();
		final ArrayList<Category> cats = cCtr.getAllCategories();
		if (cats != null) {
			for (final Category cat : cats) {
				if (cat.getName().toLowerCase().contains(name.toLowerCase())) {
					categories.add(cat);
				}
			}
		}
		return categories;
	}
	
}
