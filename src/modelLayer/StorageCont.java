package modelLayer;

import java.util.ArrayList;

/**
 * StorageCont contains a list of all storage.
 * Singleton
 * 
 * @author Group 1
 * @version 0.1
 */
public class StorageCont {
	private static StorageCont instance;
	private static boolean firstRun = true;
	private static Storage primaryStorage;
	private final ArrayList<Storage> storages;
	
	/**
	 * Constructor for objects of class StorageCont
	 */
	private StorageCont() {
		storages = new ArrayList<Storage>();
		if (firstRun) {
			primaryStorage = new Storage("Ukendt");
			addStorage(primaryStorage);
			firstRun = false;
		}
		
	}
	
	/**
	 * getInstance - Get only one instance of the StorageCont.
	 * 
	 * @return StorageCont - The instance of the StorageCont.
	 */
	public static StorageCont getInstance() {
		if (instance == null) {
			instance = new StorageCont();
		}
		return instance;
	}
	
	/**
	 * getPrimary - Returns the Primary Storage
	 * 
	 * @return Storage
	 */
	public Storage getPrimary() {
		return primaryStorage;
	}
	
	/**
	 * addStorage - Add a Storage object to the StorageCont.
	 * 
	 * @param s The Storage object to add.
	 */
	public void addStorage(final Storage s) {
		storages.add(s);
	}
	
	/**
	 * findStorage - Get a Storage object from the name of the Storage.
	 * 
	 * @param name - The name of the Storage.
	 * @return Storage object of the Storage or null if not found.
	 */
	public Storage findStorage(final String name) {
		Storage retStorage = null;
		boolean found = false;
		int i = 0;
		while (i < storages.size() && !found) {
			if (storages.get(i).getName().equalsIgnoreCase(name)) {
				retStorage = storages.get(i);
				found = true;
			}
			i++;
		}
		
		return retStorage;
	}
	
	/**
	 * removeStorage - Remove a Storage object from the container.
	 * 
	 * @param s The Storage object to remove.
	 */
	public void removeStorage(final Storage s) {
		storages.remove(s);
	}
	
	/**
	 * getAll - Get a list of all Storages.
	 * 
	 * @return ArrayList<Storage> A list with all storages.
	 */
	public ArrayList<Storage> getAll() {
		return storages;
	}
}
