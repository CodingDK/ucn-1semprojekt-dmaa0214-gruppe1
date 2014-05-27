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
	
	public ItemUI(){
		selectedCategory = null;
		selectedStorage = null;
		selectedItem = null;
		
		boolean exit = false;
		while(!exit){
			int choice = writeMenu();
			if(choice == 1){
				createCategory();
			} else if(choice == 2){
				createStorage();
			} else if(choice == 3){
				new CreateItemUI(selectedCategory, selectedStorage);
			} else if(choice == 4){
				searchItem();
			} else if(choice == 5){
				
			} else if(choice == 6){
				
			} else if(choice == 7){
				
			} else if(choice == 8){
				test();
			} else if(choice == 15){
				exit = true;
			}		
		}		
	}
	
	private void test(){
		ItemCtr iCtr = new ItemCtr();
		CategoryCtr cCtr = new CategoryCtr();
		iCtr.createStorage("Lager1");
		iCtr.createStorage("Lager2");
		Storage s1 = iCtr.findStorage("Lager1");
		Storage s2 = iCtr.findStorage("Lager2");
		cCtr.createCategory("Søm");
		cCtr.createCategory("Hammer");
		Category c1 = cCtr.findCategory("Søm");
		Category c2 = cCtr.findCategory("Hammer");
		
		
		iCtr.createItem("Søm Og Skruer", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
		iCtr.createItem("Søm Og Handsker", 200, 0, 1., 1., 1., 1, "1234", s1, 10, 1, c1);
	}
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("## Kunde menu ##");
			System.out.println(" 1. Opret Kategori");
			System.out.println(" 2. Opret Lager");
			System.out.println(" 3. Opret Vare");
			System.out.println(" 4. Find Kategori");
			System.out.println(" 5. Find Lager");
			System.out.println(" 6. Find Vare");
			System.out.println(" 7. Opdater Kategori");
			System.out.println(" 8. Opdater Lager");
			System.out.println(" 9. Opdater Vare");
			System.out.println(" 10. Fjern Kategori");
			System.out.println(" 11. Fjern Lager");
			System.out.println(" 12. Fjern Vare");
			System.out.println(" 15. Exit");
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
			System.out.println("## Søg Item ##");
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
	
	private void findCategory() {
		
	}
	
	private void findStorage(){
		
		
	}
	
	private void updateItem() {
		
	}
	
	private void updateCategory() {
		
	}
	
	private void updateStorage(){
		
		
	}
	
	private void removeItem() {
		
	}
	
	private void removeCategory() {
		
	}
	
	private void removeStorage(){
		
	}
	
}
