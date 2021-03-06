package uiLayer;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;
import ctrLayer.ItemCtr;

public class CreateItemUI extends SuperUI {
	private Category selectedCategory;
	private Storage selectedStorage;
	
	public CreateItemUI(Category c, Storage s) {
		selectedCategory = c;
		selectedStorage = s;
		
		menu();
	}
	
	/**
	 * menu - Handels the selection part of the UI
	 */
	private void menu() {
		boolean exit = false;
		while (!exit) {
			int choice = writeItemMenu();
			if (choice == 1) {
				ItemUI iUi = new ItemUI("DryRun");
				selectedCategory = iUi.pickCategory();
			} else if (choice == 2) {
				ItemUI iUi = new ItemUI("DryRun");
				selectedStorage = iUi.pickStorage();
			} else if (choice == 3) {
				if (selectedCategory != null && selectedStorage != null) {
					createItem();
				}
			} else if (choice == 4) {
				exit = true;
			}
		}
	}
	
	/**
	 * writeItemMenu - Write the item menu and get a choice.
	 * 
	 * @return The choice by the user.
	 */
	private int writeItemMenu() {
		int choice = 0;
		flush();
		System.out.println("## Opret Vare ##");
		String category = (selectedCategory != null) ? " (" + selectedCategory.getName() + ")" : "";
		System.out.println("1. Vælg Kategori" + category);
		String storage = (selectedStorage != null) ? " (" + selectedStorage.getName() + ")" : "";
		System.out.println("2. Vælg Lager" + storage);
		
		if (selectedStorage != null && selectedCategory != null) {
			System.out.println("3. Opret Vare (Lager: " + selectedStorage.getName() + ", Kategori: " + selectedCategory.getName() + ")");
		} else {
			System.out.println("Lager og Kategori skal vare valgt for at oprette en vare");
		}
		System.out.println("4. Gå tilbage");
		choice = requestInt(nL + "Valg", null, false);
		
		return choice;
	}
	
	/**
	 * createItem - TUI for creating an Item
	 */
	private void createItem() {
		flush();
		System.out.println("## Opret Vare ##");
		ItemCtr iCtr = new ItemCtr();
		String name = null;
		boolean done = false;
		while (!done) {
			name = requestString("Navn", 1, null, false);
			boolean reCheck = true;
			while (reCheck) {
				Item i = iCtr.getItem(name);
				if (iCtr.getItem(name) != null && i.getStorage() == selectedStorage) {
					if (confirm(i.getName() + " eksistere allerede på " + i.getStorage().getName() + ", vil du vælge et andet lager?")) {
						ItemUI iUi = new ItemUI("DryRun");
						selectedStorage = iUi.pickStorage();
					} else {
						return;
					}
				} else {
					reCheck = false;
					done = true;
				}
			}
		}
		int amount = requestInt("Antal", 0, false);
		double salePrice = requestDouble("Salgs pris", false);
		double purchasePrice = requestDouble("Købs pris", false);
		double bulkSalePrice = requestDouble("Bulk pris", false);
		int bulk = requestInt("Bulk", 0, false);
		String location = requestString("Placering", null, null, false);
		int min = requestInt("Minimum Lagerbeholdning", 0, false);
		int max = requestInt("Maksimal Lagerbeholdning", min, false);
		iCtr.createItem(name, amount, 0, salePrice, purchasePrice, bulkSalePrice, bulk, location, selectedStorage, max, min, selectedCategory);
	}
	
}
