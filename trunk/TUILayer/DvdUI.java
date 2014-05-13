package TUILayer;
import java.util.Scanner;
import ControlLayer.DVDCtr;
/**
 * User interface to the DVD controller
 * @author(kbh)
 * @version(2005.03.31)
 * (FEN): 2006.02.24: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 * (KBH): 2008.10.24: dvdmenu changed to If                   
 */

public class DvdUI
{
    private DVDCtr dvdCtr;//DVD UI must know the DVD controller 
    
    public DvdUI()
    {
        
    }
    
    public void start(DVDCtr ctr)
    {
        dvdCtr= ctr;
        dvdMenu();
    }
    
    public void dvdMenu()
    {   
        boolean exit = false;
        while(!exit)
        {
            //show menu and return the user's choise
            int choice =   writeDVDMenu();
            if (choice == 1)
            {
                findDVD();
            }
            else{if(choice == 2){
                   createDVD();
                }
                else{
                    if(choice == 3){
                        createCopy();
                    }
                    else{
                        if(choice == 4){
                             deleteDVD();
                        }
                        else{
                            if(choice == 5){
                                listAllDvds();
                            }
                            else{
                                exit = true;
                            }//end else
                        }//end else
                    }//end else
                }//end else
            }//end else
            
        }//end while
    }
    private int writeDVDMenu()
    {
           // creates an object keyboard to read data from the keyboard
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** DVD Menu ***");
            System.out.println(" (1) Show DVD information");
            System.out.println(" (2) Create DVD description");
            System.out.println(" (3) Create DVD specimen");
            System.out.println(" (4) Delete DVD");
            System.out.println(" (5) Show current DVD list");
            System.out.println(" (6) Return");
            System.out.print("\n Make your choice: ");
            
            int choice = keyboard.nextInt();
            return choice;
    }
    private int inputDVDNo()
    {
        // creates an object keyboard to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD number: ");
        int no = keyboard.nextInt();
        return no;
    }
        
    private String inputTitle()
    {
        // creates an object keyboard to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type DVD title: " );
        String title = keyboard.nextLine();
        return title;
    }
    private int inputCopyNo()
    {
        // creates an object keyboard to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the copy number: ");
        int no = keyboard.nextInt();
        return no;
    }
    
    //there is need for more methods to read information about DVDs
    //and methods to display the information
  
    private void findDVD()
    {     
        int no = inputDVDNo();
        //is to be changed when the DVD controller is completed
        String dvd = dvdCtr.findDVD(no);
    }
    private void createDVD()
    {
    }
    private void createCopy()
    {
    }
    
    private void deleteDVD()
    {
    }
    private void listAllDvds()
    {
    }
}