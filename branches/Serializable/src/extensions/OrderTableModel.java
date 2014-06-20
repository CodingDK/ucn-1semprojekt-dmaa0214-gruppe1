package extensions;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import personLayer.Business;
import personLayer.Customer;
import modelLayer.Sale;

public class OrderTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Sale> sales;
	private NumberFormat money;

	public OrderTableModel(ArrayList<Sale> sales){
		this.sales = sales;
		money = NumberFormat.getCurrencyInstance();
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
		Customer c = s.getCustomer();
		if(collIndex == 0){
			value = s.getId();
		}else if(collIndex == 1){
			if(c == null){
				value = " ";
			}else{
				if(c instanceof Business){
					value = ((Business) c).getCompany();
				} else{
					value = c.getName();
				}
			}
		}else if(collIndex == 2){
			value = money.format(s.getTotalPrice());
		}else if(collIndex == 3){
			if(s.getEmployee() == null){
				value = " ";
			}else{
				value = s.getEmployee().getId();
			}
		}else if(collIndex == 4){
			value = s.getDateToString();
		}else if(collIndex == 5){
			if(s.isDone()){
				value = "Nej";
			} else{
				value = "Ja";
			}
		}
		return value;
	}	

	public String getColumnName(int collIndex){

		String value = "??";

		if(collIndex == 0){
			value = "ID";
		} else if(collIndex == 1){
			value = "Kunde";
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
