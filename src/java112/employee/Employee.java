package java112.employee;


import java.io.*;
import java.sql.*;

/**
 * 
 * @author jpabon
 */

 public class Employee {

    //creating the string private instance variables
    private String employeeID;
    private String firstName;
    private String lastName;
    private String socialSecurity;
    private String department;
    private String roomNumber;
    private String phoneNumber;

    //Creating the Getters and Setters for these instance variables
    /**
    * Gets the employee ID
    * @return employeeID the employee id is returned
    */
    public String getEmployeeID(){
        return this.employeeID;
    }   
    /**
    * Sets the employee ID
    * @param employeeID
    */
    public void setEmployeeID(String employeeID){
        this.employeeID = employeeID;
    }

    /**
    * Gets the first name of the employee
    * @return firstName the first name is returned
    */
    public String getFirstName(){
        return this.firstName;
    }   
    /**
    * Sets the first name of the employee
    * @param firstName
    */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
    * Gets the lastName of the employee 
    * @return lastName the last name is returned
    */
    public String getLastName(){
        return this.lastName;
    }   
    /**
    * Sets the last name for the employee
    * @param lastName 
    */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
    * Gets the social security of the employee
    * @return socialSecurity the social security number is returned
    */
    public String getSocialSecurity(){
        return this.socialSecurity;
    }   
    /**
    * Sets the remote computer string for the HTTPRequestData class
    * @param socialSecurity
    */
    public void setSocialSecurity(String socialSecurity){
        this.socialSecurity = socialSecurity;
    }

    /**
    * Gets the remote computer's string
    * @return department the department is returned
    */
    public String getDepartment(){
        return this.department;
    }   
    /**
    * Sets the department the employee is associated with
    * @param department
    */
    public void setDepartment(String department){
        this.department = department;
    }

    /**
    * Gets the room number
    * @return roomNumber the room number is returned 
    */
    public String getRoomNumber(){
        return this.roomNumber;
    }   
    /**
    * Sets the roomNumber
    * @param roomNumber
    */
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    /**
    * Gets the phone number 
    * @return phoneNumber the phoneNumber is returned
    */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }   
    /**
    * Sets the phone number
    * @param phoneNumber
    */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

 }
