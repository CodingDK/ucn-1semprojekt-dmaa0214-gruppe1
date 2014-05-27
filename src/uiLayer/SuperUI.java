package uiLayer;

import java.util.Scanner;

import personLayer.Employee;
import ctrLayer.EmployeeCtr;

public abstract class SuperUI {
	protected static boolean admin;
	
	protected void pause(){
		Scanner k = new Scanner(System.in);	
		k.nextLine();
	}
	/*
	protected void emptyTypeIn(String typeIn){
		if(typeIn.trim().isEmpty()){
			System.out.println("Feltet må ikke være tomt");
			pause();
			return;
		}
	}
	*/
	/**
	 * stringToNull - used when "" is changed to a null
	 * @param typeIn 
	 * @return String
	 */
	protected String stringToNull(){
		Scanner k = new Scanner(System.in);
		String n = k.nextLine();
		String typeOut= null;
		if(n.equals("")){
			typeOut = null;			
		} else {
			typeOut = n;
		}
		return typeOut;
	}	

	
	protected String requestString(String input, Integer minLength, Integer maxLength, boolean allowNull){
		Scanner k = new Scanner(System.in);
		String ret = "";
		boolean done = false;
		while(!done){
			boolean error = false;
			System.out.print(input + ": ");
			String inputData = k.nextLine();
			if(!allowNull){
				if(inputData.trim().isEmpty()){
					System.out.println("Feltet må ikke være tomt");
					pause();
					error = true;
				} else if(minLength != null || maxLength != null){
					if(minLength != null){
						if(inputData.length() < minLength){
							System.out.println(input + " skal være længere end " + minLength + " tegn");
							pause();
							error = true;
						}
					}
					if(maxLength != null){
						if(inputData.length() > maxLength){
							System.out.println(input + " skal være kortere end " + maxLength + " tegn");
							pause();
							error = true;
						}
					}
				} 
				
				if(!error){
					ret = inputData;
					done = true;
				}
			}else{
				if(inputData.trim().isEmpty()){
					ret = null;
				}else{
					ret = inputData;
				}
				done = true;
			}
		}
		
		return ret;
	}
	
	protected int requestInt(String input, Integer min, boolean allowNull){
		Scanner k = new Scanner(System.in);
		int ret = 0;
		boolean done = false;
		while(!done){
			System.out.print(input + ": " );
			String inputData = k.nextLine();
			if(allowNull && inputData.trim().isEmpty()){
				ret = -1;
				done = true;
			}else{
				if(isInteger(inputData)){
					ret = Integer.parseInt(inputData);
					if(min != null){
						if(ret != min && ret <= min){
							System.out.println(input + " skal være større end " + min);
						}else{
							done = true;
						}
					}else{
						done = true;
					}
				}
			}
			
		}
		return ret;
	}
	
	protected double requestDouble(String input, boolean allowNull){
		Scanner k = new Scanner(System.in);
		double ret = 0;
		boolean done = false;
		while(!done){
			System.out.print(input + ": " );
			String inputData = k.nextLine();
			if(allowNull && inputData.trim().isEmpty()){
				ret = -1;
				done = true;
			}else{
				if(isDouble(inputData)){
					ret = Double.parseDouble(inputData);
					done = true;
				}
			}
			
		}
		return ret;
	}
	
	private boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	private boolean isDouble(String s){
		try{
			Double.parseDouble(s);
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	protected boolean confirm(String confirmStatement){
        boolean confirm = true;
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println();
            System.out.println(confirmStatement);
            System.out.println("Confirm - y/n");
            String conf = s.nextLine();
            if(conf.toLowerCase().equals("y")){
                confirm = true;
                exit = true;
            }else if(conf.toLowerCase().equals("n")){
                confirm = false;
                exit = true;
            }
        }
        return confirm;
    }
	
	protected void login(){
		Scanner k = new Scanner(System.in);
		System.out.println("## Administrator Login ##");
		String employeeID = requestString("Medarbejder Nummer", null, null, false);
		String password = requestString("Kodeord", null, null, false);
		
		EmployeeCtr eCtr = new EmployeeCtr();
		Employee e = eCtr.findEmployee(employeeID);
		if(e != null){
			if(!e.getAdmin()){
				System.out.println("Dette mederbajder nummer har ikke administrator rettigheder");
				pause();
			}else if(e.getAdmin() && e.getPassword().equals(password)){
				System.out.println("Du er nu logget ind som administrator");
				admin = true;
				pause();
			}
		}else{
			System.out.println("Denne medarbejder eksistere ikke");
		}
		
	}
}
