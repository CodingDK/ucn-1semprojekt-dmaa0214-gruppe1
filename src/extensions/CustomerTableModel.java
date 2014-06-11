package extensions;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import personLayer.Customer;

public class CustomerTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customers;
	
	public CustomerTableModel(ArrayList<Customer> cust){
		this.customers = cust;
	}

	public void refresh(ArrayList<Customer> c) {
		this.customers = c;
	}

	public int getColumnCount() {
		return 7;
	}

	public int getRowCount() {
		return customers.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Customer c  = customers.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = c.getId();
		} else if(collIndex == 1){
			value = c.getName();
		} else if(collIndex == 2){
			value = c.getStreet();
		} else if(collIndex == 3){
			value = c.getCity();
		} else if(collIndex == 4){
			value = c.getPostCode();
		} else if(collIndex == 5){
			value = c.getPhoneNr();
		} else if(collIndex == 6){
			value = c.getEmail();
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
		} else if(collIndex == 6){
			value = "E-mail";
		}
		
		return value;
	}
}
