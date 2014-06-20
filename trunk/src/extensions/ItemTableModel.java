package extensions;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Item;

public class ItemTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items;
	private NumberFormat money;
	
	public ItemTableModel(ArrayList<Item> it) {
		items = it;
		money = NumberFormat.getCurrencyInstance();
	}
	
	public void refresh(ArrayList<Item> it) {
		items = it;
	}
	
	public int getColumnCount() {
		return 8;
	}
	
	public int getRowCount() {
		return items.size();
	}
	
	public Object getValueAt(int rowIndex, int collIndex) {
		Item i = items.get(rowIndex);
		Object value = null;
		if (collIndex == 0) {
			value = i.getId();
		} else if (collIndex == 1) {
			value = i.getName();
		} else if (collIndex == 2) {
			value = i.getAmount() + "(" + i.getReserved() + ")";
		} else if (collIndex == 3) {
			value = money.format(i.getSalePrice());
		} else if (collIndex == 4) {
			value = money.format(i.getPurchasePrice());
		} else if (collIndex == 5) {
			value = i.getLocation();
		} else if (collIndex == 6) {
			value = i.getStorage().getName();
		} else if (collIndex == 7) {
			value = i.getCategory().getName();
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
		} else if (collIndex == 2) {
			value = "Mængde";
		} else if (collIndex == 3) {
			value = "Salgs Pris";
		} else if (collIndex == 4) {
			value = "Indkøbs Pris";
		} else if (collIndex == 5) {
			value = "Lokation";
		} else if (collIndex == 6) {
			value = "Lager";
		} else if (collIndex == 7) {
			value = "Kategori";
		}
		
		return value;
	}
}
