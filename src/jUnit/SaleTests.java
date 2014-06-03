package jUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Sale;
import modelLayer.Storage;

import org.junit.Test;

import personLayer.Customer;
import ctrLayer.CategoryCtr;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;
import ctrLayer.ItemCtr;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

public class SaleTests {
	
	@Test
	public void testCreateSale() {
		final SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		final Sale s = sCtr.getSale();
		assertThat(s, instanceOf(Sale.class));
	}
	
	@Test(expected = NotEnoughItemsException.class)
	public void testAddItemNotEnough() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		final ItemCtr iCtr = new ItemCtr();
		final CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		final Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		final Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		final Item i = iCtr.getItem("S Flad");
		final SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		sCtr.getSale();
		
		sCtr.addItem(i, 250);
	}
	
	@Test
	public void testAddItem() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		final ItemCtr iCtr = new ItemCtr();
		final CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		final Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		final Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		final Item i = iCtr.getItem("S Flad");
		final SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		final Sale s = sCtr.getSale();
		
		sCtr.addItem(i, 50);
		final double test1 = s.getTotalPrice();
		final double test2 = i.getSalePrice() * 150;
		
		assertEquals(test1, test2, test2);
	}
	
	@Test
	public void testSetCustomer() throws SaleNotCreatedException {
		final CustomerCtr cCont = new CustomerCtr();
		cCont.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		final ArrayList<Customer> customers = cCont.searchCustomer("Bjarne");
		Customer c = null;
		boolean found = false;
		final int i = 0;
		while (!found && i < customers.size()) {
			final Customer checkC = customers.get(i);
			if (checkC.getName().equals("Bjarne")) {
				c = checkC;
				found = true;
			}
		}
		
		final SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		final Sale s = sCtr.getSale();
		sCtr.setCustomer(c);
		assertEquals(s.getCustomer(), c);
	}
	
	@Test
	public void testFinishSale() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		final ItemCtr iCtr = new ItemCtr();
		final CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		final Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		final Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("Ss Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		final Item i = iCtr.getItem("Ss Flad");
		final SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		final Sale s = sCtr.getSale();
		
		final EmployeeCtr eCtr = new EmployeeCtr();
		eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
		
		sCtr.addItem(i, 50);
		final CustomerCtr ccCtr = new CustomerCtr();
		ccCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		final ArrayList<Customer> customers = ccCtr.searchCustomer("Bjarne");
		Customer c = null;
		boolean found = false;
		final int ii = 0;
		while (!found && ii < customers.size()) {
			final Customer checkC = customers.get(ii);
			if (checkC.getName().equals("Bjarne")) {
				c = checkC;
				found = true;
			}
		}
		sCtr.setCustomer(c);
		
		sCtr.finishSale("2");
		
		assertEquals(s.getEmployee(), eCtr.findEmployee("2"));
	}
	
}
