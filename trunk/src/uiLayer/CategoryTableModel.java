package uiLayer;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Category;

public class CategoryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> categories;
	
	public CategoryTableModel(ArrayList<Category> cust){
		this.categories = cust;
	}

	public void refresh(ArrayList<Category> c) {
		this.categories = c;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return categories.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Category c  = categories.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = c.getId();
		} else if(collIndex == 1){
			value = c.getName();
		} 
		return value;
	}	
	
	public String getColumnName(int collIndex){
		String value = "??";
		if(collIndex == 0){
			value = "ID";
		} else if(collIndex == 1){
			value = "Kategori";
		}		
		return value;
	}
}
