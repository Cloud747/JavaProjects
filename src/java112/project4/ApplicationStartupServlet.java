package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;
/**
 *  This is the servlet for project 4. 
 *  Uses the load on startup - when the applications starts up and this servlet is executed. The init is executed 
 *  Where we load our employees directory to ensure it's ready to start querying the database becuase of it's properties
 * @author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "applicationStartup", 
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)
public class ApplicationStartupServlet extends HttpServlet implements PropertiesLoader {
    //Creating the instance variables
    private Properties properties;
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    //Be sure to check the content type
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //implicit data
        response.setContentType("text/html");
    }
    
    /**
     * stores the employee directory and memory (instance of it)
     */
    //overriding the parent class 
    @Override
    public void init() {
        String propertiesFilePath = "/project4.properties";
        properties = loadProperties(propertiesFilePath);
        getServletContext().setAttribute("project4properties", properties);
        //creating the employee directory with a constructor that has a properties parameter - in the servlet context
        EmployeeDirectory employeeDir = new EmployeeDirectory(properties);
        
        getServletContext().setAttribute("employeeDir", employeeDir);
    }
}