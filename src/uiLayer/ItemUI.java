package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelLayer.*;
import ctrLayer.*;

public class ItemUI extends SuperUI{
	private Category selectedCategory;
	private Storage selectedStorage;
	
	public ItemUI(){
		selectedCategory = null;
		selectedStorage = null;
		
		boolean exit = false;
		while(!exit){
			int choice = writeMenu();
			if(choice == 1){
				createCategory();
			} else if(choice == 2){
				createStorage();
			} else if(choice == 3){
				new createItemUI(selectedCategory, selectedStorage);
			} else if(choice == 4){
				
			} else if(choice == 5){
				
			} else if(choice == 6){
				
			} else if(choice == 7){
				
			} else if(choice == 8){
				
			} else if(choice == 9){
				exit = true;
			}		
		}		
	}
	
	private int writeMenu(){
		int choice = 0;
		try{
			System.out.println("## Kunde menu ##");
			System.out.println(" 1. Opret Kategori");
			System.out.println(" 2. Opret Vare");
			System.out.println(" 3. Find Vare");
			System.out.println(" 4. Find Kategori");
			System.out.println(" 5. Opdater Vare");
			System.out.println(" 6. Opdater Kategori");
			System.out.println(" 7. Fjern Vare");
			System.out.println(" 8. Fjern Kategori");
			System.out.println(" 9. Exit");
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
			if(iCtr.findStorage(storageName)){
				iCtr.createStorage(storageName);
			}else{
				System.out.println("Dette Lager eksistere allerede");
				if(confirm("Vil du markere denne til senere brug?(Oprettelse af ny vare)")){
					selectedStorage = iCtr.findCategory(storageName);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void findItem() {
	}
	
	private void findCategory() {
	}
	
	private void updateItem() {
	}
	
	private void updateCategory() {
	}
	
	private void removeItem() {
	}
	
	private void removeCategory() {
	}
	
}
