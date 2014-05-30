package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import personLayer.Business;
import ctrLayer.CustomerCtr;

public class BusinessTest {

	@Test
	public void testGetCompany() {
		CustomerCtr cCtr = new CustomerCtr();
		Business b = cCtr.findBusiness("UCN A/S");
		assertEquals("UCN A/S", b.getCompany());
	}

	@Test
	public void testGetCvrNr() {
		CustomerCtr cCtr = new CustomerCtr();
		Business b = cCtr.findBusiness("UCN A/S");
		assertEquals("33556063", b.getCvrNr());
	}

}
