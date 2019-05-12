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
    * Gets the StringType
    * @return StringType the StringType is returned
    */
    public String getSearchType(){
        return this.searchType;
    }   
    /**
    * Sets the StringType
    * @param StringType
    */
    public void setSearchType(String searchType){
        this.searchType = searchType;
    }

    /**
    * Gets the StringTerm
    * @return StringTerm the StringTerm is returned
    */
    public String getSearchTerm(){
        return this.searchTerm;
    }   
    /**
    * Sets the StringTerm
    * @param StringTerm
    */
    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
    /**
    * Gets the employeeList
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
    //Adding the method to add found employees to the list
    public void addFoundEmployee(Employee employee) {
        this.employeeList.add(employee);
    }
 }
