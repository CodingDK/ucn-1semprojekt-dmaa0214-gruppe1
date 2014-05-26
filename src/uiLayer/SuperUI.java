package uiLayer;

import java.util.Scanner;

public abstract class SuperUI {
	
	protected void pause(){
		Scanner k = new Scanner(System.in);	
		k.nextLine();
	}
	
	protected void emptyTypeIn(String typeIn){
		if(typeIn.trim().isEmpty()){
			System.out.println("Feltet m� ikke v�re tomt");
			pause();
			return;
		}
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
				System.out.println("Feltet m� ikke v�re tomt");
				pause();
				error = true;
			} else if(minLength != null || maxLength != null){
				if(minLength != null){
					if(inputData.length() < minLength){
						System.out.println(input + " skal v�re l�ngere end " + minLength + " tegn");
						pause();
						error = true;
					}
				}
				if(maxLength != null){
					if(inputData.length() > maxLength){
						System.out.println(input + " skal v�re kortere end " + maxLength + " tegn");
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