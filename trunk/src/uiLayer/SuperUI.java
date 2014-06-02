package uiLayer;

import java.util.Scanner;

import personLayer.Employee;
import ctrLayer.EmployeeCtr;

public abstract class SuperUI {
	protected static boolean admin;
	
	/**
	 * pause - Used in TUIs to pause, waiting for a user to hit enter to continue
	 */
	protected void pause(){
		@SuppressWarnings("resource")
		Scanner k = new Scanner(System.in);	
		k.nextLine();
	}

	/**
	 * stringToNull - used when "" is changed to a null
	 * @param typeIn 
	 * @return String
	 */
	protected String stringToNull(){
		@SuppressWarnings("resource")
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

	/**
	 * requestString  - Asks for user input (the question being the first parameter, input) 
	 * and returns the user input as a String.
	 * @param input What the system should print/ask.
	 * @param minLength Minimum length of the input from the user.
	 * @param maxLength Maximum length of the input from the user.
	 * @param allowNull Whether or not blank input is accepted. 
	 * @return String Returns a string containing the user input. 
	 */
	protected String requestString(String input, Integer minLength, Integer maxLength, boolean allowNull){
		@SuppressWarnings("resource")
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
	
	/**
	 * requestInt  - Asks for user input (the question being the first parameter, input) 
	 * and returns the user input as an int. 
	 * @param input What the system should print/ask.
	 * @param min Minimum size of the integer input from the user.
	 * @param allowNull Whether or not blank input should be accepted.
	 * @return int - The int input from the user.
	 */
	protected int requestInt(String input, Integer min, boolean allowNull){
		@SuppressWarnings("resource")
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
	
	/**
	 * requestDouble - Prints a question asking the user to type a double and returns the input.
	 * @param input What the system should print/ask.
	 * @param allowNull Whether or not to allow the input to be blank.
	 * @return double The entered double.
	 */
	protected double requestDouble(String input, boolean allowNull){
		@SuppressWarnings("resource")
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
	
	/**
	 * isInteger checks if the input is an integer and returns true/false.
	 * @param s What the system should check.
	 * @return boolean True/false depending on whether s is an integer or not.
	 */
	private boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	/**
	 * isDouble checks if the input is a double and returns true/false.
	 * @param s What the system should check.
	 * @return boolean True/false depending on whether s is a double or not.
	 */
	private boolean isDouble(String s){
		try{
			Double.parseDouble(s);
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	/**
	 * confirm - Asks the user to confirm his/her choice, by typing y or n.
	 * @param confirmStatement What should be confirmed.
	 * @return boolean - True/false depending on whether the user confirmed or not.
	 */
	protected boolean confirm(String confirmStatement){
        boolean confirm = true;
        @SuppressWarnings("resource")
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
	
	/**
	 * login - Administrator login. Asks you to enter employee ID and a password.
	 */
	protected void login(){
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
