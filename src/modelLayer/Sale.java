package modelLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import personLayer.Business;
import personLayer.Customer;
import personLayer.Employee;
import personLayer.Private;

/**
 * Sale holds information of a sale.
 * 
 * @author Group 1
 * @version 0.1
 */
public class Sale {
	private double totalPrice;
	private int id;
	private Date date;
	private ArrayList<PartSale> partSales;
	private static int idIterator;
	private Customer customer;
	private Employee employee;
	private boolean done;
	
	/**
	 * Constructor for Sale objects.
	 */
	public Sale() {
		idIterator++;
		id = idIterator;
		date = new Date();
		customer = null;
		employee = null;
		done = false;
		partSales = new ArrayList<PartSale>();
	}
	
	/**
	 * @param totalPrice the totalPrice to sale
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @return id of the Sale.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return date of the Sale.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @return String with date of the Sale.
	 */
	public String getDateToString() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(date);
	}
	
	/**
	 * @return totalPrice of the Sale.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * @return list of the partsales.
	 */
	public ArrayList<PartSale> getPartSales() {
		return partSales;
	}
	
	/**
	 * addPartSale - Add a partsale to the sale and update totalPrice.
	 * 
	 * @param i The item object to make a partsale of.
	 * @param amount The amount of the item.
	 */
	public void addPartSale(Item i, int amount) {
		totalPrice += i.getSalePrice() * amount;
		int index = 0;
		PartSale ps = null;
		
		while (index < partSales.size() && ps == null) {
			if (partSales.get(index).getItem() == i) {
				ps = partSales.get(index);
			}
			index++;
		}
		if (ps != null) {
			ps.addAmount(amount);
		} else {
			PartSale p = new PartSale(i, amount);
			partSales.add(p);
		}
	}
	
	/**
	 * setCustomer - Set the customer of the sale.
	 * 
	 * @param c the new customer.
	 */
	public void setCustomer(Customer c) {
		customer = c;
	}
	
	/**
	 * @return customer object of the sale.
	 */
	public Customer getCustomer() {
		return customer;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retString = "";
		String parked = "";
		if (done) {
			parked = "Nej";
		} else {
			parked = "Ja";
		}
		if (customer instanceof Private) {
			retString = "#" + id + " Kunde: " + customer.getName() + ", Total Pris: " + totalPrice + ", Parkeret: " + parked
					+ ", Dato: " + getDateToString();
		} else if (customer instanceof Business) {
			retString = "#" + id + " Kunde: " + ((Business) customer).getCompany() + ", Total Pris: " + totalPrice + ", Parkeret: " + parked
					+ ", Dato: " + getDateToString();
		}
		return retString;
	}
	
	public void removePartSale(PartSale ps) {
		partSales.remove(ps);
	}
	
	public void setDate(Date d) {
		// TODO Auto-generated method stub
		date = d;
	}
}
