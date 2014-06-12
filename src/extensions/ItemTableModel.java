package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Item;
import personLayer.Customer;

public class ItemTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items;
	
	public ItemTableModel(ArrayList<Item> it){
		this.items = it;
	}

	public void refresh(ArrayList<Item> it) {
		this.items = it;
	}

	public int getColumnCount() {
		return 7;
	}

	public int getRowCount() {
		return items.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Item i  = items.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = i.getId();
		} else if(collIndex == 1){
			value = i.getName();
		} else if(collIndex == 2){
			value = i.getAmount() + "(" + i.getReserved() + ")";
		} else if(collIndex == 3){
			value = i.getSalePrice() + ",-";
		} else if(collIndex == 4){
			value = i.getPurchasePrice() + ",-";
		} else if(collIndex == 5){
			value = i.getLocation();
		} else if(collIndex == 6){
			value = i.getStorage().getName();
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
			value = "Mængde";
		} else if(collIndex == 3){
			value = "Salgs Pris";
		} else if(collIndex == 4){
			value = "Indkøbs Pris";
		} else if(collIndex == 5){
			value = "Lokation";
		} else if(collIndex == 6){
			value = "Lager";
		}
		
		return value;
	}
}
