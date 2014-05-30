package ctrLayer;
import java.util.ArrayList;

import personLayer.*;
import modelLayer.*;

public class CustomerCtr {
	private CustomerCont cCont;
	
	public CustomerCtr(){
		cCont = CustomerCont.getInstance();
	}
	
	/**
	 * Finds a Customer by name or phone
	 * @param nameOrPhone
	 * @return Customer
	 */
	public Customer findCustomer(String nameOrPhone){
		return cCont.findCustomer(nameOrPhone);
	}
	
	/**
	 * Finds a Business Customer by Company name
	 * @param company
	 * @return Business
	 */
	public Business findBusiness(String company){
		return cCont.findBusiness(company);
	}
	
	/**
	 * Finds a CustomerObj by ID
	 * @param id
	 * @return Customer
	 */
	public Customer findCustomer(int id){
		return cCont.findCustomer(id);
	}
	
	/**
	 * Creates a Private Customer
	 * 
	 * @param name
	 * @param phoneNr
	 * @param street
	 * @param email
	 * @param city
	 * @param postCode
	 * @param cprNr
	 * @param pictureId
	 */
	public Private createPrivateCustomer(String name, String phoneNr, String street, String email, String city, String postCode, String cprNr, String pictureId){
		Private returnPrivate = new Private(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
		cCont.addCustomer(returnPrivate);
		return returnPrivate;
	}
	
	/**
	 * Updates a customers data
	 * 
	 * @param id
	 * @param name
	 * @param phoneNr
	 * @param street
	 * @param email
	 * @param city
	 * @param postCode
	 * @param pictureID
	 * @param company
	 * @param cvrNr
	 * @throws NullPointerException if Customer does not exist
	 */
	public void updateCustomer(int id, String name, String phoneNr, String street, String email, String city, String postCode, String pictureID, String company, String cvrNr) throws NullPointerException{
		Customer c = cCont.findCustomer(id);
		if(c != null){
			if(name != null){
				c.setName(name);
			}
			if(phoneNr != null){
				c.setPhoneNr(phoneNr);
			}
			if(street != null){
				c.setStreet(street);
			}
			if(email != null){
				c.setEmail(email);
			}
			if(city != null){
				c.setCity(city);
			}
			if(postCode != null){
				c.setPostCode(postCode);
			}

			if(c instanceof Private){
				Private p = (Private) c;
				if(pictureID != null){
					p.setPictureID(pictureID);
				}
			}else if(c instanceof Business){
				Business b = (Business) c;
				if(company != null){
					b.setCompany(company);
				}
				if(cvrNr != null){
					b.setCvrNr(cvrNr);
				}
			}
		}else{
			throw new NullPointerException("Kunden eksistere ikke");
		}
	}
	
	/**
	 * Removes a Customer by ID
	 * @param id
	 */
	public void removeCustomer(int id){
		cCont.removeCustomer(cCont.findCustomer(id));
	}
	
	/**
	 * Creates a Business Customer
	 * @param name
	 * @param phoneNr
	 * @param street
	 * @param email
	 * @param city
	 * @param postCode
	 * @param company
	 * @param cvrNr
	 */
	public Business createBusinessCustomer(String name, String phoneNr, String street, String email, String city, String postCode, String company, String cvrNr){
		Business returnBusiness = new Business(name, phoneNr, street, email, city, postCode, company, cvrNr); 
		cCont.addCustomer(returnBusiness);
		return returnBusiness;
	}
	
	/**
	 * searchCustomer
	 * @param partNamePhone
	 * @return Customer
	 */
	public ArrayList<Customer> searchCustomer(String partNamePhone){
		ArrayList<Customer> foundCustomers = new ArrayList<Customer>();
		CustomerCont customerCont = CustomerCont.getInstance();
		ArrayList<Customer> cust = customerCont.getCustomers();
		if(cust != null)
			for(Customer c : cust){
				if((c.getName().toLowerCase().contains(partNamePhone.toLowerCase())) || (c.getPhoneNr().contains(partNamePhone))){
					foundCustomers.add(c);			
				}	
			}
		return foundCustomers;
	}
	
	public ArrayList<Customer> searchBusiness(String partCompName){
		ArrayList<Customer> foundBusiness = new ArrayList<Customer>();
		CustomerCont cCont = CustomerCont.getInstance();
		ArrayList<Customer> cust = cCont.getCustomers();
		if(cust != null)
			for(Customer c : cust){
				if(c instanceof Business){
					if(((Business) c).getCompany().toLowerCase().contains(partCompName.toLowerCase()) ){
						foundBusiness.add(c);	
					}	
				}
			}
		return foundBusiness;
	}
	
	
	/**
	 * searchBusiness
	 * @param partName
	 * @return Customer
	 */
//	public ArrayList<Customer> searchBusiness(String partName){
//		ArrayList<Customer> foundCustomers = new ArrayList<Customer>();
//		
//		
//		ArrayList<Customer> cust = customerCont.getCustomers();
//		if(cust != null)
//			for(Customer c : cust){
//				if( ){
//					foundCustomers.add(c.);			
//				}	
//			}
//		return foundCustomers;
//	}
}


