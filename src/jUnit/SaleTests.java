package jUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
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
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		assertThat(s, instanceOf(Sale.class));
	}

	@Test(expected = NotEnoughItemsException.class)
	public void testAddItemNotEnough() throws NullPointerException, NotEnoughItemsException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.getSale();
			
		sCtr.addItem(i, 250);
	}
	
	@Test
	public void testAddItem() throws NullPointerException, NotEnoughItemsException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
			
		sCtr.addItem(i, 150);
		double test1 = s.getTotalPrice();
		double test2 = i.getSalePrice()*150;
		
		assertEquals(test1, test2, test2);
	}

	@Test
	public void testSetCustomer() throws SaleNotCreatedException {
		CustomerCtr cCont = new CustomerCtr();
		cCont.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		Customer c = cCont.findCustomer("Bjarne");
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
		Storage s1 = iCtr.findStorage("Test1");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("Ss Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("Ss Flad");
		SaleCtr sCtr = new SaleCtr();
		sCtr.createSale();
		Sale s = sCtr.getSale();
		
		EmployeeCtr eCtr = new EmployeeCtr();
		eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
			
		sCtr.addItem(i, 150);
		CustomerCtr ccCtr = new CustomerCtr();
		ccCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		Customer c = ccCtr.findCustomer("Bjarne");
		sCtr.setCustomer(c);
		
		sCtr.finishSale("2");
		
		assertEquals(s.getEmployee(), eCtr.findEmployee("2"));
	}

}
