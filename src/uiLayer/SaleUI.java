package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelLayer.Sale;
import ctrLayer.SaleCtr;

public class SaleUI extends SuperUI{
	private Sale sale;
		
	public SaleUI(){
		SaleCtr sCtr = new SaleCtr();
		this.sale = sCtr.createSale();
		boolean exit = false;
		while(!exit){
			int choice = writeSaleMenu();
			if(choice == 1){
				addPartSale();
			} else if(choice == 2){
				createCustomer();
			} else if (choice == 3){
				searchCustomer();
			} else if(choice == 4){
				finishSale();
			} else if(choice == 5){
				exit = true;
			}
		}
	}
	


	private int writeSaleMenu(){
		int choice = 0;
		try{
			System.out.println("## Opret salg ##");
			System.out.println("1. Tilføj vare");
			System.out.println("2. Opret kunde");
			System.out.println("3. Søg kunde");
			System.out.println("4. Udfør salg");
			System.out.println("5. Gå tilbage");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	/*
	private void createSale(){
	
	}
	*/
	
	private void finishSale() {
		// TODO Auto-generated method stub
		
	}

	private void searchCustomer() {
		// TODO Auto-generated method stub
		
	}

	private void createCustomer() {
		// TODO Auto-generated method stub
		
	}

	private void addPartSale() {
		// Indtast varenr, / s�g vare
		ItemUI iUi = new ItemUI("Dry Run");
		iUi.pickItem();
		
	}
	
}
