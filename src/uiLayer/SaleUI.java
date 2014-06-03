package uiLayer;

import java.util.ArrayList;

import modelLayer.*;
import ctrLayer.SaleCtr;

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
		SaleCtr sCtr = new SaleCtr();
		sCtr.cleanUp();
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
				new CreateSaleUI();
			} else if(choice == 2){
				Sale s = pickParkedSale();
				if(s != null){
					new CreateSaleUI(s);
				}else{
					System.out.println("Genoptag Parkeret Salg kunne ikke startes");
				}
			} else if(choice == 3){
				printSales();
			} else if(choice == 4){
				exit = true;
			}
		}
	}

	/**
	 * writeSaleMenu - Write the sale menu and get a choice.
	 * @return The choice by the user.
	 */
	private int writeSaleMenu(){
		flush();
		int choice = 0;
		flush();
		System.out.println("\n## Salgs Menu ##");
		System.out.println("1. Opret Salg");
		System.out.println("2. Genoptag Parkeret Salg");
		System.out.println("3. Print Alle Salg");
		System.out.println("4. Gå tilbage");
		choice = requestInt("Valg", null, false);		
		return choice;
	}

	/**
	 * printSales - prints out all the sales
	 */
	private void printSales() {
		System.out.println("\n## Print Alle Salg ##");
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
			System.out.println("");
			pause();
		}else{
			System.out.println("Der er ikke foretaget nogen salg");
			pause();
		}
	}

	/**
	 * pickParkedSale - Finds all parkeds sales, and lets the user pick one
	 * @return Sale
	 */
	private Sale pickParkedSale() {
		Sale retSale = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("\n## Vælg Salg ##");
				SaleCtr sCtr = new SaleCtr();
				ArrayList<Sale> sales = sCtr.getParkedSales();
				if(sales != null && sales.size() > 0){
					boolean recheck = true;
					System.out.println(sales.size() + " Parkeret Salg Fundet");
					while(recheck){
						for(Sale s : sales){
							System.out.println(s);
						}
						int id = requestInt("Salg ID", null, false);
						if(sCtr.getSale(id) != null && sales.contains(sCtr.getSale(id))){
							retSale = sCtr.getSale(id);
							done = true;
							recheck = false;
						}else{
							recheck = true;
						}
					}
				}else{
					System.out.println("0 Parkeret Salg Fundet");
					pause();
					done = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retSale;
		
	}
}
