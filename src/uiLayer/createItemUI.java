package uiLayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ctrLayer.CategoryCtr;
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
			System.out.println(" 1. Vælg Kategori");
			System.out.println(" 2. Vælg Lager");
			if(selectedStorage != null && selectedCategory != null){
				System.out.println(" 3. Opret Vare (" + selectedStorage.getName() + ", " + selectedCategory.getName() + ")");
				System.out.println(" 4. Tilbage");
			}else{
				System.out.println(" 4. Tilbage");
				System.out.println("Lager og Kategori skal være valgt for at oprette en vare");
			}
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	private void selectCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> categories = cCtr.getAllCategories();
		System.out.println("## Vælg Kategori ##");
		for(Category c : categories){
			System.out.println("#" + c.getId() + " - " + c.getName());
		}
		
		boolean done = false;
		while(!done){
			Scanner k = new Scanner(System.in);
			System.out.print("Vælg Kategori(ID): ");
			String categoryID = k.nextLine();
			if(cCtr.findCategory(categoryID)){
				
			}
		}
	}

	private void selectStorage() {
		
	}

	private void createItem() {
		
	}

}
