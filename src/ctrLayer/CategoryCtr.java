package ctrLayer;

import java.util.ArrayList;

import exceptionLayer.NoSelectionException;
import modelLayer.Category;
import modelLayer.CategoryCont;

public class CategoryCtr {
	private Category selectedCategory;
	private CategoryCont cCont;
	
	public CategoryCtr(){
		cCont = CategoryCont.getInstance();
	}
	
	public void createCategory(String name) {
		cCont.addCategory(new Category(name));
	}
	
	public void updateCategory(String newName) throws NoSelectionException {
		if(selectedCategory != null){
			selectedCategory.setName(newName);
		} else {
			throw new NoSelectionException("Der er ikke valgt nogen kategori");
		}
	}
	
	public void removeCategory() throws NoSelectionException {
		if(selectedCategory != null){
			cCont.removeCategory(selectedCategory);
		} else {
			throw new NoSelectionException("Der er ikke valgt nogen kategori");
		}
	}
	
	public boolean exist(String name){
		boolean ret = false;
		if(cCont.findCategory(name) != null){
			ret = true;
		}
		
		return ret;
	}
	
	public Category findCategory(String name){
		return cCont.findCategory(name);
	} 
	
	public ArrayList<Category> getAllCategories(){
		return cCont.getAll();
	}

}
