package modelLayer;

public class PartSale {
	
	private static idIterator = 1000;
	int id;
	int amount;
	Item item;
	
	/**
	 * Constructor of the class PartSale
	 * @param i The Item associated with the PartSale.
	 * @param amount Amount of item.
	 */
	public PartSale(Item i, int amount){
		id = idIterator;
		idIterator++;
		item = i;
		this.amount = amount;
	}

}
