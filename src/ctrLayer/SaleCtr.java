package ctrLayer;
import modelLayer.*;
import personLayer.*;
import exceptionLayer.NotEnoughItemsException;

import java.util.*;

public class SaleCtr {
	
	private Sale sale;
	
	public SaleCtr(){
		this.sale = null;
	}
	
	public Sale createSale(){
		return sale = new Sale();
	}
	
	public void addItem(int id, int amount) throws NotEnoughItemsException, NullPointerException{
		ItemCtr iCtr = new ItemCtr();
		Item item = iCtr.getItem(id);
		
		if(item != null){
			int count = item.getAmount()-item.getReserved();
			if(count-amount < 0){
				throw new NotEnoughItemsException("Der er kun " + count + " af " + item.getName() + " ledige på lageret.");
			} else {
			item.addReserved(amount);
			sale.addPartSale(item, amount);
			}
		} else {
			throw new NullPointerException("Varenr.: " + id + " blev ikke fundet.");
		}
		
	}
	
	public void addItem(String name, int amount) throws NotEnoughItemsException, NullPointerException{
		ItemCtr iCtr = new ItemCtr();
		Item item = iCtr.getItem(name);
		
		if(item != null){
			int count = item.getAmount()-item.getReserved();
			if(count-amount < 0){
				throw new NotEnoughItemsException("Der er kun " + count + " af " + item.getName() + " ledige på lageret.");
			} else {
			item.addReserved(amount);
			sale.addPartSale(item, amount);
			}
		} else {
			throw new NullPointerException("Varenavn: " + name + " blev ikke fundet.");
		}
		
	}
	
	public void setCustomer(Customer c){
		sale.setCustomer(c);
	}
	
	public void finishSale(int employeeNr){
		ArrayList<PartSale> partsales = sale.getPartSales();
		for(PartSale ps : partsales){
			System.out.println("OST OST");
		}
	}
}
