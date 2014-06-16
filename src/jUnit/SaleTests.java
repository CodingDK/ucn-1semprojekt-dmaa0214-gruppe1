package jUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Sale;
import modelLayer.Order;

import org.junit.Test;

import personLayer.Customer;
import ctrLayer.CategoryCtr;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;
import ctrLayer.ItemCtr;
import ctrLayer.SaleCtr;
import exceptionLayer.CategoryExistException;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;

public class SaleTests {
	
	@Test
	public void testCreateSale() {
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		assertThat(s, instanceOf(Sale.class));
	}
	
	@Test(expected = NotEnoughItemsException.class)
	public void testAddItemNotEnough() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Order s1 = iCtr.findStorage("Test1");
		try {
			cCtr.createCategory("Søm");
			cCtr.createCategory("Hammer");
		} catch (CategoryExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		sCtr.getSale();
		
		sCtr.addItem(i, 250);
	}
	
	@Test
	public void testAddItem() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Order s1 = iCtr.findStorage("Test1");
		try {
			cCtr.createCategory("Søm");
			cCtr.createCategory("Hammer");
		} catch (CategoryExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		
		sCtr.addItem(i, 50);
		double test1 = s.getTotalPrice();
		double test2 = i.getSalePrice() * 150;
		
		assertEquals(test1, test2, test2);
	}
	
	@Test
	public void testSetCustomer() throws SaleNotCreatedException {
		CustomerCtr cCont = new CustomerCtr();
		cCont.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		ArrayList<Customer> customers = cCont.searchCustomer("Bjarne");
		Customer c = null;
		boolean found = false;
		int i = 0;
		while (!found && i < customers.size()) {
			Customer checkC = customers.get(i);
			if (checkC.getName().equals("Bjarne")) {
				c = checkC;
				found = true;
			}
		}
		
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		sCtr.setCustomer(c);
		assertEquals(s.getCustomer(), c);
	}
	
	@Test
	public void testFinishSale() throws NullPointerException, NotEnoughItemsException, SaleNotCreatedException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Order s1 = iCtr.findStorage("Test1");
		try {
			cCtr.createCategory("Søm");
			cCtr.createCategory("Hammer");
		} catch (CategoryExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("Ss Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("Ss Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		
		EmployeeCtr eCtr = new EmployeeCtr();
		eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
		
		sCtr.addItem(i, 50);
		CustomerCtr ccCtr = new CustomerCtr();
		ccCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		ArrayList<Customer> customers = ccCtr.searchCustomer("Bjarne");
		Customer c = null;
		boolean found = false;
		int ii = 0;
		while (!found && ii < customers.size()) {
			Customer checkC = customers.get(ii);
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
