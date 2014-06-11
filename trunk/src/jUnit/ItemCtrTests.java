package jUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;

import org.junit.Test;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import exceptionLayer.CategoryExistException;

public class ItemCtrTests {
	
	@Test
	public void testCreateItem() {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		Storage s1 = iCtr.findStorage("Test1");
		try {
			cCtr.createCategory("Søm");
		} catch (CategoryExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category c1 = cCtr.findCategory("Søm");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		assertThat(i, instanceOf(Item.class));
	}
	
	@Test
	public void testUpdateItem() {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Test1");
		iCtr.createStorage("Test2");
		Storage s1 = iCtr.findStorage("Test1");
		Storage s2 = iCtr.findStorage("Test2");
		try {
			cCtr.createCategory("Søm");
			cCtr.createCategory("Hammer");
		} catch (CategoryExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Category c1 = cCtr.findCategory("Søm");
		Category c2 = cCtr.findCategory("Hammer");
		
		iCtr.createItem("S Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		Item i = iCtr.getItem("S Flad");
		int id = i.getId();
		iCtr.updateItem(id, "Hej", 150, 0, 1., 1., 1., 10, "Hejs", s2, 0, 0, c2);
		i = iCtr.getItem(id);
		assertEquals(i.getAmount(), 150);
	}
	
	@Test
	public void testCreateStorage() {
		ItemCtr iCtr = new ItemCtr();
		iCtr.createStorage("Cookie");
	}
	
	@Test
	public void testRemoveStorage() {
		ItemCtr iCtr = new ItemCtr();
		Storage s = iCtr.findStorage("Cookie2");
		iCtr.removeStorage(s);
		s = iCtr.findStorage("Cookie2");
		assertEquals(s, null);
	}
	
}
