package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Order;

public class StorageTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Order> storages;
	
	public StorageTableModel(ArrayList<Order> stor){
		this.storages = stor;
	}

	public void refresh(ArrayList<Order> s) {
		this.storages = s;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return storages.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Order s  = storages.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = s.getId();
		} else if(collIndex == 1){
			value = s.getName();
		}
		return value;
	}	
	
	public String getColumnName(int collIndex){
		
		String value = "??";
		
		if(collIndex == 0){
			value = "ID";
		} else if(collIndex == 1){
			value = "Navn";
		}		
		return value;
	}
}
