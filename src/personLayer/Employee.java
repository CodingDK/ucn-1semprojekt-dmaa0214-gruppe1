package personLayer;

public class Employee extends Person{
	protected String employeeNr;
	
	public Employee(String employeeNr, String name, String phoneNr, String address, String email, String city, String postCode){
		super(name, phoneNr, address, email, city, postCode);
		this.employeeNr = employeeNr;
	}

	/**
	 * @return the employeeNr
	 */
	public String getEmployeeNr() {
		return employeeNr;
	}
	
	

}
