package jUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import modelLayer.Category;

import org.junit.Test;

import ctrLayer.CategoryCtr;

public class CategoryTests {
	
	@Test
	public void testCreateCategory() {
		final CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookies");
		final Category c = cCtr.findCategory("Cookies");
		assertNotEquals(c, null);
	}
	
	@Test
	public void testUpdateCategory() {
		final CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookies");
		final Category c = cCtr.findCategory("Cookies");
		cCtr.updateCategory(c, "Sko");
		assertEquals(c.getName(), "Sko");
	}
	
	@Test
	public void testRemoveCategory() {
		final CategoryCtr cCtr = new CategoryCtr();
		final Category c = cCtr.findCategory("Cookies");
		cCtr.removeCategory(c);
		assertEquals(cCtr.findCategory("Cookies"), null);
	}
	
	@Test
	public void testFindCategoryString() {
		final CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookie");
		final Category c = cCtr.findCategory("Cookies");
		assertThat(c, instanceOf(Category.class));
	}
	
}
