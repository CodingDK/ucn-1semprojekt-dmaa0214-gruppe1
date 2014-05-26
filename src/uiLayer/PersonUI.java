package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import ctrLayer.CustomerCtr;

public class PersonUI extends SuperUI{
	
	public PersonUI(){
	
		boolean exit = false;
		while(!exit){
			
			int choice = writeMenu();
			if(choice == 1){
				createPrivate();
			}
			if(choice ==2){
				createBusiness();
			}
		}
		
	}
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("1. Opret privat kunde");
			System.out.println("2. Opret erhvervs kunde");
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
			Scanner k = new Scanner(System.in);
			System.out.println("## Opret privat kunde ##");
			
			System.out.print("Navn: ");
			String name = k.nextLine();			
			
			System.out.print("Vej navn: ");
			String street  = k.nextLine();
			
			System.out.print("Postnummer: ");
			String postCode = k.nextLine();
			
			System.out.print("By: ");
			String city = k.nextLine();
			
			System.out.print("Telefon nr: ");
			String phoneNr = k.nextLine();
			
			System.out.print("E-mail: ");
			String email = k.nextLine();
			
			System.out.print("CPR nr: ");
			String cprNr = k.nextLine();
			
			System.out.print("Billede ID: ");
			String pictureId = k.nextLine();
			
			CustomerCtr customerCtr = new CustomerCtr();
			customerCtr.createPrivateCustomer(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
		}
		catch(InputMismatchException e){
			System.out.println("Forket input!");
		}
		
		
	}


	public void createBusiness() {
		
	}
	
	public void createSeller() {
		// TODO Auto-generated method stub
	}

	public void createSupplier() {
		// TODO Auto-generated method stub
	}

	public void createAdministrator() {
		// TODO Auto-generated method stub
	}

	public void updatePrivate() {
		// TODO Auto-generated method stub
	}

	public void updateBusiness() {
		// TODO Auto-generated method stub
	}

	private void updateSeller() {
		// TODO Auto-generated method stub
		
	}

	private void updateSupplier() {
		// TODO Auto-generated method stub
		
	}

	private void updateAdministrator() {
		// TODO Auto-generated method stub
		
	}

	private void removePerson() {
		// TODO Auto-generated method stub
		
	}

}