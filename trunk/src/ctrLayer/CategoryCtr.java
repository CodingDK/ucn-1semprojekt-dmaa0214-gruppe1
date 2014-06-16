package ctrLayer;

import java.util.ArrayList;

import modelLayer.Category;
import modelLayer.CategoryCont;
import modelLayer.Item;
import modelLayer.ItemCont;
import exceptionLayer.CategoryExistException;
import exceptionLayer.MainCategoryException;

public class CategoryCtr {
	private CategoryCont cCont;
	
	public CategoryCtr() {
		cCont = CategoryCont.getInstance();
		if (findCategory("Alle") == null) {
			try {
				createCategory("Alle");
			} catch (CategoryExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ItemCont.getInstance(findCategory("Alle"));
		}
	}
	
	/**
	 * Creates a new Category
	 * 
	 * @param name
	 */
	public void createCategory(String name) throws CategoryExistException{
		if(cCont.findCategory(name) == null){
			cCont.addCategory(new Category(name));
		} else {
			throw new CategoryExistException("Kategorien eksistere allerede");
		}
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
	 * @throws MainCategoryException 
	 */
	public void removeCategory(Category c) throws MainCategoryException {
		if(c.getName() != findCategory("Alle").getName()){
			ItemCont iContDel = ItemCont.getInstance(c);
			ArrayList<Item> items = iContDel.getAll();
			Category cat = findCategory("Alle");
			ItemCont iContAll = ItemCont.getInstance(findCategory("Alle"));
			for (Item i : items) {
				i.setCategory(cat);
				iContAll.addItem(i);
			}
			ItemCont.removeInstance(c);
			cCont.removeCategory(c);
		}else{
			throw new MainCategoryException("Hovedkategorien kan ikke slettes");
		}
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
