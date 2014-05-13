package ControlLayer;
import java.util.ArrayList;
//model layer package has to be imported
/**
 * Controller class for the DVD collection
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * @revised version English (Ab)
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class DVDCtr
{
    //declare instance variables to reference containers
    

    /**
     * Constructor for objects of class DVDCtr
     */
    public DVDCtr()
    {
        //set up references to containers    
    }
    
    //Dummy implementation: after implementing the model layer 
    //objects of class DVD are to be returned, not String
    public String findDVD( int no)
    {
        //this method is to search the container for a DVD
        //with an id-number equal to the parameter no
        //when the dvd is found, the method is to call print-methods in the TUI layer
       
       return "dvd"; 
    }
    
    //Dummy implementation: more parameters are probaly to added
    public void createDVD(String dvd)
    {       
          //this method constructs a new dvd object 
          //and stores it in the container
    }
    
    public void deleteDVD(long id)
    {
        
        //search for the dvd and delete the object from the container
       
    }
    
    public void createCopy(long id)
    {
        //create a copy of the specified dvd and add it to the dvd
    }
    
    
    public ArrayList listAllDvds()
    {
          //returns a list of all dvds and their associated copies
          return null;
    }
}
