package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import personLayer.*;
import modelLayer.*;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

public class SaleUI extends SuperUI{
	private SaleCtr sCtr;
	private Sale sale;
	private Customer customer;
		
	public SaleUI(){
		customer = null;
		sCtr = new SaleCtr();
		sale = sCtr.createSale();
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
				//searchCustomer();
			} else if(choice == 5){
				exit = finishSale();
			} else if(choice == 6){
				exit = true;
			}
		}
	}

	private int writeSaleMenu(){
		int choice = 0;
		try{
			System.out.println("## Opret salg ##");
			String ret = "";
			if(customer != null){
				ret = customer.toString();
			} else {
				ret = "Ingen valgt";
			}
			System.out.println("¤¤ Kunde: " + ret + " ¤¤");
			printPartSale();
			System.out.println("1. Tilføj vare");
			System.out.println("2. Opret privatkunde");
			System.out.println("3. Opret erhvervskunde");
			System.out.println("4. Søg kunde");
			System.out.println("5. Udfør salg");
			System.out.println("6. Gå tilbage");
			choice = requestInt("Valg", null, false);		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	private void printPartSale(){
		ArrayList<PartSale> partsales = sale.getPartSales();
		
		System.out.println("¤¤ Valgt vare " + partsales.size() + " ¤¤");
		double total = 0;
		for(PartSale ps : partsales){
			String line = "";
			Item item = ps.getItem();
			double price = item.getSalePrice()*ps.getAmount();
			line = ps.getAmount() + " " + item.getName() + " ";
			line += price + ",- ";
			total += price;
			System.out.println(line);
		}
		double moms = total*0.25;
		total += moms;
		System.out.println("Moms: " + moms + ",-");
		System.out.println("Total: " + total + ",-");
		System.out.println("¤¤ ¤¤ ¤¤ ¤¤");
	}
		
	private boolean finishSale() {
		String employeeNr = requestString("Indtast medarbejdernr.", null, null, false);
		boolean ret = false;
		try {
			sCtr.finishSale(employeeNr);
			System.out.println("Salg udført");
			ret = true;
		} catch (NullPointerException e) {
			System.out.println("Prøv igen, " + e.getMessage());
			pause();
		} catch (SaleNotCreatedException e) {
			System.out.println(e.getMessage());
			pause();
		}
		return ret;
	}
	/*
	private void searchCustomer() {
		PersonUI pUI = new PersonUI("Dry Run");
		Customer c = pUI.findCustomer();
		if(c == null){
			System.out.println("Kunde ikke fundet, søg igen.");
		}
	}
*/
	private void createPrivate() {
		PersonUI pUI = new PersonUI("Dry Run");
		customer = null;
		while(customer == null){
			customer = pUI.createPrivate();
		}
	}
	
	private void createBusiness(){
		PersonUI pUI = new PersonUI("Dry Run");
		customer = null;
		while(customer == null){
			customer = pUI.createBusiness();
		}
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
				System.out.println(i.getName() + " tilføjet til salget");
				pause();
			} catch (NullPointerException e) {
				System.out.println(e);
				pause();
			} catch (NotEnoughItemsException e) {
				System.out.println(e);
				pause();
			}
		}
		
	}
	
}
