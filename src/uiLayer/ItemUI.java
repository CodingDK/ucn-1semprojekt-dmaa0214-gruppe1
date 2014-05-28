package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;

import modelLayer.*;
import ctrLayer.*;

public class ItemUI extends SuperUI{
	private Category selectedCategory;
	private Storage selectedStorage;
	private Item selectedItem;
	
	public ItemUI(String dryRun){
		
	}
	
	public ItemUI(){
		selectedCategory = null;
		selectedStorage = null;
		selectedItem = null;
		
		boolean exit = false;
		while(!exit){
			int choice = writeMenu();
			if(admin){ // Admin adgang
				if(choice == 1){ 
					createCategory();
				} else if(choice == 2){ 
					if(selectedCategory != null){
						updateCategory();
					}else{
						selectedCategory = pickCategory();
						updateCategory();
					}
				} else if(choice == 3){ 
					if(selectedCategory != null){
						removeCategory();
					}else{
						selectedCategory = pickCategory();
						removeCategory();
					}
				} else if(choice == 4){ 
					selectedCategory = pickCategory();
				} else if(choice == 6){
					createStorage();
				} else if(choice == 7){ 
					if(selectedStorage != null){
						updateStorage();
					}else{
						selectedStorage = pickStorage();
						updateStorage();
					}
				} else if(choice == 8){
					if(selectedStorage != null){
						removeStorage();
					}else{
						selectedStorage = pickStorage();
						removeStorage();
					}
				} else if(choice == 9){
					selectedStorage = pickStorage();
				}  else if(choice == 11){
					new CreateItemUI(selectedCategory, selectedStorage);
				} else if(choice == 12){
					if(selectedItem != null){
						updateItem();
					}else{
						pickItem();
						updateItem();
					}
				} else if(choice == 13){
					if(selectedItem != null){
						removeItem();
					}else{
						pickItem();
						removeItem();
					}
				} else if(choice == 14){
					selectedItem = pickItem();
				}  
			}
			
			{ // Seller + Admin adgang
				if(choice == 5){
					searchCategory();
				}else if(choice == 10){
					searchStorage();
				}else if(choice == 15){
					searchItem();
				}else if(choice == 16){
					exit = true;
				}
			}
		}		
	}
	

	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("## Item menu ##");
			{
				if(admin){
					System.out.println("--------------------------");
					System.out.println(" 1. Opret Kategori");
					String category = (selectedCategory != null) ? " (" + selectedCategory.getName() + ")" : "";
					System.out.println(" 2. Opdater Kategori" + category);
					System.out.println(" 3. Fjern Kategori" + category);
					System.out.println(" 4. Vælg Kategori");
				}
				System.out.println(" 5. Søg Kategori");
				System.out.println("--------------------------");
			}
			
			{
				if(admin){
					System.out.println(" 6. Opret Lager");
					String storage = (selectedStorage != null) ? " (" + selectedStorage.getName() + ")" : "";
					System.out.println(" 7. Opdater Lager" + storage);
					System.out.println(" 8. Fjern Lager" + storage);
					System.out.println(" 9. Vælg Lager");
				}
				System.out.println(" 10. Søg Lager");
				System.out.println("--------------------------");
			}

