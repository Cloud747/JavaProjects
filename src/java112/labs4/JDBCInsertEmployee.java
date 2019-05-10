package java112.labs4;

import java.io.*;
import java.sql.*;

/**
 * 
 * @author jpabon
 */
public class JDBCInsertEmployee {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

    //  Database credentials
    static final String USER = "student";
    static final String PASS = "student";
    public static void main(String[] args) {
    Connection conn = null;
   Statement stmt = null;
   
}