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
			System.out.print(input + ": ");
			String inputData = k.nextLine();
			
			if(inputData.trim().isEmpty()){
				System.out.println("Feltet må ikke være tomt");
			}else if(minLength != null){
				if(inputData.length() < minLength){
					System.out.println(input + " skal være længere end " + minLength + " tegn");
				}else if(inputData.length() > maxLength){
					System.out.println(input + " må ikke være længere end " + minLength + " tegn");
				}
			}else{
				ret = inputData;
			}
		}
		
		return ret;
	}
}
