package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
 //When creating duplicate be sure to change the annotation to route correctly
 // will run into an error
@WebServlet(
    name = "simpleServlet",
    urlPatterns = { "/text" }
)
public class SimpleTextServlet extends HttpServlet {

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
        response.setContentType("text/plain");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        //explicit data
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<img src='" + request.getContextPath() + "/images/sonic.jpg' alt='Sonic The Hedgehog'/>");
        out.print("<BODY>");
        out.print("<h1>TrivialServlet Here!</h1>");
        out.print("<A HREF=\"index.jsp\">Take me back home</A>");
        System.out.println("Is this logging? - this is from a sout");
        log("Is this logging? <= is from the log");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
