package jUnit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import personLayer.Business;
import personLayer.Customer;
import ctrLayer.CustomerCtr;

public class BusinessTest {
	
	@Test
	public void testGetCompany() {
		final CustomerCtr cCtr = new CustomerCtr();
		final ArrayList<Customer> customers = cCtr.searchBusiness("UCN A/S");
		boolean found = false;
		int i = 0;
		Business b = null;
		while (!found && i < customers.size()) {
			if (customers.get(i) instanceof Business) {
				final Business checkB = (Business) customers.get(i);
				if (checkB.getCompany().equals("UCN A/S")) {
					b = checkB;
					found = true;
				}
			}
			i++;
		}
		assertEquals("UCN A/S", b.getCompany());
	}
	
	@Test
	public void testGetCvrNr() {
		final CustomerCtr cCtr = new CustomerCtr();
		final ArrayList<Customer> customers = cCtr.searchBusiness("UCN A/S");
		boolean found = false;
		int i = 0;
		Business b = null;
		while (!found && i < customers.size()) {
			if (customers.get(i) instanceof Business) {
				final Business checkB = (Business) customers.get(i);
				if (checkB.getCompany().equals("UCN A/S")) {
					b = checkB;
					found = true;
				}
			}
			i++;
		}
		assertEquals("33556063", b.getCvrNr());
	}
	
}
