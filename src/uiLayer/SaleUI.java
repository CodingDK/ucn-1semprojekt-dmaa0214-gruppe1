package uiLayer;

import java.util.ArrayList;

import modelLayer.PartSale;
import modelLayer.Sale;
import ctrLayer.SaleCtr;

/**
 * User interface to creation of a sale.
 * 
 * @author Group 1
 * @version 0.1
 */
public class SaleUI extends SuperUI {
	
	/**
	 * Constructor for running the SaleUI from other UI's
	 * 
	 * @param s
	 */
	public SaleUI(final String s) {
		
	}
	
	/**
	 * Constructor for the SaleUI.
	 */
	public SaleUI() {
		cleanUp();
		menu();
	}
	
	/**
	 * menu - Handels the selection part of the UI
	 */
	private void menu() {
		boolean exit = false;
		while (!exit) {
			final int choice = writeSaleMenu();
			if (choice == 1) {
				new CreateSaleUI();
			} else if (choice == 2) {
				final Sale s = pickParkedSale();
				if (s != null) {
					new CreateSaleUI(s);
				} else {
					System.out.println("Genoptag Parkeret Salg kunne ikke startes");
				}
			} else if (choice == 3) {
				printSales();
			} else if (choice == 4) {
				exit = true;
			}
		}
	}
	
	/**
	 * writeSaleMenu - Write the sale menu and get a choice.
	 * 
	 * @return The choice by the user.
	 */
	private int writeSaleMenu() {
		flush();
		int choice = 0;
		System.out.println("## Salgs Menu ##" + nL);
		System.out.println("1. Opret Salg");
		System.out.println("2. Genoptag Parkeret Salg");
		System.out.println("3. Print Alle Salg");
		System.out.println("4. Gå tilbage");
		choice = requestInt(nL + "Valg", null, false);
		return choice;
	}
	
	/**
	 * printSales - prints out all the sales
	 */
	private void printSales() {
		flush();
		System.out.println("## Print Alle Salg ##");
		final SaleCtr sCtr = new SaleCtr();
		final ArrayList<Sale> sales = sCtr.getSales();
		if (sales != null && sales.size() > 0) {
			for (final Sale s : sales) {
				System.out.println(s);
				final ArrayList<PartSale> partSales = s.getPartSales();
				for (final PartSale ps : partSales) {
					System.out.println(" - " + ps);
				}
			}
			System.out.println("");
			pause();
		} else {
			System.out.println("Der er ikke foretaget nogen salg");
			pause();
		}
	}
	
	/**
	 * pickParkedSale - Finds all parkeds sales, and lets the user pick one
	 * 
	 * @return Sale
	 */
	private Sale pickParkedSale() {
		flush();
		Sale retSale = null;
		try {
			boolean done = false;
			while (!done) {
				System.out.println("## Vælg Salg ##");
				final SaleCtr sCtr = new SaleCtr();
				final ArrayList<Sale> sales = sCtr.getParkedSales();
				if (sales != null && sales.size() > 0) {
					boolean recheck = true;
					System.out.println(sales.size() + " Parkeret Salg Fundet");
					while (recheck) {
						for (final Sale s : sales) {
							System.out.println(s);
						}
						final int id = requestInt("Salg ID", null, false);
						int i = 0;
						boolean found = false;
						while (!found && i < sales.size()) {
							final Sale checkS = sales.get(i);
							if (checkS.getId() == id) {
								retSale = checkS;
								found = true;
							}
							i++;
						}
						
						if (retSale != null) {
							retSale = sCtr.getSale(id);
							done = true;
							recheck = false;
						} else {
							System.out.println("Ugyldigt ID indtastet");
							pause();
							recheck = true;
						}
					}
				} else {
					System.out.println("0 Parkeret Salg Fundet");
					pause();
					done = true;
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		return retSale;
		
	}
	
	/**
	 * cleanUp - Cleans up the parked sales
	 */
	public void cleanUp() {
		final SaleCtr sCtr = new SaleCtr();
		sCtr.cleanUp();
	}
}
