package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is the servlet for project 4. Connects to the employee add results jsp
 *  This servlet is sort of a middle servlet to send the results (success or failure) to the actual employee add results jsp
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "employeeaddpostresultsservlet", 
    urlPatterns = { "/employee-add-post-results" }
)

public class EmployeeAddPostResultsServlet extends HttpServlet {
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
        //casting the variable to convert to a string
        String resultsMessage = (String)request.getSession().getAttribute("resultsMessage");
        request.setAttribute("resultsMessage", resultsMessage);
        //Create the url
        String url = "/EmployeeAddResults.jsp";
        //Forward to jsp page - this is global
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        //passing over the controls to the jsp
        dispatcher.forward(request, response);

    }
}