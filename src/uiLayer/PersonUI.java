package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import personLayer.Business;
import personLayer.Customer;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI{

	public PersonUI(String DriveRun){
		
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
				
			} else if(choice == 8){
				
			} else if(choice == 9){
				
			} 			
		}		
	}
	
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("## Kunde menu ##");
			System.out.println(" 1. S¿g privatkunde");
			System.out.println(" 2. Opret privat kunde");
			System.out.println(" 3. S¿g erhvervskunde");
			System.out.println(" 4. Opret erhvervskunde");
			System.out.println(" 5. Opret s¾lger");
			System.out.println(" 6. Opret administrator");
			System.out.println(" 7. Opdater erhvervs kunde");
			System.out.println(" 8. Opdater s¾lger");
			System.out.println(" 9. Opdater administrator");
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
	public void createPrivate() {
		try{
			System.out.println("## Opret privat kunde ##");
			
		 	String name 		= requestString("Navn", null, null, false);
		 	String street 		= requestString("Gade", null, null, false);
		 	String postCode 	= requestString("Postnummer", null, null, false);
		 	String city 		= requestString("By", null, null, false);
		 	String phoneNr 		= requestString("Telefon nr", null, null, false);
		 	String email 		= requestString("E-mail", null, null, false);
		 	String cprNr 		= requestString("CPR nr", null, null, false);
		 	String pictureId 	= requestString("Billede ID", null, null, false);
			
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.createPrivateCustomer(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
		
		} catch(InputMismatchException e){
			System.out.println("Forket input!");
			return;
		}			
	}

	/**
	 * createBusiness - Create business customer
	 */
	public void createBusiness() {
		try{
			System.out.println("## Opret erhvervs kunde ##");			
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
			System.out.println("## Opret s¾lger ##");
			String employeeNr 	= requestString("Medarbejder nummer", null, null, false);
			String name			= requestString("Navn", null, null, false);
			String street		= requestString("Gade", null, null, false);
			String postCode		= requestString("Postnummer", null, null, false);
			String city			= requestString("By", null, null, false);
			String phoneNr		= requestString("Telefon nr", null, null, false);
			String email		= requestString("E-mail", null, null, false);
			String cprNr		= requestString("CPR nr", null, null, false);
			Boolean admin 		= false;
			
			EmployeeCtr employeeCtr = new EmployeeCtr();
			employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, admin);
			
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}

	
	/**
	 * createAdministrator - Create the administrator
	 */
	public void createAdministrator() {
		try{
			System.out.println("## Opret administrator ##");
			String employeeNr 	= requestString("Medarbejder nummer", null, null, false);
			String name			= requestString("Navn", null, null, false);
			String street		= requestString("Gade", null, null, false);
			String postCode		= requestString("Postnummer", null, null, false);
			String city			= requestString("By", null, null, false);
			String phoneNr		= requestString("Telefon nr", null, null, false);
			String email		= requestString("E-mail", null, null, false);
			String cprNr		= requestString("CPR nr", null, null, false);
			Boolean admin		= true;
			
			EmployeeCtr employeeCtr = new EmployeeCtr();
			employeeCtr.createEmployee(employeeNr, name, phoneNr, street, email, city, postCode, cprNr, admin);
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}

	/**
	 * findCustomer - Find a customer in the system by the name or phone number
	 */
	public void findPrivate() {
		System.out.println("## S¿g privatkunde ##");
		System.out.print("Indtast kunde navn eller telefon nr: ");
		Scanner k = new Scanner(System.in);
		String nameOrPhone = k.nextLine();
		
		CustomerCtr customerCtr = new CustomerCtr();
		ArrayList<Customer> customers = customerCtr.searchCustomer(nameOrPhone);
		if(customers != null){
			System.out.println(customers.size() + " Kunder fundet");
			for(Customer c : customers){
				System.out.println("ID: " + c.getId() + ", Navn: " + c.getName() + ", Gade: " + c.getStreet() + ", PostNummer: " + c.getPostCode() + ", By: " + c.getCity() + ", Tlf nr: " + c.getPhoneNr());
			}
		} else{
			System.out.println("0 Kunder Fundet");
			pause();
			return;
		}
		boolean recheck = false;
		while(!recheck){
			if(customers.size() > 1){
				int id = requestInt("Indtast kunde ID for den ¿nskede kunde", null);
				for(Customer c : customers){
					if(id == c.getId()){
						System.out.println("Navn: " + c.getName() + ", Gade: " + c.getStreet() + ", PostNummer: " + c.getPostCode() + ", By: " + c.getCity() + ", Tlf nr: " + c.getPhoneNr());
						updateCustomerMenu(c);
						pause();
						recheck = true;
					}
				}
			} else if(customers.size() == 1){
				updateCustomerMenu(customerCtr.findCustomer(nameOrPhone));
			}
		}
	}
		
	/**
	 * findCustomerMenu
	 * @return choice
	 */
	private int findCustomerMenu(){
		int choice = 0;
		try{
			System.out.println("## Menu ");
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
	 * findBusiness - Search for a business customer
	 */
	public void findBusiness(){
		System.out.println("## S¿g erhvervskunde ##");
		System.out.print("Indtast virksomhedsnavn: ");
		Scanner k = new Scanner(System.in);
		String comp = k.nextLine();
		
		
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
			} else if(choice == 3){
				return;
			}	
		}
	}
	
	/**
	 * updatePrivate - Udates a privat customer
	 * @param customer
	 */
	public void updatePrivate(Customer customer) {
	
		System.out.println("## Opdater privat kunde ##");
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

	public void updateBusiness() {
		// TODO Auto-generated method stub
	}

	private void updateSeller() {
		// TODO Auto-generated method stub
		
	}


	private void updateAdministrator() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * removePerson - Used to remove a person from the Customer object
	 * @param customer
	 */
	private void removePerson(Customer customer) {
		if(confirm("¯nsker du at slette: " + customer.getName() ) ){
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
	
}