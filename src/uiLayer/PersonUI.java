package uiLayer;

import java.util.ArrayList;
import personLayer.Business;
import personLayer.Customer;
import personLayer.Employee;
import personLayer.Private;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI{

	private Private selectedPrivate;
	private Business selectedBusiness;

	public PersonUI(String DryRun){
		selectedPrivate = null;
		selectedBusiness = null;
	}

	public PersonUI(){
		selectedPrivate = null;
		selectedBusiness = null;
		boolean exit = false;
		while(!exit){

			int choice = writeMenu();
			if(admin){ // Admin access only
				if(choice == 4){

				} else if(choice == 8){

				} else if(choice == 9){

				} else if(choice == 10){

				} else if(choice == 11){

				} else if(choice == 12){

				} else if(choice == 13){

				}
			} // Access for both Admin and Seller
			if(choice == 1){
				findCustomer();
			} else if(choice == 2){
				createPrivate();
			} else if(choice == 3){
				findBusiness();
			} else if(choice == 5){
				createSeller();
			} else if(choice == 6){
				createAdministrator();
			} else if(choice == 7){
				findEmployee();
			} else if(choice == 14){
				exit = true;
			}
		}		
	}


	private int writeMenu(){
		int choice = 0;
		String pB = selectedBusiness != null ? " (" + selectedBusiness.getCompany() + ")" : ""; 
		String pP = selectedPrivate != null ? " (" + selectedPrivate.getName() + ")" : "";  

		System.out.println("\n## Person menu ##");
		System.out.println(" 1. Søg privatkunde");
		System.out.println(" 2. Opret privatkunde");
		System.out.println(" 3. Opdater privatkunde" + pP);
		if(admin){ 
			System.out.println(" 4. Slet privatkunde" + pP); 
		}
		System.out.println("--------------------------");
		System.out.println(" 5. Søg erhvervskunde");
		System.out.println(" 6. Opret erhvervskunde");
		System.out.println(" 7. Opdater erhvervskunde" + pB);
		if(admin){
			System.out.println(" 8. Slet erhvervskunde" + pB);
		}
		System.out.println("--------------------------");
		if(admin){
			System.out.println(" 9. Opret sælger");
			System.out.println(" 10. Opret administrator");
		}
		System.out.println(" 11. Søg medarbejder (sælger eller administrator)");
		if(admin){
			System.out.println(" 12. Opdater sælger");
			System.out.println(" 13. Opdater administrator");
		}
		System.out.println("--------------------------");
		System.out.println(" 14. Gå tilbage");

		choice = requestInt("\nValg", 0, false);
		return choice;
	}


	/**
	 * createPrivate - Create privat customer
	 */
	public Private createPrivate() {
		Private returnPrivate = null;
		System.out.println("\n## Opret privat kunde ##");

		String name 		= requestString("Navn", null, null, false);
		String street 		= requestString("Gade", null, null, false);
		String postCode 	= requestString("Postnummer", null, null, false);
		String city 		= requestString("By", null, null, false);
		String phoneNr 		= requestString("Telefon nr", null, null, false);
		String email 		= requestString("E-mail", null, null, false);
		String cprNr 		= requestString("CPR nr", null, null, false);
		String pictureId 	= requestString("Billede ID", null, null, false);

		CustomerCtr customerCtr = new CustomerCtr();
		returnPrivate = customerCtr.createPrivateCustomer(name, phoneNr, street, email, city, postCode, cprNr, pictureId);

		return returnPrivate;
	}

	/**
	 * createBusiness - Create business customer
	 */
	public Business createBusiness() {
		Business returnBusiness = null;

		System.out.println("\n## Opret erhvervs kunde ##");			
		String company 	= requestString("Virksomhedsnavn", null, null, false);
		String street	= requestString("Gade", null, null, false);
		String postCode = requestString("Postnummer", null, null, false);
		String city 	= requestString("By", null, null, false);
		String phoneNr 	= requestString("Telefon nr", null, null, false);
		String email 	= requestString("E-mail", null, null, false);
		String cvrNr 	= requestString("CVR nr", null, null, false);
		String name 	= requestString("Kontakt person", null, null, false);

		CustomerCtr customerCtr = new CustomerCtr();
		returnBusiness = customerCtr.createBusinessCustomer(name, phoneNr, street, email, city, postCode, company, cvrNr);

		return returnBusiness;
	}

	/**
	 * createSeller - Create a seller
	 */
	public void createSeller() {
		System.out.println("\n## Opret sælger ##");
		String employeeNr 	= requestString("Medarbejder nummer", null, null, false);
		String name			= requestString("Navn", null, null, false);
		String street		= requestString("Gade", null, null, false);
		String postCode		= requestString("Postnummer", null, null, false);
		String city			= requestString("By", null, null, false);
		String phoneNr		= requestString("Telefon nr", null, null, false);
		String email		= requestString("E-mail", null, null, false);
		String cprNr		= requestString("CPR nr", null, null, false);

		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, null, false);
	}


	/**
	 * createAdministrator - Create the administrator
	 */
	public void createAdministrator() {
		System.out.println("\n## Opret administrator ##");
		String employeeNr 	= requestString("Medarbejder nummer", null, null, false);
		String name			= requestString("Navn", null, null, false);
		String street		= requestString("Gade", null, null, false);
		String postCode		= requestString("Postnummer", null, null, false);
		String city			= requestString("By", null, null, false);
		String phoneNr		= requestString("Telefon nr", null, null, false);
		String email		= requestString("E-mail", null, null, false);
		String cprNr		= requestString("CPR nr", null, null, false);
		String password		= requestString("Kode", null, null, false);
		Boolean admin		= true;

		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, password, admin);
	}

	/**
	 * findCustomer - Find a customer in the system by the name or phone number
	 */
	public Private findCustomer() {
		Private returnPrivate = null;
		System.out.println("\n## Søg privatkunde ##");
		String nameOrPhone = requestString("Indtast kundenavn eller tlf nr.", 1, null, false);
		CustomerCtr cCtr = new CustomerCtr();
		ArrayList<Customer> customers = cCtr.searchCustomer(nameOrPhone);
		if(customers.size() > 0){
			System.out.println(customers.size() + " Kunde(r) fundet");
			for(Customer c : customers){
				System.out.println("ID: " + c.getId() + ", Navn: " + c.getName() + ", Gade: " + c.getStreet() + ", PostNummer: " + c.getPostCode() + ", By: " + c.getCity() + ", Tlf nr: " + c.getPhoneNr());
			}
			boolean recheck = false;
			while(!recheck){
				if(customers.size() > 1){
					int id = requestInt("Indtast kunde ID for den ønskede kunde", null, false);
					int i = 0;
					while(returnPrivate == null && i < customers.size()){
						Customer c = customers.get(i); 
						if(c instanceof Private && id == c.getId()){
							System.out.println(c.getName() + " valgt.");
							//updateCustomerMenu(c);
							pause();
							selectedPrivate = (Private) c;
							returnPrivate = (Private) c;
							recheck = true;
						}
					}


				} else if(customers.size() == 1){
					if(customers.get(0) instanceof Private){
						returnPrivate = (Private) customers.get(0);
						selectedPrivate = returnPrivate;
						System.out.println(returnPrivate.getName() + " valgt.");
						//updateCustomerMenu(returnPrivate);
						recheck = true;			
					}else{

					}
				}
			}
		} else{
			System.out.println("0 Privatkunder Fundet");
			pause();
		}
		return returnPrivate;
	}

	/**
	 * findCustomerMenu
	 * @return choice
	 */
	private int findCustomerMenu(){
		int choice = 0;
		System.out.println("\n## Menu ##");
		System.out.println("1. Opdater kunde");
		System.out.println("2. Fjern kunde");
		System.out.println("3. Tilbage til kundemenu");
		choice = requestInt("Valg ", 0, false);
		return choice;
	}

	/**
	 * updateCustomerMenu
	 * @param customer
	 */
	public void updateCustomerMenu(Customer customer){
		boolean exit = false;
		while(!exit){
			int choice = findCustomerMenu();
			if(choice == 1){
				updatePrivate(customer);
			} else if(choice == 2){
				removePerson(customer);
				exit = true;
			} else if(choice == 3){
				exit = true;
			}	
		}		
	}

	/**
	 * updatePrivate - Udates a privat customer
	 * @param customer
	 */
	public void updatePrivate(Customer customer) {

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
	private void removePerson(Customer customer) {
		if(confirm("Ønsker du at slette: ") ){
			int id = customer.getId();
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.removeCustomer(id);
			System.out.println("Personen er nu slettet");
			pause();
		} else{
			System.out.println("Personen er ikke slettet");
			pause();
		}
	}

	/**
	 * findBusiness - Search for a business customer
	 */
	public void findBusiness(){

		System.out.println("\n## Søg erhvervskunde ##");
		String comp = requestString("Indtast del af virksomhedsnavnet", 1, null, false);
		CustomerCtr cCtr = new CustomerCtr();
		ArrayList<Customer> busCusts = cCtr.searchBusiness(comp);
		if(busCusts.size() > 0){
			String printComp = (busCusts.size() == 1) ? " virksomhed" : " virksomheder"; 
			System.out.println(busCusts.size() + printComp + " fundet");
			for(Customer c : busCusts){
				if(c instanceof Business){
					System.out.println("ID: " + c.getId() + ", Navn: " + ((Business) c).getCompany() + ", Tlf nr.: " + c.getPhoneNr() + ", CVR-nr: " + ((Business) c).getCvrNr());
				} 
			}

			boolean recheck = false;
			while(!recheck){
				if(busCusts.size() > 1){
					int id = requestInt("Indtast virksomhedens ID", null, false);
					for(Customer c : busCusts){
						if(id == c.getId()){
							System.out.println("ID: " + c.getId() + ", Navn: " + ((Business) c).getCompany() + "Tlf nr.: " + c.getPhoneNr() + ", CVR-nr: " + ((Business) c).getCvrNr());
							updateCustomerMenu(c);
							pause();
							recheck = true;
						}
					}
				} else if(busCusts.size() == 1){
					Customer found = busCusts.get(0);				
					updateCustomerMenu(found);
					recheck = true;
				}
			}
		}else{
			System.out.println("0 virksomheder fundet");
			pause();
			return;
		}
	}

	public void updateBusiness() {
		// TODO Auto-generated method stub
	}



	public void findEmployee(){	
		System.out.println("\n## Søg medarbejder ##");
		String nameOrEmpNr = requestString("Indtast medarbejder navn eller medarbejder nr", null, null, false);

		EmployeeCtr employeeCtr = new EmployeeCtr();
		ArrayList<Employee> employees = employeeCtr.searchEmployee(nameOrEmpNr);
		if(employees.size() > 0){
			System.out.println(employees.size() + " medarbejder fundet");
			for(Employee e : employees){
				System.out.println("ID: " + e.getId() + ", Navn: " + e.getName() + ", Gade: " + e.getStreet() + ", PostNummer: " + e.getPostCode() + ", By: " + e.getCity() + ", Tlf nr: " + e.getPhoneNr());
			}


			boolean recheck = false;
			while(!recheck){
				if(employees.size() > 1){
					int id = requestInt("Indtast medarbejder ID for den ønskede medarbejder", null, false);
					for(Employee e : employees){
						if(id == e.getId()){
							System.out.println("Navn: " + e.getName() + ", Gade: " + e.getStreet() + ", PostNummer: " + e.getPostCode() + ", By: " + e.getCity() + ", Tlf nr: " + e.getPhoneNr());
							updateEmployeeMenu(e);
							pause();
							recheck = true;
						}
					}
				} else if(employees.size() == 1){
					Employee found = employees.get(0);				
					updateEmployeeMenu(found);
					recheck = true;					}
			}
		}else{
			System.out.println("0 Medarbejdere Fundet");
			pause();
			return;
		}
	}


	public void updateEmployeeMenu(Employee employee){
		boolean exit = false;
		boolean admin = employee.getAdmin();
		while(!exit){
			int choice = findEmployeeMenu();
			if(choice == 1 && !admin){
				updateSeller(employee);
			} else if(choice == 1 && admin){
				updateAdministrator(employee);
			} else if(choice == 2){
				removeEmployee(employee);
				exit = true;
			} else if(choice == 3){
				exit = true;
			}
		}
	}

	private int findEmployeeMenu(){
		int choice = 0;
		System.out.println("\n## Menu ##");
		System.out.println("1. Opdater medarbejder");
		System.out.println("2. Fjern medarbejder");
		System.out.println("3. Tilbage til medarbejdermenu");
		choice = requestInt("Valg", 0, false);
		return choice;
	}

	/**
	 * updateAdministrator
	 * @param employee
	 */
	private void updateAdministrator(Employee employee) {
		System.out.println("\n## Opdater admin ##");
		boolean admin = true;
		updateEmployee(employee, admin);		
	}

	/**
	 * updateSeller
	 * @param employee
	 */
	private void updateSeller(Employee employee){
		System.out.println("\n## Opdater medarbejder ##");
		boolean admin = false;
		updateEmployee(employee, admin);		
	}

	/**
	 * Update Empluyee
	 * @param employee
	 * @param admin
	 */
	private void updateEmployee(Employee employee, boolean admin) {
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

		int id = employee.getId();

		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.updateEmployee(id, employeeNr, name, phoneNr, street, email, city, postCode, admin);	
	}

	/**
	 * removeEmployee - Used to remove an employee from the Employee object
	 * @param Employee
	 */
	private void removeEmployee(Employee employee) {
		if(confirm("Ønsker du at slette: ") ){
			EmployeeCtr employeeCtr = new EmployeeCtr();
			employeeCtr.removeEmployee(employee);
			System.out.println("Personen er nu slettet");
			pause();
		} else{
			System.out.println("Personen er ikke slettet");
			pause();
		}
	}

}