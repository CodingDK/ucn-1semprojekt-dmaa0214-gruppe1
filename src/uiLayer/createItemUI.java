package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import modelLayer.Category;
import modelLayer.Storage;

public class createItemUI extends SuperUI {
	private Category selectedCategory;
	private Storage selectedStorage;

	public createItemUI(Category c, Storage s) {
		this.selectedCategory = c;
		this.selectedStorage = s;
		
		try{
			Scanner k = new Scanner(System.in);
			boolean exit = false;
			while(!exit){
				int choice = writeItemMenu();
				if(choice == 1){
					selectCategory();
				}else if(choice == 2){
					selectStorage();
				}else if(choice == 3){
					createItem();
				}else if(choice == 4){
					exit = true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private int writeItemMenu(){
		int choice = 0;
		try{
			System.out.println("## Opret Vare ##");
			if(selectedCategory == null){
				System.out.println(" 1. V�lg Kategori");
			}else{
				System.out.println(" 1. Skift Kategori (" + selectedCategory.getName() + ")");
			}
			
			if(selectedStorage == null){
				System.out.println(" 2. V�lg Lager");
			}else{
				System.out.println(" 2. Skift Lager (" + selectedStorage.getName() + ")");
			}
			
			if(selectedStorage != null && selectedCategory != null){
				System.out.println(" 3. Opret Vare (" + selectedStorage.getName() + ", " + selectedCategory.getName() + ")");
				System.out.println(" 4. Tilbage");
			}else{
				System.out.println(" 4. Tilbage");
				System.out.println("Lager og Kategori skal v�re valgt for at oprette en vare");
			}
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	private void selectCategory() {
		boolean done = false;
		while(!done){
			CategoryCtr cCtr = new CategoryCtr();
			ArrayList<Category> categories = cCtr.getAllCategories();
			System.out.println("## V�lg Kategori ##");
			for(Category c : categories){
				System.out.println("#" + c.getId() + " - " + c.getName());
			}
			Scanner k = new Scanner(System.in);
			System.out.print("V�lg Kategori(ID): ");
			int categoryID = k.nextInt();
			k.nextLine();
			if(cCtr.findCategory(categoryID) != null){
				selectedCategory = cCtr.findCategory(categoryID);
				done = true;
			}else{
				System.out.println("Den valgte kategori findes ikke");
			}
		}
	}
	
	private void selectStorage() {
		boolean done = false;
		while(!done){
			ItemCtr iCtr = new ItemCtr();
			ArrayList<Storage> storages = iCtr.getAllStorages();
			System.out.println("## V�lg Lager ##");
			for(Storage s : storages){
				System.out.println("#" + s.getId() + " - " + s.getName());
			}
			Scanner k = new Scanner(System.in);
			System.out.print("V�lg Lager(ID): ");
			int storageID = k.nextInt();
			k.nextLine();
			if(iCtr.findStorage(storageID) != null){
				selectedStorage = iCtr.findStorage(storageID);
				done = true;
			}else{
				System.out.println("Det valgte lager findes ikke");
			}
		}
	}

	private void createItem() {
		
	}

}