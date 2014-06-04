package uiLayer;

import java.util.ArrayList;

import modelLayer.Item;
import modelLayer.PartSale;
import modelLayer.Sale;
import personLayer.Customer;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

/**
 * User interface to creation of a sale.
 * 
 * @author Group 1
 * @version 0.1
 */
public class CreateSaleUI extends SuperUI {
	private final SaleCtr sCtr;
	
	/**
	 * Constructor for the SaleUI.
	 */
	public CreateSaleUI() {
		sCtr = new SaleCtr();
		sCtr.createSale();
		menu();
	}
	
	/**
	 * Constructor for the SaleUI, for resuming a parked sale
	 * 
	 * @param Parked sale
	 */
	public CreateSaleUI(Sale sale) {
		sCtr = new SaleCtr();
		sCtr.loadSale(sale);
		menu();
	}
	
	/**
	 * menu - Handle the selection part of the UI
	 */
	private void menu() {
		boolean exit = false;
		while (!exit) {
			final int choice = writeSaleMenu();
			if (choice == 1) {
				addPartSale();
			} else if (choice == 2) {
				createCustomer();
			} else if (choice == 3) {
				searchCustomer();
			} else if (choice == 4) {
				exit = finishSale();
			} else if (choice == 5) {
				final boolean r = parkSale();
				if (r) {
					exit = true;
				}
			} else if (choice == 6) {
				sCtr.cancelSale();
				System.out.println("Salget er blevet annulleret");
				pause();
				exit = true;
			}
		}
	}
	
	/**
	 * parkSale - Parks the current sale if possible
	 * 
	 * @return true if the sale has a customer associated
	 */
	private boolean parkSale() {
		final boolean park = sCtr.parkSale();
		boolean ret = false;
		if (park) {
			System.out.println("Salget er blevet parkeret");
			pause();
			ret = true;
		} else {
			System.out.println("Salget kan ikke parkeres uden en Kunde tilknyttet");
			pause();
		}
		return ret;
	}
	
	/**
	 * writeSaleMenu - Write the sale menu and get a choice.
	 * 
	 * @return The choice by the user.
	 */
	private int writeSaleMenu() {
		int choice = 0;
		flush();
		System.out.println("## Opret salg ##");
		String ret = "";
		final Sale sale = sCtr.getSale();
		if (sale.getCustomer() != null) {
			ret = sale.getCustomer().toString();
		} else {
			ret = "Ingen valgt";
		}
		System.out.println("Kunde: " + ret);
		printPartSale();
		System.out.println(nL + "1. Tilføj vare");
		System.out.println("2. Opret kunde");
		System.out.println("3. Søg kunde");
		System.out.println("4. Udfør salg");
		System.out.println("5. Parker salg");
		System.out.println("6. Annuller salg");
		choice = requestInt(nL + "Valg", null, false);
		return choice;
	}
	
	/**
	 * printPartSale - Print the partsales of a sale.
	 */
	private void printPartSale() {
		final Sale sale = sCtr.getSale();
		final ArrayList<PartSale> partsales = sale.getPartSales();
		System.out.println("Valgt vare " + partsales.size());
		if (partsales.size() != 0) {
			for (final PartSale ps : partsales) {
				String line = "";
				final Item item = ps.getItem();
				final double price = item.getSalePrice() * ps.getAmount();
				line = ps.getAmount() + "x " + item.getName() + " ";
				line += price + ",- ";
				System.out.println(line);
			}
			double total = sale.getTotalPrice();
			final double moms = total * 0.25;
			total += moms;
			System.out.println("Moms: " + moms + ",-");
			System.out.println("Total: " + total + ",-");
		}
	}
	
	/**
	 * finishSale - Finish a sale and add an employee to the sale.
	 * 
	 * @return true if sale is created.
	 */
	private boolean finishSale() {
		boolean ret = false;
		if (sCtr.getSale().getPartSales().size() > 0) {
			final String employeeNr = requestString(nL + "Indtast medarbejdernr", 1, 50, false);
			try {
				sCtr.finishSale(employeeNr);
				System.out.println("Salg udført");
				ret = true;
			} catch (final NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (final SaleNotCreatedException e) {
				System.out.println(e.getMessage());
			}
			pause();
		} else {
			System.out.println("Der er ingen vare tilnyttet salget");
			pause();
		}
		return ret;
	}
	
	/**
	 * searchCustomer - Search for a Customer
	 */
	private void searchCustomer() {
		final PersonUI pUI = new PersonUI("Dry Run");
		final Customer c = pUI.findCustomer();
		if (c != null) {
			sCtr.getSale().setCustomer(c);
		}
	}
	
	/**
	 * createCustomer - Create a customer.
	 */
	private void createCustomer() {
		final PersonUI pUI = new PersonUI("Dry Run");
		
		try {
			sCtr.setCustomer(pUI.createCustomer());
		} catch (final SaleNotCreatedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * addPartSale - add an item and amount to the sale.
	 */
	private void addPartSale() {
		final ItemUI iUi = new ItemUI("Dry Run");
		Item i = null;
		while (i == null) {
			i = iUi.pickItem();
			if (i == null) {
				System.out.println("Vare ikke fundet, søg igen");
			}
		}
		
		final int aviAmount = i.getAmount() - i.getReserved();
		
		if (aviAmount <= 0) {
			System.out.println(i.getName() + " er ikke på lager");
		}
		else {
			int amount = 0;
			while (aviAmount - amount < 0 || amount <= 0) {
				amount = requestInt("Antal", 1, false);
				if (aviAmount - amount < 0) {
					System.out.println("Vælg et mindre antal. Der er kun " + aviAmount + " på lager");
				}
			}
			
			try {
				sCtr.addItem(i, amount);
				System.out.println(amount + "x " + i.getName() + " tilføjet til salget");
			} catch (final NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (final NotEnoughItemsException e) {
				System.out.println(e.getMessage());
			} catch (final SaleNotCreatedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		pause();
		
	}
	
}
