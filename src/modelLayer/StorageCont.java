package modelLayer;
import java.util.ArrayList;

/**
 * StorageCont contains a list of all storage in the StorageCont.
 * 
 * @author Group 1
 * @version 0.1
 */
public class StorageCont{
	private static StorageCont instance;
	private ArrayList<Storage> storage;
	
	/**
	 * Constructor for objects of class StorageCont
	 */
	private StorageCont(){
		storage = new ArrayList<Storage>();
	}
	
	/**
     * getInstance - Get only one instance of the StorageCont.
     * @return StorageCont - The instance of the StorageCont.
     */
	public static StorageCont getInstance(){
		if(instance == null){
			instance = new StorageCont();
		}
		return instance;
	}

	/**
     * addStorage - Add a Storage object to the StorageCont.
     * @param s The Storage object to add.
     */
	public void addStorage(Storage s){
		storage.add(s);
	}
}
