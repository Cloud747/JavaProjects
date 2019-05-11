package java112.employee;

import java.util.*;

import org.junit.internal.requests.FilterRequest;

import java112.utilities.PropertiesLoader;

import java.sql.*;

/**
 * 
 * @author jpabon
 */
public class EmployeeDirectory {

    private Properties properties;


    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }
    private Connection createConnection() {

        //adding the private variable
        String url = properties.getProperty("database.url");
        String driverClass = properties.getProperty("driver.class");
        String username = properties.getProperty("mysql.username");
        String password = properties.getProperty("mysql.password");
        Connection connection = null;

        try {
            //loading the JDBC Driver
            Class.forName(driverClass);

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
     * 
     */
    public void addNewEmployeeRecord(
     String employeeID,
     String firstName,
     String lastName,
     String socialSecurity,
     String department,
     String roomNumber,
     String phoneNumber) {
        Connection connection = createConnection();
        String insertTableSQL = "INSERT INTO EMPLOYEE"
		+ "(first_name, last_name, ssn, dept, room, phone) VALUES"
        + "(?,?,?,?,?,?)";
        //Declare it after the try method
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, socialSecurity);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, roomNumber);
            preparedStatement.setString(6, phoneNumber);
            // execute insert SQL stetement
            preparedStatement .executeUpdate();
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
     * 
     * @param searchTerm
     * @param searchType
     * @return
     */
    public Search findEmployee(String searchTerm, String searchType) {
        Search search = new Search();
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
    private void findEmployeeByLastName(Search search, String lastName) {
        Connection connection = createConnection();
        String searchSQL = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
		+ "where last_name = ?";
        try {
            getEmployeeData(connection, search, searchSQL, lastName);
        }
        catch (SQLException sqlException) {
                sqlException.printStackTrace();
                throw new RuntimeException(sqlException.toString());
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
     * @param search
     * @param firstName
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
     * 
     * @param search
     * @param firstName
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
     *
     * @param connection
     * @param search
     * @param searchSQL
     * @param paramValue
     * @throws SQLException
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
/** 
driver.class=
database.url=
mysql.username=
mysql.password=
*/