package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelLayer.Item;
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
				createPrivate();
			} else if(choice == 3){
				createBusiness();
			} else if(choice == 4){
				searchCustomer();
			} else if(choice == 5){
				finishSale();
			} else if(choice == 6){
				exit = true;
			}
		}
	}

	private int writeSaleMenu(){
		int choice = 0;
		try{
			System.out.println("## Opret salg ##");
			System.out.println("1. Tilføj vare");
			System.out.println("2. Opret privatkunde");
			System.out.println("3. Opret erhvervskunde");
			System.out.println("4. Søg kunde");
			System.out.println("5. Udfør salg");
			System.out.println("6. Gå tilbage");
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
		SaleCtr sCtr = new SaleCtr();
		String employeeNr = requestString("Indtast medarbejdernr.", null, null);
		sCtr.finishSale(employeeNr);
	}

	private void searchCustomer() {
		// TODO Auto-generated method stub
		PersonUI pUI = new PersonUI("Dry Run");
		pUI.findCustomer();
	}

	private void createPrivate() {
		PersonUI pUI = new PersonUI("Dry Run");
		pUI.createPrivate();
	}
	
	private void createBusiness(){
		PersonUI pUI = new PersonUI("Dry Run");
		pUI.createBusiness();
	}

	private void addPartSale() {
		ItemUI iUi = new ItemUI("Dry Run");
		Item i = iUi.pickItem();
		
		int amount = requestInt("Antal", 1);
		sale.addPartSale(i, amount);
	}
}
