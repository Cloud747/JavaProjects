package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

import java112.employee.EmployeeDirectory;
/**
 *  This is the servlet for project 4. - this connects to the EmployeeSearch Results JSP
 *  This servlet takes the values from the search form and sets them to the employee directory to perform a query, then it sends 
 *  the results to the employee results jsp page. Used the session here
 * @author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "employeesearchresults", 
    urlPatterns = { "/employee-search-results" }
)
//has access to get the servlet context due to the inheritence 
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
        //Here is where we are setting things up for the results page to display the employee search - found some helpful tips https://stackoverflow.com/questions/1824409/servlet-result-display-in-jsp-page
        //Getting the local variable that references the servletcontext
        ServletContext context = getServletContext();
        //getting the directory from the memory (servlet context)
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDir");
        
        //getting the search criteria
        String searchTerm = request.getParameter("searchterm");
        String searchType = request.getParameter("searchtype");

        //query the database and store the result in the search object
        Search search = employeeDirectory.findEmployee(searchTerm, searchType);
        //setting data up for the jsp page
        request.setAttribute("employeeList", search.getEmployeeList());
        request.setAttribute("searchTerm", search.getSearchTerm());
        request.setAttribute("searchType", search.getSearchType());
        
        //Placing the search object into the session
        //used ideas from https://www.tutorialspoint.com/servlets/servlets-session-tracking.htm & http://paulawaite.com/education/java112/unit4/getting-an-attribute-servlet/
        request.getSession().setAttribute("search", search);
        
        //Create the url
        String url = "/EmployeeSearchResults.jsp";
        
        //Forward to jsp page - 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        //forwards controls to the JSP
        dispatcher.forward(request, response);

    }
}