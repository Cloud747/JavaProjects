package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *
 *@author     Eric Knapp
 *
 */
public class JDBCSelectEmployees {
  
    public void runSample() {
  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
  
        try {
            //Load the JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //making the connection - it will 
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
            //issue a sql command - creating the statement object 
            statement = connection.createStatement();
            
            //Defining the sql that you want to run
            String name = "Smith";
            String queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees " + "WHERE last_name like '"
                    + name + "%'";
  
            System.out.println("queryString: " + queryString);
            
            //feeding it to the statement object - pass in the queryString
            // If we wanted to change the DB like an update or insert, or delete that would be executeUpdate()
            resultSet = statement.executeQuery(queryString);
  
            System.out.println();
            
            //Using the resultSet.next() iterate through the set (allows you to access the return data but doesn't hold all the data)
            while (resultSet.next()) { // this will move us to the next row
                String employeeId = resultSet.getString("emp_id"); 
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                            + firstName + " " + lastName);
            }
  
            System.out.println();
  
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            String nameOne = resultSetMetaData.getColumnName(1);
            String typeOne = resultSetMetaData.getColumnTypeName(1);
            String labelOne = resultSetMetaData.getColumnLabel(1);
            System.out.println(" Column count : " + columns);
            System.out.println(" Column 1 name : " + nameOne);
            System.out.println(" Column 1 type : " + typeOne);
            System.out.println(" Column 1 label name : " + labelOne);
  
            System.out.println();
  
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
            //need to be in a finally block or try with resources (recommended approach)
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
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
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {
  
        JDBCSelectEmployees employees = new JDBCSelectEmployees();
  
        employees.runSample();
  
    }
}
