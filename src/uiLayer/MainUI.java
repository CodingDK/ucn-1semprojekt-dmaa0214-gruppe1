package uiLayer;

import java.util.Calendar;
import java.util.Date;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Sale;
import modelLayer.Storage;
import personLayer.Private;
import ctrLayer.CategoryCtr;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;
import ctrLayer.ItemCtr;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

public class MainUI extends SuperUI {
	
	public static void main(final String[] args) {
		new MainUI();
	}
	
	private MainUI() {
		menu();
	}
	
	/**
	 * menu - Handels the selection part of the UI
	 */
	private void menu() {
		boolean exit = false;
		boolean testCreated = false;
		while (!exit) {
			final SaleUI sUI = new SaleUI("");
			sUI.cleanUp();
			final int choice = writeMenu();
			if (choice == 1) {
				new PersonUI();
			} else if (choice == 2) {
				new SaleUI();
			} else if (choice == 3) {
				new ItemUI();
			} else if (choice == 4) {
				if (testCreated) {
					System.out.println("Test allerede oprettet");
					pause();
				} else {
					makeTest();
					testCreated = true;
				}
			} else if (choice == 5) {
				if (!admin) {
					login();
				} else {
					admin = false;
				}
			} else if (choice == 6) {
				System.out.println(nL + "Program afsluttet.");
				exit = true;
			}
		}
	}
	
	/**
	 * writeMenu - Write the Main menu and get a choice.
	 * 
	 * @return The choice by the user.
	 */
	private int writeMenu() {
		flush();
		int choice = 0;
		System.out.println("1. Person Menu");
		System.out.println("2. Salgs Menu");
		System.out.println("3. Vare Menu");
		System.out.println("4. Lav Test");
		if (!admin) {
			System.out.println("5. Administrator Login");
		} else {
			System.out.println("5. Log ud");
		}
		System.out.println("6. Afslut program");
		choice = requestInt(nL + "Valg", null, false);
		return choice;
	}
	
	private void makeTest() {
		final ItemCtr iCtr = new ItemCtr();
		final CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Lager1");
		iCtr.createStorage("Lager2");
		final Storage s1 = iCtr.findStorage("Lager1");
		final Storage s2 = iCtr.findStorage("Lager2");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		final Category c1 = cCtr.findCategory("Søm");
		final Category c2 = cCtr.findCategory("Hammer");
		
		iCtr.createItem("Søm Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("Søm t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		iCtr.createItem("Flad Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
		iCtr.createItem("Rund Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
		
		final EmployeeCtr eCtr = new EmployeeCtr();
		eCtr.createEmployee("1", "Ole", "70809010", "Egonsvej 19", "ole@ucn.dk", "Aalborg", "9000", "201050-1043", "1234", true);
		eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
		
		final CustomerCtr cusCtr = new CustomerCtr();
		final Private p = cusCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		cusCtr.createBusinessCustomer("Kis", "72691867", "Sofiendalsvej 60", "kbha@ucn.dk", "Aalborg", "9000", "UCN A/S", "33556063");
		
		// Test af CleanUp
		
		final SaleCtr ccCtr = new SaleCtr();
		ccCtr.createSale();
		try {
			ccCtr.setCustomer(p);
		} catch (final SaleNotCreatedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final Item i = iCtr.getItem("Flad Hammer");
		try {
			ccCtr.addItem(i, 100);
		} catch (final NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final NotEnoughItemsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final SaleNotCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		final Date d = c.getTime();
		
		final Sale s = ccCtr.getSale();
		s.setDate(d);
		
		ccCtr.parkSale();
		
	}
	
}
