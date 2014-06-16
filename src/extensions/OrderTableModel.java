package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Sale;
import modelLayer.Storage;

public class OrderTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Sale> sales;
	
	public OrderTableModel(ArrayList<Sale> sales){
		this.sales = sales;
	}

	public void refresh(ArrayList<Sale> sales) {
		this.sales = sales;
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return sales.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Sale s  = sales.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = s.getId();
		}else if(collIndex == 1){
			value = s.getCustomer().getName();
		}else if(collIndex == 2){
			value = s.getTotalPrice();
		}else if(collIndex == 3){
			value = s.getEmployee().getName();
		}else if(collIndex == 4){
			value = s.getDate();
		}else if(collIndex == 5){
			value = s.isDone();
		}
		return value;
	}	
	
	public String getColumnName(int collIndex){
		
		String value = "??";
		
		if(collIndex == 0){
			value = "ID";
		} else if(collIndex == 1){
			value = "Kundenavn";
		}else if(collIndex == 2){
			value = "Totalpris";
		}else if(collIndex == 3){
			value = "Ekspedient";
		}else if(collIndex == 4){
			value = "Dato";
		}else if(collIndex == 5){
			value = "Parkeret";
		}			
		return value;
	}
}
