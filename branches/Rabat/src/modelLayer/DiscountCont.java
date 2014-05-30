package modelLayer;

import java.util.ArrayList;

public class DiscountCont {
	private static DiscountCont instance;
	private ArrayList<Discount> discounts;
	
	private DiscountCont(){
		discounts = new ArrayList<Discount>();
	}
	
	public static DiscountCont getInstance(){
		if(instance == null){
			instance = new DiscountCont();
		}
		
		return instance;
	}
	
	public void addDiscount(Discount d) {
		discounts.add(d);
	}
	
	public Discount findDiscount(int id){
		Discount retD = null;
		boolean found = false;
		int i = 0;
		while(!found && i < discounts.size()){
			Discount d = discounts.get(i);
			if(d.getId() == id){
				retD = d;
				found = true;
			}
			i++;
		}
		
		return retD;
		
	}
	
	public void removeDiscount(Discount d){
		discounts.remove(d);
	}
	
	public ArrayList<Discount> getAll(){
		return discounts;
	}

}
