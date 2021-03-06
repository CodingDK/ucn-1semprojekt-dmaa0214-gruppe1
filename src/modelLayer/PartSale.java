package modelLayer;

/**
 * Item holds information of a partsale.
 * 
 * @author Group 1
 * @version 0.1
 */
public class PartSale {
	private int amount;
	private Item item;
	
	/**
	 * Constructor of the class PartSale
	 * 
	 * @param i The Item associated with the PartSale.
	 * @param amount Amount of item.
	 */
	public PartSale(Item i, int amount) {
		item = i;
		this.amount = amount;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	@Override
	public String toString() {
		return "Vare: " + item.getName() + ", Antal: " + amount;
	}
	
}
