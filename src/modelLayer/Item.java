package modelLayer;

/**
 * Item holds information of a item.
 * 
 * @author Group 1
 * @version 0.1
 */
public class Item {
	private static int idIterator;
	private int id;
	private String name;
	private int amount;
	private int reserved;
	private double salePrice;
	private double purchasePrice;
	private double bulkSalePrice;
	private int bulk;
	private String location;
	private Storage storage;
	private int max;
	private int min;
	private Category category;
	private String description;
	
	/**
	 * Constructor of the class Item
	 * 
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
	public Item(String name, int amount, int reserved,
			double salePrice, double purchasePrice, double bulkSalePrice,
			int bulk, String location, Storage storage, int max, int min,
			Category category) {
		idIterator++;
		id = idIterator;
		this.name = name;
		this.amount = amount;
		this.reserved = reserved;
		this.salePrice = salePrice;
		this.purchasePrice = purchasePrice;
		this.bulkSalePrice = bulkSalePrice;
		this.bulk = bulk;
		this.location = location;
		this.storage = storage;
		this.max = max;
		this.min = min;
		this.category = category;
	}
	
	/**
	 * addReserved - Add amount to reserved.
	 * 
	 * @param amount The amount to add.
	 */
	public void addReserved(int amount) {
		reserved += amount;
	}
	
	/**
	 * addAmount - Add amount to item amount.
	 * 
	 * @param amount The amount to add.
	 */
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
	/**
	 * Get the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the amount
	 * 
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Set the amount
	 * 
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the reserved
	 * 
	 * @return the reserved
	 */
	public int getReserved() {
		return reserved;
	}
	
	/**
	 * Set the reserved
	 * 
	 * @param reserved the reserved to set
	 */
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	
	/**
	 * Get the salePrice
	 * 
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}
	
	/**
	 * Set the salePrice
	 * 
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	/**
	 * Get the purchasePrice
	 * 
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Set the purchasePrice
	 * 
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	/**
	 * Get the bulkSalePrice
	 * 
	 * @return the bulkSalePrice
	 */
	public double getBulkSalePrice() {
		return bulkSalePrice;
	}
	
	/**
	 * Set the bulkSalePrice
	 * 
	 * @param bulkSalePrice the bulkSalePrice to set
	 */
	public void setBulkSalePrice(double bulkSalePrice) {
		this.bulkSalePrice = bulkSalePrice;
	}
	
	/**
	 * Get the bulk
	 * 
	 * @return the bulk
	 */
	public int getBulk() {
		return bulk;
	}
	
	/**
	 * Set the bulk
	 * 
	 * @param bulk the bulk to set
	 */
	public void setBulk(int bulk) {
		this.bulk = bulk;
	}
	
	/**
	 * Get the location
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Set the location
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Get the storage
	 * 
	 * @return the storage
	 */
	public Storage getStorage() {
		return storage;
	}
	
	/**
	 * Set the storage
	 * 
	 * @param storage the storage to set
	 */
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	/**
	 * Get the max
	 * 
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	
	/**
	 * Set the max
	 * 
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * Get the min
	 * 
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	
	/**
	 * Set the min
	 * 
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	/**
	 * Get the category
	 * 
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * Set the category
	 * 
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * Get the id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get the description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set the description
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
