package modelLayer;
import personLayer.*;
import java.util.ArrayList;

/**
 * EmployeeCont contains a list of all persons in the EmployeeCont.
 * 
 * @author Group 1
 * @version 0.1
 */
public class EmployeeCont{
	
	private static EmployeeCont instance;
    private ArrayList<Employee> employees;
    
    /**
     * Constructor for objects of class EmployeeCont
     */
    private EmployeeCont(){
    	employees = new ArrayList<Employee>();
    }
    
    /**
     * getInstance - Get only one instance of the EmployeeCont.
     * @return EmployeeCont - The instance of the EmployeeCont.
     */
    public static EmployeeCont getInstance(){
        if(instance == null){
            instance = new EmployeeCont();
        }
        
        return instance;
    }
    
    /**
     * addEmployee - Add a Employee object to the EmployeeCont.
     * @param e The Employee object to add.
     */
    public void addEmployee(Employee e){
    	employees.add(e);
    }
    
    /**
     * removeEmployee - Remove a Employee from the EmployeeCont.
     * @param Employee The Employee object to remove.
     */
    public void removeEmployee(Employee e){
    	employees.remove(e);
    }
	
    /**
     * findEmployee - Get a Employee object from the id of the Employee.
     * @param id - The id of the Employee.
     * @return Employee object of the Employee or null if not found.
     */
    public Employee findEmployee(int employeeNr){
    	
    	Employee retEmployee = null;
    	boolean found = false;
    	int i = 0;
    	while(i < employees.size() && !found) {
    		if(employees.get(i).getId() == employeeNr) {
    			retEmployee = employees.get(i);
    			found = true;
    		}
    		i++;
    	}
    	
    	return retEmployee;
    }
}
