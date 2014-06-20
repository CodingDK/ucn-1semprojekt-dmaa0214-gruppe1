package ctrLayer;

import java.util.ArrayList;
import java.util.Random;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;
import personLayer.Customer;
import exceptionLayer.AlreadyExistException;
import exceptionLayer.CategoryExistException;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;
import exceptionLayer.StorageExistException;

public class Demo {
	private Random rand;
	private static boolean firstRun = true;
	public Demo(){
		rand = new Random();
	}
	
	public void runDemo(){
		if(firstRun){
			ItemCtr iCtr = new ItemCtr();
			CategoryCtr cCtr = new CategoryCtr();

			try {
				iCtr.createStorage("Trælast");
				iCtr.createStorage("Byggecenter");
				iCtr.createStorage("Lager A");
				iCtr.createStorage("Lager B");
				iCtr.createStorage("Lager C");
				iCtr.createStorage("Lager D");
				
			} catch (StorageExistException e1) {
				e1.printStackTrace();
			}
			Storage s1 = iCtr.findStorage("Trælast");
			Storage s2 = iCtr.findStorage("Byggecenter");
			Storage s3 = iCtr.findStorage("Lager A");
			Storage s4 = iCtr.findStorage("Lager B");
			Storage s5 = iCtr.findStorage("Lager C");
			Storage s6 = iCtr.findStorage("Lager D");

			try {
				cCtr.createCategory("Søm");
				cCtr.createCategory("Hammer");
				cCtr.createCategory("Træ");
				cCtr.createCategory("Beton");
				cCtr.createCategory("Mur");
				cCtr.createCategory("Bord");
				cCtr.createCategory("Stol");
				cCtr.createCategory("Loft");
				cCtr.createCategory("Tavle");
				cCtr.createCategory("TV-Skærm");
				cCtr.createCategory("Vindue");
				cCtr.createCategory("Maling");
			} catch (CategoryExistException e) {
				e.printStackTrace();
			}

			Category c1 = cCtr.findCategory("Søm");
			Category c2 = cCtr.findCategory("Hammer");
			Category c3 = cCtr.findCategory("Træ");
			Category c4 = cCtr.findCategory("Beton");
			Category c5 = cCtr.findCategory("Mur");
			Category c6 = cCtr.findCategory("Bord");
			Category c7 = cCtr.findCategory("Stol");
			Category c8 = cCtr.findCategory("Loft");
			Category c9 = cCtr.findCategory("Tavle");
			Category c10 = cCtr.findCategory("TV-Skærm");
			Category c11 = cCtr.findCategory("Vindue");
			Category c12 = cCtr.findCategory("Maling");
			
			

			iCtr.createItem("Søm Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
			iCtr.createItem("Søm t. Sømpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);

			iCtr.createItem("Flad Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
			iCtr.createItem("Rund Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);

			ArrayList<Category> catList = new ArrayList<Category>();
			catList.add(c1);
			catList.add(c2);
			catList.add(c3);
			catList.add(c4);
			catList.add(c5);
			catList.add(c6);
			catList.add(c7);
			catList.add(c8);
			catList.add(c9);
			catList.add(c10);
			catList.add(c11);
			catList.add(c12);
			
			ArrayList<Storage> storList = new ArrayList<Storage>();
			storList.add(s1);
			storList.add(s2);
			storList.add(s3);
			storList.add(s4);
			storList.add(s5);
			storList.add(s6);
			
			String[] lokArray = {"Hylde 2", "Lok A", "Lok B", "Lok C", "På loftet", "På lageret", "Række 27", "Bagved", "Spørg Bjarne"};
			
			for(int i = 0; i<1000000; i++){
				int c = rand.nextInt(catList.size());
				int z = rand.nextInt(storList.size());
				int y = rand.nextInt(lokArray.length);
				iCtr.createItem("Test ting "+i, 5+i, 0, 220+i, 230+i, 100+i, 3+i, lokArray[y], storList.get(z), (100+i), (5+i), catList.get(c));
			}

			EmployeeCtr eCtr = new EmployeeCtr();
			try {
				eCtr.createEmployee("1", "Ole", "70809010", "Egonsvej 19", "ole@ucn.dk", "Aalborg", "9000", "201050-1043", "1234", true);
				eCtr.createEmployee("2", "Jens", "40509010", "Hobrovej 29", "jens@ucn.dk", "Vestbjerg", "9380", "100170-2143", null, false);
				eCtr.createEmployee("3", "Bjarne", "12345678", "Hobrovej 26", "bjarne@ucn.dk", "Vestbjerg", "9380", "100170-2141", null, false);

				for(int i = 4; i < 75; i++){
					String name = name();
					eCtr.createEmployee(i+"", name, phone(), street(), email(name, "@vb.dk"), city(), postCode(), cpr(), null, false);
				}
				for(int i = 75; i < 85; i++){
					String name = name();
					eCtr.createEmployee(i+"", name, phone(), street(), email(name, "@vb.dk"), city(), postCode(), cpr(), "asd", true);
				}
			} catch (AlreadyExistException e1) {
				e1.printStackTrace();
			}
			

			CustomerCtr cusCtr = new CustomerCtr();
			cusCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");

			for(int i = 0; i < 1000000; i++){
				String name = name();
				cusCtr.createPrivateCustomer(name, phone(), street(), email(name, "@priv.dk"), city(), postCode(), cpr(), "1");

			}
			
			for(int i = 0; i < 125; i++) {
				String name = name();
				cusCtr.createBusinessCustomer(name, phone(), street(), email(name, "@ft.dk"), city(), postCode(), company(), cvrNr());
			}

			cusCtr.createBusinessCustomer("Kis", "72691867", "Sofiendalsvej 60", "kbha@ucn.dk", "Aalborg", "9000", "UCN A/S", "33556063");
			
			
			try {
				for(int i = 1; i<45; i++){
					SaleCtr sCtr = new SaleCtr();
					sCtr.createSale();
					Item itemi = iCtr.getItem(i);
					sCtr.addItem(itemi, 1);
					Customer c = cusCtr.findCustomer(90+i);
					sCtr.setCustomer(c);
					sCtr.finishSale(""+(rand.nextInt(75)+1));
				}
				
				for(int i = 30; i<55; i++){
					SaleCtr sCtr = new SaleCtr();
					sCtr.createSale();
					Item itemi = iCtr.getItem(i);
					sCtr.addItem(itemi, 1);
					Customer c = cusCtr.findCustomer(40+i);
					sCtr.setCustomer(c);
					sCtr.parkSale();
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (NotEnoughItemsException e) {
				e.printStackTrace();
			} catch (SaleNotCreatedException e) {
				e.printStackTrace();
			}

			firstRun = false;
		}	
	}
	
	private String cpr(){
		return (rand.nextInt(899999)+100000) + "-" + (rand.nextInt(8999)+1000);
	}
	
	private String phone(){
		return "9846"+(rand.nextInt(8999)+1000);
	}
	
	private String street(){
		String[] strArray = {"Rosenvej", "Vesterbro", "Østerbro", "Niels Lykkes Gade", "Zieglersvej", "Kronprinsens Alle", "Østergade", "Engvej", "Ferskenvej", "Solvej", "Vestbjerg", "Søndergade", "Norden Alle"};
		int str = rand.nextInt(strArray.length);
		int nr = (rand.nextInt(93)+1);
		return strArray[str]+" "+nr;
	}
	
	private String company(){
		String[] compArray = {"JØR", "Tømrer", "Svenne", "Hans og søn", "Arne og Co.", "Vindue Service", "Reparer bil", "Hegnflytter", "Træplanter"};
		int comp = rand.nextInt(compArray.length);
		return compArray[comp]+" A/S";
	}
	
	private String city(){
		String[] cityArray = {"Sæby", "Frederikshavn", "Aalborg", "Vestbjerg", "Løkken", "Prag", "København", "Aarhus", "Odense", "Nørresundby", "Flensborg", "Berlin"};
		int city = rand.nextInt(cityArray.length);
		return cityArray[city];
	}
	
	private String email(String name, String at){
		int nr = (rand.nextInt(89)+10);
		return name.toLowerCase().substring(0,3).trim()+nr+at;
	}
	
	private String name(){
		String[] nameArray = {"Hans T.", "Grethe T.", "Flemming T.", "Birthe T.", "Åse T.", "Arne T.", "Henriette Birgitte Hansen T.", "Ib T.", "Mads", "Svend", "Poul", "Anders", "Rene", "Signe", "Marie", "Kristian"};
		int name = rand.nextInt(nameArray.length);
		return nameArray[name];
	}
	
	private String postCode(){
		return (rand.nextInt(89)+10)+"00";
	}
	
	private String cvrNr(){
		return "DK"+rand.nextInt(89999999)+10000000;
	}
	
}

