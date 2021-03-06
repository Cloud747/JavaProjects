package java112.employee;

import java.util.*;
import java.sql.*;

/**
 * This directory file acts as a data access layer. Middle tier between the application and the database.
 * @author jpabon
 */
public class EmployeeDirectory {
    //Adding instance variables - adding the properties to ensure we have connections to the database. 
    //Gets loaded by the application startup servlet and passed into this file
    private Properties properties;

    public EmployeeDirectory(Properties properties) {
        //loading the properties here
        this.properties = properties;
    }
    //Connection to the the database
    private Connection createConnection() {
        //adding the private variable
        String url = properties.getProperty("database.url");
        String driverClass = properties.getProperty("driver.class");
        String username = properties.getProperty("mysql.username");
        String password = properties.getProperty("mysql.password");
        Connection connection = null;
        //Used notes from http://paulawaite.com/education/java112/unit4/jdbc-basics/ to create the connection to the database
        try {
            //loading the JDBC Driver
            Class.forName(driverClass);
            //defining the connection URL
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
    /**
     * https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
     * Receieve all the properties for an employee record, used the JDBC to add the records to the database
     * @param employeeID - the employee ID will be passed in
     * @param firstName - the first name will be passed in
     * @param lastName - the last name will be passed in
     * @param socialSecurity - the social security will be passed in
     * @param department - the department will be passed in
     * @param roomNumber - the room number will be passed in
     * @param phoneNumber - the phone number for the employee will be passed in
     */
    public void addNewEmployeeRecord(
     String employeeID,
     String firstName,
     String lastName,
     String socialSecurity,
     String department,
     String roomNumber,
     String phoneNumber) {
         //creating the connection to insert the values into the database
        Connection connection = createConnection();
        String insertTableSQL = "INSERT INTO employees"
		+ "(first_name, last_name, ssn, dept, room, phone) VALUES"
        + "(?,?,?,?,?,?)";
        //Declare it after the try method
        //Used prepared statements because its the recommended way to set parameters for our sql 
        //Used https://www.mkyong.com/jdbc/jdbc-preparestatement-example-select-list-of-the-records/ & https://www.tutorialspoint.com/jdbc/jdbc-statements.htm
        //for reference on using preparedStatements
        //Used this since I was going to use the SQL statements more than once
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, socialSecurity);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, roomNumber);
            preparedStatement.setString(6, phoneNumber);
            // execute insert SQL statement
            // https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
                sqlException.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * Search Type - the attribute name (id, firstname and last name)
     * Search Term - the actual value for one of these values
     * Searching by last name and first name etc.
     * 
     * @param searchTerm
     * @param searchType
     * @return search - the search will be returned
     */
    public Search findEmployee(String searchTerm, String searchType) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);
        if (searchType.equals("lastname")) {
            findEmployeeByLastName(search, searchTerm);  
        }
        if (searchType.equals("firstname")) {
            findEmployeeByFirstName(search, searchTerm);  
        }
        if (searchType.equals("id")) {
            findEmployeeByID(search, searchTerm);  
        }
        return search;
    }
    /**
     * Executing a query where the where clause is set by the last name
     * @param search - the search is being passed into the method
     * @param lastName - the last name is being passed into the method
     */
    private void findEmployeeByLastName(Search search, String lastName) {
        Connection connection = createConnection();
        String searchSQL = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
		+ "where last_name = ?";
        try {
            getEmployeeData(connection, search, searchSQL, lastName);
        }
        catch (SQLException sqlException) {
                sqlException.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * Executing a query where the where clause is set by the first name
     * @param search passing in the search 
     * @param firstName passing in the firstName
     */
    private void findEmployeeByFirstName(Search search, String firstName) {
        Connection connection = createConnection();

        String searchSQL = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
		+ "where first_name = ?";
        //Declare it after the try method
        try {
            getEmployeeData(connection, search, searchSQL, firstName);
        }
        catch (SQLException sqlException) {
                sqlException.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * Executing a query where the wehere clause is set by the ID
     * @param search passing in the search parameter
     * @param firstName passing in the first name parameter
     */
    private void findEmployeeByID(Search search, String Id) {
        Connection connection = createConnection();

        String searchSQL = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
		+ "where emp_id = ?";
        try {
            getEmployeeData(connection, search, searchSQL, Id);
        }
        catch (SQLException sqlException) {
                sqlException.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * 
     * This function is transferring the data from the result set to the search object (has the list of employees).
     * Search is passed by reference
     * @param connection passing in the connection parameter
     * @param search passing in the search parameter
     * @param searchSQL passing in the searchSQL parameter
     * @param paramValue passing in the paramValue paramter
     * @throws SQLException - ensures we are catching all possible exceptions
     */
    private void getEmployeeData(Connection connection, Search search, String searchSQL, String paramValue) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
        preparedStatement.setString(1, paramValue);
        // execute insert SQL statement
        ResultSet resultSet = preparedStatement.executeQuery();
        try {
            while (resultSet.next()) { // this will move us to the next row
                String employeeId = resultSet.getString("emp_id"); 
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String socialSecurity = resultSet.getString("ssn");
                String department = resultSet.getString("dept");
                String roomNumber = resultSet.getString("room");
                String phoneNumber = resultSet.getString("phone");

                Employee employee = new Employee();
                employee.setEmployeeID(employeeId);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setSocialSecurity(socialSecurity);
                employee.setDepartment(department);
                employee.setRoomNumber(roomNumber);
                employee.setPhoneNumber(phoneNumber);
                //Adding it to the search 
                search.addFoundEmployee(employee);
            }
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
