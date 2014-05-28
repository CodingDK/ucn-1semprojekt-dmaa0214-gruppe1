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
		ItemCtr iCtr = new ItemCtr();
		
		if(item != null){
			int availableAmount = iCtr.getAvailableAmount(item);
			if(availableAmount-amount < 0){
				throw new NotEnoughItemsException("Der er kun " + availableAmount + " af " + item.getName() + " ledige p� lageret.");
			} else {
				iCtr.addReserved(item, amount);
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
			
			ItemCtr iCtr = new ItemCtr();
			for(PartSale ps : partsales){
				Item item = ps.getItem();
				iCtr.addReserved(item, -ps.getAmount());
				iCtr.addAmount(item, -ps.getAmount());
			}
			sale.setDone(true);
			SaleCont.getInstance().addSale(sale);
			}
		} else {
			throw new SaleNotCreatedException("Der er ikke oprettet et salg");
		}
		
	}
}
