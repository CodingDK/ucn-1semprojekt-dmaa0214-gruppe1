package modelLayer;
import java.util.ArrayList;
import java.util.Iterator;

import personLayer.*;

public class CustomerCont {
	private static CustomerCont instance;
	private ArrayList<Customer> customers;
	
	private CustomerCont(){
		customers = new ArrayList<Customer>();
	}
	
	/**
	 * Returns the instance of CustomerCont
	 * @return instance
	 */
	public static CustomerCont getInstance(){
		if(instance == null){
			instance = new CustomerCont();
		}
		
		return instance;
	}
	
	/**
	 * Adds a Customer to the ArrayList
	 * @param c
	 */
	public void addCustomer(Customer c){
		customers.add(c);
	}
	
	/**
	 * Finds and returns a CustomerObj by name or phone number
	 * @param nameOrPhone
	 * @return CustomerObj
	 */
	public Customer findCustomer(String nameOrPhone){
		boolean found = false;
		Customer c = null;
		int i = 0;
		while(i < customers.size() && !found){
			Customer cu = customers.get(i);
			if(cu.getName().equalsIgnoreCase(nameOrPhone) || cu.getPhoneNr().equalsIgnoreCase(nameOrPhone)){
				c = cu;
				found = true;
			}
			i++;
		}
		
		return c;
	}
	
	/**
	 * Finds a Business Customer by Company name
	 * @param company
	 * @return Business
	 */
	public Business findBusiness(String company){
		boolean found = false;
		Business c = null;
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext() && !found){
			Customer cu = it.next();
			if(cu instanceof Business){
				if(((Business) cu).getCompany().equalsIgnoreCase(company)){
					c = (Business) cu;
					found = true;
				}
			}
			
		}
		
		return c;
	}
	
	/**
	 * Finds a Customer by ID
	 * @param id
	 * @return Customer
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
	 * Removes a Customer by Customer Obj
	 * @param c
	 */
	public void removeCustomer(Customer c){
		customers.remove(c);
	}
}
