package jUnit;

import modelLayer.Category;
import modelLayer.Storage;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ctrLayer.CategoryCtr;
import ctrLayer.CustomerCtr;
import ctrLayer.EmployeeCtr;
import ctrLayer.ItemCtr;
import exceptionLayer.AlreadyExistException;
import exceptionLayer.CategoryExistException;
import exceptionLayer.StorageExistException;

@RunWith(Suite.class)
@SuiteClasses({BusinessTest.class, CategoryTests.class, ItemCtrTests.class,
		SaleTests.class})
public class AllTests {
	
	public AllTests() {
		
	}
	
	@BeforeClass
	public static void makeTest() throws AlreadyExistException {
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		try {
			iCtr.createStorage("Lager1");
			iCtr.createStorage("Lager2");
		} catch (StorageExistException e1) {
			e1.printStackTrace();
		}
		Storage s1 = iCtr.findStorage("Lager1");
		Storage s2 = iCtr.findStorage("Lager2");
		try {
			cCtr.createCategory("Søm");
			cCtr.createCategory("Hammer");
		} catch (CategoryExistException e) {
			e.printStackTrace();
		}
		
		Category c1 = cCtr.findCategory("Søm");
		Category c2 = cCtr.findCategory("Hammer");
		
		iCtr.createItem("Søm Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1,
				c1);
		iCtr.createItem("Søm t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1,
				10, 1, c1);
		
		iCtr.createItem("Flad Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10,
				1, c2);
		iCtr.createItem("Rund Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10,
				1, c2);
		
		EmployeeCtr eCtr = new EmployeeCtr();
		eCtr.createEmployee("1", "Ole", "70809010", "Egonsvej 19",
				"ole@ucn.dk", "Aalborg", "9000", "201050-1043", "1234", true);
		eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29",
				"jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
		
		CustomerCtr cusCont = new CustomerCtr();
		cusCont.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2",
				"bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
		cusCont.createBusinessCustomer("Kis", "72691867", "Sofiendalsvej 60",
				"kbha@ucn.dk", "Aalborg", "9000", "UCN A/S", "33556063");
	}
	
}
