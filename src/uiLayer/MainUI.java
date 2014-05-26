package uiLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainUI extends SuperUI{
	
	private MainUI(){
		menu();
	}
	
	private void menu(){
		boolean exit = false;
		while(!exit){
			int choice = writeMenu();
			if(choice == 1){
				new PersonUI();
			} else if(choice == 2){
				new SaleUI();
			} else if(choice == 3){
				new ItemUI();
			} else if(choice == 4){
				System.out.println("System is shutting down.");
				exit = true;
			}
		}
	}
	
	private int writeMenu(){
		int choice = 0;
		Scanner k = new Scanner(System.in);
		try{
			System.out.println("1. Kunde UI");
			System.out.println("2. Salg UI");
			System.out.println("3. Vare UI");
			System.out.println("4. Exit");
			choice = k.nextInt();
			k.nextLine();
		} catch(InputMismatchException e){
			System.out.println("Forkert input!");
		}
		return choice;
	}
	
	public static void main(String[] args){
		new MainUI();
	}
	
}
