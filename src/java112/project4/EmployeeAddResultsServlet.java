package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java112.employee.EmployeeDirectory;

/**
 *  This is the servlet for project 4. Connects to the add post results servlet.
 *   This servlet is called from the employeeadd jsp form, and it grabs the values from the form and it also validates and redirects to the 
 *  success page.
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
        //grabbing the values that were entered in the form
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String department = request.getParameter("department");
        String socialSecurity = request.getParameter("socialsecurity");
        String phoneNumber = request.getParameter("phonenumber");
        String roomNumber = request.getParameter("roomnumber");
        //Validating the entered values by the employee
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
        
        //If not valid it will send an error message to the results page
        //used some ideas from http://paulawaite.com/education/java112/unit4/session-tracking/ and https://www.tutorialspoint.com/servlets/servlets-session-tracking.htm
        if (errorMessage.length() > 0) {
            request.getSession().setAttribute("resultsMessage", errorMessage);
        }
        else {
            //if valid it will send a message for success and then call the employee directory to add the value to the database
            request.getSession().setAttribute("resultsMessage", "Successful Add");
            employeeDirectory.addNewEmployeeRecord(" ", firstName, lastName, socialSecurity, department, roomNumber, phoneNumber);
        }
        //Create the url - calling the other servlet
        String url = "employee-add-post-results";
        //redirecting to the URL (when you submit a post - don't want to receive the same message cache no duplicate form submission)
        response.sendRedirect(url);
    }
}