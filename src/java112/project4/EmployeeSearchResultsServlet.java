package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.net.*;
import java112.employee.*;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;
/**
 *  This is the servlet for project 4.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "employeesearchresults", 
    urlPatterns = { "/employee-search-results" }
)

public class EmployeeSearchResultsServlet extends HttpServlet {
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
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDir");
        String searchTerm = request.getParameter("searchterm");
        String searchType = request.getParameter("searchtype");
        Search search = employeeDirectory.findEmployee(searchTerm, searchType);
        request.setAttribute("employeeList", search.getEmployeeList());
        
        request.getSession().setAttribute("search", search);
        //Create the url
        String url = "/EmployeeSearchResults.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}