package ctrLayer;
import personLayer.*;
import modelLayer.*;

public class CustomerCtr {
	private CustomerCont cCont;
	
	public CustomerCtr(){
		cCont = CustomerCont.getInstance();
	}
	
	public Customer findCustomer(String nameOrPhone){
		return cCont.findCustomer(nameOrPhone);
	}
	
	public Business findBusiness(String company){
		return cCont.findBusiness(company);
	}
	
	public Customer findCustomer(int id){
		return cCont.findCustomer(id);
	}
	
	public void createPrivateCustomer(String name, String phoneNr, String street, String email, String city, String postCode, String cprNr, String pictureId){
		cCont.addCustomer(new Private(name, phoneNr, street, email, city, postCode, cprNr, pictureId));
	}
	
	public void updateCustomer(int id, String name, String phoneNr, String street, String email, String city, String postCode, String pictureID, String company, String cvrNr){
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
	
	public void removeCustomer(int id){
		cCont.removeCustomer(cCont.findCustomer(id));
	}
	
	public void createBusinessCustomer(String name, String phoneNr, String street, String email, String city, String postCode, String company, String cvrNr){
		cCont.addCustomer(new Business(name, phoneNr, street, email, city, postCode, company, cvrNr));
	}
}
