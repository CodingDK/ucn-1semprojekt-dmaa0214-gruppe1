package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import personLayer.Customer;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;

public class PersonUI extends SuperUI{

	
	public PersonUI(){
	
		boolean exit = false;
		while(!exit){
			
			int choice = writeMenu();
			if(choice == 1){
				findCustomer();
			} else if(choice == 2){
				createPrivate();
			} else if(choice == 3){
				createBusiness();
			} else if(choice == 4){
				createSeller();
			} else if(choice == 5){
				
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
			System.out.println(" 1. Find kunde");
			System.out.println(" 2. Opret privat kunde");
			System.out.println(" 3. Opret erhvervs kunde");
			System.out.println(" 4. Opret sælger");
			System.out.println(" 5. Opret administrator");
			System.out.println(" 7. Opdater erhvervs kunde");
			System.out.println(" 8. Opdater sælger");
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
			
		 	String name 		= requestString("Navn", null, null);
		 	String street 		= requestString("Gade", null, null);
		 	String postCode 	= requestString("Postnummer", null, null);
		 	String city 		= requestString("By", null, null);
		 	String phoneNr 		= requestString("Telefon nr", null, null);
		 	String email 		= requestString("E-mail", null, null);
		 	String cprNr 		= requestString("CPR nr", null, null);
		 	String pictureId 	= requestString("Billede ID", null, null);
			
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
			String company 	= requestString("Virksomhedsnavn", null, null);
			String street	= requestString("Gade", null, null);
			String postCode = requestString("Postnummer", null, null);
			String city 	= requestString("By", null, null);
			String phoneNr 	= requestString("Telefon nr", null, null);
			String email 	= requestString("E-mail", null, null);
			String cvrNr 	= requestString("CVR nr", null, null);
			String name 	= requestString("Kontakt person", null, null);
			
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
			String employeeNr 	= requestString("Medarbejder nummer", null, null);
			String name			= requestString("Navn", null, null);
			String street		= requestString("Gade", null, null);
			String postCode		= requestString("Postnummer", null, null);
			String city			= requestString("By", null, null);
			String phoneNr		= requestString("Telefon nr", null, null);
			String email		= requestString("E-mail", null, null);
			String cprNr		= requestString("CPR nr", null, null);
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
			String employeeNr 	= requestString("Medarbejder nummer", null, null);
			String name			= requestString("Navn", null, null);
			String street		= requestString("Gade", null, null);
			String postCode		= requestString("Postnummer", null, null);
			String city			= requestString("By", null, null);
			String phoneNr		= requestString("Telefon nr", null, null);
			String email		= requestString("E-mail", null, null);
			String cprNr		= requestString("CPR nr", null, null);
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
	public void findCustomer() {
		System.out.println("## Find kunde ##");
		System.out.print("Indtast kunde navn eller telefon nr: ");
		Scanner k = new Scanner(System.in);
		String nameOrPhone = k.nextLine();
			
		CustomerCtr customerCtr = new CustomerCtr();
		Customer customer = customerCtr.findCustomer(nameOrPhone);
			
		if(customer == null){
			System.out.println("Kunden er ikke fundet");
			pause();
		} else {
			System.out.println("--- Kunde info ---");
			System.out.println("Kunde ID  : " + customer.getId());
			System.out.println("Navn	  : " + customer.getName());
			System.out.println("Gade	  : " + customer.getStreet());
			System.out.println("Postnummer: " + customer.getPostCode());
			System.out.println("By	  : " + customer.getCity());
			System.out.println("Telefon nr: " + customer.getPhoneNr());
			pause();
			updateCustomerMenu(customer);
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