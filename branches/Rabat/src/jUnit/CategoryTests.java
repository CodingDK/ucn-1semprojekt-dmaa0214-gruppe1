package jUnit;

import static org.junit.Assert.*;
import modelLayer.Category;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import ctrLayer.CategoryCtr;

public class CategoryTests {

	@Test
	public void testCreateCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookies");
		Category c = cCtr.findCategory("Cookies");
		assertNotEquals(c, null);
	}

	@Test
	public void testUpdateCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookies");
		Category c = cCtr.findCategory("Cookies");
		cCtr.updateCategory(c, "Sko");
		assertEquals(c.getName(), "Sko");
	}

	@Test
	public void testRemoveCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		Category c = cCtr.findCategory("Cookies");
		cCtr.removeCategory(c);
		assertEquals(cCtr.findCategory("Cookies"), null);
	}

	@Test
	public void testFindCategoryString() {
		CategoryCtr cCtr = new CategoryCtr();
		cCtr.createCategory("Cookie");
		Category c = cCtr.findCategory("Cookies");
		assertThat(c, instanceOf(Category.class));
	}

}
