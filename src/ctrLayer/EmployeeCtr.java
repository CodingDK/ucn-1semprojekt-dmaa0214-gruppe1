package ctrLayer;
import java.util.ArrayList;

import personLayer.*;
import modelLayer.*;

/**
 * Controller class for the EmployeeCtr
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class EmployeeCtr{
	
	private EmployeeCont eCont;
	
	/**
     * Constructor for controller EmployeeCtr.
     */
    public EmployeeCtr(){
    	eCont = EmployeeCont.getInstance();
    }
	
    /**
     * findEmployee - Return Employee object found.
     * @param employeeNr The employeeNr of the Employee object to find.
     * @return Employee - The Employee object of Employee or null.
     */
    public Employee findEmployee(String employeeNr){
    	return eCont.findEmployee(employeeNr);
    }
    
    /**
     * findEmployeeNameOrEmpNr - Return Employee object found.
     * @param employeeNr The employeeNr of the Employee object to find.
     * @return Employee - The Employee object of Employee or null.
     */
    public Employee findEmployeeNameOrEmpNr(String nameOrEmployeeNr){
    	return eCont.findEmployeeNameOrEmpNr(nameOrEmployeeNr);
    }
    
    
    
    /**
     * createEmployee - Create a new Employee.
     * @param employeeNr The employeeNr of the employee.
     * @param name The name of the employee.
     * @param phoneNr The phoneNr of the employee.
     * @param street The Street of the employee.
     * @param email The email of the employee.
     * @param city The city of the employee.
     * @param postCode The postCode of the employee.
     * @param cprNr The cprNr of the employee.
     * @param admin A boolean value, true for admin.
     */
    public void createEmployee(String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode, String cprNr, String password, boolean admin){
    	eCont.addEmployee(new Employee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, password, admin));
    }
    
    /**
     * updateEmployee - Update an employee.
     * @param id The Id of the Employee object to update.
     * @param employeeNr The new value or null if not changed.
     * @param name The new value or null if not changed.
     * @param phoneNr The new value or null if not changed.
     * @param street The new value or null if not changed.
     * @param email The new value or null if not changed.
     * @param city The new value or null if not changed.
     * @param postCode The new value or null if not changed.
     * @param admin The new value or null if not changed.
     * @throws NullPointerException Employee not exits.
     */
    public void updateEmployee(int id, String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode, Boolean admin) throws NullPointerException{
    	Employee e = eCont.findEmployee(id);
    	if(e != null) {
    		if(employeeNr != null) {
    			e.setEmployeeNr(employeeNr);
    		}
    		if(name != null) {
    			e.setName(name);
    		}
    		if(phoneNr != null) {
    			e.setPhoneNr(phoneNr);
    		}
    		if(street != null) {
    			e.setStreet(street);
    		}
    		if(email != null) {
    			e.setEmail(email);
    		}
    		if(city != null) {
    			e.setCity(city);
    		}
    		if(postCode != null) {
    			e.setPostCode(postCode);
    		}
    		if(admin != null){
    			e.setAdmin(admin);
    		}
    	} else {
    		throw new NullPointerException("Medarbejder ikke fundet");
    	}
    }
    
    /**
     * removeEmployee - Remove a Employee object from the Container.
     * @param e The Employee to remove.
     */
    public void removeEmployee(Employee e) {
    	eCont.removeEmployee(e);
    }
    
    /**
	 * searchEmployee
	 * @param partName
	 * @return Employee
	 */
	public ArrayList<Employee> searchEmployee(String partName){
		ArrayList<Employee> foundEmployees = new ArrayList<Employee>();
		EmployeeCont employeeCont = EmployeeCont.getInstance();
		ArrayList<Employee> emp = employeeCont.getEmployee();
		if(emp != null)
			for(Employee e : emp){
				if(e.getName().contains(partName) ){
					foundEmployees.add(e);			
				}	
			}
		return foundEmployees;
	}
	
	/**
	 * Finds a EmployeeObj by ID
	 * @param id
	 * @return Employee
	 */
	public Employee findEmployee(int id){
		return eCont.findEmployee(id);
	}
	
}
