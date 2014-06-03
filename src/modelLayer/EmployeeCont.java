package modelLayer;

import java.util.ArrayList;

import personLayer.Employee;

/**
 * EmployeeCont contains a list of all persons in the EmployeeCont.
 * 
 * @author Group 1
 * @version 0.1
 */
public class EmployeeCont {
	
	private static EmployeeCont instance;
	private final ArrayList<Employee> employees;
	
	/**
	 * Constructor for objects of class EmployeeCont
	 */
	private EmployeeCont() {
		employees = new ArrayList<Employee>();
	}
	
	/**
	 * getInstance - Get only one instance of the EmployeeCont.
	 * 
	 * @return EmployeeCont - The instance of the EmployeeCont.
	 */
	public static EmployeeCont getInstance() {
		if (instance == null) {
			instance = new EmployeeCont();
		}
		
		return instance;
	}
	
	/**
	 * addEmployee - Add a Employee object to the EmployeeCont.
	 * 
	 * @param e The Employee object to add.
	 */
	public void addEmployee(final Employee e) {
		employees.add(e);
	}
	
	/**
	 * removeEmployee - Remove a Employee from the EmployeeCont.
	 * 
	 * @param Employee The Employee object to remove.
	 */
	public void removeEmployee(final Employee e) {
		employees.remove(e);
	}
	
	/**
	 * findEmployee - Finds and returns a EmployeeObj by name or employee number
	 * 
	 * @param nameOrEmployeeNr - The employeeNr of the Employee.
	 * @return Employee object of the Employee or null if not found.
	 */
	public Employee findEmployee(final String nameOrEmployeeNr) {
		boolean found = false;
		Employee e = null;
		int i = 0;
		while (i < employees.size() && !found) {
			final Employee em = employees.get(i);
			if (em.getName().equalsIgnoreCase(nameOrEmployeeNr) || em.getEmployeeNr().equalsIgnoreCase(nameOrEmployeeNr)) {
				e = em;
				found = true;
			}
			i++;
		}
		return e;
	}
	
	/**
	 * findEmployee - Get a Employee object from the id of the Employee.
	 * 
	 * @param id - The id of the Employee.
	 * @return Employee object of the Employee or null if not found.
	 */
	public Employee findEmployee(final int id) {
		
		Employee retEmployee = null;
		boolean found = false;
		int i = 0;
		while (i < employees.size() && !found) {
			if (employees.get(i).getId() == id) {
				retEmployee = employees.get(i);
				found = true;
			}
			i++;
		}
		
		return retEmployee;
	}
	
	/**
	 * @return employee Returns the list of employees.
	 */
	public ArrayList<Employee> getEmployee() {
		return employees;
	}
	
}
