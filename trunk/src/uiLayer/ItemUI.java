package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			if(choice == 1){ // Opret Kategori
				createCategory();
			} else if(choice == 2){ // Opdater
				if(selectedCategory != null){
					updateCategory();
				}else{
					pickCategory();
					updateCategory();
				}
			} else if(choice == 3){ // Fjern
				if(selectedCategory != null){
					removeCategory();
				}else{
					pickCategory();
					removeCategory();
				}
			} else if(choice == 4){ // S�g
				searchCategory();
			} else if(choice == 5){ // V�lg
				pickCategory();
			} else if(choice == 6){ // Opret Lager
				createStorage();
			} else if(choice == 7){ // Opdater
				if(selectedStorage != null){
					updateStorage();
				}else{
					pickStorage();
					updateStorage();
				}
			} else if(choice == 8){ // Fjern
				if(selectedStorage != null){
					removeStorage();
				}else{
					pickStorage();
					removeStorage();
				}
			} else if(choice == 9){ // S�g
				searchStorage();
			} else if(choice == 10){ // V�lg
				pickStorage();
			} else if(choice == 11){ // Opret Vare
				new CreateItemUI(selectedCategory, selectedStorage);
			} else if(choice == 12){ // Opdater
				if(selectedItem != null){
					updateItem();
				}else{
					pickItem();
					updateItem();
				}
			} else if(choice == 13){ // Fjern
				if(selectedItem != null){
					removeItem();
				}else{
					pickItem();
					removeItem();
				}
			} else if(choice == 14){ // S�g
				searchItem();
			} else if(choice == 15){ // V�lg
				selectedItem = pickItem();
			} else if(choice == 16){
				exit = true;
			} else if(choice == 17){
				test();
			}
		}		
	}
	
	private void searchStorage() {
		// TODO Auto-generated method stub
		
	}

	private void searchCategory() {
		// TODO Auto-generated method stub
		
	}

	private void pickCategory() {
		// TODO Auto-generated method stub
		
	}

	private void pickStorage() {
		// TODO Auto-generated method stub
		
	}

	private void test(){
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Lager1");
		iCtr.createStorage("Lager2");
		Storage s1 = iCtr.findStorage("Lager1");
		Storage s2 = iCtr.findStorage("Lager2");
		cCtr.createCategory("S�m");
		cCtr.createCategory("Hammer");
		Category c1 = cCtr.findCategory("S�m");
		Category c2 = cCtr.findCategory("Hammer");
		
		
		iCtr.createItem("S�m Flad", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("S�m t. S�mpistol", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		
		iCtr.createItem("Flad Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
		iCtr.createItem("Rund Hammer", 200, 0, 1., 1., 1., 1, "1234", s2, 10, 1, c2);
	}
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("## Item menu ##");
			
			{
				System.out.println("--------------------------");
				System.out.println(" 1. Opret Kategori");
				if(selectedCategory != null){
					System.out.println(" 2. Opdater Kategori (" + selectedCategory.getName() + ")");
				}else{
					System.out.println(" 2. Opdater Kategori");
				}
				if(selectedCategory != null){
					System.out.println(" 3. Fjern Kategori (" + selectedCategory.getName() + ")");
				}else{
					System.out.println(" 3. Fjern Kategori");
				}
				System.out.println(" 4. S�g Kategori");
				System.out.println(" 5. V�lg Kategori");
				System.out.println("--------------------------");
			}
			
			
			{
				System.out.println(" 6. Opret Lager");
				if(selectedStorage != null){
					System.out.println(" 7. Opdater Lager (" + selectedStorage.getName() + ")");
				}else{
					System.out.println(" 7. Opdater Lager");
				}
				if(selectedStorage != null){
					System.out.println(" 8. Fjern Lager (" + selectedStorage.getName() + ")");
				}else{
					System.out.println(" 8. Fjern Lager");
				}
				System.out.println(" 9. S�g Lager");
				System.out.println(" 10. V�lg Lager");
				System.out.println("--------------------------");
			}

			
			{
				System.out.println(" 11. Opret Vare");
				if(selectedItem != null){
					System.out.println(" 12. Opdater Vare (" + selectedItem.getName() + ")");
				}else{
					System.out.println(" 12. Opdater Vare");
				}
				if(selectedItem != null){
					System.out.println(" 13. Fjern Vare (" + selectedItem.getName() + ")");
				}else{
					System.out.println(" 13. Fjern Vare");
				}
				System.out.println(" 14. S�g Vare");
				System.out.println(" 15. V�lg Vare");
				System.out.println("--------------------------");
			}
			
			
			
			System.out.println(" 16. Exit");
			System.out.println(" 17. Test");
			System.out.print("Valg: ");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	private void createCategory() {
		try{
			CategoryCtr cCtr = new CategoryCtr();
			Scanner k = new Scanner(System.in);
			
			System.out.println(" *** Opret Kategori *** ");
			String categoryName = requestString("Kategori navn", 1, null);
			if(cCtr.findCategory(categoryName) == null){
				cCtr.createCategory(categoryName);
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
	
	private void createStorage() {
		try{
			ItemCtr iCtr = new ItemCtr();
			Scanner k = new Scanner(System.in);
			
			System.out.println(" *** Opret Lager *** ");
			String storageName = requestString("Lager navn", 1, null);
			if(iCtr.findStorage(storageName) == null){
				iCtr.createStorage(storageName);
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
	
	private void searchItem() {
		try{
			System.out.println("## S�g Vare ##");
			String name = requestString("Vare navn: ", null, null);
			ItemCtr iCtr = new ItemCtr();
			ArrayList<Item> items = iCtr.searchItem(name);
			if(items != null){
				System.out.println(items.size() + " Varer Fundet");
				for(Item i : items){
					System.out.println("#" + i.getId() + " - " + i.getName() + " Antal: " + i.getAmount() + " Kategori: " + i.getCategory().getName() + " Lager: " + i.getStorage().getName());
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
	
	public Item pickItem() {
		Item retItem = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("## V�lg Vare ##");
				String name = requestString("Vare navn", null, null);
				ItemCtr iCtr = new ItemCtr();
				ArrayList<Item> items = iCtr.searchItem(name);
				if(items != null && items.size() > 0){
					boolean recheck = true;
					System.out.println(items.size() + " Varer Fundet");
					while(recheck){
						for(Item i : items){
							System.out.println("#" + i.getId() + " - " + i.getName() + " Antal: " + i.getAmount() + " Kategori: " + i.getCategory().getName() + " Lager: " + i.getStorage().getName());
						}
						int i = requestInt("VareID", null);
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
	
	private void findCategory() {
		// TODO Auto-generated method stub
	}
	
	private void findStorage(){
		// TODO Auto-generated method stub
		
	}
	
	private void updateItem() {
		// TODO Auto-generated method stub
	}
	
	private void updateCategory() {
		// TODO Auto-generated method stub
	}
	
	private void updateStorage(){
		// TODO Auto-generated method stub
	}
	
	private void removeItem() {
		// TODO Auto-generated method stub
	}
	
	private void removeCategory() {
		// TODO Auto-generated method stub
	}
	
	private void removeStorage(){
		// TODO Auto-generated method stub
	}
	
}
