package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

import ctrLayer.ItemCtr;
import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;

public class CreateItemUI extends SuperUI {
	private Category selectedCategory;
	private Storage selectedStorage;

	public CreateItemUI(Category c, Storage s) {
		this.selectedCategory = c;
		this.selectedStorage = s;

		try{
			boolean exit = false;
			while(!exit){
				int choice = writeItemMenu();
				if(choice == 1){
					ItemUI iUi = new ItemUI("DryRun");
					selectedCategory = iUi.pickCategory();
				}else if(choice == 2){
					ItemUI iUi = new ItemUI("DryRun");
					selectedStorage = iUi.pickStorage();
				}else if(choice == 3){
					if(selectedCategory != null && selectedStorage != null){
						createItem();
					}
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
				System.out.println(" 1. Vælg Kategori");
			}else{
				System.out.println(" 1. Skift Kategori (" + selectedCategory.getName() + ")");
			}
			
			if(selectedStorage == null){
				System.out.println(" 2. Vælg Lager");
			}else{
				System.out.println(" 2. Skift Lager (" + selectedStorage.getName() + ")");
			}
			
			if(selectedStorage != null && selectedCategory != null){
				System.out.println(" 3. Opret Vare (Lager: " + selectedStorage.getName() + ", Kategori: " + selectedCategory.getName() + ")");
				System.out.println(" 4. Tilbage");
			}else{
				System.out.println(" 4. Gå tilbage");
				System.out.println("Lager og Kategori skal vare valgt for at oprette en vare");
			}
			System.out.print("Valg:");
			Scanner k = new Scanner(System.in);
			choice = k.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	/**
	 * createItem - TUI for creating an Item
	 */
	private void createItem() {
		ItemCtr iCtr = new ItemCtr();
		String name = null;
		boolean done = false;
		while(!done){
			name = requestString("Navn", 1, null, false);
			boolean reCheck = true;
			while(reCheck){
				Item i = iCtr.getItem(name);
				if(iCtr.getItem(name) != null && i.getStorage() == selectedStorage){
					if(confirm(i.getName() + " eksistere allerede på " + i.getStorage().getName() + ", vil du vælge et andet lager?")){
						ItemUI iUi = new ItemUI("DryRun");
						selectedStorage = iUi.pickStorage();
					}else{
						return;
					}
				}else{
					reCheck = false;
					done = true;
				}
			}
		}
		int amount = requestInt("Antal", null, false);
		double salePrice = requestDouble("Salgs pris", false);
		double purchasePrice = requestDouble("Købs pris", false);
		double bulkSalePrice = requestDouble("Bulk pris", false);
		int bulk = requestInt("Bulk", null, false);
		String location = requestString("Placering", null, null, false);
		int min = requestInt("Minimum Lagerbeholdning", null, false);
		int max = requestInt("Maksimal Lagerbeholdning", min, false);
		iCtr.createItem(name, amount, 0, salePrice, purchasePrice, bulkSalePrice, bulk, location, selectedStorage, max, min, selectedCategory);
	}

}
