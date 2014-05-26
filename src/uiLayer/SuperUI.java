package uiLayer;

import java.util.Scanner;

public abstract class SuperUI {
	
	protected void pause(){
		Scanner k = new Scanner(System.in);	
		k.nextLine();
	}
	
	protected void emptyTypeIn(String typeIn){
		if(typeIn.trim().isEmpty()){
			System.out.println("Feltet må ikke være tomt");
			pause();
			return;
		}
	}
}
