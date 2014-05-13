package ControlLayer;
import java.util.ArrayList;
//model layer package has to be imported

/**
 * Controller class for the address book
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class AddressCtr
{
    
    //declare instance variables to reference containers
    
    
    
    public AddressCtr()
    {
    }
    
    //Dummy implementation: after implementing the model layer 
    //objects of class Person are to be returned, not String
    public String getPerson(long id)
    {
        //this method is to search the container for a person
        //with an id-number equal to the parameter id
        //when person is found, the method is to call print-methods in the TUI layer
        return "person";
    }
    
    
    public void createPerson(long id, String name, String address, String postalCode, String city, String phone)
    {   
       //creates a Person object and stores it in the container
    }
    
    public void deletePerson(long id)
    {
        //search for the person and delete the object from the container
    }
    
    public void updatePerson(long id)
    {
    }
    
    public ArrayList listAllPersons()
    {
          return null;
    }
}