			{
				if(admin){
					System.out.println(" 11. Opret Vare");
					String item = (selectedItem != null) ? " (" + selectedItem.getName() + ")" : "";
					System.out.println(" 12. Opdater Vare" + item);
					System.out.println(" 13. Fjern Vare" + item);
					System.out.println(" 14. Vælg Vare");
				}
				System.out.println(" 15. Søg Vare");
				System.out.println("--------------------------");
			}
			System.out.println(" 16. Gå tilbage");
			choice = requestInt("Valg", null, false);
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	/**
	 * pickStorage - Possible to search and pick a Storage
	 * @return Storage
	 */
	public Storage pickStorage() {
		Storage retStorage = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("## Vælg Lagre ##");
				String name = requestString("Lager navn", null, null, false);
				ItemCtr iCtr = new ItemCtr();
				ArrayList<Storage> storages = iCtr.searchStorage(name);
				if(storages != null && storages.size() > 0){
					boolean recheck = true;
					System.out.println(storages.size() + " Lagre Fundet");
					while(recheck){
						for(Storage s : storages){
							System.out.println("#" + s.getId() + " - " + s.getName());
						}
						int i = requestInt("LagerID", null, false);
						if(iCtr.findStorage(i) != null && storages.contains(iCtr.findStorage(i))){
							retStorage = iCtr.findStorage(i);
							System.out.println("Lager " + retStorage.getName() + " valgt");
							pause();
							done = true;
							recheck = false;
						}else{
							recheck = true;
						}
					}
				}else{
					System.out.println("0 Lagre Fundet");
					pause();
					done = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retStorage;
		
	}

	/**
	 * pickCategory - Possible to search and pick a Category
	 * @return Category
	 */
	public Category pickCategory() {
		Category retCategory = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("## Vælg Kategori ##");
				String name = requestString("Kategori navn", null, null, false);
				CategoryCtr cCtr = new CategoryCtr();
				ArrayList<Category> cats = cCtr.searchCategory(name);
				if(cats != null && cats.size() > 0){
					boolean recheck = true;
					System.out.println(cats.size() + " Kategorier Fundet");
					while(recheck){
						for(Category c : cats){
							System.out.println("#" + c.getId() + " - " + c.getName());
						}
						int i = requestInt("KategoriID", null, false);
						if(cCtr.findCategory(i) != null && cats.contains(cCtr.findCategory(i))){
							retCategory = cCtr.findCategory(i);
							System.out.println("Kategori " + retCategory.getName() + " valgt");
							pause();
							done = true;
							recheck = false;
						}else{
							recheck = true;
						}
					}
				}else{
					System.out.println("0 Kategorier Fundet");
					pause();
					done = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retCategory;
		
		
	}
	
	/**
	 * createCategory - TUI for creating a Category
	 */
	private void createCategory() {
		try{
			CategoryCtr cCtr = new CategoryCtr();
			
			System.out.println(" *** Opret Kategori *** ");
			String categoryName = requestString("Kategori navn", 1, null, false);
			if(cCtr.findCategory(categoryName) == null){
				cCtr.createCategory(categoryName);
				selectedCategory = cCtr.findCategory(categoryName);
			}else{
				System.out.println("Denne Kategori eksistere allerede");
				if(confirm("Vil du markere denne til senere brug?(Oprettelse af ny vare)")){
					selectedCategory = cCtr.findCategory(categoryName);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * createStorage - TUI for creating a Storage
	 */
	private void createStorage() {
		try{
			ItemCtr iCtr = new ItemCtr();
			
			System.out.println(" *** Opret Lager *** ");
			String storageName = requestString("Lager navn", 1, null, false);
			if(iCtr.findStorage(storageName) == null){
				iCtr.createStorage(storageName);
				selectedStorage = iCtr.findStorage(storageName);
			}else{
				System.out.println("Dette Lager eksistere allerede");
				if(confirm("Vil du markere denne til senere brug?(Oprettelse af ny vare)")){
					selectedStorage = iCtr.findStorage(storageName);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * searchItem - Search through Items
	 */
	private void searchItem() {
		try{
			System.out.println("## Søg Vare ##");
			String name = requestString("Vare navn: ", null, null, false);
			ItemCtr iCtr = new ItemCtr();
			ArrayList<Item> items = iCtr.searchItem(name);
			if(items != null){
				System.out.println(items.size() + " Varer Fundet");
				for(Item i : items){
					String amount = "(";
					if(i.getReserved() != 0){
						amount += i.getReserved() + "/";
					}
					amount += i.getAmount() + ")";
					System.out.println("#" + i.getId() + " - " + i.getName() + " Antal: " + amount + " Kategori: " + i.getCategory().getName() + " Lager: " + i.getStorage().getName());
				}
				pause();
			}else{
				System.out.println("0 Varer Fundet");
				pause();
				return;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * pickItem - Possible to search and pick a Item
	 * @return Item
	 */
	public Item pickItem() {
		Item retItem = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("## Vælg Vare ##");
				String name = requestString("Vare navn", null, null, false);
				ItemCtr iCtr = new ItemCtr();
				ArrayList<Item> items = iCtr.searchItem(name);
				if(items != null && items.size() > 0){
					boolean recheck = true;
					System.out.println(items.size() + " Varer Fundet");
					while(recheck){
						for(Item i : items){
							String amount = "(";
							if(i.getReserved() != 0){
								amount += i.getReserved() + "/";
							}
							amount += i.getAmount() + ")";
							System.out.println("#" + i.getId() + " - " + i.getName() + " Antal: " + amount + " Kategori: " + i.getCategory().getName() + " Lager: " + i.getStorage().getName());
						}
						int i = requestInt("VareID", null, false);
						if(iCtr.getItem(i) != null && items.contains(iCtr.getItem(i))){
							retItem = iCtr.getItem(i);
							System.out.println("Vare " + retItem.getName() + " valgt");
							pause();
							done = true;
							recheck = false;
						}else{
							recheck = true;
						}
					}
				}else{
					System.out.println("0 Varer Fundet");
					pause();
					done = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retItem;
	}
	
	/**
	 * searchCategory - Search through Category
	 */
	private void searchCategory() {
		try{
			System.out.println("## Søg Kategori ##");
			String name = requestString("Kategori navn: ", null, null, false);
			CategoryCtr cCtr = new CategoryCtr();
			ArrayList<Category> cats = cCtr.searchCategory(name);
			if(cats != null){
				System.out.println(cats.size() + " Kategorier Fundet");
				for(Category c : cats){
					System.out.println("#" + c.getId() + " - " + c.getName());
				}
				pause();
			}else{
				System.out.println("0 Kategorier Fundet");
				pause();
				return;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * searchStorage - Search through Storage
	 */
	private void searchStorage(){
		try{
			System.out.println("## Søg Lager ##");
			String name = requestString("Lager navn", null, null, false);
			ItemCtr iCtr = new ItemCtr();
			ArrayList<Storage> storages = iCtr.searchStorage(name);
			if(storages != null){
				System.out.println(storages.size() + " Lagre Fundet");
				for(Storage s : storages){
					System.out.println("#" + s.getId() + " - " + s.getName());
				}
				pause();
			}else{
				System.out.println("0 Lagre Fundet");
				pause();
				return;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * updateItem - TUI for updating an Item
	 */
	private void updateItem() {
		ItemCtr iCtr = new ItemCtr();
		System.out.println("## Opdater Vare : " + selectedItem.getName() + " ##");
		
		String name = requestString("Navn(" + selectedItem.getName() + ")", null, null, true);
		int amount = requestInt("Antal(" + selectedItem.getAmount() + ")", null, true);
		int reserved = requestInt("Reserveret(" + selectedItem.getReserved() + ")", null, true);
		double salePrice = requestDouble("Salgs Pris(" + selectedItem.getSalePrice() + ")", true);
		double purchasePrice = requestDouble("K�bs Pris(" + selectedItem.getPurchasePrice() + ")", true);
		double bulkSalePrice = requestDouble("Bulk Pris(" + selectedItem.getBulkSalePrice() + ")", true);
		int bulk = requestInt("Bulk(" + selectedItem.getBulk() + ")", null, true);
		String location = requestString("Placering(" + selectedItem.getLocation() + ")", 0, null, true);
		int min = requestInt("Minimum Lagerbeholdning(" + selectedItem.getMin() + ")", null, true);
		int max = requestInt("Maksimal Lagerbeholdning(" + selectedItem.getMax() + ")", min, true);
		Storage storage = null;
		Category category = null;
		
		if(confirm("Vil du ændre Lager?(" + selectedItem.getStorage().getName() + ")")){
			while(storage == null){
				storage = pickStorage();
			}
		}
		if(confirm("Vil du ændre Kategori?(" + selectedItem.getCategory().getName() + ")")){
			while(category == null){
				category = pickCategory();
			}
		}
		
		iCtr.updateItem(selectedItem.getId(), name, amount, reserved, salePrice, purchasePrice, 
				bulkSalePrice, bulk, location, storage, max, min, category);
	}
	
	/**
	 * updateCategory - TUI for updating a Category
	 */
	private void updateCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		String name = requestString("Navn(" + selectedCategory.getName() + ")", null, null, false);
		cCtr.updateCategory(selectedCategory, name);

	}
	
	/**
	 * updateStorage - TUI for updating a Storage
	 */
	private void updateStorage(){
		ItemCtr iCtr = new ItemCtr();
		String name = requestString("Navn(" + selectedStorage.getName() + ")", null, null, false);
		iCtr.updateStorage(selectedStorage, name);
	}
	
	/**
	 * removeItem - TUI for removing Items
	 */
	private void removeItem() {
		ItemCtr iCtr = new ItemCtr();
		iCtr.removeItem(selectedItem);
	}
	
	/**
	 * removeCategory - TUI for removing a Category
	 */
	private void removeCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		cCtr.removeCategory(selectedCategory);
		selectedCategory = null;
	}
	
	/**
	 * removeStorage - TUI for removing Storage
	 */
	private void removeStorage(){
		ItemCtr iCtr = new ItemCtr();
		if(!iCtr.isPrimary(selectedStorage)){
			iCtr.removeStorage(selectedStorage);
		}else{
			System.out.println("Dette lager kan ikke slettes");
			pause();
		}
		selectedStorage = null;
	}
	
}
