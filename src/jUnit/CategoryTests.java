package jUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import modelLayer.Category;

import org.junit.Test;

import ctrLayer.CategoryCtr;
import exceptionLayer.CategoryExistException;
import exceptionLayer.MainCategoryException;

public class CategoryTests {
	
	@Test
	public void testCreateCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		try {
			cCtr.createCategory("Cookies");
		} catch (CategoryExistException e) {
			e.printStackTrace();
		}
		Category c = cCtr.findCategory("Cookies");
		assertNotEquals(c, null);
	}
	
	@Test
	public void testUpdateCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		try {
			cCtr.createCategory("Cookies");
		} catch (CategoryExistException e) {
			e.printStackTrace();
		}
		Category c = cCtr.findCategory("Cookies");
		cCtr.updateCategory(c, "Sko");
		assertEquals(c.getName(), "Sko");
	}
	
	@Test
	public void testRemoveCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		Category c = cCtr.findCategory("Cookies");
		try {
			cCtr.removeCategory(c);
		} catch (MainCategoryException e) {
			e.printStackTrace();
		}
		assertEquals(cCtr.findCategory("Cookies"), null);
	}
	
	@Test
	public void testFindCategoryString() {
		CategoryCtr cCtr = new CategoryCtr();
		try {
			cCtr.createCategory("Cookie");
		} catch (CategoryExistException e) {
			e.printStackTrace();
		}
		Category c = cCtr.findCategory("Cookies");
		assertThat(c, instanceOf(Category.class));
	}
	
}
