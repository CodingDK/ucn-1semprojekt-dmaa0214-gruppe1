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
	private Employee employee;
	private boolean done;
	
	public Sale(){
		idIterator++;
		this.id = idIterator;
		this.date = new Date();
		this.customer = null;
		this.employee = null;
		this.done = false;
		this.partSales = new ArrayList<PartSale>();
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

	public void addPartSale(Item i, int amount){
		PartSale p = new PartSale(i, amount);
		partSales.add(p);
	}
	
	public void setCustomer(Customer c){
		this.customer = c;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
