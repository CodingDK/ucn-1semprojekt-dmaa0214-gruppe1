package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import personLayer.Business;
import personLayer.Customer;
import personLayer.Employee;
import personLayer.Private;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI{

	public PersonUI(String DryRun){
		
	}
	
	public PersonUI(){
	
		boolean exit = false;
		while(!exit){
			
			int choice = writeMenu();
			if(choice == 1){
				findPrivate();
			} else if(choice == 2){
				createPrivate();
			} else if(choice == 3){
				findBusiness();
			} else if(choice == 4){
				createBusiness();
			} else if(choice == 5){
				createSeller();
			} else if(choice == 6){
				createAdministrator();
			} else if(choice == 7){
				findEmployee();
			} else if(choice == 8){
				
			} else if(choice == 9){
				
			} else if(choice == 10){
				exit = true;
			}	
		}		
	}
	
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("\n## Kunde menu ##");
			System.out.println(" 1. Søg privatkunde");
			System.out.println(" 2. Opret privat kunde");
			System.out.println(" 3. Søg erhvervskunde");
			System.out.println(" 4. Opret erhvervskunde");
			System.out.println(" 5. Opret sælger");
			System.out.println(" 6. Opret administrator");
			System.out.println(" 7. Søg medarbejder (sælger eller administrator)");
			System.out.println(" 8. Opdater sælger");
			System.out.println(" 9. Opdater administrator");
			System.out.println(" 10. Tilbage");
			System.out.print("\nValg: ");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	
	/**
	 * createPrivate - Create privat customer
	 */
	public Private createPrivate() {
		Private returnPrivate = null;

		try{
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

		} catch(InputMismatchException e){
			System.out.println("Forket input!");	
		}	
		return returnPrivate;
	}

	/**
	 * createBusiness - Create business customer
	 */
	public void createBusiness() {
		try{
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
			customerCtr.createBusinessCustomer(name, phoneNr, street, email, city, postCode, company, cvrNr);
		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}		
	}
	
	/**
	 * createSeller - Create a seller
	 */
	public void createSeller() {
		try{
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
			
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}

	
	/**
	 * createAdministrator - Create the administrator
	 */
	public void createAdministrator() {
		try{
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
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}

	/**
	 * findCustomer - Find a customer in the system by the name or phone number
	 */
	public void findPrivate() {
		System.out.println("\n## Søg privatkunde ##");
		String nameOrPhone = requestString("Indtast kundenavn eller tlf nr.", 1, null, false);
		CustomerCtr customerCtr = new CustomerCtr();
		ArrayList<Customer> customers = customerCtr.searchCustomer(nameOrPhone);
		if(customers.size() > 0){
			System.out.println(customers.size() + " Kunder fundet");
			for(Customer c : customers){
				System.out.println("ID: " + c.getId() + ", Navn: " + c.getName() + ", Gade: " + c.getStreet() + ", PostNummer: " + c.getPostCode() + ", By: " + c.getCity() + ", Tlf nr: " + c.getPhoneNr());
			}

			boolean recheck = false;
			while(!recheck){
				if(customers.size() > 1){
					int id = requestInt("Indtast kunde ID for den ønskede kunde", null, false);
					for(Customer c : customers){
						if(id == c.getId()){
							System.out.println("Navn: " + c.getName() + ", Gade: " + c.getStreet() + ", PostNummer: " + c.getPostCode() + ", By: " + c.getCity() + ", Tlf nr: " + c.getPhoneNr());
							updateCustomerMenu(c);
							pause();
							recheck = true;
						}
					}
				} else if(customers.size() == 1){
					Customer found = customers.get(0);				
					updateCustomerMenu(found);
					recheck = true;			
				}
			}
		} else{
			System.out.println("0 Kunder Fundet");
			pause();
		}
	}
		
	/**
	 * findCustomerMenu
	 * @return choice
	 */
	private int findCustomerMenu(){
		int choice = 0;
		try{
			System.out.println("\n## Menu ##");
			System.out.println("1. Opdater kunde");
			System.out.println("2. Fjern kunde");
			System.out.println("3. Tilbage til kundemenu");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
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
		System.out.print("Indtast medarbejder navn eller medarbejder nr: ");
		Scanner k = new Scanner(System.in);
		String nameOrEmpNr = k.nextLine();

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
		try{
			System.out.println("\n## Menu ##");
			System.out.println("1. Opdater medarbejder");
			System.out.println("2. Fjern medarbejder");
			System.out.println("3. Tilbage til medarbejdermenu");
			
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
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
			
		System.out.println("Medarbejder nr: (" + employee.getEmployeeNr());
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