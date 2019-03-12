package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
@WebServlet(
    name = "labFive",
    urlPatterns = { "/labFive" }
)
public class LabFiveServlet extends HttpServlet {
    /**
    *
    * Handles the initilization of the servlet
    *
    *
    */
    public void init() throws ServletException {

    }
    /**
    * Handles HTTP GET requests
    * @param request    the HttpServletRequest object
    * @param response   the HttpServletResponse object
    * @exception ServletException   if there is a Servlet failure
    * @exception IOException        if there is an IO failure
    */
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //implicit data
        response.setContentType("text/plain");
