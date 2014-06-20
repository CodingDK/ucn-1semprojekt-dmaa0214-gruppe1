package personLayer;

/**
 * Employee holds information for Employees.
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class Employee extends Person {
	private String employeeNr;
	private boolean admin;
	@SuppressWarnings("unused")
	private String cprNr;
	private String password;
	
	/**
	 * Constructor for Employee objects.
	 * 
	 * @param employeeNr The employeeNr of the employee.
	 * @param name The name of the employee.
	 * @param phoneNr The phoneNr of the employee.
	 * @param street The Street of the employee.
	 * @param email The email of the employee.
	 * @param city The city of the employee.
	 * @param postCode The postCode of the employee.
	 * @param cprNr The cprNr of the employee.
	 * @param password the admin password
	 * @param admin A boolean value, true for admin.
	 */
	public Employee(String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode, String cprNr, String password, boolean admin) {
		super(name, phoneNr, street, email, city, postCode);
		this.employeeNr = employeeNr;
		this.admin = admin;
		this.cprNr = cprNr;
		this.password = password;
	}
	
	/**
	 * @return the employeeNr
	 */
	public String getEmployeeNr() {
		return employeeNr;
	}
	
	/**
	 * @param employeeNr the employeeNr to set
	 */
	public void setEmployeeNr(String employeeNr) {
		this.employeeNr = employeeNr;
	}
	
	/**
	 * getAdmin - Get the boolean value of admin.
	 * 
	 * @return boolean true if employee is admin.
	 */
	public boolean getAdmin() {
		return admin;
	}
	
	/**
	 * setAdmin - Change the admin status.
	 * 
	 * @param admin true if employee is admin.
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	/**
	 * getPassword - Get the password of the employee.
	 * 
	 * @return String with password
	 */
	public String getPassword() {
		return password;
	}
}
