package uiLayer;

import java.util.ArrayList;

import ctrLayer.DiscountCtr;
import modelLayer.Discount;

public class DiscountUI extends SuperUI{
	private Discount selectedDiscount;
	private DiscountCtr dCtr;
	
	public DiscountUI(){
		dCtr = new DiscountCtr();
		menu();
	}
	
	public DiscountUI(String name){
		dCtr = new DiscountCtr();
	}
	
	private void menu(){
		boolean exit = false;
		while(!exit){
			int choice = writeMenu();
			if(choice == 1){
				createDiscount();
			}else if(choice == 2){
				searchDiscount();
			}else if(choice == 3){
				selectedDiscount = pickDiscount();
			}else if(choice == 4){
				if(selectedDiscount != null){
					updateDiscount();
				}else{
					selectedDiscount = pickDiscount();
					updateDiscount();
				}
			}else if(choice == 5){
				if(selectedDiscount != null){
					removeDiscount();
				}else{
					selectedDiscount = pickDiscount();
					removeDiscount();
				}
			}else if(choice == 6){
				exit = true;
			}
		}
	}
	
	private int writeMenu(){
		int choice = 0;
		System.out.println("## Rabat Menu ##");
		System.out.println(" 1. Opret Rabat");
		System.out.println(" 2. Søg Rabat");
		System.out.println(" 3. Vælg Rabat");
		String discount = selectedDiscount != null ? "(" + selectedDiscount.getName() + ")" : "";
		System.out.println(" 4. Opdater Rabat" + discount);
		System.out.println(" 5. Slet Rabat" + discount);
		System.out.println(" 6. Gå tilbage");
		choice = requestInt("Valg: ", null, false);
		
		return choice;
	}

	private void createDiscount(){
		System.out.println("## Opret Rabat ##");
		String name = requestString("Navn", null, null, false);
		double percent = requestDouble("Rabat Procent", false);
		
		dCtr.createDiscount(name, percent);
	}
	
	private void searchDiscount(){
		try{
			System.out.println("## Søg Rabat ##");
			String name = requestString("Rabat navn: ", null, null, false);
			ArrayList<Discount> discounts = dCtr.searchDiscount(name);
			if(discounts != null){
				System.out.println(discounts.size() + " Rabatter Fundet");
				for(Discount d : discounts){
					System.out.println("#" + d.getId() + " - " + d.getName() + " - " + d.getPercent() + "%");
				}
				pause();
			}else{
				System.out.println("0 Rabatter Fundet");
				pause();
				return;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Discount pickDiscount(){
		Discount retD = null;
		try{
			boolean done = false;
			while(!done){
				System.out.println("## Vælg Rabat ##");
				String name = requestString("Rabat navn", null, null, false);
				ArrayList<Discount> discounts = dCtr.searchDiscount(name);
				if(discounts != null && discounts.size() > 0){
					boolean recheck = true;
					System.out.println(discounts.size() + " Rabatter Fundet");
					while(recheck){
						for(Discount d : discounts){
							System.out.println("#" + d.getId() + " - " + d.getName() + " - " + d.getPercent() + "%");
						}
						int id = requestInt("RabatID", null, false);
						boolean found = false;
						int i = 0;
						while(!found && discounts.size() > i){
							Discount d = discounts.get(i);
							if(d.getId() == id){
								retD = d;
								found = true;
							}
							i++;
						}
						
						if(retD != null){
							System.out.println("Rabat " + retD.getName() + " valgt");
							pause();
							done = true;
							recheck = false;
						}else{
							recheck = true;
						}
					}
				}else{
					System.out.println("0 Rabatter Fundet");
					pause();
					done = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retD;
	}
	
	private void updateDiscount(){
		System.out.println("## Opdater Rabat ##");
		String name = requestString("Rabat navn(" + selectedDiscount.getName() + ")", null, null, true);
		double percent = requestDouble("Rabat procent(" + selectedDiscount.getPercent() + "%)", true);
		
		dCtr.updateDiscount(selectedDiscount, name, percent);
	}
	
	private void removeDiscount(){
		if(confirm("Er du sikker på du vil slette: " + selectedDiscount.getName() + ".")){
			dCtr.removeDiscount(selectedDiscount);
			selectedDiscount = null;
		}
	}
	
	
}
