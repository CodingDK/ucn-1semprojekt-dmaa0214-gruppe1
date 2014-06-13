package extensions;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import personLayer.Employee;

public class EmployeeTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Employee> employees;
	
	public EmployeeTableModel(ArrayList<Employee> emp){
		this.employees = emp;
	}

	public void refresh(ArrayList<Employee> e) {
		this.employees = e;
	}

	public int getColumnCount() {
		return 8;
	}

	public int getRowCount() {
		return employees.size();
	}

	public Object getValueAt(int rowIndex, int collIndex) {
		Employee e  = employees.get(rowIndex);
		Object value = null;
		if(collIndex == 0){
			value = e.getEmployeeNr();
		} else if(collIndex == 1){
			value = e.getName();
		} else if(collIndex == 2){
			value = e.getStreet();
		} else if(collIndex == 3){
			value = e.getCity();
		} else if(collIndex == 4){
			value = e.getPostCode();
		} else if(collIndex == 5){
			value = e.getPhoneNr();
		} else if(collIndex == 6){
			value = e.getEmail();
		} else if(collIndex == 7){
			if(e.getAdmin()){
				value = "Ja";
			} else{
				value = "Nej";
			}
		}
		return value;
	}	
	
	public String getColumnName(int collIndex){
		
		String value = "??";
		
		if(collIndex == 0){
			value = "Medarbejder ID";
		} else if(collIndex == 1){
			value = "Navn";
		} else if(collIndex == 2){
			value = "Gade";
		} else if(collIndex == 3){
			value = "By";
		} else if(collIndex == 4){
			value = "Postnummer";
		} else if(collIndex == 5){
			value = "Tlf nr.";
		} else if(collIndex == 6){
			value = "E-mail";
		} else if(collIndex == 7){
			value = "Admin";
		}
		
		
		return value;
	}
}
