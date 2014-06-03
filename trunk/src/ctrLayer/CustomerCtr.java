package ctrLayer;

import java.util.ArrayList;

import modelLayer.CustomerCont;
import personLayer.Business;
import personLayer.Customer;
import personLayer.Private;

public class CustomerCtr {
	private final CustomerCont cCont;
	
	public CustomerCtr() {
		cCont = CustomerCont.getInstance();
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
	 * @return Private Returns the created private customer.
	 */
	public Private createPrivateCustomer(final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final String cprNr, final String pictureId) {
		final Private returnPrivate = new Private(name, phoneNr, street, email, city, postCode, cprNr, pictureId);
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
	public void updateCustomer(final int id, final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final String pictureID, final String company, final String cvrNr) throws NullPointerException {
		final Customer c = cCont.findCustomer(id);
		if (c != null) {
			if (name != null) {
				c.setName(name);
			}
			if (phoneNr != null) {
				c.setPhoneNr(phoneNr);
			}
			if (street != null) {
				c.setStreet(street);
			}
			if (email != null) {
				c.setEmail(email);
			}
			if (city != null) {
				c.setCity(city);
			}
			if (postCode != null) {
				c.setPostCode(postCode);
			}
			
			if (c instanceof Private) {
				final Private p = (Private) c;
				if (pictureID != null) {
					p.setPictureID(pictureID);
				}
			} else if (c instanceof Business) {
				final Business b = (Business) c;
				if (company != null) {
					b.setCompany(company);
				}
				if (cvrNr != null) {
					b.setCvrNr(cvrNr);
				}
			}
		} else {
			throw new NullPointerException("Kunden eksistere ikke");
		}
	}
	
	/**
	 * Removes a Customer by ID
	 * 
	 * @param id
	 */
	public void removeCustomer(final int id) {
		cCont.removeCustomer(cCont.findCustomer(id));
	}
	
	/**
	 * Creates a Business Customer
	 * 
	 * @param name
	 * @param phoneNr
	 * @param street
	 * @param email
	 * @param city
	 * @param postCode
	 * @param company
	 * @param cvrNr
	 */
	public Business createBusinessCustomer(final String name, final String phoneNr, final String street, final String email, final String city, final String postCode, final String company, final String cvrNr) {
		final Business returnBusiness = new Business(name, phoneNr, street, email, city, postCode, company, cvrNr);
		cCont.addCustomer(returnBusiness);
		return returnBusiness;
	}
	
	/**
	 * searchCustomer - Searches for Customers containing the param(partNamePhone), and returns a list of matches
	 * 
	 * @param partNamePhone
	 * @return ArrayList<Customer>
	 */
	public ArrayList<Customer> searchCustomer(final String partNamePhone) {
		final ArrayList<Customer> foundCustomers = new ArrayList<Customer>();
		final CustomerCont customerCont = CustomerCont.getInstance();
		final ArrayList<Customer> cust = customerCont.getCustomers();
		if (cust != null)
			for (final Customer c : cust) {
				if ((c.getName().toLowerCase().contains(partNamePhone.toLowerCase())) || (c.getPhoneNr().contains(partNamePhone))) {
					foundCustomers.add(c);
				}
			}
		return foundCustomers;
	}
	
	/**
	 * searchCustomer - Searches for Customers containing the param(partCompName), and returns a list of matches
	 * 
	 * @param partNamePhone
	 * @return ArrayList<Customer>
	 */
	public ArrayList<Customer> searchBusiness(final String partCompName) {
		final ArrayList<Customer> foundBusiness = new ArrayList<Customer>();
		final CustomerCont cCont = CustomerCont.getInstance();
		final ArrayList<Customer> cust = cCont.getCustomers();
		if (cust != null)
			for (final Customer c : cust) {
				if (c instanceof Business) {
					if (((Business) c).getCompany().toLowerCase().contains(partCompName.toLowerCase())) {
						foundBusiness.add(c);
					}
				}
			}
		return foundBusiness;
	}
	
}
