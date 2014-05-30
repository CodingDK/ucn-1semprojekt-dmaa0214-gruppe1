package ctrLayer;
import modelLayer.*;
import personLayer.*;
import exceptionLayer.*;

import java.util.*;

/**
 * Controller class for the SaleCtr
 * 
 * @author Group 1
 * @version 0.1
 * 
 */
public class SaleCtr {
	private Sale sale;
	
	/**
     * Constructor for controller SaleCtr.
     */
	public SaleCtr(){

	}
	
	/**
	 * Creates the initial sale object
	 */
	public void createSale(){
		Sale sale = new Sale();
		this.sale = sale;
	}
		
	/**
	 * getSale - Get the sale for the controller.
	 * @return Sale The Sale object.
	 */
	public Sale getSale(){
		return this.sale;
	}
	
	/**
	 * addItem - Add an item to the sale.
	 * @param item The item to add.
	 * @param amount the amount of the item to add.
	 * @throws NotEnoughItemsException if amount and reserved in storage is under 0. 
	 * @throws NullPointerException if item object not created.
	 */
	public void addItem(Item item, int amount) throws NullPointerException, NotEnoughItemsException{
		if(item != null){
			int availableAmount = item.getAmount() - item.getReserved();
			if(availableAmount-amount < 0){
				throw new NotEnoughItemsException("Der er kun " + availableAmount + " af " + item.getName() + " ledige på lageret.");
			} else {
				item.addReserved(amount);
				if(sale != null){
					sale.addPartSale(item, amount);
				}else{
					System.out.println("Der mangler noget :o");
				}
			}
			
		} else {
			throw new NullPointerException("Varen blev ikke fundet.");
		}
	}
	
	/**
	 * setCustomer - Set the customer of a sale.
	 * @param c The Customer object to add.
	 * @throws SaleNotCreatedException if sale object not created.
	 */
	public void setCustomer(Customer c) throws SaleNotCreatedException{
		if(sale != null) {
			sale.setCustomer(c);
		} else {
			throw new SaleNotCreatedException("Der er ikke oprettet et salg");
		}
	}
	
	/**
	 * finishSale - Finish a sale and add a employeeNr to the sale.
	 * @param employeeNr The employerNr of the Employee object to add.
	 * @throws SaleNotCreatedException if sale object not created.
	 * @throws NullPointerException if employeeNr not found.
	 */
	public void finishSale(String employeeNr) throws SaleNotCreatedException, NullPointerException{
		if(sale != null){
			EmployeeCtr eCtr = new EmployeeCtr();
			Employee employee = eCtr.findEmployee(employeeNr);
			if(employee == null){
				throw new NullPointerException("Medarbejdernr.: " + employeeNr + " blev ikke fundet");
			} else {
			sale.setEmployee(employee);
			
			ArrayList<PartSale> partsales = sale.getPartSales();
			
			for(PartSale ps : partsales){
				Item item = ps.getItem();
				item.addReserved(-ps.getAmount());
				item.addAmount(-ps.getAmount());
			}
			sale.setDone(true);
			SaleCont.getInstance().addSale(sale);
			}
		} else {
			throw new SaleNotCreatedException("Der er ikke oprettet et salg");
		}
		
	}
	
	/**
	 * Cancels the sale and returns the amount, and resets the reserved
	 */
	public void cancelSale(){
		ArrayList<PartSale> partSales = sale.getPartSales();
		if(partSales != null){
			for(PartSale p : partSales){
				Item i = p.getItem();
				i.addAmount(p.getAmount());
				i.addReserved(-p.getAmount());
			}
		}
		
		SaleCont sCont = SaleCont.getInstance();
		if(sCont.getAll().contains(sale)){
			sCont.removeSale(sale);
		}
	}
	
	/**
	 * Parks the sale for later use
	 */
	public boolean parkSale(){
		boolean ret = false;
		if(sale.getCustomer() != null){
			SaleCont sCont = SaleCont.getInstance();
			sale.setDone(false);
			if(!sCont.getAll().contains(sale)){
				sCont.addSale(sale);
			}
			ret = true;
		}
		return ret;		
	}
	
	/**
	 * loadSale - Load a parked sale
	 * @param sale
	 */
	public void loadSale(Sale sale){
		if(sale.isDone()){
			System.out.println("HALLØJ!");
		}
		if(!sale.isDone()){
			this.sale = sale;
		}
	}
	
	/**
	 * getSales - Returns all the Sales contained in the SalesContainer
	 * @return ArrayList<Sale>
	 */
	public ArrayList<Sale> getSales(){
		SaleCont sCont = SaleCont.getInstance();
		ArrayList<Sale> sales = sCont.getAll();
		
		return sales;
	}
	
	/**
	 * getParkedSales - Returns all the Sales that are marked as done = false
	 * @return ArrayList<Sale>
	 */
	public ArrayList<Sale> getParkedSales(){
		ArrayList<Sale> retArry = new ArrayList<Sale>();
		ArrayList<Sale> sales = getSales();
		for(Sale s : sales){
			if(!s.isDone()){
				retArry.add(s);
			}
		}
		
		return retArry;
	}
	
	/**
	 * getSale - Finds and returns a sale based on its ID
	 * @param id
	 * @return Sale
	 */
	public Sale getSale(int id){
		Sale retSale = null;
		ArrayList<Sale> sales = getSales();
		boolean found = false;
		int i = 0;
		while(!found && i < sales.size()){
			Sale s = sales.get(i);
			if(s.getId() == id){
				retSale = s;
				found = true;
			}
		}
		
		return retSale;
		
	}
	
	/**
	 * cleanUp - Removed parked sales older than a day
	 */
	public void cleanUp(){
		ArrayList<Sale> sales = getParkedSales();
		Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
		for(Sale s : sales){
			c2.setTime(s.getDate());
			if(c1.get(Calendar.DAY_OF_YEAR) != c2.get(Calendar.DAY_OF_YEAR)){
				this.sale = s;
				cancelSale();
			}
		}
	}
	
}
