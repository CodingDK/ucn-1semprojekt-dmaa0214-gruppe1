package ctrLayer;

import java.util.ArrayList;
import modelLayer.Category;
import modelLayer.CategoryCont;
import modelLayer.Item;
import modelLayer.ItemCont;

public class CategoryCtr {
	private CategoryCont cCont;
	
	public CategoryCtr(){
		cCont = CategoryCont.getInstance();
		if(findCategory("U/K") == null){
			createCategory("U/K");
			ItemCont.getInstance(findCategory("U/K"));
		}
	}
	
	/**
	 * Creates a new Category
	 * @param name
	 */
	public void createCategory(String name){
		cCont.addCategory(new Category(name));
	}
	
	/**
	 * Updates the name of the Category
	 * @param newName
	 */
	public void updateCategory(Category c, String newName) {
		c.setName(newName);
	}
	
	/**
	 * Removes the selected category
	 * @throws NoSelectionException
	 */
	public void removeCategory(Category c) {
		ItemCont iContDel = ItemCont.getInstance(c);
		ArrayList<Item> items = iContDel.getAll();
		Category cat = findCategory("U/K");
		ItemCont iContAll = ItemCont.getInstance(findCategory("U/K"));
		for(Item i : items){
			i.setCategory(cat);
			iContAll.addItem(i);
		}
		ItemCont.removeInstance(c);
		cCont.removeCategory(c);
	}
	
	
	/**
	 * Returns boolean true if the category exists
	 * @param name
	 * @return boolean
	 */
	public boolean exist(String name){
		boolean ret = false;
		if(cCont.findCategory(name) != null){
			ret = true;
		}
		
		return ret;
	}
	
	
	/**
	 * Finds the category by name
	 * @param name
	 * @return Category
	 */
	public Category findCategory(String name){
		return cCont.findCategory(name);
	} 
	
	/**
	 * Finds the category by ID
	 * @param name
	 * @return Category
	 */
	public Category findCategory(int id){
		return cCont.findCategory(id);
	} 
	
	
	
	/**
	 * Returns all Categorys as ArrayList
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> getAllCategories(){
		return cCont.getAll();
	}

	public ArrayList<Category> searchCategory(String name) {
		ArrayList<Category> categories = new ArrayList<Category>();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> cats = cCtr.getAllCategories();
		if(cats != null){
			for(Category cat : cats){
				if(cat.getName().toLowerCase().contains(name.toLowerCase())){
					categories.add(cat);
				}
			}
		}
		return categories;
	}

}
