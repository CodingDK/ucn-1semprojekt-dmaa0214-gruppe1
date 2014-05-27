package uiLayer;

import java.util.Scanner;

public class SaleUI extends SuperUI{
		
	public SaleUI(){
		sCtr.createSale();
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
				exit = true
				new MainUI();
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
			System.out.println("Forkert input!")
		}
		return choice;
	}
	
	/*
	private void createSale(){
	
	}
	*/
	
}
