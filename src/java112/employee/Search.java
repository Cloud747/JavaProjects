package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 
 * 
 * @author jpabon
 */

 public class Search {

    //Adding the required instance variables
    private String enteredStringType;
    private String enteredStringTerm;
    private ArrayList<Employee> resultsList = new ArrayList<Employee>();
    private Boolean employeeFound = true;

    //Adding the empty constructor
    public Search() {
        
    }
    //Creating the Getters and Setters for these instance variables
    /**
    * Gets the enteredStringType
    * @return enteredStringType the enteredStringType is returned
    */
    public String getEnteredStringType(){
        return this.enteredStringType;
    }   
    /**
    * Sets the enteredStringType
    * @param enteredStringType
    */
    public void setEnteredStringType(String enteredStringType){
        this.enteredStringType = enteredStringType;
    }

    /**
    * Gets the enteredStringTerm
    * @return enteredStringTerm the enteredStringTerm is returned
    */
    public String getEnteredStringTerm(){
        return this.enteredStringTerm;
    }   
    /**
    * Sets the enteredStringTerm
    * @param enteredStringTerm
    */
    public void setEnteredStringTerm(String enteredStringTerm){
        this.enteredStringTerm = enteredStringTerm;
    }

    /**
    * Gets the resultsList
    * @return resultsList the arraylist resultsList is returned
    */
    public ArrayList<Employee> getResultsList(){
        return this.resultsList;
    }   
    /**
    * Sets the resultsList
    * @param resultsList
    */
    public void setStringList(ArrayList<Employee> resultsList) {
        this.resultsList = resultsList;
    }

    /**
    * confirms if the employee has been found
    * @return employeeID the employee id is returned
    */
    public boolean isEmployeeFound(){
        return this.employeeFound;
    }   
    /**
    * Sets the employee ID
    * @param employeeFound
    */
    public void setEmployeeFound(boolean employeeFound){
        this.employeeFound = employeeFound;
    }

    //Adding the method 
    public void addFoundEmployee(Employee employee) {
        this.resultsList.add(employee);
    }
 }
