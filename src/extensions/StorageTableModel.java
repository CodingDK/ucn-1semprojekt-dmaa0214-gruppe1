package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Storage;

public class StorageTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Storage> storages;
	
	public StorageTableModel(ArrayList<Storage> stor) {
		storages = stor;
	}
	
	public void refresh(ArrayList<Storage> s) {
		storages = s;
	}
	
	public int getColumnCount() {
		return 2;
	}
	
	public int getRowCount() {
		return storages.size();
	}
	
	public Object getValueAt(int rowIndex, int collIndex) {
		Storage s = storages.get(rowIndex);
		Object value = null;
		if (collIndex == 0) {
			value = s.getId();
		} else if (collIndex == 1) {
			value = s.getName();
		}
		return value;
	}
	
	@Override
	public String getColumnName(int collIndex) {
		
		String value = "??";
		
		if (collIndex == 0) {
			value = "ID";
		} else if (collIndex == 1) {
			value = "Navn";
		}
		return value;
	}
}
