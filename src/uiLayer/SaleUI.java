package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import personLayer.*;
import modelLayer.*;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

public class SaleUI extends SuperUI{
	private SaleCtr sCtr;
	private Customer customer;
		
	public SaleUI(){
		customer = null;
		
		sCtr = new SaleCtr();
		sCtr.createSale();
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
			if(customer == null){
				System.out.println("¤¤ Kunde valgt: " + customer.toString() + " ¤¤");
			}
			System.out.println("1. Tilføj vare");
			System.out.println("2. Opret privatkunde");
			System.out.println("3. Opret erhvervskunde");
			System.out.println("4. Søg kunde");
			System.out.println("5. Udfør salg");
			System.out.println("6. Gå tilbage");
			System.out.print("Valg:");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
		
	private void finishSale() {
		String employeeNr = requestString("Indtast medarbejdernr.", null, null, false);
		
		try {
			sCtr.finishSale(employeeNr);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (SaleNotCreatedException e) {
			System.out.println(e);
		}
	}
	
	private void searchCustomer() {
		PersonUI pUI = new PersonUI("Dry Run");
		Customer c = pUI.findCustomer();
		if(c == null){
			System.out.println("Kunde ikke fundet, søg igen.");
		}
	}

	private void createPrivate() {
		PersonUI pUI = new PersonUI("Dry Run");
		customer = pUI.createPrivate();
	}
	
	private void createBusiness(){
		PersonUI pUI = new PersonUI("Dry Run");
		customer = pUI.createBusiness();
	}

	private void addPartSale() {
		ItemUI iUi = new ItemUI("Dry Run");
		Item i = null;
		while(i == null){
			i = iUi.pickItem();
			if(i == null){
				System.out.println("Vare ikke fundet, søg igen");
			}
		}
	
		int aviAmount = i.getAmount()-i.getReserved();
		
		if(aviAmount <= 0){
			System.out.println(i.getName() + " er ikke på lager");
		}
		else {
			int amount = 0;
			while(aviAmount-amount < 0 || amount<=0){
				amount = requestInt("Antal", 1, false);
				if(aviAmount-amount < 0){
					System.out.println("Vælg et mindre antal. Der er kun " + aviAmount + " på lager");
				}
			}
						
			try {
				sCtr.addItem(i, amount);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (NotEnoughItemsException e) {
				System.out.println(e);
			}
		}
		
	}
	
}
