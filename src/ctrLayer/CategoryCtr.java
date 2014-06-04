package ctrLayer;

import java.util.ArrayList;

import modelLayer.Category;
import modelLayer.CategoryCont;
import modelLayer.Item;
import modelLayer.ItemCont;

public class CategoryCtr {
	private CategoryCont cCont;
	
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
	public void createCategory(String name) {
		cCont.addCategory(new Category(name));
	}
	
	/**
	 * Updates the name of the Category
	 * 
	 * @param newName
	 */
	public void updateCategory(Category c, String newName) {
		c.setName(newName);
	}
	
	/**
	 * Removes the selected category
	 * 
	 * @param Category
	 */
	public void removeCategory(Category c) {
		ItemCont iContDel = ItemCont.getInstance(c);
		ArrayList<Item> items = iContDel.getAll();
		Category cat = findCategory("U/K");
		ItemCont iContAll = ItemCont.getInstance(findCategory("U/K"));
		for (Item i : items) {
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
	public Category findCategory(String name) {
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
	public ArrayList<Category> searchCategory(String name) {
		ArrayList<Category> categories = new ArrayList<Category>();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> cats = cCtr.getAllCategories();
		if (cats != null) {
			for (Category cat : cats) {
				if (cat.getName().toLowerCase().contains(name.toLowerCase())) {
					categories.add(cat);
				}
			}
		}
		return categories;
	}
	
}
