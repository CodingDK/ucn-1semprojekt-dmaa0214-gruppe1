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
public class SaleUI extends SuperUI{
	
	/**
	 * Constructor for the SaleUI.
	 */
	public SaleUI(){
		boolean exit = false;
		while(!exit){
			int choice = writeSaleMenu();
			if(choice == 1){
				new CreateSaleUI();
			} else if(choice == 2){
				pickParkedSale();
			} else if(choice == 3){
				printSales();
			} else if(choice == 4){
				exit = true;
			}
		}
	}

	private void printSales() {
		System.out.println("## Print Alle Salg ##");
		SaleCtr sCtr = new SaleCtr();
		ArrayList<Sale> sales = sCtr.getSales();
		if(sales != null && sales.size() > 0){
			for(Sale s : sales){
				System.out.println(s);
				ArrayList<PartSale> partSales = s.getPartSales();
				for(PartSale ps : partSales){
					System.out.println(" - " + ps);
				}
			}
			System.out.println("/n");
		}else{
			System.out.println("Der er ikke foretaget nogen salg");
			pause();
		}
	}

	private void pickParkedSale() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * writeSaleMenu - Write the sale menu and get a choice.
	 * @return The choice by the user.
	 */
	private int writeSaleMenu(){
		int choice = 0;
		try{
			System.out.println("## Salgs Menu ##");
			System.out.println("1. Opret Salg");
			System.out.println("2. Vælg Parkeret Salg");
			System.out.println("3. Print Alle Salg");
			System.out.println("4. Gå tilbage");
			choice = requestInt("Valg", null, false);		
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
}
