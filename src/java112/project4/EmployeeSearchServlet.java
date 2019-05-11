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
    name = "employeeSearch", 
    urlPatterns = { "/employee-search" }
)

public class EmployeeSearchServlet extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Create the url
        String url = "/EmployeeSearch.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}