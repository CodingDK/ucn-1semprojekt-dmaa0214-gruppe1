package uiLayer;

import java.util.ArrayList;

import personLayer.Business;
import personLayer.Customer;
import personLayer.Employee;
import personLayer.Private;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI {
	
	private Customer selectedCustomer;
	private Employee selectedEmployee;
	
	public PersonUI(String DryRun) {
		selectedCustomer = null;
		selectedEmployee = null;
	}
	
	public PersonUI() {
		selectedCustomer = null;
		selectedEmployee = null;
		
		menu();
	}
	
	/**
	 * menu - Handels the selection part of the UI
	 */
	private void menu() {
		boolean exit = false;
		while (!exit) {
			
			int choice = writeMenu();
			if (admin) { 						// Admin access only
				if (choice == 7) {		//Opdate medarbejder
					if (selectedEmployee == null) {
						findEmployee();
					}
					if (selectedEmployee != null) {
						updateEmployee();
					}
				} else if (choice == 8) {		//Slet medarbejder
					if (selectedEmployee == null) {
						findEmployee();
					}
					if (selectedEmployee != null) {
						removeEmployee();
					}
				} else if (choice == 5) {		//Opret medarbejder
					createEmployee();
				} else if (choice == 6) {		//Søg medarbejder
					findEmployee();
				}
			} 							// Access for both Admin and Seller
			if (choice == 1) {			//Søg kunde
				findCustomer();
			} else if (choice == 2) {		//Opret kunde
				createCustomer();
			} else if (choice == 3) {		//Opdater kunde
				if (selectedCustomer == null) {
					findCustomer();
				}
				if (selectedCustomer != null) {
					updateCustomer();
				}
			} else if (choice == 4) {			//Slet kunde
				if (selectedCustomer == null) {
					findCustomer();
				}
				if (selectedCustomer != null) {
					removeCustomer();
				}
			} else if (choice == 9) {	//Gå tilbage
				exit = true;
			}
		}
	}
	
	/**
	 * writeMenu - Write the Person menu and get a choice.
	 * 
	 * @return The choice by the user.
	 */
	private int writeMenu() {
		int choice = 0;
		String pP = selectedCustomer != null ? " (" + selectedCustomer.getName() + ")" : "";
		String m = selectedEmployee != null ? " (" + selectedEmployee.getName() + ")" : "";
		
		flush();
		System.out.println("## Person menu ##");
		System.out.println("1. Søg kunde");
		System.out.println("2. Opret kunde");
		System.out.println("3. Opdater kunde" + pP);
		System.out.println("4. Slet kunde" + pP);
		if (admin) {
			System.out.println("--------------------------");
			System.out.println("5. Opret medarbejder");
			System.out.println("6. Søg medarbejder");
			System.out.println("7. Opdater medarbejder" + m);
			System.out.println("8. Slet medarbejder" + m);
		}
		System.out.println("--------------------------");
		System.out.println("9. Gå tilbage");
		choice = requestInt(nL + "Valg", 0, false);
		return choice;
	}
	
	/**
	 * createCustomer - Create a private or business customer
	 * 
	 * @return Customer
	 */
	public Customer createCustomer() {
		Customer retC = null;
		boolean exit = false;
		CustomerCtr cCtr = new CustomerCtr();
		
		while (!exit) {
			flush();
			System.out.println("## Opret kunde ##");
			System.out.println("1. Erhvervskunde");
			System.out.println("2. Privatkunde");
			System.out.println("3. Gå tilbage");
			
			int choice = requestInt("Valg", null, false);
			
			if (choice == 1 || choice == 2) {
				String company = null;
				String cvrNr = null;
				System.out.println();
				if (choice == 1) {
					company = requestString("Virksomheds navn", 2, 30, false);
					cvrNr = requestString("CVR-nr", 8, 15, false);
				}
				String name = requestString("Navn", 2, 100, false);
				String street = requestString("Gade", 5, 100, false);
				String postCode = requestString("Postnummer", 4, 15, false);
				String city = requestString("By", 1, 25, false);
				String phoneNr = requestString("Telefon nr", 8, 12, false);
				String email = requestString("E-mail", 5, 50, false);
				if (choice == 2) {
					String cprNr = requestString("CPR nr", 10, 15, false);
					String pictureId = requestString("Billede ID", null, null, false);
					retC = cCtr.createPrivateCustomer(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
					exit = true;
				}
				retC = cCtr.createBusinessCustomer(name, phoneNr, street, email, city, postCode, company, cvrNr);
				selectedCustomer = retC;
				exit = true;
			} else if (choice == 3) {
				exit = true;
			}
		}
		return retC;
	}
	
	/**
	 * createEmployee - Create a seller or administrator
	 */
	private void createEmployee() {
		boolean rights = false;
		flush();
		System.out.println("## Opret sælger ##");
		String employeeNr = requestString("Medarbejder nummer", 1, 25, false);
		String name = requestString("Navn", 2, 100, false);
		String street = requestString("Gade", 5, 100, false);
		String postCode = requestString("Postnummer", 4, 15, false);
		String city = requestString("By", 1, 25, false);
		String phoneNr = requestString("Telefon nr", 8, 12, false);
		String email = requestString("E-mail", 5, 50, false);
		String cprNr = requestString("CPR nr", 10, 15, false);
		
		if (confirm("Vil du give denne medarbejder administrator rettigheder")) {
			rights = true;
		}
		
		EmployeeCtr employeeCtr = new EmployeeCtr();
		selectedEmployee = employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, null, rights);
	}
	
	/**
	 * findCustomer - Find a customer in the system by the name, company or phone number
	 * 
	 * @return Customer
	 */
	public Customer findCustomer() {
		Customer retC = null;
		flush();
		System.out.println("## Søg kunde ##");
		String nameOrPhone = requestString("Indtast kundenavn, virksomhedsnavn eller tlf nr.", 1, 50, false);
		CustomerCtr cCtr = new CustomerCtr();
		ArrayList<Customer> customers = cCtr.searchCustomer(nameOrPhone);
		if (customers.size() > 0) {
			System.out.println(customers.size() + " Kunde(r) fundet");
			for (Customer c : customers) {
				if (c instanceof Private) {
					System.out.println("ID: " + c.getId() + "\tNavn: " + c.getName() + "\tGade: " + c.getStreet() + "\tPostNummer: " + c.getPostCode() + "\tBy: " + c.getCity() + "\tTlf nr: " + c.getPhoneNr());
				} else if (c instanceof Business) {
					Business b = (Business) c;
					System.out.println("ID: " + b.getId() + "\tVirksomhed: " + b.getCompany() + "\tCVR-nr: " + b.getCvrNr() + "\tPostNummer: " + b.getPostCode() + "\tBy: " + b.getCity() + "\tKontakt: " + b.getName() + "\tTlf. nr.: " + b.getPhoneNr());
				}
			}
			boolean recheck = false;
			while (!recheck) {
				int i = 0;
				if (customers.size() > 1) {
					int id = requestInt("Indtast ID for den ønskede kunde", null, false);
					while (retC == null && i < customers.size()) {
						Customer c = customers.get(i);
						if (id == c.getId()) {
							if (c instanceof Business) {
								Business b = (Business) c;
								System.out.println("Valgt - Virksomhed: " + b.getCompany() + ", tlf: " + b.getPhoneNr());
							} else {
								System.out.println("Valgt - Navn: " + c.getName() + ", tlf: " + c.getPhoneNr());
							}
							pause();
							selectedCustomer = c;
							retC = c;
							recheck = true;
						}
						i++;
					}
				} else if (customers.size() == 1) {
					retC = customers.get(0);
					selectedCustomer = retC;
					if (retC instanceof Business) {
						Business b = (Business) retC;
						System.out.println("Valgt - Virksomhed: " + b.getCompany() + ", tlf: " + b.getPhoneNr());
					} else {
						System.out.println("Valgt - Navn: " + retC.getName() + ", tlf: " + retC.getPhoneNr());
					}
					recheck = true;
				}
			}
			pause();
		} else {
			System.out.println("0 Kunder Fundet");
			pause();
		}
		return retC;
	}
	
	/**
	 * updateCustomer - Updates a Customer
	 */
	public void updateCustomer() {
		if (selectedCustomer != null) {
			flush();
			System.out.println("## Opdater kunde ##");
			System.out.println("Skriv ny info ellers tryk enter");
			
			System.out.println("Navn: (" + selectedCustomer.getName() + ")");
			String name = stringToNull();
			
			System.out.println("Gade: (" + selectedCustomer.getStreet() + ")");
			String street = stringToNull();
			
			System.out.println("Postnummer: (" + selectedCustomer.getStreet() + ")");
			String postCode = stringToNull();
			
			System.out.println("By: (" + selectedCustomer.getCity() + ")");
			String city = stringToNull();
			
			System.out.println("Telefon nr: (" + selectedCustomer.getPhoneNr() + ")");
			String phoneNr = stringToNull();
			
			System.out.println("E-mail: (" + selectedCustomer.getEmail() + ")");
			String email = stringToNull();
			
			System.out.println("Billede ID:");
			String pictureID = stringToNull();
			
			int id = selectedCustomer.getId();
			String company = null;
			String cvrNr = null;
			
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.updateCustomer(id, name, phoneNr, street, email, city, postCode, pictureID, company, cvrNr);
		}
	}
	
	/**
	 * removeCustomer - Used to remove a Customer from the Container
	 */
	private void removeCustomer() {
		String name = selectedCustomer.getName();
		flush();
		if (confirm("Ønsker du at slette " + name + "? ")) {
			int id = selectedCustomer.getId();
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.removeCustomer(id);
			System.out.println(name + " blev slettet");
			selectedCustomer = null;
			pause();
		} else {
			System.out.println(name + "blev ikke slettet");
			pause();
		}
	}
	
	/**
	 * findEmployee - Find an employee or administrator in the system
	 * 
	 * @return Employee
	 */
	public Employee findEmployee() {
		Employee retE = null;
		flush();
		System.out.println("## Søg medarbejder ##");
		String nameOrEmpNr = requestString("Indtast del af medarbejder navn eller nummer", 1, 50, false);
		EmployeeCtr eCtr = new EmployeeCtr();
		ArrayList<Employee> employees = eCtr.searchEmployee(nameOrEmpNr);
		if (employees.size() > 0) {
			System.out.println(employees.size() + " medarbejder(e) fundet");
			for (Employee e : employees) {
				System.out.println("ID: " + e.getId() + ", Navn: " + e.getName() + ", Gade: " + e.getStreet() + ", PostNummer: " + e.getPostCode() + ", By: " + e.getCity() + ", Tlf nr: " + e.getPhoneNr());
			}
			
			boolean recheck = false;
			while (!recheck) {
				if (employees.size() > 1) {
					int id = requestInt("Indtast medarbejder ID for den ønskede medarbejder", null, false);
					int i = 0;
					while (retE == null && i < employees.size()) {
						Employee e = employees.get(i);
						if (id == e.getId()) {
							System.out.println("Valgt - Navn: " + e.getName() + ", medarbejdernr: " + e.getEmployeeNr());
							pause();
							retE = e;
							selectedEmployee = retE;
							recheck = true;
						}
						i++;
					}
				} else if (employees.size() == 1) {
					retE = employees.get(0);
					selectedEmployee = retE;
					System.out.println("Valgt - Navn: " + retE.getName() + ", medarbejdernr: " + retE.getEmployeeNr());
					recheck = true;
					pause();
				}
			}// while
		} else {
			System.out.println("0 Medarbejdere Fundet");
			pause();
		}
		return retE;
	}
	
	/**
	 * updateEmployee - Update the information about a seller or administrator
	 */
	private void updateEmployee() {
		System.out.println("## Opdater medarbejder ##");
		System.out.println("Skriv ny info ellers tryk enter");
		
		System.out.println("Medarbejder nr: (" + selectedEmployee.getEmployeeNr() + ")");
		String employeeNr = stringToNull();
		
		System.out.println("Navn: (" + selectedEmployee.getName() + ")");
		String name = stringToNull();
		
		System.out.println("Gade: (" + selectedEmployee.getStreet() + ")");
		String street = stringToNull();
		
		System.out.println("Postnummer: (" + selectedEmployee.getStreet() + ")");
		String postCode = stringToNull();
		
		System.out.println("By: (" + selectedEmployee.getCity() + ")");
		String city = stringToNull();
		
		System.out.println("Telefon nr: (" + selectedEmployee.getPhoneNr() + ")");
		String phoneNr = stringToNull();
		
		System.out.println("E-mail: (" + selectedEmployee.getEmail() + ")");
		String email = stringToNull();
		
		boolean rights = false;
		if (admin) {
			if (confirm("Vil du give denne bruger administrator rettigheder")) {
				rights = true;
			}
		}
		int id = selectedEmployee.getId();
		
		EmployeeCtr employeeCtr = new EmployeeCtr();
		employeeCtr.updateEmployee(id, employeeNr, name, phoneNr, street, email, city, postCode, rights);
	}
	
	/**
	 * removeEmployee - Used to remove an Employee object from the Container
	 */
	private void removeEmployee() {
		String name = selectedEmployee.getName();
		if (confirm("Ønsker du at slette " + name + "? ")) {
			EmployeeCtr eCtr = new EmployeeCtr();
			eCtr.removeEmployee(selectedEmployee);
			System.out.println(name + " blev slettet");
			selectedEmployee = null;
			pause();
		} else {
			System.out.println(name + " blev ikke slettet");
			pause();
		}
	}
	
}
