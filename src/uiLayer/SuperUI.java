package uiLayer;

import java.util.Scanner;

public abstract class SuperUI {
	
	protected void pause(){
		Scanner k = new Scanner(System.in);	
		k.nextLine();
	}
	
	protected void emptyTypeIn(String typeIn){
		if(typeIn.trim().isEmpty()){
			System.out.println("Feltet mŒ ikke v¾re tomt");
			pause();
			return;
		}
	}
	
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

	
	protected String requestString(String input, Integer minLength, Integer maxLength){
		Scanner k = new Scanner(System.in);
		String ret = "";
		boolean done = false;
		while(!done){
			boolean error = false;
			System.out.print(input + ": ");
			String inputData = k.nextLine();
			
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
		}
		
		return ret;
	}
	
	protected int requestInt(String input){
		Scanner k = new Scanner(System.in);
		int ret = 0;
		boolean done = false;
		while(!done){
			System.out.print(input + ":" );
			String inputData = k.nextLine();
			
			if(isInteger(inputData)){
				ret = Integer.parseInt(inputData);
				done = true;
			}
			
		}
		return ret;
	}
	
	protected double requestDouble(String input){
		Scanner k = new Scanner(System.in);
		double ret = 0;
		boolean done = false;
		while(!done){
			System.out.print(input + ":" );
			String inputData = k.nextLine();
			
			if(isDouble(inputData)){
				ret = Double.parseDouble(inputData);
				done = true;
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
}
