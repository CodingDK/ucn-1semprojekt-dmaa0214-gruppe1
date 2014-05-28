package modelLayer;

public class PartSale {
	private int amount;
	private Item item;
	
	/**
	 * Constructor of the class PartSale
	 * @param i The Item associated with the PartSale.
	 * @param amount Amount of item.
	 */
	public PartSale(Item i, int amount){
		this.item = i;
		this.amount = amount;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
}
