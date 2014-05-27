package modelLayer;
import java.util.ArrayList;

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
}
