package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java112.employee.EmployeeDirectory;

/**
 *  This is the servlet for project 4.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "employeeaddresults", 
    urlPatterns = { "/employee-add-results" }
)

public class EmployeeAddResultsServlet extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     * obtained some examples from https://examples.javacodegeeks.com/enterprise-java/servlet/java-servlet-sendredirect-example/
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDir");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String department = request.getParameter("department");
        String socialSecurity = request.getParameter("socialsecurity");
        String phoneNumber = request.getParameter("phonenumber");
        String roomNumber = request.getParameter("roomnumber");
        //Validating the entered values
        String errorMessage = "";
        if (firstName == null || firstName.length() < 1 || firstName.length() > 25) {
            errorMessage = "First name is not valid";
        }
        else if (lastName == null || lastName.length() < 1 || lastName.length() > 30) {
            errorMessage = "Last name is not valid";
        }
        else if (department == null || department.length() < 1 || department.length() > 10) {
            errorMessage = "Department is not valid";
        }
        if (errorMessage.length() > 0) {
            request.getSession().setAttribute("resultsMessage", errorMessage);
        }
        else {
            request.getSession().setAttribute("resultsMessage", "Successful Add");
            employeeDirectory.addNewEmployeeRecord(" ", firstName, lastName, socialSecurity, department, roomNumber, phoneNumber);
        }
        //Create the url
        String url = "employee-add-post-results";
        //redirecting to the URL
        response.sendRedirect(url);
    }
}