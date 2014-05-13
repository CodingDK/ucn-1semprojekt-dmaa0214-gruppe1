package TUILayer;//makes this class a part of the TUILayer package
import java.util.Scanner;
import ControlLayer.*;//The TUILayer needs to know the ControlLayer
 

/**
 * User interface class to the AddressBook
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * (FEN): 2006.03.21: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class AddressBookUI
{   

    private AddressCtr addrCtr;//reference to the ControlLayer
    
    //constructor which does nothing
    public AddressBookUI()
    {
       
    }
    
    public void start()
    {
       
        addressMenu();
    }
    
    public void addressMenu()
    {
       boolean exit = false;
       while(!exit)//that is: while exit is false
       {
          int choice = writeAddressBookMenu(); 
          if(choice == 1)
          {   //show person
              getPerson();
          }
          else{
              if(choice == 2){
                    //create person
              }  
              else{
                  if(choice == 3){
                      //delete person
                  }  
                  else{
                      if(choice == 4){
                          // update person
                      }
                      else{
                          if(choice == 5){
                              // listAllPersons();
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
    public int writeAddressBookMenu()
    {      // makes an object keyboard to read input from the screen
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** AddressBook Menu ***");
            System.out.println(" (1) Show information about person");
            System.out.println(" (2) Add person");
            System.out.println(" (3) Delete person");
            System.out.println(" (4) Update person");
            System.out.println(" (5) List all persons");
            System.out.println(" (6) Return");
            System.out.print("\n Make your choice: ");
            
            int choice = keyboard.nextInt();
            return choice;
        }
        
    //the method reads id for a person and return
    // 
    public long inputPersonsID()
    {   
        boolean ok = false;
        long id = 0;
        while(!ok)
        {
        // makes an object keyboard to have input from the console
           Scanner keyboard = new Scanner(System.in);
           System.out.println(" Write Id:  ");
           try{
             id = keyboard.nextLong();
             ok = true;
           }
           catch (Exception e)
            {
             System.out.println("You must enter a number -  try again");
             String input = keyboard.nextLine();
           }
        }//end while
        return id;
    }
    
    public String inputName()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Name:  ");
         String name = keyboard.nextLine();
         return name;
    }
   
    public String inputPostalCode()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Postal Code:  ");
         String code = keyboard.nextLine();
         return code;
    }
    public String inputCity()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write City:  ");
         String city = keyboard.nextLine();
         return city;
    } 
    public String inputPhone()
    {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Write Phone Number:  ");
         String phone = keyboard.nextLine();
         return phone;
    } 
     
    public String  inputAddress()
    {
        // makes an object keyboard to read input from the console
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Write Address: ");
        String address = keyboard.nextLine();
        return address;
    }
    
    public void showId(long id)
    {
        System.out.println("ID of the person: " + id);
    }
    public void showName(String name)
    { 
        System.out.println("The name of the persone: " + name);
    }
    public void showAddress(String address)
    { 
        System.out.println("The address of the person: " + address);
    }

    private void getPerson()
    {//is to be changed when the address book controller is completed
        long id = inputPersonsID();
        

    }   
}
            
        
