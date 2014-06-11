package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Storage;

public class StorageTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Storage> storages;
	
	public StorageTableModel(ArrayList<Storage> stor){
		this.storages = stor;
	}

	public void refresh(ArrayList<Storage> s) {
		this.storages = s;
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return storages.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Storage s  = storages.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = s.getId();
		} else if(collIndex == 1){
			value = s.getName();
		} else if(collIndex == 2){
			value = "";
		} else if(collIndex == 3){
			value = "";
		} else if(collIndex == 4){
			value = "";
		} else if(collIndex == 5){
			value = "";
		} 
		return value;
	}	
	
	public String getColumnName(int collIndex){
		
		String value = "??";
		
		if(collIndex == 0){
			value = "ID";
		} else if(collIndex == 1){
			value = "Navn";
		} else if(collIndex == 2){
			value = "Gade";
		} else if(collIndex == 3){
			value = "By";
		} else if(collIndex == 4){
			value = "Postnummer";
		} else if(collIndex == 5){
			value = "Tlf nr";
		}
		
		return value;
	}
}
