package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

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
				
			} else if(choice == 6){
				
			} else if(choice == 7){
				
			} else if(choice == 8){
				
			} else if(choice == 9){
				
			} else if(choice == 10){
				
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
			System.out.println(" 4. Opret s¾lger");
			System.out.println(" 5. Opret administrator");
			System.out.println(" 6. Opdater privat kunde");
			System.out.println(" 7. Opdater erhvervs kunde");
			System.out.println(" 8. Opdater s¾lger");
			System.out.println(" 9. Opdater administrator");
			System.out.println("10. Slet Person");
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
		 	String street 		= requestString("Vej navn", null, null);
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
			String street	= requestString("Vej navn", null, null);
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
			String street		= requestString("Vej navn", null, null);
			String postCode		= requestString("Postnummer", null, null);
			String city			= requestString("By", null, null);
			String phoneNr		= requestString("Telefon nr", null, null);
			String email		= requestString("E-mail", null, null);
			String cprNr		= requestString("CPR nr", null, null);
			
			EmployeeCtr employeeCtr = new EmployeeCtr();
			employeeCtr.createSeller(employeeNr, name, phoneNr, street, email, city, postCode, cprNr);
			
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
			String street		= requestString("Vej navn", null, null);
			String postCode		= requestString("Postnummer", null, null);
			String city			= requestString("By", null, null);
			String phoneNr		= requestString("Telefon nr", null, null);
			String email		= requestString("E-mail", null, null);
			String cprNr		= requestString("CPR nr", null, null);
			
			EmployeeCtr employeeCtr = new EmployeeCtr();
			employeeCtr.createAdministrator(employeeNr, name, phoneNr, street, email, city, postCode, cprNr);
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}

	public void findCustomer() {
		try{
			System.out.println("## Find kunde ##");
			System.out.print("Indtast kunde navn eller telefon nr: ");
			Scanner k = new Scanner(System.in);
			String find = k.nextLine();
			
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.findCustomer(find);
			
			if(customerCtr.findCustomer(find) == null){
				System.out.println("Kunden blev ikke fundet");
				pause();
			}
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
	}
	
	public void updatePrivate() {
//		try{
//			System.out.println("## Opdater privat kunde ##");
//			
//			CustomerCtr customerCtr = new CustomerCtr();
//			customerCtr.
//		} catch(InputMismatchException e){
//			System.out.println("Forkert input!");
//		}
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

	private void removePerson() {
		// TODO Auto-generated method stub
		
	}

}