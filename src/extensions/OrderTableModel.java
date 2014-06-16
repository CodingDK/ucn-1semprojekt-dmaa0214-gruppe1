package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Order;

public class OrderTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Order> orders;
	
	public OrderTableModel(ArrayList<Order> orders){
		this.orders = orders;
	}

	public void refresh(ArrayList<Order> ords) {
		this.orders = ords;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return orders.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Order o  = orders.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = o.getId();
		} else if(collIndex == 1){
			value = o.getName();
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
