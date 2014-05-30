package modelLayer;
import java.util.ArrayList;

/**
 * Container for objects of Sale
 * 
 * @author Group 1 
 * @version 0.1
 */
public class SaleCont {
	private static SaleCont instance;
	private ArrayList<Sale> sales; 
	
	/**
	 * Singleton container of the container class SaleCont.
	 */
	private SaleCont(){
		sales = new ArrayList<Sale>();
	}
	
	/**
	 * Get instance method.
	 * @return SaleCont - The instance of the Sale Container.
	 */
	public static SaleCont getInstance(){
		if(instance == null){
			instance = new SaleCont();
		}
		return instance;
	}
	
	/**
	 * Adds a sale object to the list of sales.
	 * @param s Sale object.
	 */
	public void addSale(Sale s){
		sales.add(s);
	}

	public ArrayList<Sale> getAll() {
		return sales;
	}

	public void removeSale(Sale sale) {
		sales.remove(sale);
	}
}
