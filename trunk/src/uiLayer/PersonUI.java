package uiLayer;

import java.util.ArrayList;
import personLayer.Business;
import personLayer.Customer;
import personLayer.Employee;
import personLayer.Private;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI{

	private Customer selectedCustomer;
	private Employee selectedEmployee;

	public PersonUI(String DryRun){
		selectedCustomer = null;
	}

	public PersonUI(){
		selectedCustomer = null;
		boolean exit = false;
		while(!exit){

			int choice = writeMenu();
			if(admin){ 						// Admin access only
				if(choice == 4){			//Slet kunde
					removeCustomer(selectedCustomer);
				} else if(choice == 7){		//Opdate medarbejder
					updateEmployee(selectedEmployee);
				} else if(choice == 8){		//Slet medarbejder
					removeEmployee(selectedEmployee);					
				}
			} 							// Access for both Admin and Seller
			if(choice == 1){			//Søg kunde
				findCustomer();
			} else if(choice == 2){		//Opret kunde
				//createCustomer();
			} else if(choice == 3){		//Opdater kunde
				//updateCustomer();
			} else if(choice == 5){		//Opret medarbejder
				createEmployee();
			} else if(choice == 6){		//Søg medarbejder
				findEmployee();
			} else if(choice == 9){	//Gå tilbage
				exit = true;
			}
		}		
	}

	private int writeMenu(){
		int choice = 0;
		String pP = selectedCustomer != null ? " (" + selectedCustomer.getName() + ")" : "";  
		String m = selectedEmployee != null ? " (" + selectedEmployee.getName() + ")" : "";

		System.out.println("\n## Person menu ##");
		System.out.println(" 1. Søg kunde");
		System.out.println(" 2. Opret kunde" + pP);
		System.out.println(" 3. Opdater kunde" + pP);
		if(admin){ 
			System.out.println(" 4. Slet kunde" + pP); 
		}
		System.out.println("--------------------------");
		if(admin){
			System.out.println(" 5. Opret medarbejder");
		}
		System.out.println(" 6. Søg medarbejder");
		if(admin){
			System.out.println(" 7. Opdater medarbejder" + m);
			System.out.println(" 8. Slet medarbejder" + m);
		}
		System.out.println("--------------------------");
		System.out.println(" 9. Gå tilbage");
		choice = requestInt("\nValg", 0, false);
		return choice;
	}

	
	
	/**
	 * createCustomer - Create a private or business customer
	 * @return Customer
	 */
	public Customer createCustomer() {
		Customer retC = null;
		boolean exit = false;
		CustomerCtr cCtr = new CustomerCtr();

		while(!exit){
			System.out.println("\n## Opret kunde ##");
			System.out.println("1. Erhvervskunde");
			System.out.println("2. Privatkunde");
			int choice = requestInt("Valg", null, false);

			if(choice == 1 || choice == 2){
				String company = null;
				String cvrNr = null;
				
				if(choice == 1){
					company 		= requestString("Virksomheds navn", null, null, false);
					cvrNr 			= requestString("CVR-nr", null, null, false);
				}
				String name 		= requestString("Navn", null, null, false);
				String street 		= requestString("Gade", null, null, false);
				String postCode 	= requestString("Postnummer", null, null, false);
				String city 		= requestString("By", null, null, false);
				String phoneNr 		= requestString("Telefon nr", null, null, false);
				String email 		= requestString("E-mail", null, null, false);
				if(choice == 2){
					String cprNr 		= requestString("CPR nr", null, null, false);
					String pictureId 	= requestString("Billede ID", null, null, false);
					retC = cCtr.createPrivateCustomer(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
					exit = true;
				}
				retC = cCtr.createBusinessCustomer(name, phoneNr, street, email, city, postCode, company, cvrNr);
				exit = true;
			}
		}
		return retC;
	}


	/**
	 * createSeller - Create a seller
	 */
	public void createEmployee() {
		boolean rights = false;
		System.out.println("\n## Opret sælger ##");
		String employeeNr 	= requestString("Medarbejder nummer", null, null, false);
		String name			= requestString("Navn", null, null, false);
		String street		= requestString("Gade", null, null, false);
		String postCode		= requestString("Postnummer", null, null, false);
		String city			= requestString("By", null, null, false);
		String phoneNr		= requestString("Telefon nr", null, null, false);
		String email		= requestString("E-mail", null, null, false);
		String cprNr		= requestString("CPR nr", null, null, false);
		
		if(confirm("Vil du give denne medarbejder administrator rettigheder") ){
			rights = true;
		}
		
		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, null, rights);
	}


	/**
	 * findCustomer - Find a customer in the system by the name or phone number
	 * @return Customer
	 */
	public Customer findCustomer() {
		Customer retC = null;
		System.out.println("\n## Søg kunde ##");
		String nameOrPhone = requestString("Indtast kundenavn, virksomhedsnavn eller tlf nr.", 1, null, false);
		CustomerCtr cCtr = new CustomerCtr();
		ArrayList<Customer> customers = cCtr.searchCustomer(nameOrPhone);
		if(customers.size() > 0){
			System.out.println(customers.size() + " Kunde(r) fundet");
			for(Customer c : customers){
				if(c instanceof Private){
					System.out.println("ID: " + c.getId() + "\tNavn: " + c.getName() + "\tGade: " + c.getStreet() + "\tPostNummer: " + c.getPostCode() + "\tBy: " + c.getCity() + "\tTlf nr: " + c.getPhoneNr());
				}else if(c instanceof Business){
					Business b = (Business) c; 
					System.out.println("ID: " + b.getId() + "\tVirksomhed: " + b.getCompany() + "\tCVR-nr: " + b.getCvrNr() + "\tPostNummer: " + b.getPostCode() + "\tBy: " + b.getCity() + "\tKontakt: " + b.getName() + "\tTlf. nr.: " + b.getPhoneNr());
				}
			}
			boolean recheck = false;
			while(!recheck){
				int i = 0;
				if(customers.size() > 1){
					int id = requestInt("Indtast ID for den ønskede kunde", null, false);
					while(retC == null && i < customers.size()){
						Customer c = customers.get(i); 
						if(id == c.getId()){
							if(c instanceof Business){
								Business b = (Business) c;
								System.out.println("Valgt - Virksomhed: " + b.getCompany() + ", tlf: " + b.getPhoneNr());
							}else{
								System.out.println("Valgt - Navn: " + c.getName() + ", tlf: " + c.getPhoneNr());
							}
							pause();
							selectedCustomer = c;
							retC = c;
							recheck = true;
						}
						i++;
					}
				} else if(customers.size() == 1){
					retC = customers.get(0);
					selectedCustomer = retC;
					if(retC instanceof Business){
						Business b = (Business) retC;
						System.out.println("Valgt - Virksomhed: " + b.getCompany() + ", tlf: " + b.getPhoneNr());
					}else{
						System.out.println("Valgt - Navn: " + retC.getName() + ", tlf: " + retC.getPhoneNr());
					}
					recheck = true;			
				}
			}
		} else{
			System.out.println("0 Kunder Fundet");
			pause();
		}
		return retC;
	}

	/**
	 * updatePrivate - Updates a private customer
	 * @param customer
	 */
	public void updateCustomer(Customer customer) {

		System.out.println("\n## Opdater privat kunde ##");
		System.out.println("Skriv ny info ellers tryk enter");

		System.out.println("Navn: (" + customer.getName() + ")" );
		String name = stringToNull();

		System.out.println("Gade: (" + customer.getStreet() + ")");
		String street = stringToNull();

		System.out.println("Postnummer: (" + customer.getStreet() + ")");
		String postCode = stringToNull();

		System.out.println("By: (" + customer.getCity() + ")");
		String city = stringToNull();

		System.out.println("Telefon nr: (" + customer.getPhoneNr() + ")");
		String phoneNr = stringToNull();

		System.out.println("E-mail: (" + customer.getEmail() + ")");
		String email = stringToNull();

		System.out.println("Billede ID:");
		String pictureID = stringToNull();

		int id = customer.getId();
		String company = null;
		String cvrNr = null;

		CustomerCtr customerCtr = new CustomerCtr();
		customerCtr.updateCustomer(id, name, phoneNr, street, email, city, postCode, pictureID, company, cvrNr);		
	}


	/**
	 * removePerson - Used to remove a person from the Customer object
	 * @param customer
	 */
	private void removeCustomer(Customer customer) {
		String name = selectedCustomer.getName();
		if(confirm("Ønsker du at slette " + name + "? ") ){
			int id = customer.getId();
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.removeCustomer(id);
			System.out.println(name + " blev slettet");
			pause();
		} else{
			System.out.println(name + "blev ikke slettet");
			pause();
		}
	}


	/**
	 * findEmployee - Find an employee or administrator in the system
	 * @return Employee
	 */
	public Employee findEmployee(){	
		Employee retE = null;
		System.out.println("\n## Søg medarbejder ##");
		String nameOrEmpNr = requestString("Indtast del af medarbejder navn eller nummer", 1, null, false);
		EmployeeCtr eCtr = new EmployeeCtr();
		ArrayList<Employee> employees = eCtr.searchEmployee(nameOrEmpNr);
		if(employees.size() > 0){
			System.out.println(employees.size() + " medarbejder(e) fundet");
			for(Employee e : employees){
				System.out.println("ID: " + e.getId() + ", Navn: " + e.getName() + ", Gade: " + e.getStreet() + ", PostNummer: " + e.getPostCode() + ", By: " + e.getCity() + ", Tlf nr: " + e.getPhoneNr());
			}

			boolean recheck = false;
			while(!recheck){	
				if(employees.size() > 1){
					int id = requestInt("Indtast medarbejder ID for den ønskede medarbejder", null, false);
					int i = 0;
					while(retE == null && i < employees.size()){
						Employee e = employees.get(i);
						if(id == e.getId()){
							System.out.println("Valgt - Navn: " + e.getName() + ", medarbejdernr: " + e.getEmployeeNr());
							pause();
							retE = eCtr.findEmployee(id);
							selectedEmployee = retE;
							recheck = true;
						}
						i++;
					}
				} else if(employees.size() == 1){
					retE = employees.get(0);
					selectedEmployee = retE;
					System.out.println("Valgt - Navn: " + retE.getName() + ", medarbejdernr: " + retE.getEmployeeNr());
					recheck = true;					
				}
			}// while
		} else{
			System.out.println("0 Medarbejdere Fundet");
			pause();
		}
		return retE;
	}





	/**
	 * Update Employee - Update the information about an employee or administrator
	 * @param employee
	 */
	private void updateEmployee(Employee employee) {
		System.out.println("## Opdater medarbejder ##");
		System.out.println("Skriv ny info ellers tryk enter");

		System.out.println("Medarbejder nr: (" + employee.getEmployeeNr() + ")");
		String employeeNr = stringToNull();

		System.out.println("Navn: (" + employee.getName() + ")" );
		String name = stringToNull();

		System.out.println("Gade: (" + employee.getStreet() + ")");
		String street = stringToNull();

		System.out.println("Postnummer: (" + employee.getStreet() + ")");
		String postCode = stringToNull();

		System.out.println("By: (" + employee.getCity() + ")");
		String city = stringToNull();

		System.out.println("Telefon nr: (" + employee.getPhoneNr() + ")");
		String phoneNr = stringToNull();

		System.out.println("E-mail: (" + employee.getEmail() + ")");
		String email = stringToNull();

		boolean rights = false;
		if(admin){
			if(confirm("Vil du give denne bruger administrator rettigheder") ){
				rights = true;
			}
		}
		int id = employee.getId();

		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.updateEmployee(id, employeeNr, name, phoneNr, street, email, city, postCode, rights);	
	}

	/**
	 * removeEmployee - Used to remove an employee from the Employee object
	 * @param employee
	 */
	private void removeEmployee(Employee employee) {
		String name = selectedEmployee.getName();
		if(confirm("Ønsker du at slette " + name + "? ") ){			
			EmployeeCtr eCtr = new EmployeeCtr();
			eCtr.removeEmployee(employee);
			System.out.println(name + " blev slettet");
			pause();
		} else{
			System.out.println(name + "blev ikke slettet");
			pause();
		}
	}

}