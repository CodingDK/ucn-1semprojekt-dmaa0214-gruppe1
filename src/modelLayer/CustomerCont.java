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
	
	public static CustomerCont getInstance(){
		if(instance == null){
			instance = new CustomerCont();
		}
		
		return instance;
	}
	
	public void addCustomer(Customer c){
		customers.add(c);
	}
	
	public Customer findCustomer(String nameOrPhone){
		boolean found = false;
		Customer c = null;
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext() && !found){
			Customer cu = it.next();
			if(cu.getName().equalsIgnoreCase(nameOrPhone) || cu.getPhoneNr().equalsIgnoreCase(nameOrPhone)){
				c = cu;
				found = true;
			}
		}
		
		return c;
	}
	
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
	
	public void removeCustomer(Customer c){
		customers.remove(c);
	}
}
