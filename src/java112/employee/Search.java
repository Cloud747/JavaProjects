package java112.employee;
import java.util.*;

/**
 * 
 * 
 * @author jpabon
 */

 public class Search {

    //Adding the required instance variables
    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();
    

    //Adding the empty constructor
    public Search() {
        
    }
    //Creating the Getters and Setters for these instance variables
    /**
    * Gets the enteredStringType
    * @return enteredStringType the enteredStringType is returned
    */
    public String getSearchType(){
        return this.searchType;
    }   
    /**
    * Sets the enteredStringType
    * @param enteredStringType
    */
    public void setSearchType(String searchType){
        this.searchType = searchType;
    }

    /**
    * Gets the enteredStringTerm
    * @return enteredStringTerm the enteredStringTerm is returned
    */
    public String getSearchTerm(){
        return this.searchTerm;
    }   
    /**
    * Sets the enteredStringTerm
    * @param enteredStringTerm
    */
    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
    /**
    * Gets the resultsList
    * @return employeeList the arraylist resultsList is returned
    */
    public ArrayList<Employee> getEmployeeList(){
        return this.employeeList;
    }   
    /**
    * confirms if the employee has been found
    * @return employeeID the employee id is returned
    */
    public boolean isEmployeeFound(){
        return this.employeeList.size() > 0;
    }   
    //Adding the method 
    public void addFoundEmployee(Employee employee) {
        this.employeeList.add(employee);
    }
 }