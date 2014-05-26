package ctrLayer;
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
    	eCont = eCont.getInstance();
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
     * createSeller - Create a new Seller.
     * @param employeeNr The employeeNr of the employee.
     * @param name The name of the employee.
     * @param phoneNr The phoneNr of the employee.
     * @param street The Street of the employee.
     * @param email The email of the employee.
     * @param city The city of the employee.
     * @param postCode The postCode of the employee.
     * @param cprNr The cprNr of the employee.
     */
    public void createSeller(String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode, String cprNr){
    	eCont.addEmployee(new Seller(employeeNr, name, phoneNr, street, email, city, postCode));
    }
    
    /**
     * createAdministrator - Create a new Administrator.
     * @param employeeNr The employeeNr of the employee.
     * @param name The name of the employee.
     * @param phoneNr The phoneNr of the employee.
     * @param street The Street of the employee.
     * @param email The email of the employee.
     * @param city The city of the employee.
     * @param postCode The postCode of the employee.
     * @param cprNr The cprNr of the employee.
     */
    public void createAdministrator(String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode, String cprNr){
    	eCont.addEmployee(new Administrator(employeeNr, name, phoneNr, street, email, city, postCode));
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
     * @throws NullPointerException Employee not exits.
     */
    public void updateEmployee(int id, String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode) throws NullPointerException{
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
}
