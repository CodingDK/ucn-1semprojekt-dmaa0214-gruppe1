package uiLayer;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Item;
import modelLayer.PartSale;

public class SaleItemTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<PartSale> partSales;
	
	public SaleItemTableModel(ArrayList<PartSale> ps){
		this.partSales = ps;
	}

	public void refresh(ArrayList<PartSale> ps) {
		this.partSales = ps;
	}

	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return partSales.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		PartSale ps  = partSales.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			Item item = ps.getItem();
			value = item.getId();
		} else if(collIndex == 1){
			Item item = ps.getItem();
			value = item.getName();
		} else if(collIndex == 2){
			
			value = ps.getAmount();
		} else if(collIndex == 3){
			Item item = ps.getItem();
			value = item.getSalePrice();
		} else if(collIndex == 4){
			Item item = ps.getItem();
			String totalPrice = "" + item.getSalePrice()*ps.getAmount();
			value = totalPrice;
		}
		return value;
	}	
	
	public String getColumnName(int collIndex){
		
		String value = "??";
		
		if(collIndex == 0){
			value = "Varenr.";
		} else if(collIndex == 1){
			value = "Varenavn";
		} else if(collIndex == 2){
			value = "Stk.";
		} else if(collIndex == 3){
			value = "Stk. pris";
		} else if(collIndex == 4){
			value = "Total";
		}
		
		return value;
	}
}
