package extensions;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelLayer.Storage;

public class OrderTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Storage> orders;
	
	public OrderTableModel(ArrayList<Storage> orders){
		this.orders = orders;
	}

	public void refresh(ArrayList<Storage> ords) {
		this.orders = ords;
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return orders.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Storage o  = orders.get(rowIndex);
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
			value = "Kundenavn";
		}else if(collIndex == 2){
			value = "Dato";
		}else if(collIndex == 3){
			value = "Totalpris";
		}else if(collIndex == 4){
			value = "Ekspedient";
		}else if(collIndex == 5){
			value = "Dato";
		}else if(collIndex == 6){
			value = "Parkeret";
		}			
		return value;
	}
}
