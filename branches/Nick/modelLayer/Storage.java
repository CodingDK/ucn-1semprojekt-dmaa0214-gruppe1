package modelLayer;

/**
 * Storage holds information of a storage.
 * 
 * @author Group 1
 * @version 0.1
 */
public class Storage{
	private static int idIterator;
	private int id;
	private String name;

	/**
	 * Constructor of the class Storage
	 * @param name The name of the storage.
	 */
    public Storage(String name) {
    	idIterator++;
    	this.name = name;
    	this.id = idIterator;
    }

    /**
    * getId - Returns the Id
	* @return id
    */
	public int getId(){
		return id;
	}

    /**
    * getName - Returns the Name
	* @return name
    */
	public String getName(){
		return name;
	}

    /**
    * setName - sets the Name
	* @param String name
    */
	public void setName(String name){
		this.name = name;
	}
}