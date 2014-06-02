package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;

import personLayer.*;
import modelLayer.*;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

/**
 * User interface to creation of a sale.
 * @author Group 1
 * @version 0.1                 
 */
public class CreateSaleUI extends SuperUI{
	private SaleCtr sCtr;
	
	/**
	 * Constructor for the SaleUI.
	 */
	public CreateSaleUI(){
		sCtr = new SaleCtr();
		sCtr.createSale();
		menu();
	}
	
	/**
	 * Constructor for the SaleUI, for resuming a parked sale
	 * @param Parked sale
	 */
	public CreateSaleUI(Sale sale){
		sCtr = new SaleCtr();
		sCtr.loadSale(sale);
		menu();
	}
	
	/**
	 * menu - Handels the selection part of the UI
	 */
	private void menu(){
		boolean exit = false;
		while(!exit){
			int choice = writeSaleMenu();
			if(choice == 1){
				addPartSale();
			} else if(choice == 2){
				createCustomer();
			} else if(choice == 3){
				searchCustomer();
			} else if(choice == 4){
				exit = finishSale();
			} else if(choice == 5){
				boolean r = parkSale();
				if(r){
					exit = true;
				}
			} else if(choice == 6){
				sCtr.cancelSale();
				System.out.println("Salget er blevet annulleret");
				pause();
				exit = true;
			}
		}
	}

	/**
	 * parkSale - Parks the current sale if possible
	 * @return true if the sale has a customer associated
	 */
	private boolean parkSale() {
		boolean park = sCtr.parkSale();
		boolean ret = false;
		if(park){
			System.out.println("Salget er blevet parkeret");
			pause();
			ret = true;
		}else{
			System.out.println("Salget kan ikke parkeres uden en Kunde tilknyttet");
			pause();
		}
		
		return ret;
		
	}

	/**
	 * writeSaleMenu - Write the sale menu and get a choice.
	 * @return The choice by the user.
	 */
	private int writeSaleMenu(){
		int choice = 0;
		try{
			System.out.println("## Opret salg ##");
			String ret = "";
			Sale sale = sCtr.getSale();
			if(sale.getCustomer() != null){
				ret = sale.getCustomer().toString();
			} else {
				ret = "Ingen valgt";
			}
			System.out.println("## Kunde: " + ret + " ##");
			printPartSale();
			System.out.println("1. Tilføj vare");
			System.out.println("2. Opret privatkunde");
			System.out.println("3. Søg kunde");
			System.out.println("4. Udfør salg");
			System.out.println("5. Parker salg");
			System.out.println("6. Annuller salg");
			choice = requestInt("Valg", null, false);		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	/**
	 * printPartSale - Print the partsales of a sale.
	 */
	private void printPartSale(){
		Sale sale = sCtr.getSale();
		ArrayList<PartSale> partsales = sale.getPartSales();
		
		System.out.println("## Valgt vare " + partsales.size() + " ##");
		if(partsales.size() != 0){
		for(PartSale ps : partsales){
			String line = "";
			Item item = ps.getItem();
			double price = item.getSalePrice()*ps.getAmount();
			line = ps.getAmount() + " " + item.getName() + " ";
			line += price + ",- ";
			System.out.println(line);
		}
		double total = sale.getTotalPrice();
		double moms = total*0.25;
		total += moms;
		System.out.println("Moms: " + moms + ",-");
		System.out.println("Total: " + total + ",-");
		}
		System.out.println("## ## ## ## ##");
	}
	
	/**
	 * finishSale - Finish a sale and add an employee to the sale.
	 * @return true if sale is created.
	 */
	private boolean finishSale() {
		String employeeNr = requestString("Indtast medarbejdernr.", null, null, false);
		boolean ret = false;
		try {
			sCtr.finishSale(employeeNr);
			System.out.println("Salg udført");
			ret = true;
		} catch (NullPointerException e) {
			System.out.println("Prøv igen, " + e.getMessage());
		} catch (SaleNotCreatedException e) {
			System.out.println(e.getMessage());
		}
		pause();
		return ret;
	}

	/**
	 * searchCustomer - Search for a Customer
	 */
	private void searchCustomer() {
		PersonUI pUI = new PersonUI("Dry Run");
		Customer c = null;
		while(c == null){
			c = pUI.findCustomer();
			if(c == null){
			System.out.println("Kunde ikke fundet, søg igen.");
			}
		}
		sCtr.getSale().setCustomer(c);
		
	}

	/**
	 * createCustomer - Create a customer.
	 */
	private void createCustomer() {
		PersonUI pUI = new PersonUI("Dry Run");
		
		try {
			sCtr.setCustomer(pUI.createCustomer());
		} catch (SaleNotCreatedException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * addPartSale - add an item and amount to the sale.
	 */
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
				System.out.println(i.getName() + " tilføjet til salget");
				pause();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				pause();
			} catch (NotEnoughItemsException e) {
				System.out.println(e.getMessage());
				pause();
			} catch (SaleNotCreatedException e) {
				System.out.println(e.getMessage());
				pause();
			}
		}
		
	}
	
}
