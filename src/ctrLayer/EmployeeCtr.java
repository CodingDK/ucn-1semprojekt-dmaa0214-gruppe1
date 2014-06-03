package ctrLayer;

import java.util.ArrayList;

import modelLayer.EmployeeCont;
import personLayer.Employee;

/**
 * Controller class for the EmployeeCtr
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class EmployeeCtr {
	private final EmployeeCont eCont;
	
	/**
	 * Constructor for controller EmployeeCtr.
	 */
	public EmployeeCtr() {
		eCont = EmployeeCont.getInstance();
	}
	
	/**
	 * findEmployee - Return Employee object found.
	 * 
	 * @param employeeNr The name or employeeNr of the Employee object to find.
	 * @return Employee - The Employee object of Employee or null.
	 */
	public Employee findEmployee(final String nameOrEmployeeNr) {
		return eCont.findEmployee(nameOrEmployeeNr);
	}
	
	/**
	 * createEmployee - Create a new Employee.
	 * 
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
	public Employee createEmployee(final String employeeNr, final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final String cprNr, final String password, final boolean admin) {
		final Employee retE = new Employee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, password, admin);
		eCont.addEmployee(retE);
		return retE;
	}
	
	/**
	 * updateEmployee - Update an employee.
	 * 
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
	public void updateEmployee(final int id, final String employeeNr, final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final Boolean admin) throws NullPointerException {
		final Employee e = eCont.findEmployee(id);
		if (e != null) {
			if (employeeNr != null) {
				e.setEmployeeNr(employeeNr);
			}
			if (name != null) {
				e.setName(name);
			}
			if (phoneNr != null) {
				e.setPhoneNr(phoneNr);
			}
			if (street != null) {
				e.setStreet(street);
			}
			if (email != null) {
				e.setEmail(email);
			}
			if (city != null) {
				e.setCity(city);
			}
			if (postCode != null) {
				e.setPostCode(postCode);
			}
			if (admin != null) {
				e.setAdmin(admin);
			}
		} else {
			throw new NullPointerException("Medarbejder ikke fundet");
		}
	}
	
	/**
	 * removeEmployee - Remove a Employee object from the Container.
	 * 
	 * @param Employee The Employee to remove.
	 */
	public void removeEmployee(final Employee e) {
		eCont.removeEmployee(e);
	}
	
	/**
	 * searchEmployee - Searches for Employees containing the param(partNameOrEmpNr), and returns a list of matches
	 * 
	 * @param partNameOrEmpNr
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Employee> searchEmployee(final String partNameOrEmpNr) {
		final ArrayList<Employee> foundEmployees = new ArrayList<Employee>();
		final EmployeeCont eCont = EmployeeCont.getInstance();
		final ArrayList<Employee> emp = eCont.getEmployee();
		if (emp != null)
			for (final Employee e : emp) {
				if ((e.getName().toLowerCase().contains(partNameOrEmpNr.toLowerCase())) || e.getEmployeeNr().contains(partNameOrEmpNr)) {
					foundEmployees.add(e);
				}
			}
		return foundEmployees;
	}
	
}
