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
}
