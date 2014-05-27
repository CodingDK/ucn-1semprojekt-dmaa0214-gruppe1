package modelLayer;

import java.util.ArrayList;
import java.util.Date;
import personLayer.*;

public class Sale {
	private double totalPrice;
	private int id;
	private Date date;
	private ArrayList<PartSale> partSales;
	private static int idIterator;
	private Customer customer;
	
	public Sale(){
		idIterator++;
		this.id = idIterator;
		this.date = new Date();
	} 
		
	public void setTotalPrice(double totalPrice) {
		 this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public ArrayList<PartSale> getPartSales() {
		return partSales;
	}
	
	public void setPartSales(ArrayList<PartSale> partSales) {
		this.partSales = partSales;
	}

	public void addPartSale(Item i,int amount){
		PartSale p = new PartSale(i,amount);
		partSales.add(p);
	}
	
	public void setCustomer(Customer c){
		this.customer = c;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}

}
