package ctrLayer;

import exceptionLayer.CategoryExistException;
import modelLayer.Category;
import modelLayer.Storage;
import personLayer.Private;

public class Demo {
	private static boolean firstRun = true;
	public Demo(){
		
	}
	
	public void runDemo(){
		if(firstRun){
			ItemCtr iCtr = new ItemCtr();
			CategoryCtr cCtr = new CategoryCtr();
			iCtr.createStorage("Trælast");
			iCtr.createStorage("Byggecenter");
			Storage s1 = iCtr.findStorage("Trælast");
			Storage s2 = iCtr.findStorage("Byggecenter");
			try {
				cCtr.createCategory("Søm");
				cCtr.createCategory("Hammer");
			} catch (CategoryExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Category c1 = cCtr.findCategory("Søm");
			Category c2 = cCtr.findCategory("Hammer");
			
			iCtr.createItem("Søm Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
			iCtr.createItem("Søm t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
			
			iCtr.createItem("Flad Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
			iCtr.createItem("Rund Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
			
			EmployeeCtr eCtr = new EmployeeCtr();
			eCtr.createEmployee("1", "Ole", "70809010", "Egonsvej 19", "ole@ucn.dk", "Aalborg", "9000", "201050-1043", "1234", true);
			eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
			eCtr.createEmployee("3", "Bjarne", "12345678", "Hobrovej 26", "bjarne@ucn.dk", "Vestbjerg", "9380", "100170-2141", null, false);
			
			for(int i = 0; i < 25; i++){
				eCtr.createEmployee(""+i, "Testper"+i, "" +i+i+i+i+i+i+i+i, "Testvej", "test@ucn.dk", "Testbjerg", "8888", "141010-2040", null, false);

			}
			
			CustomerCtr cusCtr = new CustomerCtr();
			cusCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
			
			for(int i = 0; i < 25; i++){
				cusCtr.createPrivateCustomer("Testper"+i, "00885501", "Testvej "+i, "test"+i+"@ft.dk", "Aalborg", "9000", "121248-3011", "08080808");

			}
			
			cusCtr.createBusinessCustomer("Kis", "72691867", "Sofiendalsvej 60", "kbha@ucn.dk", "Aalborg", "9000", "UCN A/S", "33556063");
			
			firstRun = false;
		}
	}
}
