package ctrLayer;

import java.util.ArrayList;

import exceptionLayer.AlreadyExistException;
import exceptionLayer.NoSelectionException;
import modelLayer.Category;
import modelLayer.CategoryCont;
import modelLayer.Item;
import modelLayer.ItemCont;

public class CategoryCtr {
	private Category selectedCategory;
	private CategoryCont cCont;
	
	public CategoryCtr(){
		cCont = CategoryCont.getInstance();
		if(findCategory("U/K") == null){
			createCategory("U/K");
			ItemCont iCont = ItemCont.getInstance(findCategory("U/K"));
		}
	}
	
	/**
	 * Creates a new Category
	 * @param name
	 * @throws AlreadyExistException If the category already exists
	 */
	public void createCategory(String name){
		if(!exist(name)){
			cCont.addCategory(new Category(name));
		}else{
			//throw new AlreadyExistException("Kategorien eksistere allerede");
		}
	}
	
	/**
	 * Updates the name of the Category
	 * @param newName
	 * @throws NoSelectionException If no category is selected
	 */
	public void updateCategory(String newName) throws NoSelectionException {
		if(selectedCategory != null){
			selectedCategory.setName(newName);
		} else {
			throw new NoSelectionException("Der er ikke valgt nogen kategori");
		}
	}
	
	/**
	 * Removes the selected category
	 * @throws NoSelectionException
	 */
	public void removeCategory() throws NoSelectionException {
		if(selectedCategory != null){
			ItemCont iContDel = ItemCont.getInstance(selectedCategory);
			ArrayList<Item> items = iContDel.getAll();
			Category cat = findCategory("U/K");
			ItemCont iContAll = ItemCont.getInstance(findCategory("U/K"));
			for(Item i : items){
				i.setCategory(cat);
				iContAll.addItem(i);
			}
			ItemCont.removeInstance(selectedCategory);
			cCont.removeCategory(selectedCategory);
		} else {
			throw new NoSelectionException("Der er ikke valgt nogen kategori");
		}
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
	
	/**
	 * Selects the category for later use
	 * @param name
	 */
	public void selectCategory(String name){
		selectedCategory = cCont.findCategory(name);
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
