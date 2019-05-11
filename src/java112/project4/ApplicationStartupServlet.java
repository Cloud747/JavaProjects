package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.net.*;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;
/**
 *  This is the servlet for project 4.
 *
 *@author    jpabon
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

        //Forward to jsp page
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        //dispatcher.forward(request, response);

    }
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