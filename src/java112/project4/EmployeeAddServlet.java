package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is the servlet for project 4. This connects to the employee add JSP file.
 *  Another middle servlet because we aren't calling the jsp directly. 
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "employeeadd", 
    urlPatterns = { "/employee-add" }
)

public class EmployeeAddServlet extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    //setting it to the employee add jsp
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("errorMessage", "");
        //Create the url
        String url = "/EmployeeAdd.jsp";
        //Forward to jsp page - global oject for the application that can store configuration information.
        //storing the employee directory because it has connection information.
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        //transferring control
        dispatcher.forward(request, response);

    }
}