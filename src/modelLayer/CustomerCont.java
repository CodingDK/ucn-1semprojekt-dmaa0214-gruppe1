package modelLayer;
import java.util.ArrayList;
import java.util.Iterator;

import personLayer.*;

/**
 * CustomerCont holds a list of all categories.
 * 
 * @author Group 1
 * @version 0.1
 */
public class CustomerCont {
	private static CustomerCont instance;
	private ArrayList<Customer> customers;

	/**
	 * Constructor for CustomerCont objects.
	 */
	private CustomerCont(){
		customers = new ArrayList<Customer>();
	}

	/**
	 * getInstance - Returns the instance of CustomerCont
	 * @return instance get only one instance of the container
	 */
	public static CustomerCont getInstance(){
		if(instance == null){
			instance = new CustomerCont();
		}

		return instance;
	}

	/**
	 * Adds a Customer to the Container
	 * @param c The Customer to add.
	 */
	public void addCustomer(Customer c){
		customers.add(c);
	}

	/**
	 * Finds a Customer by ID
	 * @param id the id of the customer to look for
	 * @return Customer The found Customer or null
	 */
	public Customer findCustomer(int id){
		boolean found = false;
		Customer c = null;
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext() && !found){
			Customer cu = it.next();
			if(cu.getId() == id){
				c = cu;
				found = true;
			}
		}

		return c;
	}

	/**
	 * Removes a Customer.
	 * @param c the Customer to remove
	 */
	public void removeCustomer(Customer c){
		customers.remove(c);
	}

	/**
	 * @return ArrayList<Customer> Returns the list of customers.
	 */
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
}
