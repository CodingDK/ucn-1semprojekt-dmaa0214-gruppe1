package ctrLayer;

import java.util.ArrayList;

import modelLayer.Discount;
import modelLayer.DiscountCont;

public class DiscountCtr {
	private DiscountCont dCont;
	
	public DiscountCtr(){
		dCont = DiscountCont.getInstance();
	}
	
	public void createDiscount(String name, double percent){
		dCont.addDiscount(new Discount(name, percent));
	}
	
	
	public void updateDiscount(Discount d, String name, double percent) {
		if(d != null){
			if(name != null){
				d.setName(name);
			}
			if(percent != -1){
				d.setPercent(percent);
			}
		}else{
			throw new NullPointerException("Denne Discount eksistere ikke");
		}
	}
	
	public void removeDiscount(Discount d) {
		dCont.removeDiscount(d);
	}
	
	public Discount findDiscount(int id){
		return dCont.findDiscount(id);
	}
	
	public ArrayList<Discount> getAllDiscounts(){
		return dCont.getAll();
	}
	
	public ArrayList<Discount> searchDiscount(String name){
		ArrayList<Discount> retD = new ArrayList<Discount>();
		ArrayList<Discount> discounts = getAllDiscounts();
		
		for(Discount d : discounts){
			if(d.getName().toLowerCase().contains(name.toLowerCase())){
				retD.add(d);
			}
		}
		
		return retD;
		
	}
	
	
}
