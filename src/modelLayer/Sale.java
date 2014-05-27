package modelLayer;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
	private double TotalPrice;
	private int id;
	private Date date;
	private ArrayList<PartSale>partSales;
	private static int idIterator;
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
