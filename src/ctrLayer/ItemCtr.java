package ctrLayer;
import modelLayer.*;

import java.util.*;

/**
 * Controller class for the ItemCtr
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class ItemCtr {
	
	public ItemCtr(){}
	
	/**
	 * getItem - Get an item object from an id.
	 * @param id The id of the Item object.
	 * @return Item - The founded object or null.
	 */
	public Item getItem(int id){
		Item retItem = null;
		
		ArrayList<Category> allCat = new CategoryCtr().getAllCategories();
		boolean found = false;
		int iCat = 0;
		while(iCat < allCat.size() && !found){
			int i = 0;
			ArrayList<Item> items = ItemCont.getInstance(allCat.get(iCat)).getAll();
			iCat++;
			while(i < items.size() && !found){
				if(items.get(i).getId() == id){
					retItem = items.get(i);
					found = true;
				}
				i++;
			}
		}
		return retItem;
	}
	
	/**
	 * getItem - Get an item object from a name.
	 * @param name The name of the Item object.
	 * @return Item - The founded object or null.
	 */
	public Item getItem(String name){
		Item retItem = null;
		
		ArrayList<Category> allCat = new CategoryCtr().getAllCategories();
		boolean found = false;
		int iCat = 0;
		while(iCat < allCat.size() && !found){
			int i = 0;
			ArrayList<Item> items = ItemCont.getInstance(allCat.get(iCat)).getAll();
			iCat++;
			while(i < items.size() && !found){
				if(items.get(i).getName().equalsIgnoreCase(name)){
					retItem = items.get(i);
					found = true;
				}
				i++;
			}
		}
		return retItem;
	}
	
	/**
	 * createItem - Create a new item and add it to the itemContainer.
	 * @param name The name of the item.
	 * @param amount The amount of the item.
	 * @param reserved The reserved of the item.
	 * @param salePrice The salePrice of the item.
	 * @param purchasePrice The purchasePrice of the item.
	 * @param bulkSalePrice The bulkSalePrice of the item.
	 * @param bulk The bulk of the item.
	 * @param location The location of the item.
	 * @param storage The storage object of the item.
	 * @param max the max amount of the item.
	 * @param min The min amount of the item.
	 * @param category The category object of the item.
	 */
	public void createItem(String name, int amount, int reserved, double salePrice, double purchasePrice, double bulkSalePrice, int bulk, String location, Storage storage, int max, int min, Category category){
		Item item = new Item(name, amount, reserved, salePrice, purchasePrice, bulkSalePrice, bulk, location, storage, min, min, category);
		ItemCont.getInstance(category).addItem(item);
	}
	
	/**
	 * updateItem - Update an Item object.
	 * @param id The id of the item.
	 * @param name The name of the item.
	 * @param amount The amount of the item.
	 * @param reserved The reserved of the item.
	 * @param salePrice The salePrice of the item.
	 * @param purchasePrice The purchasePrice of the item.
	 * @param bulkSalePrice The bulkSalePrice of the item.
	 * @param bulk The bulk of the item.
	 * @param location The location of the item.
	 * @param storage The storage object of the item.
	 * @param max the max amount of the item.
	 * @param min The min amount of the item.
	 * @param category The category object of the item.
	 * @throws NullPointerException if id not found.
	 */
	public void updateItem(int id, String name, int amount, int reserved,
			double salePrice, double purchasePrice, double bulkSalePrice,
			int bulk, String location, Storage storage, int max, int min, 
			Category category) throws NullPointerException {
		Item item = getItem(id);
		if(item != null){
			if(name != null) {
				item.setName(name);
			}
			if(amount != -1) {
				item.setAmount(amount);
			}
			if(reserved != -1){
				item.setReserved(reserved);
			}
			if(salePrice != -1){
				item.setSalePrice(salePrice);
			}
			if(purchasePrice != -1){
				item.setPurchasePrice(purchasePrice);
			}
			if(bulkSalePrice != -1){
				item.setBulkSalePrice(bulkSalePrice);
			}
			if(bulk != -1) {
				item.setBulk(bulk);
			}
			if(location != null){
				item.setLocation(location);
			}
			if(storage != null){
				item.setStorage(storage);
			}
			if(max != -1){
				item.setMax(max);
			}
			if(min != -1){
				item.setMin(min);
			}
			if(category != null){
				removeItem(item);
				ItemCont.getInstance(category).addItem(item);
				item.setCategory(category);
			}
		} else {
			throw new NullPointerException("Ukendt vare");
		}
	}
	
	/**
	 * removeItem - Remove an item.
	 * @param i The Item object to remove.
	 */
	public void removeItem(Item i){
		Category oldCat = i.getCategory();
		ItemCont.getInstance(oldCat).removeItem(i);
	}
	
	/**
	 * createStorage - Create a new Storage.
	 * @param name The name of the new Storage.
	 */
	public void createStorage(String name){
		StorageCont.getInstance().addStorage(new Storage(name));
	}
	
	/**
     * findStorage - Get a Storage object from the name of the Storage.
     * @param name - The name of the Storage.
     * @return Storage object of the Storage or null if not found.
     */
	public Storage findStorage(String name){
		StorageCont cCont = StorageCont.getInstance();
		return cCont.findStorage(name);
	}
	
	/**
	 * updateStorage - Update a Storage object.
	 * @param storage The Storage Object to update.
	 * @param name The new name of the Storage.
	 * @throws NullPointerException If Storage object not found.
	 */
	public void updateStorage(Storage s, String name) throws NullPointerException {
		if(s != null){
			s.setName(name);
		} else if(s == null){
			throw new NullPointerException("Ukendt lager");
		}
	}
	
	/**
	 * removeStorage - Remove a Storage object from the container.
	 * Allocates all items to the primary Storage
	 * @param s The Storage object to remove.
	 */
	public void removeStorage(Storage s){
		StorageCont sCont = StorageCont.getInstance();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> categories = cCtr.getAllCategories();
		for(Category c : categories){
			ItemCont iCont = ItemCont.getInstance(c);
			ArrayList<Item> items = iCont.getAll();
			for(Item i : items){
				if(i.getStorage() == s){
					i.setStorage(sCont.getPrimary());
				}
			}
		}
		sCont.removeStorage(s);
	}
	
	/**
	 * Checks if the Storage is the Primary Storage
	 * @param Storage
	 * @return boolean
	 */
	public boolean isPrimary(Storage s){
		boolean ret = false;
		StorageCont sCont = StorageCont.getInstance();
		if(s == sCont.getPrimary()){
			ret = true;
		}
		return ret;
	}
	
	/**
	 * searchItem - Returns a list of items based on the requested name
	 * @param name
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> searchItem(String name){
		ArrayList<Item> items = new ArrayList<Item>();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> cats = cCtr.getAllCategories();
		if(cats != null){
			for(Category cat : cats){
				ArrayList<Item> list = ItemCont.getInstance(cat).getAll();
				if(list != null){
					for(Item i : list){
						if(i.getName().toLowerCase().contains(name.toLowerCase())){
							items.add(i);
						}
					}
				}
			}
		}
		return items;
	}
	
	/**
	 * searchStorage - Returns a list of Storages based on the requested name
	 * @param name
	 * @return ArrayList<Storage>
	 */
	public ArrayList<Storage> searchStorage(String name) {
		ArrayList<Storage> storages = new ArrayList<Storage>();
		StorageCont sCont = StorageCont.getInstance();
		ArrayList<Storage> stor = sCont.getAll();
		if(stor != null){
			for(Storage s : stor){
				if(s.getName().toLowerCase().contains(name.toLowerCase())){
					storages.add(s);
				}
			}
		}
		return storages;
	}
}
