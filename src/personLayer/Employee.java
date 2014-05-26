package personLayer;

public class Employee extends Person{
	protected String employeeNr;
	
	public Employee(String employeeNr, String name, String phoneNr, String street, String email, String city, String postCode){
		super(name, phoneNr, street, email, city, postCode);
		this.employeeNr = employeeNr;
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
	
	
	
	

}
